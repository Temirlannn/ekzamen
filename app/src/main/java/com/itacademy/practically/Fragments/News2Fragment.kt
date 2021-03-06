package com.itacademy.practically.Fragments

import android.graphics.Color.red
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.itacademy.practically.R
import com.itacademy.practically.models.Categories
import com.itacademy.practically.models.News

class News2Fragment: Fragment() {
    private lateinit var news: News

    private lateinit var newsTitleTV: TextView
    private lateinit var newsDescriptionTV: TextView
    private lateinit var newsIV: ImageView
    private lateinit var newsContainer: ConstraintLayout

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        news = arguments?.getSerializable("category") as News
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        newsDescriptionTV = view.findViewById(R.id.news_description)
        newsTitleTV = view.findViewById(R.id.news_title)
        newsIV = view.findViewById(R.id.news_image)
        newsContainer = view.findViewById(R.id.news_container)

        newsTitleTV.text = news.name
        newsDescriptionTV.text = news.description

        Glide.with(requireContext()).load(news.imageUrl).into(newsIV)

        when (news.category) {Categories.weather -> newsContainer.background =
            ColorDrawable(ContextCompat.getColor(requireContext(), R.color.purple_200))
            Categories.Sport -> newsContainer.background = ColorDrawable(ContextCompat.getColor(requireContext(), R.color.red))
        }
        return view
    }
}