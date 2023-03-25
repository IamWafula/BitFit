package com.example.bitfit

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [WorkoutEntity::class], version = 1)
abstract class BitFitDatabase: RoomDatabase(){

    abstract fun workoutDao(): WorkoutDao

    companion object {
        @Volatile
        private var INSTANCE: BitFitDatabase? = null

        fun getDatabase(context: Context): BitFitDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    BitFitDatabase::class.java,
                    "bitfit_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}