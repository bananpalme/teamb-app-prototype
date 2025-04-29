package com.example.teamb_app_prototype.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.teamb_app_prototype.data.MinStroem
import com.example.teamb_app_prototype.data.RetrofitInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch


class MinStroemViewModel : ViewModel() {
    private val _strømpriser = MutableStateFlow<List<MinStroem>>(emptyList())
    val strømpriser = _strømpriser.asStateFlow()

    init {
        fetchPrices()
    }

    private fun fetchPrices() {
        viewModelScope.launch {
            try {
                val result = RetrofitInstance.api.getPrices()
                _strømpriser.value = result
            } catch (e: Exception) {

            }
        }
    }
}