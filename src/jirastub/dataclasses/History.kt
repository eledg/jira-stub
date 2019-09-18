package com.elliotledger.jirastub.dataclasses

data class History(
    val created: String,
    val items: List<Item>
)