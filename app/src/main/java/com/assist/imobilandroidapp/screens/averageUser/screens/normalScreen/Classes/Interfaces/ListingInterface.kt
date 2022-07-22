package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Interfaces

import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Listing

interface ListingInterface {

    fun onCategoryClicked(category : String,categoryList:List<Listing>){}

    fun onItemClicked(listing: Listing)

    fun onChildItemCLick(listing: Listing)
}