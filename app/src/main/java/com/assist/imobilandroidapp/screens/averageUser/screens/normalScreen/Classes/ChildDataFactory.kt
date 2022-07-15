package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes

import android.content.SharedPreferences
import com.assist.imobilandroidapp.R
import kotlin.random.Random

object ChildDataFactory {
    private val random = Random

    private val titles =  arrayListOf( "Dreaming", "Aurora", "Lucy House", "KingPenthouse")
    private val locations = arrayListOf("Suceava, Romania")
    private val prices = arrayListOf("764,34 RON", "10000 RON", "989,99 RON" , "540 RON")
    private val descriptions = arrayListOf("Description 1")
    private val seller = Seller(R.drawable.ic_launcher_foreground,"Zarinschi Armand","Joined now","Response rate: 97%","Response time: with an hour")

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

    private fun randomDescription() : String{
        return descriptions[0]
    }

    fun getChildren(count : Int) : List<ChildModel>{
        val children = mutableListOf<ChildModel>()
        repeat(count){
            val child = ChildModel(randomImage(), randomTitle() , randomLocation() , randomDescription(), randomPrice() , seller)
            children.add(child)
        }
        return children
    }
}