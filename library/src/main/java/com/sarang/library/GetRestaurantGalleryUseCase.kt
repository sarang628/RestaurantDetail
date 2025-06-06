package com.sarang.library

interface GetRestaurantGalleryUseCase {
    suspend fun invoke(restaurantId : Int): List<RestaurantImage>
}