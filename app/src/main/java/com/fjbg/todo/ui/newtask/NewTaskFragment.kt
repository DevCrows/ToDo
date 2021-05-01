package com.fjbg.todo.ui.newtask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.fjbg.todo.data.local.model.Task
import com.fjbg.todo.databinding.FragmentNewTaskBinding
import com.fjbg.todo.ui.viewmodel.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewTaskFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels()
    lateinit var binder: FragmentNewTaskBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binder = FragmentNewTaskBinding.inflate(inflater, container, false)
        initUi()
        return binder.root
    }

    private fun initUi() {
        binder.btnSaveTask.setOnClickListener {
            saveTask()
        }
    }

    private fun saveTask() {
        val task = Task(
            id = 0,
            title = binder.edTaskTitle.text.toString(),
            content = binder.edTaskContent.text.toString(),
            isActive = true,
            dateCreated = System.currentTimeMillis(),
        )
        viewModel.createNewTask(task)
    }
}