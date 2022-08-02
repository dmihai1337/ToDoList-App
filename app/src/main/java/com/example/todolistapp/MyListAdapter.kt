package com.example.todolistapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyListAdapter(private val list: ArrayList<Task>): RecyclerView.Adapter<MyListAdapter.MyListViewHolder>() {
    class MyListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var taskText: TextView = itemView.findViewById(R.id.taskText)
        var isChecked: CheckBox = itemView.findViewById(R.id.checkBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyListViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.task, parent, false)
        return MyListViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyListViewHolder, position: Int) {
        val curItem = list[position]

        holder.taskText.text = curItem.text
        holder.isChecked.isChecked = curItem.isChecked
        holder.itemView.findViewById<CheckBox>(R.id.checkBox).setOnCheckedChangeListener { _, isChecked ->
            curItem.isChecked = !curItem.isChecked
        }
    }

    override fun getItemCount(): Int = list.size

    fun addTodo(task: Task) {
        list.add(task)
        notifyItemInserted(itemCount - 1)
    }

    fun delTodo() {
        list.removeAll { task ->  task.isChecked}
        notifyDataSetChanged()
    }
}