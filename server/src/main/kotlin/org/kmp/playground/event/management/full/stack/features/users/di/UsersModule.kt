package org.kmp.playground.event.management.full.stack.features.users.di

import org.kmp.playground.event.management.full.stack.dbcore.DatabaseHelper
import org.kmp.playground.event.management.full.stack.features.users.db.dao.UsersDao
import org.kmp.playground.event.management.full.stack.features.users.db.dao.UsersDaoImpl

object UsersModule {
    private val database by lazy { DatabaseHelper.getDatabase() }

    fun usersDao(): UsersDao = UsersDaoImpl(database)
}