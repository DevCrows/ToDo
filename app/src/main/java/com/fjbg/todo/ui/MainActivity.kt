package com.fjbg.todo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.fjbg.todo.R
import com.fjbg.todo.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
	
	lateinit var binder: ActivityMainBinding
	
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binder = ActivityMainBinding.inflate(layoutInflater)
		val view = binder.root
		setContentView(view)
		
		binder.bottomNavView.setOnNavigationItemSelectedListener { item ->
			when (item.itemId) {
				R.id.action_home -> {
					findNavController(R.id.nav_host_fragment).navigate(R.id.HomeFragment)
					true
				}
				R.id.action_new_task -> {
					findNavController(R.id.nav_host_fragment).navigate(R.id.NewTaskFragment)
					true
				}
				else -> false
			}
		}
		binder.bottomNavView.setOnNavigationItemReselectedListener { }
	}
	
}