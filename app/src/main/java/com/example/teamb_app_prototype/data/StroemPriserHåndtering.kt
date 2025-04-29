package com.example.teamb_app_prototype.data


class StroemPriserHåndtering {
    private val retrofit = RetrofitInstance();

    suspend fun getNewPrices(): MinStroem {
        val fact: MinStroem = retrofit.apiService.getPrices()
        return fact;
    }
}