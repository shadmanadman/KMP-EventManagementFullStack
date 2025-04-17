package org.kmp.playground.event.management.full.stack.domain.models.users.response

data class UsersResponse(
    val username: String,
    val email: String,
    val phone: String,
    val avatar: String,
    val password: String
)
