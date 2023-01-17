package com.ru.studentsroom.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import com.ru.studentsroom.R
import com.ru.studentsroom.adapter.SubjectsAdapterDetailed
import com.ru.studentsroom.databinding.FragmentHomeBinding
import com.ru.studentsroom.databinding.FragmentPodrobnoBinding
import com.ru.studentsroom.room.StudentApplication
import com.ru.studentsroom.viewModel.RoomViewModel
import com.ru.studentsroom.viewModel.RoomViewModelFactory

class PodrobnoFragment : Fragment() {

    //Getting SafeArgs from another fragments
    private val args by navArgs<PodrobnoFragmentArgs>()

    //binding
    private var _binding : FragmentPodrobnoBinding? = null
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

        _binding = FragmentPodrobnoBinding.inflate(inflater,container,false)

        //Filling all detailes
        binding.name.text = "${args.student.name} ${args.student.surname}"
        binding.age.text = "${args.student.age}"
        binding.gender.text = args.student.gender
        binding.course.text = "${args.student.course}"
        binding.univer.text = args.student.university
        binding.stipendiya.text = "${args.student.stipendiya} см"


        //Adapter for RV
        val adapter = SubjectsAdapterDetailed()

        //Getting student ID from passed arguments
        val studentId = args.student.id

        //List of students subjects
        roomViewModel.studentSubjects(studentId).observe(viewLifecycleOwner){ list ->
                adapter.submitList(list)
        }

        binding.rvSubjectsDetailed.adapter = adapter


        return binding.root
    }
}