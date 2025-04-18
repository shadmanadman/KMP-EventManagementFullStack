package org.kmp.playground.event.management.full.stack.features.events.di

import org.kmp.playground.event.management.full.stack.dbcore.DatabaseHelper
import org.kmp.playground.event.management.full.stack.features.events.db.dao.EventsDao
import org.kmp.playground.event.management.full.stack.features.events.db.dao.EventsDaoImpl

object EventsModule {
    private val database by lazy { DatabaseHelper.getDatabase() }

    fun eventsDao(): EventsDao = EventsDaoImpl(database)
}