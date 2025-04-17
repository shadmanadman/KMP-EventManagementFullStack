package org.kmp.playground.event.management.full.stack.db

import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase

fun getDatabase(): MongoDatabase {
    return MongoClient.create(
        "mongodb://localhost:27017"
    ).getDatabase("appDatabase")
}