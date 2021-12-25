package com.itacademy.practically.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.itacademy.practically.Fragments.NewsFragments
import com.itacademy.practically.R
import com.itacademy.practically.models.News

class NewsAdapters(private val array: List<News>, val listener: NewsFragments):
    RecyclerView.Adapter<NewsAdapters.ViewHolder>() {

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val newst = view.findViewById<TextView>(R.id.news_title)
        val newsi = view.findViewById<ImageView>(R.id.news_image)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: NewsAdapters.ViewHolder, position: Int) {
        val item = array[position]

        Glide
            .with(holder.itemView.context)
            .load(item.imageUrl)
            .into(holder.newsi)

        holder.newst.text = item.name

        holder.itemView.setOnClickListener {
            listener.newsClicked(item)
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }
}
interface NewsClickListener{
    fun newsClicked(clickedNews : News)
}