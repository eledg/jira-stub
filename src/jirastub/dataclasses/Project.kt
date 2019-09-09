package com.elliotledger.jirastub.dataclasses

data class Project(
    val self: String?,
    val id: String,
    val key: String,
    val name: String,
    val avatarUrls: Map<String, String>
)