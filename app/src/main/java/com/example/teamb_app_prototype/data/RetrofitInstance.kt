package com.example.teamb_app_prototype.data

import com.example.teamb_app_prototype.viewmodel.MinStroemApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Lukas

object RetrofitInstance {
    val api: MinStroemApi by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.minstroem.app/thirdParty/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MinStroemApi::class.java)
    }

}

