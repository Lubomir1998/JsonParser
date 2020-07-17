package com.example.task.models

import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Coordinates (

    @SerializedName("longitude")
    val lon: Double,

    @SerializedName("latitude")
    val lat: Double
)  {
}