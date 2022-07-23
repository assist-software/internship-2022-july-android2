package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Interfaces

import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.ChildModel
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Listing

interface FavouriteInterface {

    fun isListEmpty()

    fun removeItemFromFavourite(listing: Listing)
}