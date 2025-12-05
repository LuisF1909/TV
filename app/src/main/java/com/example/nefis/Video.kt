
package com.example.nefis

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Video(
    val id: Int,
    val videoUri: String,
    val imageUri: String,
    val title: String,
    val description: String
) : Parcelable
