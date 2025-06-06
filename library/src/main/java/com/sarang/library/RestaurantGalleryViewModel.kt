package com.sarang.library

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantGalleryViewModel @javax.inject.Inject constructor(
    private val getRestaurantGalleryUseCase: GetRestaurantGalleryUseCase
) : ViewModel() {
    val tag = "__RestaurantGalleryViewModel"
    var uiState: List<RestaurantImage> by mutableStateOf((arrayListOf()))
        private set

    fun loadImage(restaurantId: Int) {
        viewModelScope.launch {
            try {
                uiState = getRestaurantGalleryUseCase.invoke(restaurantId)
            } catch (e: Exception) {
                Log.e(tag, "$e")
            }
        }
    }
}