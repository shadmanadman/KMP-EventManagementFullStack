package org.kmp.playground.event.management.full.stack.application.request

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import org.kmp.playground.event.management.full.stack.domain.entity.Artists
import org.kmp.playground.event.management.full.stack.domain.entity.EventArtists

data class ArtistsRequest(
    val artistName: String, val artistAvatar: String
)

fun ArtistsRequest.toDomain() =
    Artists(artistId = ObjectId(), artistName = this.artistName, artistAvatar = this.artistAvatar)

data class EventArtistsRequest(val artistId:ObjectId,val eventId:ObjectId)

fun EventArtistsRequest.toDomain() = EventArtists(eventArtistId = ObjectId(), eventId = this.eventId, artistId = this.artistId)