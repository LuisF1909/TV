
package com.example.nefis

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.leanback.app.BrowseSupportFragment
import androidx.leanback.widget.ArrayObjectAdapter
import androidx.leanback.widget.HeaderItem
import androidx.leanback.widget.ListRow
import androidx.leanback.widget.ListRowPresenter
import androidx.leanback.widget.OnItemViewClickedListener

class MainFragment: BrowseSupportFragment() {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        title="Nefis"

        setupUI()
        setupListeners()
    }

    private fun setupUI() {
        val categories = DataRepository.getCategories(requireContext())
        val rowsAdapter = ArrayObjectAdapter(ListRowPresenter())
        val cardPresenter = Card()

        for ((index, category) in categories.withIndex()) {
            val listRowAdapter = ArrayObjectAdapter(cardPresenter)
            listRowAdapter.addAll(0, category.videos)

            val header = HeaderItem(index.toLong(), category.name)
            rowsAdapter.add(ListRow(header, listRowAdapter))
        }

        adapter = rowsAdapter
    }

    private fun setupListeners() {
        onItemViewClickedListener = OnItemViewClickedListener { _, item, _, _ ->
            if (item is Video) {
                val intent = Intent(requireContext(), PlayActivity::class.java).apply {
                    putExtra("video", item)
                }
                startActivity(intent)
            }
        }
    }
}
