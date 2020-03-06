package com.example.room_database_example.room.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.room_database_example.room.entities.Task

@Database(entities = [Task::class], version = 1, exportSchema = false)
abstract class TaskDatabase : RoomDatabase() {
    abstract fun taskDAO(): TaskDAO
}
