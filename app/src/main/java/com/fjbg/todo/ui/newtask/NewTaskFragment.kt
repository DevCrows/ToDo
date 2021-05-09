package com.fjbg.todo.ui.newtask

import android.util.Log
import android.view.View
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.fjbg.todo.R
import com.fjbg.todo.base.BaseFragment
import com.fjbg.todo.data.local.model.Category
import com.fjbg.todo.data.local.model.Task
import com.fjbg.todo.databinding.FragmentNewTaskBinding
import com.fjbg.todo.ui.newtask.category.CategoryAdapter
import com.fjbg.todo.ui.newtask.category.CategoryBottomSheet
import com.fjbg.todo.ui.viewmodel.TaskViewModel
import com.fjbg.todo.utils.DEBUG_TAG
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class NewTaskFragment : BaseFragment<FragmentNewTaskBinding, TaskViewModel>() {

    private lateinit var categoryAdapter: CategoryAdapter

    override fun initViewModel(): Class<TaskViewModel> = TaskViewModel::class.java

    override fun initLayout(): Int = R.layout.fragment_new_task

    override fun initFragment() {
        initUi()
        viewModel.getCategories()
        lifecycleScope.launch {
            viewModel.getCategories.collect { list ->
                Log.d(DEBUG_TAG, "initFragment - list: $list")
                list?.let {
                    initCategoryAdapter(it)
                }
            }
        }
    }

    private fun initUi() {
        binding.btnSaveTask.setOnClickListener {
            saveTask()
        }

        binding.btnAddCategory.setOnClickListener {
            val categoryBottomSheet = CategoryBottomSheet(viewModel)
            categoryBottomSheet.show(parentFragmentManager, "CategoryBottomSheet")
        }
    }

    private fun saveTask() {
        val task = Task(
            id = 0,
            title = binding.etTaskTitle.text.toString(),
            content = binding.etTaskContent.text.toString(),
            isActive = true,
            dateCreated = System.currentTimeMillis(),
        )
        viewModel.createTask(task)
    }

    private fun initCategoryAdapter(categories: List<Category>) {
        if (categories.isNullOrEmpty()) binding.rvCategories.visibility = View.VISIBLE
        binding.rvCategories.layoutManager = LinearLayoutManager(context)
        categoryAdapter = CategoryAdapter(
            categories = categories,
            selectCategory = ::onSelectCategory,
            deleteCategory = ::onLongPressedCategory
        )
        binding.rvCategories.adapter = categoryAdapter
    }

    private fun onSelectCategory(categoryId: Int) {

    }

    private fun onLongPressedCategory(categoryId: Int) {
        lifecycleScope.launchWhenResumed {
            viewModel.deleteCategory(categoryId)
        }
    }
}