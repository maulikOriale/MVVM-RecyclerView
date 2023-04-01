package com.example.kotlinpractice

import retrofit2.Call
import retrofit2.http.GET

interface RetrofitInterface {

    @GET("posts")
    fun getData(): Call<List<DataModel>>
}