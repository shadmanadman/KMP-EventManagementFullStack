package org.kmp.playground.event.management.full.stack.features.artists.mapper

import org.bson.types.ObjectId
import org.kmp.playground.event.management.full.stack.domain.models.artists.request.ArtistsRequest
import org.kmp.playground.event.management.full.stack.domain.models.artists.request.EventArtistsRequest
import org.kmp.playground.event.management.full.stack.features.artists.db.entity.Artists
import org.kmp.playground.event.management.full.stack.features.artists.db.entity.EventArtists


fun EventArtistsRequest.toEntity() = EventArtists(
    eventArtistId = ObjectId(),
    eventId = ObjectId(this.eventId),
    artistId = ObjectId(this.artistId)
)

fun ArtistsRequest.toEntity() =
    Artists(artistId = ObjectId(), artistName = this.artistName, artistAvatar = this.artistAvatar)