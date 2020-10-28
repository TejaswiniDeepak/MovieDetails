package com.example.moviedetails

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    companion object {
        private const val API_KEY = "7bc0651fe0ea5973822df3bd27e779d9"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fetchMovies()
    }

    private fun fetchMovies() {
        var networkHelper=NetworkHelper(this)
        if(networkHelper.isNetworkConnected())
        {
            val request=RetrofitBuilder.buildService()
            val call=request.getMovies(API_KEY)
            call.enqueue(object :Callback<MovieResponse>
            {
                override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                    if(response.isSuccessful && response.body() !=null)
                    {
                        val movieResponse=response.body()!!
                        val movies=movieResponse.results
                        Log.i("result is ","$movies")
                    }
                    else
                    {
                       Log.i("error1","Error in response")
                    }

                }

                override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.i("onSOmeException","$t.message")
                }


            })

        }
        else
        {
            Log.i("error2","NoInternet")
        }
    }

}