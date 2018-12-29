package ca.rovbot.flowtracker.database

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import ca.rovbot.flowtracker.dao.PeriodTableDAO
import ca.rovbot.flowtracker.model.PeriodTable

@Database(entities = arrayOf(PeriodTable::class), version = 1)
abstract class LoggerDatabase : RoomDatabase() {
    abstract fun periodTableDao(): PeriodTableDAO
}