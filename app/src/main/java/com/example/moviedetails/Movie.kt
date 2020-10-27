package com.example.moviedetails

import com.google.gson.annotations.SerializedName

data class Movie (
    val id:Int,
    //use @serializeName when there is mismatch in variable name declared in program and in the JSON response
    @SerializedName("poster_path")
    val posterPath:String,
    @SerializedName("release_date")
    val releaseDate:String,
    val title:String,
    @SerializedName("vote_average")
    val voteAverage:Double,
    @SerializedName("vote_count")
    val voteCount:Int
)