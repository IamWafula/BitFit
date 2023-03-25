package com.example.bitfit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    // #449F48

    // #FF0000

    private lateinit var workoutsRv : RecyclerView
    private val workouts = mutableListOf<Workout>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        workoutsRv = findViewById(R.id.recyclerView)

        val adapter = WorkoutAdapter(workouts)
        workoutsRv.adapter = adapter
        workoutsRv.layoutManager = LinearLayoutManager(this)


        var button = findViewById<Button>(R.id.button)
        button.setOnClickListener(){
            val workout = Workout(1, "2021-05-01", "12:00", "1:00")
            workouts.add(workout)
            adapter.notifyDataSetChanged()
        }

    }
}