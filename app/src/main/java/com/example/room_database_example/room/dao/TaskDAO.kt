package com.example.room_database_example.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.room_database_example.room.entities.Task

@Dao
interface TaskDAO {
    @Query("Select * from Task")
    fun getAllTask(): MutableList<Task>
    @Insert
    fun addTask(task : Task)
}