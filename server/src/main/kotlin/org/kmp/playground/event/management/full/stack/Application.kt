package org.kmp.playground.event.management.full.stack

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.kmp.playground.event.management.full.stack.features.artists.networking.routes.artistsRouting
import org.kmp.playground.event.management.full.stack.features.events.networking.routes.eventsRouting
import org.kmp.playground.event.management.full.stack.features.users.networking.routes.usersRouting

fun main() {
    embeddedServer(Netty, port = SERVER_PORT, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    routing {
        artistsRouting()
        usersRouting()
        eventsRouting()
    }
}