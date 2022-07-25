package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assist.imobilandroidapp.R
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Interfaces.ListingInterface
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.ParentModel
import kotlinx.android.synthetic.main.imobil_item.view.*

class ParentAdapter(private val parents: List<ParentModel>,private val listingInterface: ListingInterface) :
    RecyclerView.Adapter<ParentAdapter.ViewHolder>() {
    private val viewPool = RecyclerView.RecycledViewPool()
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.imobil_item, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return parents.size
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        val parent = parents[position]
        holder.textView.text = parent.category
        val childLayoutManager = LinearLayoutManager(holder.recyclerView.context, LinearLayout.HORIZONTAL, false)
        childLayoutManager.initialPrefetchItemCount = 4
        holder.recyclerView.apply {
            layoutManager = childLayoutManager
            adapter = ChildAdapter(parent.children,listingInterface)
            setRecycledViewPool(viewPool)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val recyclerView: RecyclerView = itemView.rv_child
        val textView: TextView = itemView.parent_category
        private val seeEverything : RelativeLayout = itemView.see_everything_relativeLayout

        init {
           seeEverything.setOnClickListener {
               listingInterface.onCategoryClicked(textView.text.toString(),parents[adapterPosition].children)
           }
        }
    }
}