package com.ru.listadapter.view.activity

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.GestureDetector
import android.view.GestureDetector.SimpleOnGestureListener
import android.view.MotionEvent
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.core.view.GestureDetectorCompat
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.genius.multiprogressbar.MultiProgressBar
import com.google.android.material.behavior.SwipeDismissBehavior
import com.google.android.material.tabs.TabLayoutMediator
import com.ru.listadapter.R
import com.ru.listadapter.databinding.ActivityStoryBinding
import com.ru.listadapter.databinding.FragmentStoryBinding
import com.ru.listadapter.view.adapter.StoryViewPagerAdapter
import com.ru.listadapter.view.fragment.StoryFragment

class StoryActivity : AppCompatActivity(),MultiProgressBar.ProgressStepChangeListener,MultiProgressBar.ProgressFinishListener {



    //binding
    private lateinit var binding : ActivityStoryBinding

    private lateinit var viewPager : ViewPager2

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = binding.storiesViewPager


        val list = listOf<Fragment>(
            StoryFragment.newInstance(R.drawable.welcome),
            StoryFragment.newInstance(R.drawable.avatarka),
            StoryFragment.newInstance(R.drawable.rounded_background_all)
        )

        binding.myltiprog.apply {
            setListener(this@StoryActivity)
            setFinishListener(this@StoryActivity)
            setProgressStepsCount(list.size)
            setSingleDisplayTime(6F)
            start()
        }

        binding.previous.setOnClickListener {
            binding.myltiprog.previous()
        }
        binding.next.setOnClickListener {
                if (binding.myltiprog.getCurrentStep() >= list.size - 1)
                    finish()
                else binding.myltiprog.next()
        }


        viewPager.adapter = StoryViewPagerAdapter(list,supportFragmentManager,lifecycle)


    }

    override fun onProgressStepChange(newStep: Int) {
        Log.d("MyERROR", "$newStep")
        viewPager.currentItem = newStep

    }

    override fun onProgressFinished() {
        finish()
    }
}

class GestureListener(val context: Context) : GestureDetector.SimpleOnGestureListener() {

    override fun onDown(e: MotionEvent?): Boolean {

        return super.onDown(e)
    }

}
