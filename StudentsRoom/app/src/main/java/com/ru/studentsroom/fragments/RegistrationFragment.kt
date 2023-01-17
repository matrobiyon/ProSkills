package com.ru.studentsroom.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.ru.studentsroom.HomeActivity
import com.ru.studentsroom.R
import com.ru.studentsroom.databinding.FragmentHomeBinding
import com.ru.studentsroom.databinding.FragmentRegistrationBinding
import com.ru.studentsroom.room.StudentApplication
import com.ru.studentsroom.viewModel.RoomViewModel
import com.ru.studentsroom.viewModel.RoomViewModelFactory

class RegistrationFragment : Fragment() {

    //binding main page
    private var _binding : FragmentRegistrationBinding? = null
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
        _binding = FragmentRegistrationBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginContainer.setOnClickListener {
            val intent = Intent(requireContext(), HomeActivity::class.java)
            startActivity(intent)
        }

        binding.newStudentContainer.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_newStudentFragment)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

