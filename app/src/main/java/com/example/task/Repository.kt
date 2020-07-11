package com.example.task

import com.example.task.data.ApiService
import com.example.task.data.RetrofitHelper


class Repository {

    private val client: ApiService = RetrofitHelper.retrofit

    fun getData() = client.getDataFromApi()


   suspend fun getDetail(id: String) = client.getDetailInfoFromApi(id)



}
