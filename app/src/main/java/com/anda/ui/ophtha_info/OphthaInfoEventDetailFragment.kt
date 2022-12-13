package com.anda.ui.ophtha_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.databinding.FragmentOphthaInfoEventDetailBinding

class OphthaInfoEventDetailFragment() : Fragment() {

    lateinit var binding: FragmentOphthaInfoEventDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOphthaInfoEventDetailBinding.inflate(inflater, container, false)




        return binding.root
    }

}