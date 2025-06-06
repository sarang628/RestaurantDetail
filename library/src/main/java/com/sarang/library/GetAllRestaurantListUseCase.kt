package com.sarang.library

interface GetAllRestaurantListUseCase {
    suspend fun invoke(): List<String>
}