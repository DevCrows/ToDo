package com.fjbg.todo.ui.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.fjbg.todo.data.local.model.Task
import com.fjbg.todo.databinding.ItemTaskBinding

class TaskListViewHolder(val binder: ItemTaskBinding) : RecyclerView.ViewHolder(binder.root) {

    fun initData(task: Task) {
        with(binder) {
binder.tvTitle.text = this.tvTitle
        }
    }
}