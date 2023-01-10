package com.ru.listadapter.view.activity

import TaskAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.ru.listadapter.R
import com.ru.listadapter.databinding.ActivityMainBinding
import com.ru.listadapter.model.data.PostAdd
import com.ru.listadapter.model.loadData.ListOfAddedImages
import com.ru.listadapter.model.loadData.user3
import com.ru.listadapter.view.adapter.PostAdapterRV
import com.ru.listadapter.view.adapter.StoryAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvStories.adapter = StoryAdapter()

        binding.rvPosts.adapter = TaskAdapter().also {
            it.submitList(ListOfAddedImages)
        }


    }
}