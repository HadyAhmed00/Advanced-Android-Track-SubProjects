package com.example.android.trackmysleepquality.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity (tableName = "sleep_data_table")
data class SleepNight(
    @PrimaryKey (autoGenerate = true)
    val nabId: Long = 0,
    @ColumnInfo (name = "start_time_Millis")
    val startTime: Long = System.currentTimeMillis(),
    @ColumnInfo (name = "end_time_Millis")
    var endTime: Long = System.currentTimeMillis(),
    @ColumnInfo (name = "rate")
    var quality: Int = -1
)