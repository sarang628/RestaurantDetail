package com.sarang.library.usecase

import com.sarang.library.Feed

interface FetchReviewsUseCase {
    suspend fun invoke(restaurantId: Int) : List<Feed>
}