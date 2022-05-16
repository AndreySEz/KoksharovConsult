package com.example.koksharovconsult.Retrofit

import com.example.koksharovconsult.login
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RetApi {
    @POST("auth/login")
    fun login(@Body hashMap: HashMap<String, String>): Call<login>
}