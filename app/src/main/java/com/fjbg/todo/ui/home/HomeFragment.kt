package com.fjbg.todo.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.fjbg.todo.data.local.model.Task
import com.fjbg.todo.databinding.FragmentHomeBinding
import com.fjbg.todo.ui.home.adapter.TaskListAdapter
import com.fjbg.todo.ui.viewmodel.TaskViewModel
import com.fjbg.todo.ui.viewmodel.TaskListState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel: TaskViewModel by viewModels()
    lateinit var adapter: TaskListAdapter

    lateinit var binder: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binder = FragmentHomeBinding.inflate(inflater, container, false)
        return binder.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launchWhenStarted {
            viewModel.uiState.collect { state ->
                when (state) {
                    is TaskListState.Success -> {
                        initAdapter(state.list)
                    }
                    is TaskListState.Error -> {
                        //TODO: show error view
                    }
                }
            }
        }


        //binder.

    }

    private fun initAdapter(list: List<Task>) {
        adapter = TaskListAdapter(list)
        binder.rvTaskList.adapter = adapter
    }
}