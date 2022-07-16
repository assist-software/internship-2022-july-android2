package com.assist.imobilandroidapp.screens.averageUser.screens.normalScreen.Classes

import com.assist.imobilandroidapp.R
import kotlin.random.Random

object ChildDataFactory {
    private val random = Random

    private val titles =  arrayListOf( "Dreaming", "Aurora", "Lucy House", "KingPenthouse")
    private val locations = arrayListOf("Suceava, Romania")
    private val prices = arrayListOf("764,34 RON", "10000 RON", "989,99 RON" , "540 RON")
    private val descriptions = arrayListOf("Description 1")
    private val seller = Seller(R.drawable.ic_launcher_foreground,"Zarinschi Armand","Joined now","Response rate: 97%","Response time: with an hour")
    private val images = arrayListOf(R.drawable.first_image,R.drawable.third_image,R.drawable.second_image,R.drawable.test_photo)
    private val galleryImages = arrayListOf(R.drawable.second_image, R.drawable.third_image)

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
        val index = random.nextInt(images.size)
        return images[index]
    }

    private fun randomDescription() : String{
        return descriptions[0]
    }

    private fun randomImageFromGallery() : Int{
        val index = random.nextInt(galleryImages.size)
        return galleryImages[index]
    }

    fun getChildren(count : Int) : List<ChildModel>{
        val children = mutableListOf<ChildModel>()
        repeat(count){
            val child = ChildModel(randomImage(), randomTitle() , randomLocation() , randomDescription(), randomPrice() , seller , randomImageFromGallery() , randomImageFromGallery())
            children.add(child)
        }
        return children
    }
}