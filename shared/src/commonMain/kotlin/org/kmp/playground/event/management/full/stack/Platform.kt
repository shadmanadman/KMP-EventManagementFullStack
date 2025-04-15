package org.kmp.playground.event.management.full.stack

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform