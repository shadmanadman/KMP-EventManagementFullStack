package org.kmp.playground.event.management.full.stack.features.events.mapper

import org.bson.types.ObjectId
import org.kmp.playground.event.management.full.stack.domain.models.events.request.EventRegistrationRequest
import org.kmp.playground.event.management.full.stack.domain.models.events.request.EventRequest
import org.kmp.playground.event.management.full.stack.features.events.db.entity.EventRegistrations
import org.kmp.playground.event.management.full.stack.features.events.db.entity.Events


fun EventRegistrationRequest.toEntity() =
    EventRegistrations(userId = ObjectId(this.userId), eventId = ObjectId(this.eventId))

fun EventRequest.toEntity() = Events(
    eventName = this.eventName,
    eventDate = this.eventDate,
    eventTime = this.eventTime,
    location = this.location,
    description = this.description,
    capacity = this.capacity,
    coverImage = this.coverImage
)
