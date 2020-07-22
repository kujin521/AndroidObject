package com.kj.test2.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.kj.test2.R
import kotlinx.android.synthetic.main.fragment_navhost.*

class NavHostFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        playButton.setOnClickListener {
            //it.findNavController().navigate(R.id.f)
        }
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_navhost, container, false)
    }

}