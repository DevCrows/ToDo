package com.fjbg.todo.ui.newtask.category

import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.fjbg.todo.data.local.model.Category
import com.fjbg.todo.databinding.ItemCategoryBinding
import com.fjbg.todo.utils.DEBUG_TAG

class CategoryViewHolder(
    val binding: ItemCategoryBinding,
    val onClick: (Int) -> Unit,
) : RecyclerView.ViewHolder(binding.root) {
    fun initData(category: Category): Unit = with(binding) {
        Log.d(DEBUG_TAG, "initData - category: $category ")
        this.cbCategory.text = category.name
    }
}