package com.elliotledger.jirastub.dataclasses

data class TicketField(
    val summary: String,
    val status: Status,
    val issueType: IssueType,
    val epicLinksKey: String,
    val assignee: String,
    val dueDate: String
)