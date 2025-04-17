package org.kmp.playground.event.management.full.stack.domain.ports

import org.bson.BsonValue
import org.bson.types.ObjectId
import org.kmp.playground.event.management.full.stack.domain.entity.Artists
import org.kmp.playground.event.management.full.stack.domain.entity.Events

interface EventsRepo {
    suspend fun findAll(): List<Events>?

    suspend fun findById(objectId: ObjectId): Events?

    suspend fun insertOne(events: Events): BsonValue?

    suspend fun deleteById(objectId: ObjectId): Long

    suspend fun updateOne(objectId: ObjectId, events: Events): Long
}