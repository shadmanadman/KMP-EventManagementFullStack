package org.kmp.playground.event.management.full.stack.features.users.db.entity

import org.bson.codecs.pojo.annotations.BsonId
import org.bson.types.ObjectId
import org.kmp.playground.event.management.full.stack.domain.models.users.request.UsersRequest
import org.kmp.playground.event.management.full.stack.domain.models.users.response.UsersResponse
import java.time.LocalDateTime

data class Users(
    @BsonId
    val userId: ObjectId = ObjectId(),
    val username: String,
    val email: String,
    val password: String,
    val phoneNumber: String,
    val avatar: String,
    val registrationDate: LocalDateTime = LocalDateTime.now()
) {
    fun toResponse() = UsersResponse(
        id = userId.toString(),
        username = username,
        email = email,
        phoneNumber = phoneNumber,
        avatar = avatar,
        password = password
    )
}


