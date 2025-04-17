package org.kmp.playground.event.management.full.stack.features.artists.db.dao

import org.bson.BsonValue
import org.bson.types.ObjectId
import org.kmp.playground.event.management.full.stack.features.artists.db.entity.Artists

interface ArtistDao {

    suspend fun findAll(): List<Artists>?

    suspend fun findById(objectId: ObjectId): Artists?

    suspend fun insertOne(artists: Artists): BsonValue?

    suspend fun deleteById(objectId: ObjectId): Long

    suspend fun updateOne(objectId: ObjectId, artists: Artists): Long
}