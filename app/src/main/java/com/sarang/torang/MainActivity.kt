package com.sarang.torang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import com.sarang.library.compose.LocalImageLoader
import com.sarang.library.compose.RestaurantDetailNavigationScreen
import com.sarang.library.compose.restaurantdetail.RestaurantDetailScreen
import com.sarang.torang.di.image.customImageLoader
import com.sryang.torang.ui.TorangTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TorangTheme {
                CompositionLocalProvider(LocalImageLoader provides customImageLoader) {
                    //RestaurantDetailScreenTest()
                    RestaurantDetailNavigationScreen_()
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RestaurantDetailScreenTest(restaurantId : Int = 234){
    RestaurantDetailScreen(restaurantId = restaurantId)
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
fun RestaurantDetailNavigationScreen_(restaurantId : Int  = 234) {
    RestaurantDetailNavigationScreen(
        restaurantId = restaurantId,
        feed = {
            /*Feed(
                review = Review.empty().copy(
                    user = User.empty()
                        .copy(name = it.name, profilePictureUrl = it.profilePictureUrl),
                    rating = 4.0f,
                    reviewImages = it.reviewImages,
                    contents = it.contents,
                    restaurant = Restaurant(it.restaurantId, it.restaurantName)
                ),
                imageLoadCompose = provideTorangAsyncImage1(),
                expandableText = { modifier, a, b, c -> ExpandableText(modifier, a, b, c) })*/
        }
    )
}
