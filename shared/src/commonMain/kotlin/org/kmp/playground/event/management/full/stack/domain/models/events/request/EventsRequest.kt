package org.kmp.playground.event.management.full.stack.domain.models.events.request

import org.kmp.playground.event.management.full.stack.domain.entity.EventRegistrations
import org.kmp.playground.event.management.full.stack.domain.entity.Events


data class EventRequest(
    val eventName: String,
    val eventDate: String,
    val eventTime: String?,
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
