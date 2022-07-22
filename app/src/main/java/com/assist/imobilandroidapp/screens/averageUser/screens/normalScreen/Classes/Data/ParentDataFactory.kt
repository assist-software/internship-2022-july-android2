package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.Data

import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.DataSharing
import com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes.ParentModel

object ParentDataFactory {

    private

    fun getParents(count : Int) : List<ParentModel>{
        val parents = mutableListOf<ParentModel>()
        repeat(count){
            val parent = ParentModel("", DataSharing.getUserListings())
            parents.add(parent)
        }
        return parents
    }

    fun get
}