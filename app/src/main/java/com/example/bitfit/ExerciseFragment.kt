package com.example.bitfit

import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*

class ExerciseFragment(private var workouts: MutableList<Workout>) : Fragment() {
    private lateinit var workoutsRv : RecyclerView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_exercise, container, false)
        val layoutManager = LinearLayoutManager(context)

        workoutsRv = view.findViewById(R.id.exercises)
        val adapter = WorkoutAdapter(workouts)
        workoutsRv.layoutManager = layoutManager
        workoutsRv.setHasFixedSize(true)
        workoutsRv.adapter = adapter

        val duration = view.findViewById<TextView>(R.id.editDuration2)

        //var imageView = view.findViewById<ImageView>(R.id.imageView)
        //val trendText = view.findViewById<TextView>(R.id.textView3)


        var button = view.findViewById<Button>(R.id.button5)
        button.setOnClickListener{
            val date = LocalDate.now()
            val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val time = Calendar.getInstance().get(Calendar.HOUR_OF_DAY).toString() + ":" + Calendar.getInstance().get(Calendar.MINUTE).toString()
            val formattedDate = date.format(dateFormat)


            if (duration.text.toString() == ""){
                duration.text = "0"
            }

            val workout = Workout(workouts.size + 1, formattedDate.toString(), time, duration.text.toString())

            workouts.add(workout)

            adapter.notifyDataSetChanged()

        }



        view.findViewById<Button>(R.id.button6).setOnClickListener{
            workouts.clear()
            adapter.notifyDataSetChanged()
        }

        return view
    }

    private fun getAverage(workouts: MutableList<Workout>): Int {
        return if (workouts.size == 0){
            0
        } else {
            var sum = 0
            for (workout in workouts){
                sum += workout.duration.toInt()
            }
            (sum / workouts.size)
        }
    }

    companion object {
        fun newInstance(): ExerciseFragment{
            return ExerciseFragment(workouts = mutableListOf<Workout>())
        }
    }
}