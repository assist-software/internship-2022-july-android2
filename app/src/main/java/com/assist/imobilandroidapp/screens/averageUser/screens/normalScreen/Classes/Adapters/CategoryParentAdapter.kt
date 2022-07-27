package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.ChildModel
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Interfaces.ListingInterface
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Listing
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.favourite_item_list_type.view.*

class CategoryParentAdapter(private val categoryChildrens: List<Listing>,private val context: Context, private val listingInterface: ListingInterface) :
    RecyclerView.Adapter<CategoryParentAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context)
            .inflate(R.layout.favourite_item_list_type, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val categoryChild = categoryChildrens[position]
        Glide.with(context).load(categoryChild.images?.get(0)).into(holder.image)
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
        private val favorite: ImageButton = itemView.favourite_item_fav_icon

        init {
            favorite.setImageResource(R.drawable.ic_outline_hearth)
            favorite.setOnClickListener {
                itemFavouriteIconClick(favorite ,it,adapterPosition)
            }
            itemView.setOnClickListener {
                listingInterface.onChildItemCLick(categoryChildrens[adapterPosition])
            }
        }
    }

    private fun itemFavouriteIconClick(button: ImageButton, view: View, position: Int) {
        when (button.drawable.constantState) {
            view.resources.getDrawable(R.drawable.ic_outline_hearth).constantState -> {
                Toast.makeText(view.context, view.context.getString(R.string.child_favorit_button_add), Toast.LENGTH_SHORT).show()
                button.setImageResource(R.drawable.ic_full_hearth)
//                ChildDataFactory.addFavouriteChildren(children[position])
                listingInterface.onAddFavouriteIconClick(categoryChildrens[position])
            }
            view.resources.getDrawable(R.drawable.ic_full_hearth).constantState -> {
                Toast.makeText(view.context, view.context.getString(R.string.child_favorit_button_remove), Toast.LENGTH_SHORT).show()
                button.setImageResource(R.drawable.ic_outline_hearth)
            }
        }
    }

}