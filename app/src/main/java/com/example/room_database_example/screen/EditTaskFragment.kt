package com.example.room_database_example.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.room_database_example.R
import com.example.room_database_example.room.dao.TaskDatabase
import com.example.room_database_example.room.entities.Task
import kotlinx.android.synthetic.main.fragment_edit_task.*

class EditTaskFragment : Fragment() {

    companion object {

        private const val EDIT_ITEM_POSITION = "edit_item_position"
        private var position = -1

        @JvmStatic
        fun newInstance(position: Int) = EditTaskFragment().apply {
            arguments = Bundle().apply { putInt(EDIT_ITEM_POSITION, position) }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            position = it.getInt(EDIT_ITEM_POSITION, -1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_edit_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (position != -1) {
            val db = context?.let { TaskDatabase.getDatabase(it).taskDAO() }
            val task = db?.getTask(position)
            bindData(task)
        }
    }

    private fun bindData(task: Task?) {
        edtNoteName.setText(task?.taskName)
        edtNoteName.setText(task?.description.toString())
        edtNoteName.setText(task?.finish)

    }
}