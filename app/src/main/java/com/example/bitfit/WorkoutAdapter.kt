package com.example.bitfit

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class WorkoutAdapter(private val workouts: MutableList<Workout>) : RecyclerView.Adapter<WorkoutAdapter.WorkoutViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WorkoutAdapter.WorkoutViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.exercise_view, parent, false)
        return WorkoutViewHolder(view)
    }



    inner class WorkoutViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mDate: TextView = itemView.findViewById(R.id.date_today) as TextView
        var mTime: TextView = itemView.findViewById(R.id.ex_time) as TextView
        var mDuration: TextView = itemView.findViewById(R.id.ex_duration) as TextView

        override fun toString(): String {
            return mDate.text.toString() + " " + mTime.text.toString() + " " + mDuration.text.toString()
        }

    }

    override fun getItemCount(): Int {
        return workouts.size
    }

    override fun onBindViewHolder(holder: WorkoutViewHolder, position: Int) {
        var workout = workouts[position]
        holder.mDate.text = workout.date
        holder.mTime.text = workout.time
        holder.mDuration.text = workout.duration + "s"
    }


}
