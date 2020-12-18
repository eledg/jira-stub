package com.elliotledger.jirastub.dataclasses

data class IssueFields(
    val issuelinks: List<IssueLink>,
    val created: String,
    val summary: String,
    val status: Status
)