package com.example.bitfit

import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.Calendar
import java.util.Calendar.HOUR_OF_DAY

class MainActivity : AppCompatActivity() {
    // #449F48

    // #FF0000

    private lateinit var workoutsRv : RecyclerView
    private val workouts = mutableListOf<Workout>()

    private var prevAverage = 0
    private var newAverage = 0


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val bottomNavigationView : BottomNavigationView = findViewById(R.id.bottomNavigationView2)
        val fragmentManager : FragmentManager = supportFragmentManager

        bottomNavigationView.setOnItemSelectedListener {
            lateinit var fragment : Fragment
            when(it.itemId){
                R.id.nav_exercise -> {
                    fragment = ExerciseFragment(workouts)
                }
                R.id.nav_stats -> {
                    fragment = StatsFragment(workouts)
                }
            }
            fragmentManager.beginTransaction().replace(R.id.main_frame_layout, fragment).commit()
            true
        }

        bottomNavigationView.selectedItemId = R.id.nav_exercise

    }


}