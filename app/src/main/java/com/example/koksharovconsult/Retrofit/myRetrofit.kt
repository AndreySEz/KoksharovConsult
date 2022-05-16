package com.example.koksharovconsult.Retrofit

import com.example.koksharovconsult.Retrofit.RetApi
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object myRetrofit {
    fun getRetrofit(): RetApi = Retrofit.Builder()
        .baseUrl("https://food.madskill.ru")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(RetApi::class.java)
}