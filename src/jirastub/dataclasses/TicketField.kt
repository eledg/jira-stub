package com.elliotledger.jirastub.dataclasses

data class TicketField(
    val summary: String,
    val timetracking: String?,
    val issueType: IssueType,
    val description: String?,
    val project: Project?
)