package com.example.room_database_example.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface TaskDAO {
    @Query("Select * from Task")
    fun getAllTask(): MutableList<Task>
    @Insert
    fun addTask(task : Task)
}