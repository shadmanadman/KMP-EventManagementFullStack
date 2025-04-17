package org.kmp.playground.event.management.full.stack.application.response

import java.time.LocalDate
import java.time.LocalTime

data class EventResponse(
    val id:String,
    val eventName: String,
    val eventDate: LocalDate,
    val eventTime: LocalTime?,
    val location: String?,
    val description: String?,
    val capacity: Int?,
    val coverImage: String?
)


data class EventRegistrationsResponse(val userId: String, val eventId: String)