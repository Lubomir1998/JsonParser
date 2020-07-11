package com.example.task.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class Experience(

    val title: String,

    val id: String,

    val description: String,

    @SerializedName("coverImage")
    @Expose
    val imgUrl: Original,

    @SerializedName("nextSchedules")
    @Expose
    val date: List<String>,

    val type: String,

    @SerializedName("location")
    @Expose
    val loc: LocationData


) {
}