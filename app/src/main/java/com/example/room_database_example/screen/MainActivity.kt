package com.example.room_database_example.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room_database_example.R
import com.example.room_database_example.room.dao.TaskDAO
import com.example.room_database_example.room.dao.TaskDatabase
import com.example.room_database_example.room.entities.Task

class MainActivity : AppCompatActivity() {

    private lateinit var tasks: List<Task>
    private lateinit var roomDatabase: RoomDatabase //RoomDatabase Instance
    private lateinit var taskDAO: TaskDAO

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        supportFragmentManager.beginTransaction()
            .add(R.id.frmContainer, ListTaskFragment.newInstance()).addToBackStack(null).commit()
    }
    private fun initView() {
    }
}
