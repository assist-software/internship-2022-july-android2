package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters

import android.content.Context
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
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.*
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Data.ChildDataFactory
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
            childItemClick(it,child)
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
                itemFavouriteIconClick(favorite,it,adapterPosition)
            }
        }
    }

    private fun childItemClick(view: View, childModel: ChildModel) {

        DataSharing.init(view.context.getSharedPreferences(SHARED_KEY,Context.MODE_PRIVATE))

        DataSharing.addItemImage(ITEM_IMAGE,childModel.image)
        DataSharing.addItemText(ITEM_TITLE,childModel.title)
        DataSharing.addItemText(ITEM_LOCATION,childModel.location)
        DataSharing.addItemText(ITEM_DESCRIPTION,childModel.description)
        DataSharing.addItemText(ITEM_PRICE,childModel.price)
        childModel.seller?.let { it1 ->
            DataSharing.addSellerImage(ITEM_SELLER_IMAGE,it1.image)
            DataSharing.addSellerInfo(ITEM_SELLER_NAME,it1.name)
            DataSharing.addSellerInfo(ITEM_SELLER_JOINED,it1.joined)
            DataSharing.addSellerInfo(ITEM_SELLER_RESPONSE_RATE,it1.responseRate)
            DataSharing.addSellerInfo(ITEM_SELLER_RESPONSE_TIME,it1.responseTime)
        }
        DataSharing.addItemImage(ITEM_SECOND_IMAGE,childModel.secondImage)
        DataSharing.addItemImage(ITEM_THIRD_IMAGE,childModel.thirdImage)

        DataSharing.commit()

        ChildDataFactory.childModel = childModel
        view.findNavController().navigate(R.id.action_normalScreenFragment_to_detailsScreenFragment)
    }

    private fun itemFavouriteIconClick(button: ImageButton,view: View,position: Int) {
        when (button.drawable.constantState) {
            view.resources.getDrawable(R.drawable.ic_outline_hearth).constantState -> {
                Toast.makeText(view.context, view.context.getString(R.string.child_favorit_button_add), Toast.LENGTH_SHORT).show()
                button.setImageResource(R.drawable.ic_full_hearth)
                ChildDataFactory.addFavouriteChildren(children[position])
            }
            view.resources.getDrawable(R.drawable.ic_full_hearth).constantState -> {
                Toast.makeText(view.context, view.context.getString(R.string.child_favorit_button_remove), Toast.LENGTH_SHORT).show()
                button.setImageResource(R.drawable.ic_outline_hearth)
            }
        }
    }
}