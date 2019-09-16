package com.elliotledger

import io.ktor.http.*
import io.ktor.http.auth.HttpAuthHeader
import kotlin.test.*
import io.ktor.server.testing.*
import java.util.*

class JiraStubTest {
    private val username = "username"
    private val password = "password"

    @Test
    fun testAuthenticationFailed() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/rest/api/2/user?username=tony.foxbridge").apply {
                assertEquals(HttpStatusCode.Unauthorized, response.status())
            }
        }
    }

    @Test
    fun testGetUser() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/rest/api/2/user?username=tony.foxbridge") {
                addHeader(
                    HttpHeaders.Authorization,
                    HttpAuthHeader.Single("basic", Base64.getEncoder().encodeToString("$username:$password".toByteArray())).render()
                )
            }.apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(
                    """{"key":"tony.foxbridge","name":"tony.foxbridge","emailAddress":"tfoxbridge@gmail.com","avatarUrls":{"48x48":"https://images.vexels.com/media/users/3/145908/preview2/52eabf633ca6414e60a7677b0b917d92-male-avatar-maker.jpg","24x24":"https://images.vexels.com/media/users/3/145908/preview2/52eabf633ca6414e60a7677b0b917d92-male-avatar-maker.jpg","16x16":"https://images.vexels.com/media/users/3/145908/preview2/52eabf633ca6414e60a7677b0b917d92-male-avatar-maker.jpg","32x32":"https://images.vexels.com/media/users/3/145908/preview2/52eabf633ca6414e60a7677b0b917d92-male-avatar-maker.jpg"},"displayName":"Tony Foxbridge","active":true}""",
                    response.content
                )
            }
        }
    }
    @Test
    fun testGetSearchResultWith() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/rest/api/2/search?jql=test") {
                addHeader(
                    HttpHeaders.Authorization,
                    HttpAuthHeader.Single("basic", Base64.getEncoder().encodeToString("$username:$password".toByteArray())).render()
                )
            }.apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(
                    """{"startAt":0,"maxResults":50,"total":3,"issues":[{"key":"ABC-1111","fields":{"summary":"A summary","status":{"name":"Status Name"},"issuetype":{"name":"Type name"},"customfield_10006":"ABC-1234","assignee":{"displayName":"Tony Foxbridge"},"duedate":"2020-01-01"}},{"key":"ABC-2222","fields":{"summary":"A summary","status":{"name":"Status Name"},"issuetype":{"name":"Type name"},"customfield_10006":"ABC-2345","assignee":{"displayName":"Tony Foxbridge"},"duedate":"2020-01-01"}},{"key":"ABC-3333","fields":{"summary":"A summary","status":{"name":"Status Name"},"issuetype":{"name":"Type name"},"customfield_10006":"ABC-3456","assignee":{"displayName":"Tony Foxbridge"},"duedate":"2020-01-01"}}]}""",
                    response.content
                )
            }
        }
    }
    @Test
    fun testGetIssue() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/rest/api/2/issue/testkey") {
                addHeader(
                    HttpHeaders.Authorization,
                    HttpAuthHeader.Single("basic", Base64.getEncoder().encodeToString("$username:$password".toByteArray())).render()
                )
            }.apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(
                    """{"fields":{"issuelinks":[{"type":{"name":"Gant End to End","inward":"depends on"},"outwardIssue":{"key":"TEST-1"},"inwardIssue":{"key":"TEST-1"}},{"type":{"name":"Gant End to End","inward":"depends on"},"outwardIssue":{"key":"TEST-2"},"inwardIssue":{"key":"TEST-2"}},{"type":{"name":"Gant End to End","inward":"depends on"},"outwardIssue":{"key":"TEST-3"},"inwardIssue":{"key":"TEST-3"}}]}}""",
                    response.content
                )
            }
        }
    }
}