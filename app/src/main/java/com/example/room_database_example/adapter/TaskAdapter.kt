package com.example.room_database_example.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.room_database_example.R
import com.example.room_database_example.room.entities.Task

class TaskAdapter(val tasks: List<Task>, val context: Context) :
    RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_note, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = tasks.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(position)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val txtTaskName = itemView.findViewById<TextView>(R.id.txtTaskName)
        private val txtFinish = itemView.findViewById<TextView>(R.id.txtFinish)
        private val txtDes = itemView.findViewById<TextView>(R.id.txtDescription)

        fun bindView(pos: Int) {
            txtTaskName.text = tasks[pos].taskName
            txtDes.text = tasks[pos].description
            txtFinish.text = tasks[pos].finish
            itemView.setOnClickListener(object : View.OnClickListener {
                override fun onClick(v: View?) {
                    Toast.makeText(context, tasks[pos].taskName, Toast.LENGTH_SHORT).show()
                }
            })
        }
    }
}