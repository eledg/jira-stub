package com.elliotledger.jirastub.dataclasses

data class IssueLink(
    val type: IssueLinkType,
    val outwardIssue: OutInIssue,
    val inwardIssue: OutInIssue
)