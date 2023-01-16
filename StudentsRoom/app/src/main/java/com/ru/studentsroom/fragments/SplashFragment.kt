package com.ru.studentsroom.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.ru.studentsroom.R
import com.ru.studentsroom.databinding.FragmentHomeBinding
import com.ru.studentsroom.databinding.FragmentSplashBinding
import com.ru.studentsroom.room.StudentApplication
import com.ru.studentsroom.viewModel.RoomViewModel
import com.ru.studentsroom.viewModel.RoomViewModelFactory
import java.util.concurrent.Executor

class SplashFragment : Fragment() {

    //binding main page
    private var _binding : FragmentSplashBinding? = null
    private val binding get() = _binding!!

    //Room View Model

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSplashBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
        },1500)

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}