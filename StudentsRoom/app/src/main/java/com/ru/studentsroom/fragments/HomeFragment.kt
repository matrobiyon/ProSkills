package com.ru.studentsroom.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.ru.studentsroom.R
import com.ru.studentsroom.databinding.FragmentHomeBinding
import com.ru.studentsroom.room.StudentApplication
import com.ru.studentsroom.room.SubjectsDao
import com.ru.studentsroom.viewModel.RoomViewModel
import com.ru.studentsroom.viewModel.RoomViewModelFactory

class HomeFragment : Fragment() {

    //binding main page
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //Randomly adding some subjects
//        roomViewModel.addNewSubject("Soc gigiena")
//        roomViewModel.addNewSubject("Pediatriya",true)
//        roomViewModel.addNewSubject("Psixiatriya")
//        roomViewModel.addNewSubject("Khirurgiya")
//        roomViewModel.addNewSubject("Neonatologiya", true)
//        roomViewModel.addNewSubject("Kardiologiya", true)
//        roomViewModel.addNewSubject("NeuroPatology")


    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}