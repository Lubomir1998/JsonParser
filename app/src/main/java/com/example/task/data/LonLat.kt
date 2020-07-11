package com.example.task.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class LonLat (

    @SerializedName("longitude")
    @Expose
    val lon: Double,

    @SerializedName("latitude")
    @Expose
    val lat: Double
){
}