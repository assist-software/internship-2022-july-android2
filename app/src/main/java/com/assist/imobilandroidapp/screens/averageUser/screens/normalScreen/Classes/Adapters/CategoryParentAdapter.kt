package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.ChildModel
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Listing
import kotlinx.android.synthetic.main.favourite_item_list_type.view.*

class CategoryParentAdapter(private val categoryChildrens: List<Listing>) :
    RecyclerView.Adapter<CategoryParentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.favourite_item_list_type, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categoryChild = categoryChildrens[position]
        holder.image.setImageResource(categoryChild.images?.toInt()!!)
        holder.title.text = categoryChild.title
        holder.description.text = categoryChild.description
        holder.price.text = categoryChild.price.toString()
    }

    override fun getItemCount(): Int = categoryChildrens.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.favourite_item_image_imageView
        val title: TextView = itemView.favourite_item_title_textView
        val description: TextView = itemView.favourite_item_description_textView
        val price: TextView = itemView.favourite_item_price_textView
        private val favorite: ImageView = itemView.favourite_item_fav_icon

        init {
            favorite.setImageResource(R.drawable.ic_outline_hearth)
        }
    }
}