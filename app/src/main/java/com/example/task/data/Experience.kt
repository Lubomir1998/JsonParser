package com.example.task.data

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.task.models.Image
import com.example.task.models.Location

@Entity
data class Experience(

    @PrimaryKey
    val id: String,

    val title: String,

    val description: String? = null,

    @Embedded
    val coverImage: Image,

    val nextSchedules: List<String>,

    val type: String,

    @Embedded
    val location: Location

)