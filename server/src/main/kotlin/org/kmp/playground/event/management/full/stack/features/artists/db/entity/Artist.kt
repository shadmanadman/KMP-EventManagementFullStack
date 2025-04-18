package org.kmp.playground.event.management.full.stack.features.artists.db.entity

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import org.kmp.playground.event.management.full.stack.domain.models.artists.request.ArtistsRequest
import org.kmp.playground.event.management.full.stack.domain.models.artists.request.EventArtistsRequest
import org.kmp.playground.event.management.full.stack.domain.models.artists.response.ArtistsResponse

data class Artists(
    @BsonId
    val artistId: ObjectId = ObjectId(),
    val artistName: String,
    val artistAvatar: String
) {
    fun toResponse() = ArtistsResponse(
        id = artistId.toString(),
        artistName = artistName,
        artistAvatar = artistAvatar
    )
}

data class EventArtists(
    @BsonId
    val eventArtistId: ObjectId = ObjectId(),
    val eventId: ObjectId,
    val artistId: ObjectId
)
