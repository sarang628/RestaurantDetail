package com.sarang.library

interface GetMenuUseCase {
    suspend fun invoke(restaurantId: Int): List<MenuData>
}