/*
package com.example.nefis.otros

import android.os.Bundle
import android.view.View
import androidx.leanback.app.DetailsSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.DetailsOverviewRow
import androidx.leanback.widget.FullWidthDetailsOverviewRowPresenter
import com.example.nefis.PlayActivity
import com.example.nefis.Video

class PlayFragment: DetailsSupportFragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val video=requireActivity().intent.getParcelableExtra<Video>(PlayActivity.MOVIE_EXTRA)

        val info=FullWidthDetailsOverviewRowPresenter(VideoDescription())

        val videos=ArrayObjectAdapter(info)
        videos.add(DetailsOverviewRow(video))

        adapter=videos
    }

}*/