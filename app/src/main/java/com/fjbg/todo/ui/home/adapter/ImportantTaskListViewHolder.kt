package com.fjbg.todo.ui.home.adapter

import androidx.recyclerview.widget.RecyclerView
import com.fjbg.todo.data.local.model.Task
import com.fjbg.todo.databinding.ItemImportatntTaskBinding

class ImportantTaskListViewHolder(
    private val binder: ItemImportatntTaskBinding
) : RecyclerView.ViewHolder(binder.root) {

    fun initData(task: Task) = with(binder) {
        this.tvTitle.text = task.title
        this.tvContent.text = task.content
    }
}