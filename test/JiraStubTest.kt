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
}