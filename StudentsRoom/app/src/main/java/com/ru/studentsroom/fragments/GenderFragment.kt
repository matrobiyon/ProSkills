package com.ru.studentsroom.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.ru.studentsroom.adapter.StudentsAdapter
import com.ru.studentsroom.databinding.FragmentGenderBinding
import com.ru.studentsroom.room.StudentApplication
import com.ru.studentsroom.viewModel.RoomViewModel
import com.ru.studentsroom.viewModel.RoomViewModelFactory

class GenderFragment : Fragment() {

    //binding
    private var _binding : FragmentGenderBinding? = null
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
        _binding = FragmentGenderBinding.inflate(inflater,container,false)

        val adapter = StudentsAdapter()
        binding.rvStudentsHome.adapter = adapter
        adapter.onPodrobneeClicked = {
            val action = GenderFragmentDirections.actionGenderFragmentToPodrobnoFragment(it)
            findNavController().navigate(action)
        }

        roomViewModel.listOfStudents.observe(viewLifecycleOwner) {
            adapter.submitList(it.filter {
                it.gender == "M"
            })
        }

        binding.genderM.setOnCheckedChangeListener { buttonView, isChecked ->
            if (buttonView.isChecked) {
                roomViewModel.listOfStudents.observe(viewLifecycleOwner) {
                    adapter.submitList(it.filter {
                        it.gender == "M"
                    })
                }
            } else {
                roomViewModel.listOfStudents.observe(viewLifecycleOwner) {
                    adapter.submitList(it.filter {
                        it.gender == "J"
                    })
                }
            }
        }

//        binding.genderJ.setOnClickListener {
//            roomViewModel.listOfStudents.observe(viewLifecycleOwner) {
//                adapter.submitList(it.filter {
//                    it.gender == "J"
//                })
//            }
//        }
            return binding.root

        }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}