package com.sarang.torang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.CompositionLocalProvider
import com.sarang.library.compose.DetailRestaurantInfo
import com.sarang.library.compose.ImageLoader
import com.sarang.library.compose.LocalDetailRestaurantInfo
import com.sarang.library.compose.LocalImageLoader
import com.sarang.library.compose.restaurantdetail.RestaurantDetailScreen
import com.sarang.torang.di.image.customImageLoader
import com.sarang.torang.di.image.provideTorangAsyncImage
import com.sarang.torang.di.restaurant_info.RestaurantInfoWithPermission
import com.sryang.library.compose.workflow.BestPracticeViewModel
import com.sryang.torang.ui.TorangTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TorangTheme {
                CompositionLocalProvider(
                    LocalImageLoader provides customImageLoader,
                    LocalDetailRestaurantInfo provides customRestaurantInfo,
                    LocalRestaurantInfoImageLoader provides restaurantImageLoader
                ) {
                    RestaurantDetailScreen(restaurantId = 234)
                }
            }
        }
    }
}

val customImageLoader: ImageLoader = { modifier, url, width, height, scale ->
    // 여기서 실제 이미지 로딩 구현 예시
    provideTorangAsyncImage().invoke(modifier, url, width, height, scale)
}

val customRestaurantInfo: DetailRestaurantInfo = {
    RestaurantInfoWithPermission(restaurantId = it, viewModel = BestPracticeViewModel())
}

val restaurantImageLoader: RestaurantInfoImageLoader = { modifier, url, width, height, scale ->
    // 여기서 실제 이미지 로딩 구현 예시
    provideTorangAsyncImage().invoke(modifier, url, width, height, scale)
}