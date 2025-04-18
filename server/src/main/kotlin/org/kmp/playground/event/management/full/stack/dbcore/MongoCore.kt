package org.kmp.playground.event.management.full.stack.dbcore

import com.mongodb.kotlin.client.coroutine.MongoClient
import com.mongodb.kotlin.client.coroutine.MongoDatabase

object DatabaseHelper{
    private val client: MongoClient by lazy {
        MongoClient.create("mongodb://localhost:27017")
    }
    fun getDatabase(): MongoDatabase {
        return client.getDatabase("appDatabase")
    }

    fun closeConnection() {
        client.close()
    }
}