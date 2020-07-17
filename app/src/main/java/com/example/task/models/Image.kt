package com.example.task.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class Image(

    @ColumnInfo(name = "imageID")
    val id: String,

    val original: String

) {
}
