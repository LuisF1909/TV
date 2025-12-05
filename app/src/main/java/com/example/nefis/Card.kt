package com.example.nefis

import android.view.ViewGroup
import androidx.leanback.widget.ImageCardView
import androidx.leanback.widget.Presenter
import coil.load

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
            mainImageView.load(video.imageUri)
        }
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder) {

    }

}