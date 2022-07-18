package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Data.ChildDataFactory
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.ChildModel
import kotlinx.android.synthetic.main.favourite_item_list_type.view.*

class FavouriteChildAdapter(private val favouriteChildren: List<ChildModel>):
    RecyclerView.Adapter<FavouriteChildAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.favourite_item_list_type, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val favouriteChild = favouriteChildren[position]
        holder.image.setImageResource(favouriteChild.image)
        holder.title.text = favouriteChild.title
        holder.description.text = favouriteChild.description
        holder.price.text = favouriteChild.price
    }

    override fun getItemCount(): Int {
        return favouriteChildren.size
    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.favourite_item_image_imageView
        val title: TextView = itemView.favourite_item_title_textView
        val description: TextView = itemView.favourite_item_description_textView
        val price: TextView = itemView.favourite_item_price_textView
        private val favorite: ImageView = itemView.favourite_item_fav_icon

        init {
            favorite.setOnClickListener {
                removedFromFavourites(it,adapterPosition)
            }
        }
    }

    private fun removedFromFavourites(view: View,position: Int) {
        ChildDataFactory.removeChildrenFromFavourite(position)
        Toast.makeText(view.context, view.context.getString(R.string.child_favorit_button_remove), Toast.LENGTH_SHORT).show()
    }
}