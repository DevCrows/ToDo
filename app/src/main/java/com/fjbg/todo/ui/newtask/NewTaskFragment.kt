package com.fjbg.todo.ui.newtask

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
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

        val taskTitle = binder.edTaskTitle.text.toString()
        val taskContent = binder.edTaskContent.text.toString()

        binder.btnSaveTask.setOnClickListener {
            lifecycleScope.launchWhenStarted {
                viewModel.createNewTask(
                    Task(
                        id = 0,
                        title = taskTitle,
                        content = taskContent,
                        isActive = true,
                        dateCreated = System.currentTimeMillis(),
                    )
                )
            }
        }
    }
}