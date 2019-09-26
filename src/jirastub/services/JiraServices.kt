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
        var result = SearchResult(
            startAt = startAt,
            maxResults = maxResults,
            total = 3,
            issues = listOf(
                Ticket(
                    key = "ABC-1111",
                    fields = TicketField(
                        summary = "1111 Outcome",
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
                        summary = "1112 Outcome",
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
                        summary = "1113 Outcome",
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
        when(jql) {
            "((Project = ABC AND Component = team1 AND issueType in (Story, Bug) AND status IN (Done, Amazing, Live)) OR (Project = ABC AND Component = team2 AND issueType in (Story, Bug) AND status IN (Done, Amazing, Live)) OR (Project = ABC AND Component = CITeam AND issueType in (Story, Bug) AND status IN (Done, Amazing, Live))) AND (resolutionDate >= startOfMonth()) AND status NOT IN (Closed, Withdrawn)"
            -> result = SearchResult(
                startAt = startAt,
                maxResults = maxResults,
                total = 3,
                issues = listOf(
                    Ticket(
                        key = "ABC-1111",
                        fields = TicketField(
                            summary = "1111 Outcome",
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
                            summary = "1112 Outcome",
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
                            summary = "1113 Outcome",
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
            "key in (ABC-2111, ABC-2112) AND status NOT IN (Closed, Withdrawn)"
            -> result = SearchResult(
                startAt = startAt,
                maxResults = maxResults,
                total = 2,
                issues = listOf(
                    Ticket(
                        key = "ABC-2111",
                        fields = TicketField(
                            summary = "2111 Epic summary",
                            status = Status(
                                name = "Amazing"
                            ),
                            issuetype = IssueType(
                                name = "Chore"
                            ),
                            customfield_10006 = "ABC-6789",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-01"
                        )
                    ),
                    Ticket(
                        key = "ABC-2112",
                        fields = TicketField(
                            summary = "2112 Epic summary",
                            status = Status(
                                name = "Amazing"
                            ),
                            issuetype = IssueType(
                                name = "Chore"
                            ),
                            customfield_10006 = "ABC-7896",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-01"
                        )
                    )
                )
            )
            "\"Epic Link\" = ABC-2111 AND status NOT IN (Closed, Withdrawn)"
            -> result = SearchResult(
                startAt = startAt,
                maxResults = maxResults,
                total = 2,
                issues = listOf(
                    Ticket(
                        key = "ABC-3111",
                        fields = TicketField(
                            summary = "3111 summary",
                            status = Status(
                                name = "Amazing"
                            ),
                            issuetype = IssueType(
                                name = "Chore"
                            ),
                            customfield_10006 = "ABC-2111",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-01"
                        )
                    ),
                    Ticket(
                        key = "ABC-3112",
                        fields = TicketField(
                            summary = "3112 summary",
                            status = Status(
                                name = "Amazing"
                            ),
                            issuetype = IssueType(
                                name = "Chore"
                            ),
                            customfield_10006 = "ABC-2111",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-01"
                        )
                    )
                )
            )
            "\"Epic Link\" = ABC-2112 AND status NOT IN (Closed, Withdrawn)"
            -> result = SearchResult(
                startAt = startAt,
                maxResults = maxResults,
                total = 2,
                issues = listOf(
                    Ticket(
                        key = "ABC-3113",
                        fields = TicketField(
                            summary = "3113 summary",
                            status = Status(
                                name = "Amazing"
                            ),
                            issuetype = IssueType(
                                name = "Chore"
                            ),
                            customfield_10006 = "ABC-2112",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-01"
                        )
                    ),
                    Ticket(
                        key = "ABC-3114",
                        fields = TicketField(
                            summary = "3114 summary",
                            status = Status(
                                name = "Amazing"
                            ),
                            issuetype = IssueType(
                                name = "Chore"
                            ),
                            customfield_10006 = "ABC-2112",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-01"
                        )
                    )
                )
            )
        }
        return result
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
                            key = "ABC-2111",
                            fields = OutwardInwardIssueFields(
                                issuetype = IssueType(name = "Epic")
                            )
                        ),
                        inwardissue = OutwardInwardIssue(
                            key = "ABC-2111",
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
                            key = "ABC-2112",
                            fields = OutwardInwardIssueFields(
                                issuetype = IssueType(name = "Epic")
                            )
                        ),
                        inwardissue = OutwardInwardIssue(
                            key = "ABC-2112",
                            fields = OutwardInwardIssueFields(
                                issuetype = IssueType(name = "Epic")
                            )
                        )
                    )
                )
            ),
            changelog = null
        )
    }
    fun getIssueWithChangelog(key: String, expand: String, maxResults: Int, startAt: Int): Issue {
        return Issue(
            key = key,
            fields = null,
            changelog = Changelog(
                startAt = startAt,
                maxResults = maxResults,
                total = 1,
                histories = listOf(
                    Histories(
                        created = "2019-12-25T20:00:00.000+0000",
                        items = listOf(
                            Items(
                                field = "status",
                                fromString = "Open",
                                toString = "Closed"
                            )
                        )
                    )
                )
            )
        )
    }
}