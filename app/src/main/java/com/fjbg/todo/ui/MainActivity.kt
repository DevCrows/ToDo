package com.fjbg.todo.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
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
    }
}