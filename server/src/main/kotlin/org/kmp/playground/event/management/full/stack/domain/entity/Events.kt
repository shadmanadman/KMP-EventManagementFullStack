package org.kmp.playground.event.management.full.stack.domain.entity

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

data class Events(
    @BsonId
    val eventId: ObjectId = ObjectId(),
    val eventName: String,
    val eventDate: LocalDate,
    val eventTime: LocalTime?,
    val location: String?,
    val description: String?,
    val capacity: Int?,
    val coverImage: String?
)

data class EventRegistrations(
    @BsonId
    val registrationId: ObjectId = ObjectId(),
    val userId: ObjectId,
    val eventId: ObjectId,
    val registrationTimestamp: LocalDateTime = LocalDateTime.now()
)


