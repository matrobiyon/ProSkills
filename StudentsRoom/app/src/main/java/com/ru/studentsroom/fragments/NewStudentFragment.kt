package com.ru.studentsroom.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import com.ru.studentsroom.R
import com.ru.studentsroom.adapter.SubjectsAdapter
import com.ru.studentsroom.databinding.FragmentNewStudentBinding
import com.ru.studentsroom.room.StudentApplication
import com.ru.studentsroom.room.Subjects
import com.ru.studentsroom.viewModel.RoomViewModel
import com.ru.studentsroom.viewModel.RoomViewModelFactory

class NewStudentFragment : Fragment() {

    //binding
    private var _binding : FragmentNewStudentBinding? = null
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
        _binding = FragmentNewStudentBinding.inflate(inflater,container,false)

        //Adapter
        val adapter = SubjectsAdapter()

        roomViewModel.listOfSubject.observe(this.viewLifecycleOwner){
            it.let {
                adapter.submitList(it)
                Log.d("MyERROR", "$it")
            }
        }
        binding.rvSubjects.adapter = adapter

        //list for selected subjects
        val selectedSubjects = mutableListOf<Subjects>()

        adapter.onClicked = { subjects, checkBoxState ->
            if (checkBoxState)
                selectedSubjects.add(subjects)
            else selectedSubjects.remove(subjects)
            Log.d("MyERROR", "hello")
        }

        //Getting datas from User Input
        var name = binding.name.text.toString()
        var surname = binding.surname.text.toString()
        var otchestvo = binding.otchestvo.text.toString()
        var vozrast = binding.age.text.toString()
        var university = binding.university.text.toString()
        var course = binding.course.text.toString()
        var fakultet = binding.facultet.text.toString()
        var stipendiya = binding.stipendiya.text.toString()

        binding.name.doOnTextChanged { text, _, _, _ ->
            name = text.toString()
        }
        binding.surname.doOnTextChanged { text, _, _, _ ->
            surname = text.toString()
        }
        binding.otchestvo.doOnTextChanged { text, _, _, _ ->
            otchestvo = text.toString()
        }
        binding.age.doOnTextChanged { text, _, _, _ ->
            vozrast = text.toString()
        }
        binding.university.doOnTextChanged { text, _, _, _ ->
            university = text.toString()
        }
        binding.course.doOnTextChanged { text, _, _, _ ->
            course = text.toString()
        }
        binding.facultet.doOnTextChanged { text, _, _, _ ->
            fakultet = text.toString()
        }
        binding.stipendiya.doOnTextChanged { text, _, _, _ ->
            stipendiya = text.toString()
        }



        binding.submitRegistration.setOnClickListener {
            //Check if fields are not empty
            val notEmptyFields = checkIfValid(name,surname,otchestvo,vozrast,university,course,fakultet,stipendiya)

            //Checks if more than 3 subjects are selected
            val checkedSubjects = checkSubjects(selectedSubjects.size)

            //Getting gender of Student
            val gender = if (binding.genderM.isChecked) "M" else "J"

            //Getting student Id from room which will be declared later
            if (notEmptyFields && checkedSubjects){
                //adding student to database and getting his/her Id
                 roomViewModel.addNewStudent(name,surname,otchestvo,vozrast,university,course,fakultet,stipendiya,gender)

                //Adding Subjects to Connection Table
                roomViewModel.findLastId.observe(this.viewLifecycleOwner) {lastId ->
                    Log.d("MyERROR", "$lastId")
                    roomViewModel.addNewConnection(lastId,selectedSubjects)

                    //Transition back
                    val registrationFragment = RegistrationFragment()
                    requireActivity().supportFragmentManager.beginTransaction().setCustomAnimations(
                        R.anim.slide_in,
                        R.anim.fade_out,
                        R.anim.fade_in,
                        R.anim.slide_out
                    ).replace(R.id.fragmentContainerView,registrationFragment)
                        .addToBackStack(null)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                }


            }else{
                Toast.makeText(requireContext(),"Something went wrong",Toast.LENGTH_SHORT).show()
            }
        }

        //Adding Animation for entering and existing the fragment


        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    //Checking all field is they are not empty
    //Checking if Vozrast,Stupendiya and Course are bigger than 0
    private fun checkIfValid(name: String,surname: String,otchestvo: String,vozrast:String,
                     university:String,course:String,fakultet:String,stipendita:String) : Boolean{
        return !(name.isBlank()&&surname.isBlank()&&otchestvo.isBlank()&&vozrast.isBlank()&&university.isBlank()
                &&course.isBlank()&&fakultet.isBlank()&&stipendita.isBlank()
                &&vozrast.toInt()>0&&stipendita.toInt()>0&&course.toInt()>0)
    }

    // Checks if more than 3 subjects are selected
    private fun checkSubjects(sizeOfList : Int) : Boolean{
        return sizeOfList > 3
    }

}