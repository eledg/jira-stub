package com.elliotledger.jirastub.dataclasses

data class Changelog(
    val startAt: Int,
    val maxResults: Int,
    val total: Int,
    val histories: List<History>
)