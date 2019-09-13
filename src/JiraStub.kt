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
                    var maxResults = 50
                    var startAt = 0
                    call.parameters["maxResults"]?.let {
                        maxResults = it.toInt()
                    }
                    call.parameters["startAt"]?.let {
                        startAt = it.toInt()
                    }
                    jql?.let {
                        call.respond(JiraServices().getSearchResultWith(jql, maxResults, startAt))
                    } ?: run {
                        call.respond(HttpStatusCode.BadRequest)
                    }
                }
                get("issue/{ticketKey}") {
                    val ticketKey = call.parameters["ticketKey"]
                    ticketKey?.let {
                        call.respond(JiraServices().getIssue(ticketKey))
                    } ?: run {
                        call.respond(HttpStatusCode.BadRequest)
                    }
                }
                get("issue/{ticketKey?}") {
                    val ticketKey = call.parameters["ticketKey"]
                    ticketKey?.let {
                        call.respond(JiraServices().getIssue())
                    } ?: run {
                        call.respond(HttpStatusCode.BadRequest)
                    }
                }
            }
        }
    }
}
