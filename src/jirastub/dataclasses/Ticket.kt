package com.elliotledger.jirastub.dataclasses

import com.google.gson.JsonObject

data class Ticket(
    val expand: String,
    val id: String,
    val self: String,
    val key: String,
    val fields: JsonObject
)