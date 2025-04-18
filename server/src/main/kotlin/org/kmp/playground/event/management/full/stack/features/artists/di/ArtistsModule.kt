package org.kmp.playground.event.management.full.stack.features.artists.di

import org.kmp.playground.event.management.full.stack.dbcore.DatabaseHelper
import org.kmp.playground.event.management.full.stack.features.artists.db.dao.ArtistDao
import org.kmp.playground.event.management.full.stack.features.artists.db.dao.ArtistDaoImpl

object ArtistsModule {
    private val database by lazy { DatabaseHelper.getDatabase() }

    fun artistDao(): ArtistDao = ArtistDaoImpl(database)
}