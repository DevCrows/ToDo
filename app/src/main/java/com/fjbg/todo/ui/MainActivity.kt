package com.fjbg.todo.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.fjbg.todo.R
import com.fjbg.todo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binder: ActivityMainBinding
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binder = ActivityMainBinding.inflate(layoutInflater)
        val view = binder.root
        setContentView(view)
        binder.fabNewTask.setOnClickListener(this)

        navController = NavController(this)
        navController = findNavController(R.id.nav_host_fragment)
    }
    

    override fun onClick(v: View?) {
        navController.navigate(R.id.NewTaskFragment)
    }
}