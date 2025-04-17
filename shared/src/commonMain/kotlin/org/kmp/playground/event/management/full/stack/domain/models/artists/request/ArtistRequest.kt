package org.kmp.playground.event.management.full.stack.domain.models.artists.request

data class ArtistsRequest(
    val artistName: String, val artistAvatar: String
)


data class EventArtistsRequest(val artistId: String, val eventId: String)

