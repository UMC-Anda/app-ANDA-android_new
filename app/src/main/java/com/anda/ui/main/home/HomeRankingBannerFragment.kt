package com.anda.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.databinding.FragmentHomeRankingBannerBinding

class HomeRankingBannerFragment (val imgRes : Int) : Fragment() {
    lateinit var binding: FragmentHomeRankingBannerBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeRankingBannerBinding.inflate(inflater, container, false)

        binding.homeRankingBannerOphthaListRv.adapter
        binding.homeRankingBannerOphthaListRv.layoutManager

        return binding.root
    }
}