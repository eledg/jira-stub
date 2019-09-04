package com.elliotledger.jirastub.dataclasses

class User(
    val key: String,
    val name: String,
    val emailAddress: String,
    val avatarUrls: Map<String, String>,
    val displayName: String,
    val active: Boolean
)