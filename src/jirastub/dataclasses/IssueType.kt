package com.elliotledger.jirastub.dataclasses

data class IssueType(
    val self: String?,
    val id: String,
    val description: String,
    val iconUrl: String,
    val name: String,
    val subtask: Boolean,
    val avatarId: Int
)