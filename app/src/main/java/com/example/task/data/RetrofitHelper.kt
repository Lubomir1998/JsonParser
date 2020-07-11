package com.example.task.data

import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitHelper {


    companion object {
        private const val baseUrl = "https://a1ea1343-8fcb-408e-ba56-395933b2e4c8.mock.pstmn.io/"

        val retrofit: ApiService = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .build().create(ApiService::class.java)
            }



}