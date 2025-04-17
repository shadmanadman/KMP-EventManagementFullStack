package org.kmp.playground.event.management.full.stack.application.request

import org.kmp.playground.event.management.full.stack.domain.entity.Users

data class UsersRequest(
    val username: String,
    val email: String,
    val phone: String,
    val password: String,
    val avatar: String
)

fun UsersRequest.toEntity(): Users {
    return Users(
        username = this.username,
        email = this.email,
        password = this.password,
        avatar = this.avatar,
        phoneNumber = this.phone
    )
}