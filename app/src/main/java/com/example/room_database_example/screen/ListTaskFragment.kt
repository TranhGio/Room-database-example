package com.example.room_database_example.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.room_database_example.R
import kotlinx.android.synthetic.main.fragment_list_task.*

class ListTaskFragment : Fragment() {
    companion object {
        @JvmStatic
        fun newInstance() = ListTaskFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        btnFloatingActionButton.setOnClickListener {
            fragmentManager?.apply {
                this.beginTransaction().replace(
                    R.id.frmContainer,
                    AddTaskFragment.newInstance(),
                    AddTaskFragment::class.java.toString()
                ).commit()
            }
        }
    }
}