package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Data

import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.DataSharing
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Listing

object ChildDataFactory {
    private val favouriteChildrens = mutableListOf<Listing>()
    private var categoryChildrens = mutableListOf<Listing>()
    private var searchChildrens = mutableListOf<Listing>()
    var category : String = ""

    fun getChildren(): List<Listing> {
        return DataSharing.getUserListings()
    }

    fun getFavouriteChildrens() : List<Listing>{
        return favouriteChildrens
    }

    fun addFavouriteChildren(child : Listing) {
        favouriteChildrens.add(child)
    }

    fun removeChildrenFromFavourite(child: Listing){
        favouriteChildrens.remove(child)
    }

    fun addCategoryChildrens(childrens: List<Listing>){
        categoryChildrens = childrens as MutableList<Listing>
    }

    fun getCategoryChildrens(): List<Listing> {
        return categoryChildrens
    }

    fun addSearchChild(children : Listing){
        searchChildrens.add(children)
    }

    fun getSearchChildrens() : List<Listing>{
        return searchChildrens
    }
}