package com.anda.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.databinding.FragmentHomeAdsBannerBinding

class HomeAdsBannerFragment(val imgRes : Int) : Fragment() {
    lateinit var binding : FragmentHomeAdsBannerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeAdsBannerBinding.inflate(inflater, container, false)

        binding.homeAdsBannerImageIv.setImageResource(imgRes)
        return binding.root
    }
}