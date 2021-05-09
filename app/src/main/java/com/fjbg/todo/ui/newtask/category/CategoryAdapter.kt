package com.fjbg.todo.ui.newtask.category

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.fjbg.todo.data.local.model.Category
import com.fjbg.todo.databinding.ItemCategoryBinding

class CategoryAdapter(
    private val categories: List<Category>,
    private val selectCategory: (Int) -> Unit,
    private val deleteCategory: (Int) -> Unit,
) : RecyclerView.Adapter<CategoryViewHolder>() {

    lateinit var binding: ItemCategoryBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        binding = ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding, selectCategory, deleteCategory)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int): Unit =
        holder.initData(categories[position])

    override fun getItemCount(): Int = categories.size
}