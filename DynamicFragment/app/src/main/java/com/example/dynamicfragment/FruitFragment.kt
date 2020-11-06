package com.example.dynamicfragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.fragment_fruit.view.*


class FruitFragment : Fragment() {
    val fruitFragment= arrayOf(
        "pa","on","ta",
        "le","ca","caap",
        "go","pum","Ra"
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragmentview=inflater.inflate(R.layout.fragment_fruit, container, false)
        fragmentview.lvFruit.adapter=ArrayAdapter<String>(
            context!!,
            android.R.layout.simple_list_item_1,
            android.R.id.text1,
            fruitFragment
        )
        return fragmentview
    }


}