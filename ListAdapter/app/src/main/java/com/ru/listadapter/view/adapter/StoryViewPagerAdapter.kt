package com.ru.listadapter.view.adapter

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.ru.listadapter.view.fragment.StoryFragment

class StoryViewPagerAdapter(var list : List<Fragment>, fm : FragmentManager, lifecycle: Lifecycle)
    : FragmentStateAdapter(fm,lifecycle) {

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return list[position]
    }
}