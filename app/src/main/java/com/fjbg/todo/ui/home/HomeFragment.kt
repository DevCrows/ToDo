package com.fjbg.todo.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.fjbg.todo.R
import com.fjbg.todo.data.local.model.Task
import com.fjbg.todo.databinding.FragmentHomeBinding
import com.fjbg.todo.ui.home.adapter.TaskListAdapter
import com.fjbg.todo.ui.viewmodel.TaskListState
import com.fjbg.todo.ui.viewmodel.TaskViewModel
import com.fjbg.todo.utils.DEBUG_TAG
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

        binder.fabNewTask.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_HomeFragment_to_NewTaskFragment)
        }

        initData()

        return binder.root
    }

    private fun initData() {
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
    }

    private fun initAdapter(list: List<Task>) {

        Log.d(DEBUG_TAG, "list: $list")

        adapter = TaskListAdapter(list)
        binder.rvTaskList.adapter = adapter
    }
}