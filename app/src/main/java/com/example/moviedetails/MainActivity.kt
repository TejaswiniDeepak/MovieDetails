package com.example.moviedetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchMovies()
    }

    private fun fetchMovies() {
        var networkHelper=NetworkHelper(this)
        if(networkHelper.isNetworkConnected())
        {

        }
    }
}