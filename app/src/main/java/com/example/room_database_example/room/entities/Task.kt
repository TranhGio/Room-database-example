package com.example.room_database_example.room.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity()
data class Task(
    @PrimaryKey(autoGenerate = true) var id: Int?,
    @ColumnInfo(name = "task_name") var taskName: String? = "",
    @ColumnInfo(name = "description") var description: String? = "",
    @ColumnInfo(name = "finish") var finish: String? = ""
)