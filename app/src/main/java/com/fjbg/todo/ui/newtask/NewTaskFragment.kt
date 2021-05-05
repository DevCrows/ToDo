package com.fjbg.todo.ui.newtask

import com.fjbg.todo.R
import com.fjbg.todo.base.BaseFragment
import com.fjbg.todo.data.local.model.Task
import com.fjbg.todo.databinding.FragmentNewTaskBinding
import com.fjbg.todo.ui.viewmodel.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewTaskFragment : BaseFragment<FragmentNewTaskBinding, TaskViewModel>() {

    override fun initViewModel(): Class<TaskViewModel> = TaskViewModel::class.java

    override fun initLayout(): Int = R.layout.fragment_new_task

    override fun initFragment() {
        initUi()
    }

    private fun initUi() {
        binding.btnSaveTask.setOnClickListener {
            saveTask()
        }
    }

    private fun saveTask() {
        val task = Task(
            id = 0,
            title = binding.edTaskTitle.text.toString(),
            content = binding.edTaskContent.text.toString(),
            isActive = true,
            dateCreated = System.currentTimeMillis(),
        )
        viewModel.createNewTask(task)
    }
}