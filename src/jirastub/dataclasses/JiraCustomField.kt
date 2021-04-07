package com.elliotledger.jirastub.dataclasses

data class JiraCustomField(
    val value: String,
    val self: String = "some-url",
    val id: String = "some-id"
)