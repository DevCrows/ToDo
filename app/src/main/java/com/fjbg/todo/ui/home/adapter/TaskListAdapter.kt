package com.fjbg.todo.ui.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fjbg.todo.data.local.model.Task
import com.fjbg.todo.databinding.ItemTaskBinding
import com.fjbg.todo.utils.DEBUG_TAG

class TaskListAdapter(
    private val taskList: List<Task>
) : RecyclerView.Adapter<TaskListViewHolder>() {

    lateinit var binder: ItemTaskBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskListViewHolder {
        binder = ItemTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TaskListViewHolder(binder)
    }

    override fun onBindViewHolder(holder: TaskListViewHolder, position: Int) {

        Log.d(DEBUG_TAG, "position: $position")

        holder.initData(taskList[position])
    }

    override fun getItemCount(): Int {

        Log.d(DEBUG_TAG, "taskList.size: ${taskList.size}")

        return taskList.size
    }
}