package com.example.teamb_app_prototype.viewmodel

import com.example.teamb_app_prototype.data.MinStroem
import retrofit2.http.GET

interface MinStroemApi {
    @GET("/prices/DK1")
    suspend fun getPrices(): MinStroem
}