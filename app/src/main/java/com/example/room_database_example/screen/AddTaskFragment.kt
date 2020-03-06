package com.example.room_database_example.screen

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Build
import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.room_database_example.R
import kotlinx.android.synthetic.main.fragment_add_task.*
import java.util.*

class AddTaskFragment : Fragment() {

    companion object {
        @JvmStatic
        fun newInstance() = AddTaskFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_task, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        edtFinishBy.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val day = calendar.get(Calendar.DAY_OF_MONTH)
            val hour = calendar.get(Calendar.HOUR_OF_DAY)
            val minute = calendar.get(Calendar.MINUTE)

            context?.apply {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    val timePickerDialog =
                        TimePickerDialog(this, object : TimePickerDialog.OnTimeSetListener {
                            override fun onTimeSet(view: TimePicker?, hourOfDay: Int, minute: Int) {
                                edtFinishBy.text = Editable.Factory.getInstance()
                                    .newEditable("$hour:$minute - ".plus(edtFinishBy.text.toString()))
                            }
                        }, hour, minute, true)
                    val onDataSetListener = object : DatePickerDialog.OnDateSetListener {
                        override fun onDateSet(
                            view: DatePicker?,
                            year: Int,
                            month: Int,
                            dayOfMonth: Int
                        ) {
                            edtFinishBy.text = Editable.Factory.getInstance()
                                .newEditable("$dayOfMonth/${month + 1}/$year")
                            timePickerDialog.show()
                        }
                    }
                    val datePickerDialog =
                        DatePickerDialog(this, onDataSetListener, year, month, day)
                    datePickerDialog.show()

                } else {
                    Toast.makeText(this, "Not support", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
