package com.ru.week_1.view.activity

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ru.week_1.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)



        binding.apply {
            line1.setBackgroundColor(randomColor())
            line2.setBackgroundColor(randomColor())
            line3.setBackgroundColor(randomColor())
            line4.setBackgroundColor(randomColor())
            line5.setBackgroundColor(randomColor())
            line6.setBackgroundColor(randomColor())
            line7.setBackgroundColor(randomColor())
            line8.setBackgroundColor(randomColor())
            line9.setBackgroundColor(randomColor())
            line10.setBackgroundColor(randomColor())
            line11.setBackgroundColor(randomColor())
            line12.setBackgroundColor(randomColor())
            line13.setBackgroundColor(randomColor())
            line14.setBackgroundColor(randomColor())
            line15.setBackgroundColor(randomColor())
            musicPlayerPlay.setOnClickListener {
                var intent = Intent(this@MainActivity, ThecondActivity::class.java)
                startActivity(intent)
            }
        }
    }
    fun randomColor() : Int {
        var random = Random
        return Color.argb(155,random.nextInt(255),random.nextInt(255),random.nextInt(255))
    }
}
