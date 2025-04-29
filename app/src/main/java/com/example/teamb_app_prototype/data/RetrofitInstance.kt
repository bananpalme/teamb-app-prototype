package com.example.teamb_app_prototype.data

import com.example.teamb_app_prototype.viewmodel.MinStroemApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitInstance {
    private val baseURL = "https://api.minstroem.app/thirdParty"

    val retrofitClient = Retrofit.Builder()
        .baseUrl(baseURL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofitClient.create(MinStroemApi::class.java)
}