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
    fun getSearchResultWith(jql: String, maxResults: Int, startAt: Int): SearchResult {
        return SearchResult(
            startAt = startAt,
            maxResults = maxResults,
            total = 3,
            issues = listOf(
                Ticket(
                    key = "ABC-1111",
                    fields = TicketField(
                        summary = "A summary",
                        status = Status(
                            name = "Amazing"
                        ),
                        issuetype = IssueType(
                            name = "Chore"
                        ),
                        customfield_10006 = "ABC-1234",
                        assignee = Assignee(displayName = "Tony Foxbridge"),
                        duedate = "2020-01-01"
                    )
                ),
                Ticket(
                    key = "ABC-1112",
                    fields = TicketField(
                        summary = "A summary",
                        status = Status(
                            name = "Amazing"
                        ),
                        issuetype = IssueType(
                            name = "Chore"
                        ),
                        customfield_10006 = "ABC-2345",
                        assignee = Assignee(displayName = "Tony Foxbridge"),
                        duedate = "2020-01-01"
                    )
                ),
                Ticket(
                    key = "ABC-1113",
                    fields = TicketField(
                        summary = "A summary",
                        status = Status(
                            name = "Amazing"
                        ),
                        issuetype = IssueType(
                            name = "Chore"
                        ),
                        customfield_10006 = "ABC-3456",
                        assignee = Assignee(displayName = "Tony Foxbridge"),
                        duedate = "2020-01-01"
                    )
                )
            )
        )
    }
    fun getIssue(key: String): Issue {
        return Issue(
            key = key,
            fields = IssueFields(
                issuelinks = listOf(
                    IssueLink(
                        type = IssueLinkType(
                            name = "Gant End to End",
                            inward = "depends on"
                        ),
                        outwardIssue = OutwardInwardIssue(
                            key = "DEF-1111",
                            fields = OutwardInwardIssueFields(
                                issuetype = IssueType(name = "Epic")
                            )
                        ),
                        inwardissue = OutwardInwardIssue(
                            key = "DEF-1111",
                            fields = OutwardInwardIssueFields(
                                issuetype = IssueType(name = "Epic")
                            )
                        )
                    ),
                    IssueLink(
                        type = IssueLinkType(
                            name = "Gant End to End",
                            inward = "depends on"
                        ),
                        outwardIssue = OutwardInwardIssue(
                            key = "DEF-1112",
                            fields = OutwardInwardIssueFields(
                                issuetype = IssueType(name = "Epic")
                            )
                        ),
                        inwardissue = OutwardInwardIssue(
                            key = "DEF-1112",
                            fields = OutwardInwardIssueFields(
                                issuetype = IssueType(name = "Epic")
                            )
                        )
                    )
                )
            )
        )
    }
}