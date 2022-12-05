package com.anda.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.databinding.FragmentHomeAndaInfoBannerBinding

class HomeAndaInfoBannerFragment (val imgRes : Int) : Fragment() {
    lateinit var binding: FragmentHomeAndaInfoBannerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeAndaInfoBannerBinding.inflate(inflater, container, false)

        binding.homeAndaInfoBannerImageIv.setImageResource(imgRes)
        binding.homeAndaInfoBannerImageIv.clipToOutline = true

        return binding.root
    }
}