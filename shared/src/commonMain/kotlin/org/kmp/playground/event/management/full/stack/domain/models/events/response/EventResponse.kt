package org.kmp.playground.event.management.full.stack.domain.models.events.response

data class EventResponse(
    val id:String,
    val eventName: String,
    val eventDate: String,
    val eventTime: String?,
    val location: String?,
    val description: String?,
    val capacity: Int?,
    val coverImage: String?
)


data class EventRegistrationsResponse(val userId: String, val eventId: String)