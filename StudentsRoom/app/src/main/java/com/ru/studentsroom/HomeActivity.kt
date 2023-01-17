package com.ru.studentsroom

import android.content.ClipData.Item
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.Toolbar
import androidx.navigation.NavGraph
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.ru.studentsroom.databinding.ActivityHomeBinding
import com.ru.studentsroom.fragments.FacultyFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Getting my Bottom Navvigation view
        val bottomNavView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)

        //Getting my Tool bar
        val navBar = findViewById<Toolbar>(R.id.toolbarForHome)

        // Getting my Nav Host and setting to it a Nav Controller
        val navFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerHome) as NavHostFragment
        val navController = navFragment.navController

        //Changing ToolBar title according to fragments
        val appBarConfiguration = AppBarConfiguration(setOf(R.id.homeFragment,R.id.facultyFragment,R.id.genderFragment,R.id.stipendiyaFragment))
        navBar.setupWithNavController(navController,appBarConfiguration)
        navBar.setNavigationIcon(R.drawable.ic_menu)

        //Implementing navigation beetween fragments clicking Bottom NavView
        bottomNavView.setupWithNavController(navController)
        bottomNavView.clearAnimation()

    }
}