package org.kmp.playground.event.management.full.stack.features.artists.db.dao

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

class ArtistRepoImpl(private val mongoDatabase: MongoDatabase) : ArtistDao {
    companion object {
        const val ARTISTS_COLLECTION = "artists"
    }

    override suspend fun findAll(): List<Artists> =
        mongoDatabase.getCollection<Artists>(ARTISTS_COLLECTION).find().toList()

    override suspend fun findById(objectId: ObjectId): Artists? =
        mongoDatabase.getCollection<Artists>(ARTISTS_COLLECTION).withDocumentClass<Artists>()
            .find(Filters.eq("_id", objectId))
            .firstOrNull()


    override suspend fun insertOne(artists: Artists): BsonValue? {
        try {
            val result = mongoDatabase.getCollection<Artists>(ARTISTS_COLLECTION).insertOne(
                artists
            )

            return result.insertedId
        } catch (e: MongoException) {
            System.err.println("Unable to insert due to an error: $e")
        }

        return null
    }

    override suspend fun deleteById(objectId: ObjectId): Long {
        try {
            val result = mongoDatabase.getCollection<Artists>(ARTISTS_COLLECTION)
                .deleteOne(Filters.eq("_id", objectId))
            return result.deletedCount
        } catch (e: MongoException) {
            System.err.println("Unable to delete due to an error: $e")
        }

        return 0
    }

    override suspend fun updateOne(objectId: ObjectId, artists: Artists): Long {
        try {
            val query = Filters.eq("_id", objectId)
            val updates = Updates.combine(
                Updates.set(Artists::artistName.name, artists.artistName),
                Updates.set(Artists::artistAvatar.name, artists.artistAvatar)
            )

            val options = UpdateOptions().upsert(true)

            val result =
                mongoDatabase.getCollection<Artists>(ARTISTS_COLLECTION)
                    .updateOne(query, updates, options)

            return result.modifiedCount
        } catch (e: MongoException) {
            System.err.println("Unable to update due to an error: $e")
        }

        return 0
    }

}