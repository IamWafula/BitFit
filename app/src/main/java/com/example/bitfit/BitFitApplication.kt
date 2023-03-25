package com.example.bitfit

import android.app.Application

class BitFitApplication : Application(){
    val db by lazy { BitFitDatabase.getDatabase(this) }
}