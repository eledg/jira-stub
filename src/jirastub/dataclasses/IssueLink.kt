package com.elliotledger.jirastub.dataclasses

data class IssueLink(
    val type: IssueLinkType,
    val outwardIssue: OutwardInwardIssue,
    val inwardissue: OutwardInwardIssue
)