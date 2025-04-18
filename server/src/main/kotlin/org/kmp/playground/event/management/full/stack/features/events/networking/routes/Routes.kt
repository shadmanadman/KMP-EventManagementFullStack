package org.kmp.playground.event.management.full.stack.features.events.networking.routes

import io.ktor.http.HttpStatusCode
import io.ktor.server.request.receive
import io.ktor.server.response.respond
import io.ktor.server.response.respondText
import io.ktor.server.routing.Route
import io.ktor.server.routing.delete
import io.ktor.server.routing.get
import io.ktor.server.routing.patch
import io.ktor.server.routing.post
import io.ktor.server.routing.route
import org.bson.types.ObjectId
import org.kmp.playground.event.management.full.stack.domain.models.events.request.EventRequest
import org.kmp.playground.event.management.full.stack.features.events.di.EventsModule
import org.kmp.playground.event.management.full.stack.features.events.mapper.toEntity

fun Route.eventsRouting() {
    val repository = EventsModule.eventsDao()

    route("/events") {
        get {
            repository.findAll()?.let { list ->
                call.respond(list.map { it.toResponse() })
            } ?: call.respondText("No records found")
        }

        get("/{id?}") {
            val id = call.parameters["id"]
            if (id.isNullOrEmpty()) {
                return@get call.respondText(
                    text = "Missing id",
                    status = HttpStatusCode.BadRequest
                )
            }

            repository.findById(ObjectId(id))?.let {
                call.respond(it.toResponse())
            } ?: call.respondText("No records found for id $id")
        }


        delete("/{id?}") {
            val id = call.parameters["id"] ?: return@delete call.respondText(
                text = "Missing event id",
                status = HttpStatusCode.BadRequest
            )

            val delete: Long = repository.deleteById(ObjectId(id))

            if (delete == 1L) {
                return@delete call.respondText(
                    "Event Deleted successfully",
                    status = HttpStatusCode.OK
                )
            }
            return@delete call.respondText("Event not found", status = HttpStatusCode.NotFound)

        }


        patch("/{id?}") {
            val id = call.parameters["id"] ?: return@patch call.respondText(
                text = "Missing event id",
                status = HttpStatusCode.BadRequest
            )

            val updated = repository.updateOne(ObjectId(id), call.receive())

            call.respondText(
                text = if (updated == 1L) "Event updated successfully" else "Event not found",
                status = if (updated == 1L) HttpStatusCode.OK else HttpStatusCode.NotFound
            )
        }

        post {
            val event = call.receive<EventRequest>()
            val insertedId = repository.insertOne(event.toEntity())
            call.respond(HttpStatusCode.Created, "Created event with id $insertedId")
        }
    }
}