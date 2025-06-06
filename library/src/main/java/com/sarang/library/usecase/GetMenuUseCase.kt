package com.sarang.library.usecase

import com.sarang.library.MenuData

interface GetMenuUseCase {
    suspend fun invoke(restaurantId: Int): List<MenuData>
}