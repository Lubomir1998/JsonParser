package com.example.task.data

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("v1/users/favorites/experiences/")
    fun getDataFromApi(): Call<ResultObj>


    @GET("v1/experiences/{id}")
    suspend fun getDetailInfoFromApi(@Path("id") exId: String): ResultExp
}