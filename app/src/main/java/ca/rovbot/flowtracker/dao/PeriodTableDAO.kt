package ca.rovbot.flowtracker.dao

import android.arch.persistence.room.*
import ca.rovbot.flowtracker.model.PeriodTable

@Dao
interface PeriodTableDAO {

    @get:Query("SELECT * FROM PeriodTable")
    val all: List<PeriodTable>

    @Insert
    fun insertAll(products: List<PeriodTable>)

    @Update
    fun update(product: PeriodTable)

    @Delete
    fun delete(product: PeriodTable)
}