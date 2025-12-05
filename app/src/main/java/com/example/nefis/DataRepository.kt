
package com.example.nefis

import android.content.Context

object DataRepository {

    fun getLocalUri(context: Context, resId: Int): String {
        return "android.resource://${context.packageName}/$resId"
    }

    fun getVideos(context: Context): List<Video> {
        val videos = mutableListOf<Video>()

        // Video 1
        videos.add(
            Video(
                id = 1,
                videoUri = getLocalUri(context, R.raw.nutella),
                imageUri = getLocalUri(context, R.mipmap.mishito),
                title = "Video 1",
                description = "Descripción del video 1"
            )
        )

        // Video 2
        videos.add(
            Video(
                id = 2,
                videoUri = getLocalUri(context, R.raw.utzmg),
                imageUri = getLocalUri(context, R.mipmap.mandarino),
                title = "Video 2",
                description = "Descripción del video 2"
            )
        )

        // Videos 3 to 25
        for (i in 3..25) {
            videos.add(
                Video(
                    id = i,
                    videoUri = "https://storage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
                    imageUri = "https://picsum.photos/300/200?random=$i",
                    title = "Video $i",
                    description = "Descripción del video $i"
                )
            )
        }

        return videos
    }

    fun getCategories(context: Context): List<Category> {
        val videos = getVideos(context)
        val categories = mutableListOf<Category>()
        val videosPerCategory = 5

        for (i in 0 until 5) {
            val startIndex = i * videosPerCategory
            val endIndex = startIndex + videosPerCategory
            categories.add(
                Category(
                    name = "Categoría ${i + 1}",
                    videos = videos.subList(startIndex, endIndex)
                )
            )
        }

        return categories
    }
}

data class Category(val name: String, val videos: List<Video>)

