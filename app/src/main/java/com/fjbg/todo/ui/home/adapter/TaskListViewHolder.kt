package com.fjbg.todo.ui.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.fjbg.todo.data.local.model.Task
import com.fjbg.todo.databinding.ItemTaskBinding

class TaskListViewHolder(
    private val binder: ItemTaskBinding,
    val onClick: (Int) -> Unit
) : RecyclerView.ViewHolder(binder.root) {

    fun initData(task: Task): Unit = with(binder) {
        this.tvTitle.text = task.title
        this.tvContent.text = task.content
        this.clTask.setOnClickListener {
            onClick.invoke(task.id)
        }
    }
}