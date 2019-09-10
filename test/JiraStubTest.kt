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
        withTestApplication({ module(testing = true)}) {
            handleRequest(HttpMethod.Get, "/rest/api/2/search?jql=test") {
                addHeader(
                    HttpHeaders.Authorization,
                    HttpAuthHeader.Single("basic", Base64.getEncoder().encodeToString("$username:$password".toByteArray())).render()
                )
            }.apply {
                assertEquals(HttpStatusCode.OK, response.status())
                assertEquals(
                    """{"startAt":0,"maxResults":50,"total":3,"issues":[{"id":"01111","key":"ABC-1111","fields":{"summary":"A summary","status":{"description":"A description","iconUrl":"url","name":"Status Name","id":"54321"},"issueType":{"id":"23456","description":"Type description","iconUrl":"url","name":"Type name","subtask":false,"avatarId":12345},"epicLinksKey":"ABC-1234","assignee":"Tony","dueDate":"01/01/2020"}},{"id":"01112","key":"ABC-1112","fields":{"summary":"A summary","status":{"description":"B description","iconUrl":"url","name":"Status Name","id":"54321"},"issueType":{"id":"23456","description":"Type description","iconUrl":"url","name":"Type name","subtask":false,"avatarId":12345},"epicLinksKey":"ABC-1234","assignee":"Tony","dueDate":"02/01/2020"}},{"id":"01113","key":"ABC-1113","fields":{"summary":"A summary","status":{"description":"C description","iconUrl":"url","name":"Status Name","id":"54321"},"issueType":{"id":"23456","description":"Type description","iconUrl":"url","name":"Type name","subtask":false,"avatarId":12345},"epicLinksKey":"ABC-1234","assignee":"Tony","dueDate":"03/01/2020"}}]}""",
                    response.content
                )
            }
        }
    }
}