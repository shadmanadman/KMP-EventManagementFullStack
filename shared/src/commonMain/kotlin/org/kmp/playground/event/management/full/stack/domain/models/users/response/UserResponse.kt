package org.kmp.playground.event.management.full.stack.domain.models.users.response

data class UsersResponse(
    val id: String,
    val username: String,
    val email: String,
    val phoneNumber: String,
    val avatar: String,
    val password: String
)
