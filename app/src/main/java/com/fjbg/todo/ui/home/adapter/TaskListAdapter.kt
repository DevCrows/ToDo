package com.fjbg.todo.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fjbg.todo.R
import com.fjbg.todo.data.local.model.Task

class TaskListAdapter(
    private val taskList: List<Task>
) : RecyclerView.Adapter<TaskListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task, parent, false)
        return TaskListViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {

    }

    override fun getItemCount(): Int = taskList.size
}