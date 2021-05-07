package com.fjbg.todo.ui.taskdetail

import android.util.Log
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.fjbg.todo.R
import com.fjbg.todo.base.BaseFragment
import com.fjbg.todo.databinding.FragmentTaskDetailBinding
import com.fjbg.todo.ui.viewmodel.TaskViewModel
import com.fjbg.todo.utils.DEBUG_TAG
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class TaskDetailFragment : BaseFragment<FragmentTaskDetailBinding, TaskViewModel>() {

    private val args: TaskDetailFragmentArgs by navArgs()


    override fun initViewModel(): Class<TaskViewModel> = TaskViewModel::class.java

    override fun initLayout(): Int = R.layout.fragment_task_detail

    override fun initFragment() {

        lifecycleScope.launchWhenCreated {
            viewModel.getTaskById(args.taskId)
        }

        lifecycleScope.launchWhenResumed {
            viewModel.getTask.collect { task ->
                if (task != null) {
                    Log.d(DEBUG_TAG, "task: $task")

                    binding.tvTitle.text = task.title
                    binding.tvContent.text = task.content
                }
            }
        }
    }
}