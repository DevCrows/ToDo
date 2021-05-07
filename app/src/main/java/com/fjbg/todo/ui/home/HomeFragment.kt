package com.fjbg.todo.ui.home

import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.fjbg.todo.R
import com.fjbg.todo.base.BaseFragment
import com.fjbg.todo.data.local.model.Task
import com.fjbg.todo.databinding.FragmentHomeBinding
import com.fjbg.todo.ui.home.adapter.ImportantTaskListAdapter
import com.fjbg.todo.ui.home.adapter.TaskListAdapter
import com.fjbg.todo.ui.home.adapter.TitleListAdapter
import com.fjbg.todo.ui.viewmodel.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding, TaskViewModel>() {

    private lateinit var mainTitleAdapter: TitleListAdapter
    private lateinit var titleListAdapter: TitleListAdapter
    private lateinit var titleImportantListAdapter: TitleListAdapter
    private lateinit var importantTaskListAdapter: ImportantTaskListAdapter
    private lateinit var taskListAdapter: TaskListAdapter
    private lateinit var footer: TitleListAdapter

    override fun initViewModel(): Class<TaskViewModel> = TaskViewModel::class.java

    override fun initLayout(): Int = R.layout.fragment_home

    override fun initFragment() {
        initData()
    }

    private fun initData() =
        lifecycleScope.launchWhenCreated {
            viewModel.taskList.collect { list ->
                initAdapters(list)
            }
        }

    private fun initAdapters(list: List<Task>) {
        binding.rvTaskList.layoutManager = LinearLayoutManager(context)
        val importantTaskList = list.filter {
            it.isImportant
        }

        footer = TitleListAdapter("", true)
        if (importantTaskList.isNotEmpty()) {
            mainTitleAdapter = TitleListAdapter(title = "Home", isHome = true)
            titleImportantListAdapter = TitleListAdapter(title = "Important", isHome = false)
            importantTaskListAdapter = ImportantTaskListAdapter(importantTaskList)
            titleListAdapter = TitleListAdapter(title = "Latest", isHome = false)
            taskListAdapter = TaskListAdapter(
                taskList = list,
                action = ::navigateToTask
            )
            val concatAdapter = ConcatAdapter(
                mainTitleAdapter,
                titleImportantListAdapter,
                importantTaskListAdapter,
                titleListAdapter,
                taskListAdapter,
                footer,
            )
            binding.rvTaskList.adapter = concatAdapter
        } else {
            mainTitleAdapter = TitleListAdapter(title = "Home", isHome = true)
            titleListAdapter = TitleListAdapter(title = "Latest", isHome = false)
            taskListAdapter = TaskListAdapter(
                taskList = list,
                action = ::navigateToTask
            )
            val concatAdapter = ConcatAdapter(
                mainTitleAdapter,
                titleListAdapter,
                taskListAdapter,
                footer,
            )
            binding.rvTaskList.adapter = concatAdapter
        }
    }

    private fun navigateToTask(taskId: Int) {
        findNavController().navigate(
            HomeFragmentDirections.actionHomeFragmentToTaskDetailFragment(
                taskId
            )
        )

    }
}