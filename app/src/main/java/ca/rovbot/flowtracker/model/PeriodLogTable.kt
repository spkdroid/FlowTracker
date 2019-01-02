package ca.rovbot.flowtracker.model

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
data class PeriodLogTable(
    @PrimaryKey var uid: Int,
    @ColumnInfo(name = "title") var title: String?,
    @ColumnInfo(name = "type") var type: String?,
    @ColumnInfo(name = "date") var date: String?,
    @ColumnInfo(name = "description") var description: String?
    )