package com.elliotledger.jirastub.dataclasses

data class Ticket(
    val id: String,
    val key: String,
    val type: String,
    val fields: TicketField
)