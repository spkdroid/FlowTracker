package ca.rovbot.flowtracker.repository

import android.arch.persistence.room.Room
import android.content.Context
import ca.rovbot.flowtracker.model.PeriodLogTable
import ca.rovbot.flowtracker.repository.database.LogDatabase


class LogRepository(private val applicationContext: Context) {
    private var database: LogDatabase? = null

    val allLogs: List<PeriodLogTable>
        get() = database!!.logDaoAccess.fetchAll()

    init {
        initDB()
    }

    private fun initDB() {
        val DB_NAME = "LOGDATABASE"
        database = Room.databaseBuilder(applicationContext, LogDatabase::class.java!!, DB_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    fun addLog(logToBeAdded: PeriodLogTable) {
        database!!.logDaoAccess.insertSingleSong(logToBeAdded)
    }

    fun deleteLog(logToBeDeleted: PeriodLogTable) {
        database!!.logDaoAccess.deleteLog(logToBeDeleted)
    }

    fun clearTable() {
        database!!.logDaoAccess.clearTable()
    }

    fun getLogById(Id: Int): PeriodLogTable {
        return database!!.logDaoAccess.fetchLogByID(Id)
    }
}
