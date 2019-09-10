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
    fun getSearchResultWith(jql: String): SearchResult {
        //logger.debug(jql)
        return SearchResult(
            startAt = 0,
            maxResults = 50,
            total = 3,
            issues = listOf(
                Ticket(
                    id = "01111",
                     key = "ABC-1111",
                    fields = TicketField(
                        summary = "A summary",
                        status = Status(
                            description = "A description",
                            iconUrl = "url",
                            name = "Status Name",
                            id = "54321"
                        ),
                        issueType = IssueType(
                            id = "23456",
                            description = "Type description",
                            iconUrl = "url",
                            name = "Type name",
                            subtask = false,
                            avatarId = 12345
                        ),
                        epicLinksKey = "ABC-1234",
                        assignee = "Tony",
                        dueDate = "01/01/2020"
                    )
                ),
                Ticket(
                    id = "01112",
                    key = "ABC-1112",
                    fields = TicketField(
                        summary = "A summary",
                        status = Status(
                            description = "B description",
                            iconUrl = "url",
                            name = "Status Name",
                            id = "54321"
                        ),
                        issueType = IssueType(
                            id = "23456",
                            description = "Type description",
                            iconUrl = "url",
                            name = "Type name",
                            subtask = false,
                            avatarId = 12345
                        ),
                        epicLinksKey = "ABC-1234",
                        assignee = "Tony",
                        dueDate = "02/01/2020"
                    )
                ),
                Ticket(
                    id = "01113",
                    key = "ABC-1113",
                    fields = TicketField(
                        summary = "A summary",
                        status = Status(
                            description = "C description",
                            iconUrl = "url",
                            name = "Status Name",
                            id = "54321"
                        ),
                        issueType = IssueType(
                            id = "23456",
                            description = "Type description",
                            iconUrl = "url",
                            name = "Type name",
                            subtask = false,
                            avatarId = 12345
                        ),
                        epicLinksKey = "ABC-1234",
                        assignee = "Tony",
                        dueDate = "03/01/2020"
                    )
                )
            )
        )
    }
}