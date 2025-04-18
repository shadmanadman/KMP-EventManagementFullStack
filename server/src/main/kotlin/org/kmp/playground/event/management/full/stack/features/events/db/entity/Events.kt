package org.kmp.playground.event.management.full.stack.features.events.db.entity

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import org.kmp.playground.event.management.full.stack.domain.models.events.request.EventRegistrationRequest
import org.kmp.playground.event.management.full.stack.domain.models.events.request.EventRequest
import org.kmp.playground.event.management.full.stack.domain.models.events.response.EventResponse
import java.time.LocalDateTime

data class Events(
    @BsonId
    val eventId: ObjectId = ObjectId(),
    val eventName: String?,
    val eventDate: String?,
    val eventTime: String?,
    val location: String?,
    val description: String?,
    val capacity: Int?,
    val coverImage: String?
) {
    fun toResponse() = EventResponse(
        id = eventId.toString(),
        eventName = eventName,
        eventDate = eventDate,
        eventTime = eventTime,
        location = location,
        description = description,
        capacity = capacity,
        coverImage = coverImage
    )
}

data class EventRegistrations(
    @BsonId
    val registrationId: ObjectId = ObjectId(),
    val userId: ObjectId,
    val eventId: ObjectId,
    val registrationTimestamp: LocalDateTime = LocalDateTime.now()
)


