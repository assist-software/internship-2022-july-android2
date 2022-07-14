package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters

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
import kotlinx.android.synthetic.main.child_item_recycler.view.*

class ChildAdapter(private val children : List<ChildModel>) : RecyclerView.Adapter<ChildAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v =  LayoutInflater.from(parent.context).inflate(R.layout.child_item_recycler,parent,false)
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
            Toast.makeText(it.context, it.context.getString(R.string.imobil_item_click), Toast.LENGTH_SHORT).show()
        }
    }

    inner class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        val image: ImageView = itemView.child_image
        val title: TextView = itemView.child_title
        val location: TextView = itemView.child_location
        val price: TextView = itemView.child_price
        private val favorite : ImageButton = itemView.child_favorit_button

        init {
            favorite.setOnClickListener {
                Toast.makeText(this.itemView.context, it.context.getString(R.string.child_favorit_button), Toast.LENGTH_SHORT).show()
            }
        }
    }
}