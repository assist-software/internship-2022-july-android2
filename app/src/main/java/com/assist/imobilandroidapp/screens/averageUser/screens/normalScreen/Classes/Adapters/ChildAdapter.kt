package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.ColorFilter
import android.graphics.PorterDuff
import android.provider.Settings.System.getString
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.ChildModel
import kotlinx.android.synthetic.main.child_item_recycler.view.*

class ChildAdapter(private val children: List<ChildModel>) :
    RecyclerView.Adapter<ChildAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =
            LayoutInflater.from(parent.context).inflate(R.layout.child_item_recycler, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return children.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val child = children[position]
        holder.image.setImageResource(child.image)
        holder.title.text = child.title
        holder.location.text = child.location
        holder.price.text = child.price

        holder.itemView.setOnClickListener {
            val sharedPref: SharedPreferences =
                it.context.applicationContext.getSharedPreferences("pref", Context.MODE_PRIVATE)
            val editor: SharedPreferences.Editor = sharedPref.edit()
//            Toast.makeText(it.context, it.context.getString(R.string.imobil_item_click), Toast.LENGTH_SHORT).show(

            editor.putInt("image", child.image)
            editor.putString("title", child.title)
            editor.putString("location", child.location)
            editor.putString("description", child.description)
            editor.putString("price", child.price)
            child.seller?.let { it1 ->
                editor.putInt("sellerImage", it1.image)
                editor.putString("sellerName", it1.name)
                editor.putString("sellerJoined", it1.joined)
                editor.putString("sellerResponseRate", it1.responseRate)
                editor.putString("sellerResponseTime", it1.responseTime)
            }
            editor.putInt("secondImage", child.secondImage)
            editor.putInt("thirdImage", child.thirdImage)

            editor.commit()

            it.findNavController().navigate(R.id.action_normalScreenFragment_to_detailsScreenFragment)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.child_image
        val title: TextView = itemView.child_title
        val location: TextView = itemView.child_location
        val price: TextView = itemView.child_price
        private val favorite: ImageButton = itemView.child_favorit_button

        init {
            favorite.setOnClickListener {
                when (favorite.drawable.constantState) {
                    it.resources.getDrawable(R.drawable.ic_outline_hearth).constantState -> {
                        Toast.makeText(
                            it.context,
                            it.context.getString(R.string.child_favorit_button_add),
                            Toast.LENGTH_SHORT
                        ).show()
                        favorite.setImageResource(R.drawable.ic_full_hearth)
                    }
                    it.resources.getDrawable(R.drawable.ic_full_hearth).constantState -> {
                        Toast.makeText(
                            it.context,
                            it.context.getString(R.string.child_favorit_button_remove),
                            Toast.LENGTH_SHORT
                        ).show()
                        favorite.setImageResource(R.drawable.ic_outline_hearth)
                    }
                }
            }
        }
    }
}