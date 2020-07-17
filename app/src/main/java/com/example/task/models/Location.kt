package com.example.task.models

import androidx.room.ColumnInfo
import androidx.room.Embedded

data class Location(

    @ColumnInfo(name = "locationDescription")
    val description: String? = null,

    @Embedded
    val coordinates: Coordinates,

    val addressText: String? = null

) {
}