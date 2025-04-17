package org.kmp.playground.event.management.full.stack.application.request

import org.bson.types.ObjectId
import org.kmp.playground.event.management.full.stack.domain.entity.EventRegistrations
import org.kmp.playground.event.management.full.stack.domain.entity.Events
import java.time.LocalDate
import java.time.LocalTime


data class EventRequest(
    val eventName: String,
    val eventDate: LocalDate,
    val eventTime: LocalTime?,
    val location: String?,
    val description: String?,
    val capacity: Int?,
    val coverImage: String?
)

fun EventRequest.toEntity() = Events(
    eventName = this.eventName,
    eventDate = this.eventDate,
    eventTime = this.eventTime,
    location = this.location,
    description = this.description,
    capacity = this.capacity,
    coverImage = this.coverImage
)

data class EventRegistrationRequest(val userId: String, val eventId: String)
fun EventRegistrationRequest.toEntity() =
    EventRegistrations(userId = ObjectId(this.userId), eventId = ObjectId(this.eventId))