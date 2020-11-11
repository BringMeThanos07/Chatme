package com.example.reclycerview

import kotlin.random.Random

data class Fruit (val name :String,val origin:String,val quantity:Int){
    companion object{
        val FRUIT_NAMES =arrayOf("Apple","Mango","watermelon","strawberry", "guava","banana","kiwiw","grapes")
        val ORIGIN= arrayOf("Luchnow","delhi","assam","jammu","babbuon")
        fun getRandomfruits(n:Int):ArrayList<Fruit>{
            val  fruitArray=ArrayList<Fruit>(n)
            for (i in 1..n)
            {
                fruitArray.add(Fruit(FRUIT_NAMES[Random.nextInt(8)], ORIGIN[Random.nextInt(5)],Random.nextInt(10)*100))
            }
            return fruitArray
        }
    }
}