package com.ru.listadapter.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ru.listadapter.R
import com.ru.listadapter.databinding.FragmentStoryBinding

private const val ARG_PARAM1 = "key"

class StoryFragment : Fragment() {

    private var key: Int? = null

    //binding
    private var _binding : FragmentStoryBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            key = it.getInt(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentStoryBinding.inflate(inflater,container,false)

        binding.image.setImageResource(key!!)

        return binding.root

    }

    companion object {
        @JvmStatic
        fun newInstance(param1: Int) =
            StoryFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_PARAM1, param1)
                }
            }
    }
}