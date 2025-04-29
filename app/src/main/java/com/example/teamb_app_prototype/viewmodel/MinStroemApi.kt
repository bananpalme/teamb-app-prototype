package com.example.teamb_app_prototype.viewmodel

import com.example.teamb_app_prototype.data.MinStroem
import retrofit2.http.GET
import retrofit2.http.Headers

interface MinStroemApi {
    @GET("prices/DK1")
    @Headers("Authorization: Bearer Rjk1OUY1OTgtMUE4NC00MTU4LUFEOEMtQ0E5MzZFMkQyM0ZBOmYzMWJiYjA3YWQ5YTQ5ZjI5ZmRlZTljZjNjYjlhNWRhZDQ2ZDE0M2U0ZTQ0OWI4ZDZiMTQ1OTYyNjY0NzkxNzE=")
    suspend fun getPrices(): List<MinStroem>
}