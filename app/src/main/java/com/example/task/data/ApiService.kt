package com.example.task.data

import com.example.task.models.ResultExp
import com.example.task.models.ResultObj
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("v1/users/favorites/experiences/")
    suspend fun getDataFromApi(): ResultObj


    @GET("v1/experiences/{id}")
    suspend fun getDetailInfoFromApi(@Path("id") exId: String): ResultExp
}