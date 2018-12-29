package ca.rovbot.flowtracker

import android.app.Application
import android.content.SharedPreferences
import android.arch.persistence.room.Room
import android.content.Context
import ca.rovbot.flowtracker.database.LoggerDatabase

class App : Application() {

    var db: LoggerDatabase? = null
        private set

    var isForceUpdate: Boolean
        get() = sp.getBoolean(KEY_FORCE_UPDATE, true)
        set(force) {
            val edit = sp.edit()
            edit.putBoolean(KEY_FORCE_UPDATE, force)
            edit.apply()
        }

    private val sp: SharedPreferences
        get() = getSharedPreferences(PREFERENCES, Context.MODE_PRIVATE)

    override fun onCreate() {
        super.onCreate()

        // create database
        db = Room.databaseBuilder(applicationContext, LoggerDatabase::class.java!!, DATABASE_NAME)
            .build()

        INSTANCE = this
    }

    companion object {

        lateinit var INSTANCE: App
        private val DATABASE_NAME = "LoggerDatabase"
        private val PREFERENCES = "RoomDemo.preferences"
        private val KEY_FORCE_UPDATE = "force_update"

        fun get(): App {
            return INSTANCE
        }

    }
}