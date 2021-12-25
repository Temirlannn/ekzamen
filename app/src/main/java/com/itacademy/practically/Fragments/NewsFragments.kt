package com.itacademy.practically.Fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.Fragment
import com.itacademy.practically.R
import com.itacademy.practically.adapters.NewsAdapters
import com.itacademy.practically.models.CategoryModel
import com.itacademy.practically.adapters.NewsClickListener
import com.itacademy.practically.models.News

class NewsFragments : Fragment(), NewsClickListener {
    private lateinit var newsRecyclerView: RecyclerView
    private lateinit var currentCategory: CategoryModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_news, container, false)
        newsRecyclerView = view.findViewById(R.id.category_recyclerview)
        currentCategory = arguments?.getSerializable("category") as CategoryModel

        val newsAdapters = NewsAdapters(currentCategory.news, this,)
        return view
    }
     override fun newsClicked(clickedNews: News){
         val bundle =Bundle()
         bundle.putSerializable("category",clickedNews)
         requireActivity().supportFragmentManager.beginTransaction()
             .replace(R.id.container, News2Fragment::class.java,bundle)
             .addToBackStack(null)
             .commit()
     }
}