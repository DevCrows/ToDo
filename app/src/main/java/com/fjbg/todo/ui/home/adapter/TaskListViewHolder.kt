package com.fjbg.todo.ui.home.adapter

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.fjbg.todo.data.local.model.Task
import com.fjbg.todo.databinding.ItemTaskBinding
import com.fjbg.todo.utils.DEBUG_TAG

class TaskListViewHolder(
    private val binder: ItemTaskBinding
) : RecyclerView.ViewHolder(binder.root) {
    fun initData(task: Task) {
        with(binder) {

            Log.d(DEBUG_TAG, "${task.title}")

            this.tvTitle.text = task.title
            this.tvContent.text = task.content
        }
    }
}