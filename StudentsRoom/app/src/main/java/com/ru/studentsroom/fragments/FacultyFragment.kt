package com.ru.studentsroom.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.ru.studentsroom.R
import com.ru.studentsroom.adapter.StudentsAdapter
import com.ru.studentsroom.databinding.FragmentFacultyBinding
import com.ru.studentsroom.room.StudentApplication
import com.ru.studentsroom.viewModel.RoomViewModel
import com.ru.studentsroom.viewModel.RoomViewModelFactory

class FacultyFragment : Fragment() {

    //binding
    private var _binding : FragmentFacultyBinding? = null
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
        _binding = FragmentFacultyBinding.inflate(inflater,container,false)

        //Getting faculty text from user
        var faculty: String

        binding.poisk.doOnTextChanged { text, _, _, _ ->
            faculty = text.toString()
            Log.d("MyERROR", "$faculty")
            val adapter = StudentsAdapter()

            adapter.onPodrobneeClicked = {
                val action = FacultyFragmentDirections.actionFacultyFragmentToPodrobnoFragment(it)
                findNavController().navigate(action)
            }

            roomViewModel.listOfStudents.observe(viewLifecycleOwner){
                binding.rvStudentsHome.adapter = adapter
                adapter.submitList(it.filter {
                    it.fakultet == faculty.lowercase()
                })
            }
        }


        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}