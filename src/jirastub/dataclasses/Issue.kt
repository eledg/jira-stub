package com.elliotledger.jirastub.dataclasses

data class Issue(
    val key: String,
    val fields: IssueFields?,
    val changelog: Changelog?
)