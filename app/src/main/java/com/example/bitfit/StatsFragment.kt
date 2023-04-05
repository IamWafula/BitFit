package com.example.bitfit

import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment

class StatsFragment(private val workouts: MutableList<Workout>) : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: android.view.LayoutInflater, container: android.view.ViewGroup?,
        savedInstanceState: Bundle?
    ): android.view.View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.stats_layout, container, false)

        val avg = view.findViewById<TextView>(R.id.avg)
        avg.text = "Average: " + getAverage(workouts).toString() + " seconds"

        val high = view.findViewById<TextView>(R.id.high)
        high.text = "Highest: " + getHighest(workouts).toString() + " seconds"

        val low = view.findViewById<TextView>(R.id.low)
        low.text = "Lowest: " + getLowest(workouts).toString() + " seconds"


        return view
    }

    private fun getLowest(workouts: MutableList<Workout>): Any {
        return if (workouts.size == 0){
            0
        } else {
            var lowest = workouts[0].duration.toInt()
            for (workout in workouts){
                if (workout.duration.toInt() < lowest){
                    lowest = workout.duration.toInt()
                }
            }
            lowest
        }
    }

    private fun getHighest(workouts: MutableList<Workout>): Int {
        return if (workouts.size == 0){
            0
        } else {
            var highest = 0
            for (workout in workouts){
                if (workout.duration.toInt() > highest){
                    highest = workout.duration.toInt()
                }
            }
            highest
        }
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
}

