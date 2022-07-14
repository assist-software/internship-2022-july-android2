package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes

import com.assist.imobilandroidapp.R
import kotlin.random.Random

object ChildDataFactory {
    private val random = Random

    private val titles =  arrayListOf( "Dreaming", "Aurora", "Lucy House", "KingPenthouse")
    private val locations = arrayListOf("Suceava, Romania")
    private val prices = arrayListOf("764,34 RON", "10000 RON", "989,99 RON" , "540 RON")

    private fun randomTitle() : String{
        val index = random.nextInt(titles.size)
        return titles[index]
    }

    private fun randomPrice() : String{
        val index = random.nextInt(prices.size)
        return prices[index]
    }

    private fun randomLocation() : String{
        return locations[0]
    }

    private fun randomImage() : Int{
        return R.drawable.test_photo
    }

    fun getChildren(count : Int) : List<ChildModel>{
        val children = mutableListOf<ChildModel>()
        repeat(count){
            val child = ChildModel(randomImage(), randomTitle() , randomLocation() , randomPrice())
            children.add(child)
        }
        return children
    }
}