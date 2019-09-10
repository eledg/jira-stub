package com.elliotledger.jirastub.dataclasses

data class Ticket(
    val id: String,
    val key: String,
    val fields: TicketField
)