package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes

data class ParentModel(
    var title : String = "",
    val children : MutableList<Listing>
)


//parents =[]
//
//listam de server. foreach{
//
//
//    parents.firstorNull{
//        it.title ==    listing.category
//    }?.let{
//        update
//        it.add
//    }?:run{
//        parents.add
//    }
//}