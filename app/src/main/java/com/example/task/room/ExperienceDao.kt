package com.example.task.room

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.*
import com.example.task.data.Experience
import com.example.task.models.ResultExp


@Dao
interface ExperienceDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(experience: Experience)

    @Update
    suspend fun update(experience: Experience)

    @Query("SELECT * FROM Experience WHERE id = :id")
    suspend fun getExperienceById(id: String): Experience

    @Query("SELECT * FROM Experience")
    suspend fun getAllExperiences(): List<Experience>

}