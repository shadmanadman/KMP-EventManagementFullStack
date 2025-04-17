package org.kmp.playground.event.management.full.stack.domain.ports

import org.bson.BsonValue
import org.bson.types.ObjectId
import org.kmp.playground.event.management.full.stack.domain.entity.Users

interface UsersRepo {
    suspend fun findAll(): List<Users>?

    suspend fun findById(objectId: ObjectId): Users?

    suspend fun insertOne(user: Users): BsonValue?

    suspend fun deleteById(objectId: ObjectId): Long

    suspend fun updateOne(objectId: ObjectId, user: Users): Long
}