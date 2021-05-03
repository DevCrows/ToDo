package com.fjbg.todo.ui.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fjbg.todo.data.local.model.Task
import com.fjbg.todo.databinding.ItemImportantTaskBinding

class ImportantTaskListAdapter(
    private val taskList: List<Task>
) : RecyclerView.Adapter<ImportantTaskListViewHolder>() {

    lateinit var binder: ItemImportantTaskBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImportantTaskListViewHolder {
        binder =
            ItemImportantTaskBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImportantTaskListViewHolder(binder)
    }

    override fun onBindViewHolder(holder: ImportantTaskListViewHolder, position: Int) =
        holder.initData(taskList[position])

    override fun getItemCount(): Int = taskList.size

}