package com.elliotledger.jirastub.dataclasses

data class TicketField(
    val summary: String,
    val status: Status,
    val issuetype: IssueType,
    val customfield_10006: String,
    val assignee: Assignee,
    val duedate: String
)