package com.example.room_database_example.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.example.room_database_example.room.entities.Task

@Dao
interface TaskDAO {

    @Query("Select * from Task")
    fun getAllTask(): List<Task>

    @Query("Select * from Task where id = :taskId")
    fun getTask(taskId: Int): Task

    @Insert(onConflict = REPLACE)
    fun addTask(task: Task)

    @Update(onConflict = REPLACE)
    fun updateTask(task: Task)
}