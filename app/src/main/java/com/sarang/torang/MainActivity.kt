package com.sarang.torang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.sarang.library.RestaurantDetailNavigationScreen
import com.sarang.library.RestaurantDetailScreen
import com.sarang.torang.ui.theme.RestaurantDetailTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            RestaurantDetailTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    RestaurantDetailTheme {
        Greeting("Android")
    }
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
