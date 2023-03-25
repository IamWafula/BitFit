package com.example.bitfit

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutDao {
    @Query("SELECT * FROM workout_table")
    fun getAllWorkouts(): Flow<List<WorkoutEntity>>

    @Insert
    fun insertAll(workouts: List<WorkoutEntity>)

    @Query("DELETE FROM workout_table")
    fun deleteAll()

}