package com.ru.listadapter.view.activity

import TaskAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ru.listadapter.databinding.ActivityMainBinding
import com.ru.listadapter.model.data.Story
import com.ru.listadapter.model.loadData.ListOfAddedImages
import com.ru.listadapter.model.loadData.listOfStories
import com.ru.listadapter.view.adapter.StoryAdapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Stories Adapter
        val storyAdapter = StoryAdapter()

        binding.rvStories.adapter = storyAdapter

        //Clicked on story event
        //Changing seen false to true
        storyAdapter.onStoryClicked = { clickedIndex ->
            val newList = mutableListOf<Story>()
            val previousList = storyAdapter.currentList

            for (storyIndex in previousList.indices){
                if (storyIndex == clickedIndex)
                    newList.add(previousList[clickedIndex].copy(seen = true))
                else
                    newList.add(previousList[storyIndex])
            }
            storyAdapter.submitList(newList)

            var intent = Intent(this,StoryActivity::class.java)
            startActivity(intent)
        }


        //List for Stories
        var list = listOfStories

        storyAdapter.submitList(list)

        binding.rvPosts.adapter = TaskAdapter().also {
            it.submitList(ListOfAddedImages)
        }
    }
}