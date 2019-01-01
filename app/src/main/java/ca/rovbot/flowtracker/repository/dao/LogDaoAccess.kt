package ca.rovbot.flowtracker.repository.dao

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import ca.rovbot.flowtracker.model.PeriodLogTable


@Dao
interface LogDaoAccess {

    @Insert
    fun insertSingleSong(logToInsert: PeriodLogTable)

    @Query("SELECT * FROM PeriodLogTable WHERE uid = :logID")
    fun fetchLogByID(logID: Int): PeriodLogTable

    @Query("SELECT * FROM PeriodLogTable")
    fun fetchAll(): List<PeriodLogTable>

    @Query("DELETE FROM PeriodLogTable")
    fun clearTable()

    @Delete
    fun deleteLog(logToBeDeleted: PeriodLogTable)
}
