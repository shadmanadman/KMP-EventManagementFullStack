package org.kmp.playground.event.management.full.stack.features.users.db.dao

import com.mongodb.MongoException
import com.mongodb.client.model.Filters
import com.mongodb.client.model.UpdateOptions
import com.mongodb.client.model.Updates
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.toList
import org.bson.BsonValue
import org.bson.types.ObjectId
import org.kmp.playground.event.management.full.stack.features.artists.db.entity.Artists
import org.kmp.playground.event.management.full.stack.features.events.db.entity.Events
import org.kmp.playground.event.management.full.stack.features.users.db.entity.Users

class UsersDaoImpl (private val mongoDatabase: MongoDatabase):UsersDao{
    companion object {
        const val USERS_COLLECTION = "users"
    }
    override suspend fun findAll(): List<Users> =
    mongoDatabase.getCollection<Users>(USERS_COLLECTION).find().toList()

    override suspend fun findById(objectId: ObjectId): Users? =
        mongoDatabase.getCollection<Artists>(USERS_COLLECTION).withDocumentClass<Users>()
            .find(Filters.eq("_id", objectId))
            .firstOrNull()

    override suspend fun insertOne(user: Users): BsonValue? {
        try {
            val result = mongoDatabase.getCollection<Users>(USERS_COLLECTION).insertOne(
                user
            )

            return result.insertedId
        } catch (e: MongoException) {
            System.err.println("Unable to insert due to an error: $e")
        }

        return null
    }

    override suspend fun deleteById(objectId: ObjectId): Long {
        try {
            val result = mongoDatabase.getCollection<Users>(USERS_COLLECTION)
                .deleteOne(Filters.eq("_id", objectId))
            return result.deletedCount
        } catch (e: MongoException) {
            System.err.println("Unable to delete due to an error: $e")
        }

        return 0
    }

    override suspend fun updateOne(objectId: ObjectId, user: Users): Long {
        try {
            val query = Filters.eq("_id", objectId)
            val updates = Updates.combine(
                Updates.set(Users::username.name, user.username),
                Updates.set(Users::email.name, user.email),
                Updates.set(Users::password.name, user.password),
                Updates.set(Users::phoneNumber.name, user.phoneNumber),
                Updates.set(Users::avatar.name, user.avatar),
           )

            val options = UpdateOptions().upsert(true)

            val result =
                mongoDatabase.getCollection<Events>(USERS_COLLECTION)
                    .updateOne(query, updates, options)

            return result.modifiedCount
        } catch (e: MongoException) {
            System.err.println("Unable to update due to an error: $e")
        }

        return 0
    }

}