package com.fjbg.todo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.fjbg.todo.data.local.model.Task
import com.fjbg.todo.databinding.FragmentHomeBinding
import com.fjbg.todo.ui.home.adapter.ImportantTaskListAdapter
import com.fjbg.todo.ui.home.adapter.TaskListAdapter
import com.fjbg.todo.ui.home.adapter.TitleListAdapter
import com.fjbg.todo.ui.viewmodel.TaskViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels()

    private lateinit var mainTitleAdapter: TitleListAdapter
    private lateinit var titleListAdapter: TitleListAdapter
    private lateinit var titleImportantListAdapter: TitleListAdapter
    private lateinit var importantTaskListAdapter: ImportantTaskListAdapter
    private lateinit var taskListAdapter: TaskListAdapter
    private lateinit var footer: TitleListAdapter

    lateinit var binder: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binder = FragmentHomeBinding.inflate(inflater, container, false)
        initData()
        return binder.root
    }

    private fun initData() {
        lifecycleScope.launchWhenCreated {
            viewModel.uiState.collect { state ->
                initAdapters(state)
            }
        }
    }

    private fun initAdapters(list: List<Task>) {
        binder.rvTaskList.layoutManager = LinearLayoutManager(context)
        val importantTaskList = list.filter {
            it.isImportant
        }

        footer = TitleListAdapter("", true)
        if (importantTaskList.isNotEmpty()) {
            mainTitleAdapter = TitleListAdapter(title = "Home", isHome = true)
            titleImportantListAdapter = TitleListAdapter(title = "Important", isHome = false)
            importantTaskListAdapter = ImportantTaskListAdapter(importantTaskList)
            titleListAdapter = TitleListAdapter(title = "Latest", isHome = false)
            taskListAdapter = TaskListAdapter(list)
            val concatAdapter = ConcatAdapter(
                mainTitleAdapter,
                titleImportantListAdapter,
                importantTaskListAdapter,
                titleListAdapter,
                taskListAdapter,
                footer,
            )
            binder.rvTaskList.adapter = concatAdapter
        } else {
            mainTitleAdapter = TitleListAdapter(title = "Home", isHome = true)
            titleListAdapter = TitleListAdapter(title = "Latest", isHome = false)
            taskListAdapter = TaskListAdapter(list)
            val concatAdapter = ConcatAdapter(
                mainTitleAdapter,
                titleListAdapter,
                taskListAdapter,
                footer,
            )
            binder.rvTaskList.adapter = concatAdapter
        }
    }
}