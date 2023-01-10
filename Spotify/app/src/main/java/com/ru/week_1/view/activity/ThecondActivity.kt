package com.ru.week_1.view.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ru.week_1.model.MusicData
import com.ru.week_1.R
import com.ru.week_1.databinding.ActivityThecondBinding
import com.ru.week_1.view.adapter.MusicAdapter
import com.ru.week_1.view.adapter.NestedAdapter

class ThecondActivity : AppCompatActivity() {

    private lateinit var recyclerView : RecyclerView

    private lateinit var binding : ActivityThecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var list = mutableListOf<MusicData>()
        repeat(6){
            list.add(MusicData("The Lord of Rings ${it + 1}", R.drawable.forspotifyapp))
        }

        //Recycler view
        recyclerView = binding.parentRv
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = NestedAdapter(list)

    }
}