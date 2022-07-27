package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Listing
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.child_item_recycler.view.*

class NewListingAdapter(private val context: Context,private val children: List<Listing>) :
RecyclerView.Adapter<NewListingAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.child_item_recycler, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return children.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val child = children[position]
        Glide.with(context).load(child.images?.get(0)).into(holder.image)
        holder.title.text = child.title
        holder.location.text = child.location.toString()
        holder.price.text = child.price.toString()
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.child_image
        val title: TextView = itemView.child_title
        val location: TextView = itemView.child_location
        val price: TextView = itemView.child_price
    }
}