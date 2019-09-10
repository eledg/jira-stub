package com.elliotledger.jirastub.dataclasses

data class SearchResult(
    val startAt: Int,
    val maxResults: Int,
    val total: Int,
    val issues: List<Ticket>
)