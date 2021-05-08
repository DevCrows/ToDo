package com.fjbg.todo.ui.newtask.category

import androidx.recyclerview.widget.RecyclerView
import com.fjbg.todo.data.local.model.Category
import com.fjbg.todo.databinding.ItemCategoryBinding

class CategoryViewHolder(
    val binding: ItemCategoryBinding,
    val onClick: (Int) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    fun initData(category: Category): Unit = with(binding) {
        this.cbCategory.text = category.name
    }
}