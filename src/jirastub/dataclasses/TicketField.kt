package com.elliotledger.jirastub.dataclasses

data class TicketField(
    val summary: String,
    val status: Status,
    val issuetype: IssueType,
    val customfield_10006: String,
    val assignee: Assignee,
    val duedate: String,
    val customfield_11912: FeatureStateField?,
    val customfield_18301: JiraCustomField?, // Performance Testing: Required, Not required
    val customfield_16800: JiraCustomField? // Migrator: Yes, No
)