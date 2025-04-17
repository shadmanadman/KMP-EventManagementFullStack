package org.kmp.playground.event.management.full.stack.domain.models.users.request


data class UsersRequest(
    val username: String,
    val email: String,
    val phone: String,
    val password: String,
    val avatar: String
)
