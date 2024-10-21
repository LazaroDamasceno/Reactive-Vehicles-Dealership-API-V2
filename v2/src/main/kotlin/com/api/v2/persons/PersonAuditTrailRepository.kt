package com.api.v2.persons

import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import java.util.*

interface PersonAuditTrailRepository: CoroutineCrudRepository<PersonAuditTrail, UUID>
