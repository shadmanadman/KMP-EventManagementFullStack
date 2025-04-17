package org.kmp.playground.event.management.full.stack.domain.ports

import org.bson.BsonValue
import org.bson.types.ObjectId
import org.kmp.playground.event.management.full.stack.domain.entity.Artists
import org.kmp.playground.event.management.full.stack.domain.entity.Events


interface ArtistRepo {

    suspend fun findAll(): List<Artists>?

    suspend fun findById(objectId: ObjectId): Artists?

    suspend fun insertOne(artists: Artists): BsonValue?

    suspend fun deleteById(objectId: ObjectId): Long

    suspend fun updateOne(objectId: ObjectId, artists: Artists): Long
}