package com.elliotledger

import com.elliotledger.jirastub.services.JiraServices
import io.ktor.application.*
import io.ktor.response.*
import io.ktor.routing.*
import io.ktor.http.*
import io.ktor.auth.*
import io.ktor.gson.*
import io.ktor.features.*

fun main(args: Array<String>): Unit = io.ktor.server.netty.EngineMain.main(args)

@Suppress("unused") // Referenced in application.conf
@kotlin.jvm.JvmOverloads
fun Application.module(testing: Boolean = false) {
    install(Authentication) {
        basic("basicAuth") {
            realm = "Jira stub"
            validate { if (it.name == "username" && it.password == "password") UserIdPrincipal(it.name) else null }
        }
    }

    install(ContentNegotiation) {
        gson {
        }
    }

    routing {
        authenticate("basicAuth") {
            route("/rest/api/2") {
                get("user") {
                    val username = call.parameters["username"]
                    username?.let {
                        call.respond(JiraServices().getUser(username))
                    } ?: run {
                        call.respond(HttpStatusCode.BadRequest)
                    }
                }
                get("search") {
                    val jql = call.parameters["jql"]
                    var maxResults = call.parameters["maxResults"]
                    var startAt = call.parameters["startAt"]
                    if (maxResults == null) {
                        maxResults = "50"
                    }
                    if (startAt == null) {
                        startAt = "0"
                    }
                    jql?.let {
                        call.respond(JiraServices().getSearchResultWith(jql, maxResults, startAt))
                    } ?: run {
                        call.respond(HttpStatusCode.BadRequest)
                    }
                }
            }
        }
    }
}
