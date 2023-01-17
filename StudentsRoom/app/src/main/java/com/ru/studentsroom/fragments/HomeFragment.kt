package com.ru.studentsroom.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.ru.studentsroom.R
import com.ru.studentsroom.adapter.StudentsAdapter
import com.ru.studentsroom.databinding.FragmentHomeBinding
import com.ru.studentsroom.room.StudentApplication
import com.ru.studentsroom.viewModel.RoomViewModel
import com.ru.studentsroom.viewModel.RoomViewModelFactory

class HomeFragment : Fragment() {

    //binding
    private var _binding : FragmentHomeBinding? = null
    private val binding get() = _binding!!

    //Room View Model
    private val roomViewModel : RoomViewModel by activityViewModels {
        RoomViewModelFactory((activity?.application as StudentApplication).database.StudentsDao(),
            (activity?.application as StudentApplication).database.SubjectsDao(),
            (activity?.application as StudentApplication).database.ConnectionDao())
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater,container,false)

        val adapter = StudentsAdapter()

        roomViewModel.listOfStudents.observe(viewLifecycleOwner){
            adapter.submitList(it)
        }
        adapter.onPodrobneeClicked = {
            val action = HomeFragmentDirections.actionHomeFragmentToPodrobnoFragment(it)
            findNavController().navigate(action)
        }

        binding.rvStudentsHome.adapter = adapter

        return binding.root

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}