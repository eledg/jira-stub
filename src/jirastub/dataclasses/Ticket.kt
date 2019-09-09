package com.elliotledger.jirastub.dataclasses

data class Ticket(
    val expand: String,
    val id: String,
    val self: String?,
    val key: String,
    val fields: TicketField
)