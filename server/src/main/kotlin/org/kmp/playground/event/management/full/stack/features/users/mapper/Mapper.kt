package org.kmp.playground.event.management.full.stack.features.users.mapper

import org.kmp.playground.event.management.full.stack.domain.models.users.request.UsersRequest
import org.kmp.playground.event.management.full.stack.features.users.db.entity.Users


fun UsersRequest.toEntity(): Users {
    return Users(
        username = this.username,
        email = this.email,
        password = this.password,
        avatar = this.avatar,
        phoneNumber = this.phone
    )
}