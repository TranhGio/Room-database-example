package com.example.room_database_example.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.room_database_example.R
import com.example.room_database_example.room.entities.Task

class TaskAdapter(val tasks: List<Task>) :
    RecyclerView.Adapter<TaskAdapter.ViewHolder>() {

    internal var onItemClick: (position: Int) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_note, parent, false)
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
            itemView.setOnClickListener { onItemClick.invoke(adapterPosition) }
        }
    }
}