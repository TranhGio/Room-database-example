package com.example.room_database_example.screen

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.room_database_example.R
import com.example.room_database_example.room.Task
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var tasks: List<Task>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        supportFragmentManager.beginTransaction()
            .add(R.id.frmContainer, ListTaskFragment.newInstance()).commit()
    }

    private fun initView() {
        getAllTask()
    }

    private fun getAllTask() {

    }

    private fun addTask() {

    }

    private fun editTask(taskId: Int) {

    }
}
