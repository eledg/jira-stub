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
                        duedate = "2020-01-07"
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
                        duedate = "2020-01-05"
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
                        duedate = "2020-01-03"
                    )
                )
            )
        )
        when (jql) {
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
                            customfield_10006 = "ABC-6100",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-07"
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
                            customfield_10006 = "ABC-6101",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-06"
                        )
                    )
                )
            )
            "key in (ABC-2113, ABC-2114) AND status NOT IN (Closed, Withdrawn)"
            -> result = SearchResult(
                startAt = startAt,
                maxResults = maxResults,
                total = 2,
                issues = listOf(
                    Ticket(
                        key = "ABC-2113",
                        fields = TicketField(
                            summary = "2113 Epic summary",
                            status = Status(
                                name = "Amazing"
                            ),
                            issuetype = IssueType(
                                name = "Chore"
                            ),
                            customfield_10006 = "ABC-6102",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-05"
                        )
                    ),
                    Ticket(
                        key = "ABC-2114",
                        fields = TicketField(
                            summary = "2114 Epic summary",
                            status = Status(
                                name = "Amazing"
                            ),
                            issuetype = IssueType(
                                name = "Chore"
                            ),
                            customfield_10006 = "ABC-6103",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-04"
                        )
                    )
                )
            )
            "key in (ABC-2115, ABC-2116) AND status NOT IN (Closed, Withdrawn)"
            -> result = SearchResult(
                startAt = startAt,
                maxResults = maxResults,
                total = 2,
                issues = listOf(
                    Ticket(
                        key = "ABC-2115",
                        fields = TicketField(
                            summary = "2115 Epic summary",
                            status = Status(
                                name = "Amazing"
                            ),
                            issuetype = IssueType(
                                name = "Chore"
                            ),
                            customfield_10006 = "ABC-6104",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-03"
                        )
                    ),
                    Ticket(
                        key = "ABC-2116",
                        fields = TicketField(
                            summary = "2116 Epic summary",
                            status = Status(
                                name = "Amazing"
                            ),
                            issuetype = IssueType(
                                name = "Chore"
                            ),
                            customfield_10006 = "ABC-6105",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-02"
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
                        key = "ABC-4001",
                        fields = TicketField(
                            summary = "4001 summary",
                            status = Status(
                                name = "Amazing"
                            ),
                            issuetype = IssueType(
                                name = "Chore"
                            ),
                            customfield_10006 = "ABC-2111",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-07"
                        )
                    ),
                    Ticket(
                        key = "ABC-4002",
                        fields = TicketField(
                            summary = "4002 summary",
                            status = Status(
                                name = "Amazing"
                            ),
                            issuetype = IssueType(
                                name = "Chore"
                            ),
                            customfield_10006 = "ABC-2111",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-06"
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
                        key = "ABC-4003",
                        fields = TicketField(
                            summary = "4003 summary",
                            status = Status(
                                name = "Amazing"
                            ),
                            issuetype = IssueType(
                                name = "Chore"
                            ),
                            customfield_10006 = "ABC-2112",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-06"
                        )
                    ),
                    Ticket(
                        key = "ABC-4004",
                        fields = TicketField(
                            summary = "4004 summary",
                            status = Status(
                                name = "Amazing"
                            ),
                            issuetype = IssueType(
                                name = "Chore"
                            ),
                            customfield_10006 = "ABC-2112",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-05"
                        )
                    )
                )
            )
            "\"Epic Link\" = ABC-2113 AND status NOT IN (Closed, Withdrawn)"
            -> result = SearchResult(
                startAt = startAt,
                maxResults = maxResults,
                total = 2,
                issues = listOf(
                    Ticket(
                        key = "ABC-4005",
                        fields = TicketField(
                            summary = "4005 summary",
                            status = Status(
                                name = "Amazing"
                            ),
                            issuetype = IssueType(
                                name = "Chore"
                            ),
                            customfield_10006 = "ABC-2113",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-05"
                        )
                    ),
                    Ticket(
                        key = "ABC-4006",
                        fields = TicketField(
                            summary = "4006 summary",
                            status = Status(
                                name = "Amazing"
                            ),
                            issuetype = IssueType(
                                name = "Chore"
                            ),
                            customfield_10006 = "ABC-2113",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-04"
                        )
                    )
                )
            )
            "\"Epic Link\" = ABC-2114 AND status NOT IN (Closed, Withdrawn)"
            -> result = SearchResult(
                startAt = startAt,
                maxResults = maxResults,
                total = 2,
                issues = listOf(
                    Ticket(
                        key = "ABC-4006",
                        fields = TicketField(
                            summary = "4006 summary",
                            status = Status(
                                name = "Amazing"
                            ),
                            issuetype = IssueType(
                                name = "Chore"
                            ),
                            customfield_10006 = "ABC-2114",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-04"
                        )
                    ),
                    Ticket(
                        key = "ABC-4007",
                        fields = TicketField(
                            summary = "4007 summary",
                            status = Status(
                                name = "Amazing"
                            ),
                            issuetype = IssueType(
                                name = "Chore"
                            ),
                            customfield_10006 = "ABC-2114",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-03"
                        )
                    )
                )
            )
            "\"Epic Link\" = ABC-2115 AND status NOT IN (Closed, Withdrawn)"
            -> result = SearchResult(
                startAt = startAt,
                maxResults = maxResults,
                total = 2,
                issues = listOf(
                    Ticket(
                        key = "ABC-4008",
                        fields = TicketField(
                            summary = "4008 summary",
                            status = Status(
                                name = "Amazing"
                            ),
                            issuetype = IssueType(
                                name = "Chore"
                            ),
                            customfield_10006 = "ABC-2115",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-03"
                        )
                    ),
                    Ticket(
                        key = "ABC-4009",
                        fields = TicketField(
                            summary = "4009 summary",
                            status = Status(
                                name = "Amazing"
                            ),
                            issuetype = IssueType(
                                name = "Chore"
                            ),
                            customfield_10006 = "ABC-2115",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-02"
                        )
                    )
                )
            )
            "\"Epic Link\" = ABC-2116 AND status NOT IN (Closed, Withdrawn)"
            -> result = SearchResult(
                startAt = startAt,
                maxResults = maxResults,
                total = 2,
                issues = listOf(
                    Ticket(
                        key = "ABC-4010",
                        fields = TicketField(
                            summary = "4010 summary",
                            status = Status(
                                name = "Amazing"
                            ),
                            issuetype = IssueType(
                                name = "Chore"
                            ),
                            customfield_10006 = "ABC-2116",
                            assignee = Assignee(displayName = "Tony Foxbridge"),
                            duedate = "2020-01-02"
                        )
                    ),
                    Ticket(
                        key = "ABC-4011",
                        fields = TicketField(
                            summary = "4011 summary",
                            status = Status(
                                name = "Amazing"
                            ),
                            issuetype = IssueType(
                                name = "Chore"
                            ),
                            customfield_10006 = "ABC-2116",
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
        var result = Issue(
            key = key,
            fields = IssueFields(
                issuelinks = listOf(
                    IssueLink(
                        type = IssueLinkType(
                            name = "Gantt End to End",
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
                            name = "Gantt End to End",
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
                ),
                created = "2019-05-01T20:00:00.000+0000",
                summary = "Issue title",
                status = "Amazing"
            ),
            changelog = null
        )
        when (key) {
            "ABC-1112"
            -> result = Issue(
                key = key,
                fields = IssueFields(
                    issuelinks = listOf(
                        IssueLink(
                            type = IssueLinkType(
                                name = "Gantt End to End",
                                inward = "depends on"
                            ),
                            outwardIssue = OutwardInwardIssue(
                                key = "ABC-2113",
                                fields = OutwardInwardIssueFields(
                                    issuetype = IssueType(name = "Epic")
                                )
                            ),
                            inwardissue = OutwardInwardIssue(
                                key = "ABC-2113",
                                fields = OutwardInwardIssueFields(
                                    issuetype = IssueType(name = "Epic")
                                )
                            )
                        ),
                        IssueLink(
                            type = IssueLinkType(
                                name = "Gantt End to End",
                                inward = "depends on"
                            ),
                            outwardIssue = OutwardInwardIssue(
                                key = "ABC-2114",
                                fields = OutwardInwardIssueFields(
                                    issuetype = IssueType(name = "Epic")
                                )
                            ),
                            inwardissue = OutwardInwardIssue(
                                key = "ABC-2114",
                                fields = OutwardInwardIssueFields(
                                    issuetype = IssueType(name = "Epic")
                                )
                            )
                        )
                    ),
                    created = "2019-05-01T20:00:00.000+0000",
                    summary = "Issue title",
                    status = "Amazing"
                ),
                changelog = null
            )
            "ABC-1113"
            -> result = Issue(
                key = key,
                fields = IssueFields(
                    issuelinks = listOf(
                        IssueLink(
                            type = IssueLinkType(
                                name = "Gantt End to End",
                                inward = "depends on"
                            ),
                            outwardIssue = OutwardInwardIssue(
                                key = "ABC-2115",
                                fields = OutwardInwardIssueFields(
                                    issuetype = IssueType(name = "Epic")
                                )
                            ),
                            inwardissue = OutwardInwardIssue(
                                key = "ABC-2115",
                                fields = OutwardInwardIssueFields(
                                    issuetype = IssueType(name = "Epic")
                                )
                            )
                        ),
                        IssueLink(
                            type = IssueLinkType(
                                name = "Gantt End to End",
                                inward = "depends on"
                            ),
                            outwardIssue = OutwardInwardIssue(
                                key = "ABC-2116",
                                fields = OutwardInwardIssueFields(
                                    issuetype = IssueType(name = "Epic")
                                )
                            ),
                            inwardissue = OutwardInwardIssue(
                                key = "ABC-2116",
                                fields = OutwardInwardIssueFields(
                                    issuetype = IssueType(name = "Epic")
                                )
                            )
                        )
                    ),
                    created = "2019-05-01T20:00:00.000+0000",
                    summary = "Issue title",
                    status = "Amazing"
                ),
                changelog = null
            )
        }
        return result
    }
    fun getIssueWithChangelog(key: String, expand: String, maxResults: Int, startAt: Int): Issue {
        return Issue(
            key = key,
            fields = IssueFields(
                issuelinks = listOf(
                    IssueLink(
                        type = IssueLinkType(
                            name = "Gantt End to End",
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
                    )
                ),
                created = "2019-05-01T20:00:00.000+0000",
                summary = "Issue title",
                status = "Amazing"
            ),
            changelog = Changelog(
                startAt = startAt,
                maxResults = maxResults,
                total = 1,
                histories = listOf(
                    Histories(
                        created = "2019-05-01T20:00:00.000+0000",
                        items = listOf(
                            Items(
                                field = "status",
                                fromString = "Next",
                                toString = "In Progress"
                            )
                        )
                    )
                )
            )
        )
    }
}