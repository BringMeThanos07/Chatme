package com.example.layoutinclude

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_count_up.view.*


/**
 * A simple [Fragment] subclass.
 * Use the [CountUpFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CountUpFragment : Fragment() {
    // TODO: Rename and change types of parameters


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var count= 0
        // Inflate the layout for this fragment
        val fragmentView= inflater.inflate(R.layout.fragment_count_up, container, false)

        fragmentView.btnAdd.setOnClickListener {
            count++
            fragmentView.TvCounter.text=count.toString()
        }
        return fragmentView
    }
}