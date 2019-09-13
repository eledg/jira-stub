package com.elliotledger.jirastub.services

import com.elliotledger.jirastub.dataclasses.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class JiraServices {
    private val logger: Logger = LoggerFactory.getLogger(JiraServices::class.simpleName)

    fun getUser(username: String): User {
        return User(
            key = username,
            name = username,
            emailAddress = "tfoxbridge@gmail.com",
            avatarUrls = mapOf(
                "48x48" to "https://images.vexels.com/media/users/3/145908/preview2/52eabf633ca6414e60a7677b0b917d92-male-avatar-maker.jpg",
                "24x24" to "https://images.vexels.com/media/users/3/145908/preview2/52eabf633ca6414e60a7677b0b917d92-male-avatar-maker.jpg",
                "16x16" to "https://images.vexels.com/media/users/3/145908/preview2/52eabf633ca6414e60a7677b0b917d92-male-avatar-maker.jpg",
                "32x32" to "https://images.vexels.com/media/users/3/145908/preview2/52eabf633ca6414e60a7677b0b917d92-male-avatar-maker.jpg"
            ),
            displayName = "Tony Foxbridge",
            active = true
        )
    }
    fun getSearchResultWith(jql: String, maxResults: String, startAt: String): SearchResult {
        return SearchResult(
            startAt = startAt.toInt(),
            maxResults = maxResults.toInt(),
            total = 3,
            issues = listOf(
                Ticket(
                    key = "ABC-1111",
                    fields = TicketField(
                        summary = "A summary",
                        status = Status(
                            name = "Status Name"
                        ),
                        issuetype = IssueType(
                            name = "Type name"
                        ),
                        customfield_10006 = "ABC-1234",
                        assignee = Assignee(displayName = "Tony Foxbridge"),
                        duedate = "2020-01-01"
                    )
                ),
                Ticket(
                    key = "ABC-1111",
                    fields = TicketField(
                        summary = "A summary",
                        status = Status(
                            name = "Status Name"
                        ),
                        issuetype = IssueType(
                            name = "Type name"
                        ),
                        customfield_10006 = "ABC-1234",
                        assignee = Assignee(displayName = "Tony Foxbridge"),
                        duedate = "2020-01-01"
                    )
                ),
                Ticket(
                    key = "ABC-1111",
                    fields = TicketField(
                        summary = "A summary",
                        status = Status(
                            name = "Status Name"
                        ),
                        issuetype = IssueType(
                            name = "Type name"
                        ),
                        customfield_10006 = "ABC-1234",
                        assignee = Assignee(displayName = "Tony Foxbridge"),
                        duedate = "2020-01-01"
                    )
                )
            )
        )
    }
}