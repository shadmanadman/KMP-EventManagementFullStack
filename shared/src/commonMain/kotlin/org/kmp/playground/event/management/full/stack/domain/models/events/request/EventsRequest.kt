package org.kmp.playground.event.management.full.stack.domain.models.events.request


data class EventRequest(
    val eventName: String,
    val eventDate: String,
    val eventTime: String?,
    val location: String?,
    val description: String?,
    val capacity: Int?,
    val coverImage: String?
)


data class EventRegistrationRequest(val userId: String, val eventId: String)
