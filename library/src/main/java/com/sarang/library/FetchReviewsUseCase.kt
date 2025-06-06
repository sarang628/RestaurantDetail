package com.sarang.library

interface FetchReviewsUseCase {
    suspend fun invoke(restaurantId: Int) : List<Feed>
}