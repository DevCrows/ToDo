package com.fjbg.todo.ui.taskdetail

import android.os.Bundle
import com.fjbg.todo.R
import com.fjbg.todo.base.BaseFragment
import com.fjbg.todo.databinding.FragmentTaskDetailBinding
import com.fjbg.todo.ui.viewmodel.TaskViewModel

class TaskDetailFragment : BaseFragment<FragmentTaskDetailBinding, TaskViewModel>() {

    override fun initViewModel(): Class<TaskViewModel> = TaskViewModel::class.java

    override fun initLayout(): Int = R.layout.fragment_task_detail

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
}