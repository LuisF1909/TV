
package com.example.nefis

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest

class MainActivity2 : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val context = LocalContext.current
            val categories = DataRepository.getCategories(context)
            CategoryList(categories)
        }
    }
}

@Composable
fun CategoryList(categories: List<Category>) {
    LazyColumn {
        items(categories) { category ->
            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = category.name)
                VideoRow(category.videos)
            }
        }
    }
}

@Composable
fun VideoRow(videos: List<Video>) {
    val context = LocalContext.current
    LazyRow(contentPadding = PaddingValues(horizontal = 8.dp)) {
        items(videos) { video ->
            val imageRequest = ImageRequest.Builder(context)
                .data(video.imageUri)
                .listener(onError = { _, result ->
                    Log.e("MainActivity2", "Error loading image: ${video.imageUri}", result.throwable)
                })
                .build()

            AsyncImage(
                model = imageRequest,
                contentDescription = null,
                modifier = Modifier
                    .padding(4.dp)
                    .width(150.dp)
                    .height(100.dp)
                    .clickable { navigateToPlayActivity(context, video) },
                contentScale = ContentScale.Crop
            )
        }
    }
}

private fun navigateToPlayActivity(context: android.content.Context, video: Video) {
    val intent = Intent(context, PlayActivity::class.java).apply {
        putExtra("video", video)
    }
    context.startActivity(intent)
}
