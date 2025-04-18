package org.kmp.playground.event.management.full.stack.features.events.db.dao

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

class EventsDaoImpl (private val mongoDatabase: MongoDatabase):EventsDao{
    companion object {
        const val EVENTS_COLLECTION = "events"
    }
    override suspend fun findAll(): List<Events> =
    mongoDatabase.getCollection<Events>(EVENTS_COLLECTION).find().toList()


    override suspend fun findById(objectId: ObjectId): Events? =
        mongoDatabase.getCollection<Artists>(EVENTS_COLLECTION).withDocumentClass<Events>()
            .find(Filters.eq("_id", objectId))
            .firstOrNull()

    override suspend fun insertOne(events: Events): BsonValue? {
        try {
            val result = mongoDatabase.getCollection<Events>(EVENTS_COLLECTION).insertOne(
                events
            )

            return result.insertedId
        } catch (e: MongoException) {
            System.err.println("Unable to insert due to an error: $e")
        }

        return null
    }

    override suspend fun deleteById(objectId: ObjectId): Long {
        try {
            val result = mongoDatabase.getCollection<Events>(EVENTS_COLLECTION)
                .deleteOne(Filters.eq("_id", objectId))
            return result.deletedCount
        } catch (e: MongoException) {
            System.err.println("Unable to delete due to an error: $e")
        }

        return 0
    }

    override suspend fun updateOne(objectId: ObjectId, events: Events): Long {
        try {
            val query = Filters.eq("_id", objectId)
            val updates = Updates.combine(
                Updates.set(Events::eventName.name, events.eventName),
                Updates.set(Events::eventDate.name, events.eventDate),
                Updates.set(Events::location.name, events.location),
                Updates.set(Events::coverImage.name, events.coverImage),
                Updates.set(Events::eventTime.name, events.eventTime)
            )

            val options = UpdateOptions().upsert(true)

            val result =
                mongoDatabase.getCollection<Events>(EVENTS_COLLECTION)
                    .updateOne(query, updates, options)

            return result.modifiedCount
        } catch (e: MongoException) {
            System.err.println("Unable to update due to an error: $e")
        }

        return 0
    }

}