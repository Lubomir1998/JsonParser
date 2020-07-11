package com.example.task.data

data class LocationData(

    val description: String,
    val coordinates: LonLat,
    val addressText: String? = null

) {
}