package com.example.nefis

import android.util.Log
import android.view.ViewGroup
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import coil.imageLoader
import coil.load
import coil.request.ImageRequest

class Card: Presenter(){
    override fun onCreateViewHolder(parent: ViewGroup): ViewHolder {
        val card=ImageCardView(parent.context)
        card.isFocusable=true
        card.isFocusableInTouchMode=true

        return ViewHolder(card)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, item: Any?) {
        val video=item as Video
        with(viewHolder.view as ImageCardView){
            titleText=video.title
            contentText=video.description
            setMainImageDimensions(300, 150)

            val request = ImageRequest.Builder(context)
                .data(video.imageUri)
                .target(mainImageView)
                .listener(
                    onError = { _, result ->
                        Log.e("CardPresenter", "Error loading image: ${video.imageUri}", result.throwable)
                    }
                )
                .build()
            context.imageLoader.enqueue(request)
        }
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {

    }

}