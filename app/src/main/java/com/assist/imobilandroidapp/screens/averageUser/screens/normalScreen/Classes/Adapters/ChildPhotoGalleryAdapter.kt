package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.assist.imobilandroidapp.R
import kotlinx.android.synthetic.main.item_photo_galery.view.*

class ChildPhotoGalleryAdapter :
    RecyclerView.Adapter<ChildPhotoGalleryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_photo_galery, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val sharedPref: SharedPreferences = holder.itemView.context.getSharedPreferences("pref", Context.MODE_PRIVATE)

        holder.firstImage.setImageResource(sharedPref.getInt("image",-1))
        holder.secondImage.setImageResource(sharedPref.getInt("secondImage",-1))
        holder.thirdImage.setImageResource(sharedPref.getInt("thirdImage",-1))
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