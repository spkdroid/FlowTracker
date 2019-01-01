package ca.rovbot.flowtracker.repository.database

import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.Database
import ca.rovbot.flowtracker.model.PeriodLogTable
import ca.rovbot.flowtracker.repository.dao.LogDaoAccess


@Database(entities = arrayOf(PeriodLogTable::class), version = 1)
abstract class LogDatabase : RoomDatabase() {
    abstract val logDaoAccess: LogDaoAccess
}
