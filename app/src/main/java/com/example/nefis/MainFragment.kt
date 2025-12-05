/*
package com.example.nefis

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.OnItemViewClickedListener
import androidx.leanback.widget.OnItemViewSelectedListener

class MainFragment: BrowseSupportFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title="Netflix pirata"

        val categories=ArrayObjectAdapter(ListRowPresenter())

        val title="Nutella"
        val videos=ArrayObjectAdapter(Card())
        videos.addAll(0, listOf(
            Video("icono", "dibujo", R.mipmap.mishito, "Esta es la descripcion de mishito", R.raw.nutella),
            Video("sin luz", "foto", R.mipmap.mandarino, "Esta es la descripcion de mandarino", R.raw.utzmg)
        ))

        val header=HeaderItem(1, title)
        categories.add(ListRow(header, videos))

        adapter=categories

        onItemViewClickedListener= OnItemViewClickedListener{ _, video, _, _ ->
            val intent=Intent(requireContext(), PlayActivity::class.java).apply{
                putExtra(PlayActivity.MOVIE_EXTRA, video as Video)
            }
            startActivity(intent)
        }
    }
}*/
