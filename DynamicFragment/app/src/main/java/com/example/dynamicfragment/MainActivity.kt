package com.example.dynamicfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val fragman=supportFragmentManager

        btnFruits.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.flFragContainer,FruitFragment())
                .commit()
        }
        val bundle =Bundle()
        bundle.putString("KEY","yash")
        val fragment1 =VegetableFragment()
        fragment1.arguments =bundle

        val viewPagerAdapter= ViewPagerAdapter(supportFragmentManager)
        viewPagerAdapter.apply {
            add(fragment1)
            add(FruitFragment())
        }

        viewpager.adapter =viewPagerAdapter

        btnVege.setOnClickListener {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.flFragContainer,fragment1)
                .commit()
        }

    }
}