package com.itacademy.practically.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.itacademy.practically.R
import com.itacademy.practically.models.CategoryModel

class CategoryAdapter(private val array: ArrayList<CategoryModel>,val listener: CategoryClickListener) : RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.findViewById<TextView>(R.id.itemCategory)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = array[position]
        holder.title.text = holder.itemView.context.getString(item.name)

        holder.itemView.setOnClickListener {
            listener.categoryClicked(item)
        }
    }

    override fun getItemCount(): Int {
        return array.size
    }
}
    interface CategoryClickListener {
        fun categoryClicked(clickedCategory: CategoryModel)
    }
