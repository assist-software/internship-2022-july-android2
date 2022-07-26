package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Data.ChildDataFactory
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.DataSharing
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.item_photo_galery.view.*

class ChildPhotoGalleryAdapter(private val context: Context) :
    RecyclerView.Adapter<ChildPhotoGalleryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_photo_galery, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        Glide.with(context).load(ChildDataFactory.listing.images?.get(0)).into(holder.firstImage)
        Glide.with(context).load(ChildDataFactory.listing.images?.get(1)).into(holder.secondImage)
        Glide.with(context).load(ChildDataFactory.listing.images?.get(2)).into(holder.thirdImage)
    }

    override fun getItemCount(): Int {
        return 3
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val firstImage : ImageView = itemView.first_image
        val secondImage : ImageView = itemView.second_image
        val thirdImage : ImageView = itemView.third_image
    }
}