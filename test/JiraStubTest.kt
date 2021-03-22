package com.elliotledger

import com.elliotledger.jirastub.dataclasses.Issue
import com.elliotledger.jirastub.dataclasses.SearchResult
import com.elliotledger.jirastub.dataclasses.User
import com.google.gson.Gson
import io.ktor.http.*
import io.ktor.http.auth.HttpAuthHeader
import kotlin.test.*
import io.ktor.server.testing.*
import java.util.*

class JiraStubTest {
    private val username = "username"
    private val password = "password"

    private val gson = Gson()

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

                val user = gson.fromJson(response.content, User::class.java)
                assertEquals("tony.foxbridge", user.key)
                assertEquals("tony.foxbridge", user.name)
                assertEquals("tfoxbridge@gmail.com", user.emailAddress)
                assertEquals("Tony Foxbridge", user.displayName)
                assertEquals(true, user.active)
                assertEquals(
                    "https://images.vexels.com/media/users/3/145908/preview2/52eabf633ca6414e60a7677b0b917d92-male-avatar-maker.jpg",
                    user.avatarUrls["24x24"]
                )
            }
        }
    }

    @Test
    fun testGetSearchResultWithTestJql() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/rest/api/2/search?jql=test") {
                addHeader(
                    HttpHeaders.Authorization,
                    HttpAuthHeader.Single("basic", Base64.getEncoder().encodeToString("$username:$password".toByteArray())).render()
                )
            }.apply {
                assertEquals(HttpStatusCode.OK, response.status())

                val searchResult = gson.fromJson(response.content, SearchResult::class.java)
                assertEquals(0, searchResult.startAt)
                assertEquals(50, searchResult.maxResults)
                assertEquals(4, searchResult.total)
                assertEquals(4, searchResult.issues.size)
                assertEquals("ABC-1111", searchResult.issues.first().key)
                assertEquals("Required", searchResult.issues.first().fields.customfield_18301?.value)
                assertEquals("No", searchResult.issues.first().fields.customfield_16800?.value)
            }
        }
    }

    @Test
    fun testGetSearchResultWithDifferentStartAtAndMaxResults() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "rest/api/2/search?jql=test&startAt=10&maxResults=40") {
                addHeader(
                    HttpHeaders.Authorization,
                    HttpAuthHeader.Single("basic", Base64.getEncoder().encodeToString("$username:$password".toByteArray())).render()
                )
            }.apply {
                assertEquals(HttpStatusCode.OK, response.status())

                val searchResult = gson.fromJson(response.content, SearchResult::class.java)
                assertEquals(10, searchResult.startAt)
                assertEquals(40, searchResult.maxResults)
            }
        }
    }

    @Test
    fun testGetIssue() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/rest/api/2/issue/testKey") {
                addHeader(
                    HttpHeaders.Authorization,
                    HttpAuthHeader.Single("basic", Base64.getEncoder().encodeToString("$username:$password".toByteArray())).render()
                )
            }.apply {
                assertEquals(HttpStatusCode.OK, response.status())

                val issue = gson.fromJson(response.content, Issue::class.java)
                assertEquals("testKey", issue.key)
                assertEquals("ABC-2111", issue.fields?.issuelinks?.first()?.inwardissue?.key)
                assertEquals("ABC-2111", issue.fields?.issuelinks?.first()?.outwardIssue?.key)
            }
        }
    }

    @Test
    fun testGetIssueWithChangelog() {
        withTestApplication({ module(testing = true) }) {
            handleRequest(HttpMethod.Get, "/rest/api/2/issue/testKey?expand=changelog&maxResults=40&startAt=10") {
                addHeader(HttpHeaders.Authorization,
                    HttpAuthHeader.Single("basic", Base64.getEncoder().encodeToString("$username:$password".toByteArray())).render()
                )
            }.apply {
                assertEquals(HttpStatusCode.OK, response.status())

                val issue = gson.fromJson(response.content, Issue::class.java)
                assertEquals("testKey", issue.key)
                assertEquals(10, issue.changelog?.startAt)
                assertEquals(40, issue.changelog?.maxResults)
                assertEquals(1, issue.changelog?.total)
                assertEquals("2019-05-01T20:00:00.000+0000", issue.fields?.created)
                assertEquals("2019-05-01T21:00:00.000+0000", issue.changelog?.histories?.first()?.created)
                assertEquals("status", issue.changelog?.histories?.first()?.items?.first()?.field)
                assertEquals("Next", issue.changelog?.histories?.first()?.items?.first()?.fromString)
                assertEquals("In Progress", issue.changelog?.histories?.first()?.items?.first()?.toString)
            }
        }
    }
}