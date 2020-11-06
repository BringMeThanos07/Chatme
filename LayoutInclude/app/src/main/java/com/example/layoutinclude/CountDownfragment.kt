package com.example.layoutinclude

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_count_downfragment.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [CountDownfragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CountDownfragment : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var count=0
        // Inflate the layout for this fragment
        val fragmentview=inflater.inflate(R.layout.fragment_count_downfragment, container, false)
        fragmentview.btnAdd1.setOnClickListener {
            count--
            fragmentview.TvCounter1.text=count.toString()
        }

        return fragmentview
    }

}