package com.example.room_database_example.screen

import android.app.Dialog
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
        private const val OPEN_TYPE = "open_type"
        private var position = -1

        @JvmStatic
        fun newInstance(position: Int, isEdit: Boolean) = EditTaskFragment().apply {
            arguments = Bundle().apply {
                putInt(EDIT_ITEM_POSITION, position)
                putBoolean(OPEN_TYPE, isEdit)
            }
        }
    }

    private var isEdit = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            position = it.getInt(EDIT_ITEM_POSITION, -1)
            isEdit = it.getBoolean(OPEN_TYPE, false)
        }
        if (position == -1) {
            context?.let { Dialog(it) }
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
            refreshData(task)
        }
        btnAddNote.setOnClickListener {
//            context?.let { it1 -> TaskDatabase.getDatabase(it1).taskDAO().updateTask(task) }
        }
    }

    private fun refreshData(task: Task?) {
        edtNoteName.setText(task?.taskName)
        edtDescription.setText(task?.description.toString())
        edtFinishBy.setText(task?.finish)
            edtNoteName.isEnabled = isEdit
            edtDescription.isEnabled = isEdit
            edtFinishBy.isEnabled = isEdit
            btnAddNote.isEnabled = isEdit
    }
}