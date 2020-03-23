package com.example.room_database_example.screen

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.room_database_example.R
import com.example.room_database_example.adapter.TaskAdapter
import com.example.room_database_example.bus.RxBus
import com.example.room_database_example.room.dao.TaskDatabase
import com.example.room_database_example.room.entities.Task
import kotlinx.android.synthetic.main.fragment_list_task.*

class ListTaskFragment : Fragment() {

    private lateinit var adapter: TaskAdapter
    private lateinit var taskList: ArrayList<Task>

    companion object {
        @JvmStatic
        fun newInstance() = ListTaskFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        taskList = ArrayList()
        adapter = TaskAdapter(taskList)
        adapter.onItemClick = {
            fragmentManager?.beginTransaction()?.replace(
                R.id.frmContainer,
                EditTaskFragment.newInstance(it, false),
                EditTaskFragment::class.java.simpleName
            )?.addToBackStack(null)?.commit()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_list_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerViewNote.setHasFixedSize(true)
        recyclerViewNote.adapter = adapter
        btnFloatingActionButton.setOnClickListener {
            fragmentManager?.apply {
                this.beginTransaction().replace(
                    R.id.frmContainer,
                    AddTaskFragment.newInstance(),
                    AddTaskFragment::class.java.simpleName
                ).addToBackStack(AddTaskFragment::class.java.simpleName).commit()
            }
        }
        refreshAllTask()
        RxBus.listen(Task::class.java).subscribe {
            refreshAllTask()
        }
    }

    private fun refreshAllTask() {
        context?.let {
            val db = TaskDatabase.getDatabase(it)
            taskList.clear()
            taskList.addAll(db.taskDAO().getAllTask())
            Log.i("xxx", "Refesh task: " + taskList.size.toString())
            adapter.notifyDataSetChanged()
        }
    }


}
