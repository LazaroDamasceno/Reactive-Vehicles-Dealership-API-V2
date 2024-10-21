package com.api.v2.customers

import java.time.LocalDateTime
import java.time.ZoneId
import java.util.UUID

data class CustomerAuditTrail(
    val id: UUID,
    val customer: Customer,
    val createdAt: LocalDateTime,
    val createdAtZone: ZoneId
)
