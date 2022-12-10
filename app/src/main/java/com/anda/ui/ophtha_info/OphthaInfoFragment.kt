package com.anda.ui.ophtha_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.anda.data.entities.HomeAndaRankingOphtha
import com.anda.databinding.FragmentOphthaInfoBinding

class OphthaInfoFragment(ophthaInfo : HomeAndaRankingOphtha) : Fragment() {

    val ophthaInfoEventList = ophthaInfo.ophthaEvents
    lateinit var binding: FragmentOphthaInfoBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOphthaInfoBinding.inflate(inflater, container, false)

        optionDetails()

        return binding.root
    }

    private fun optionDetails() {
        addDetailsEvents()

        val ophthaInfoBannerAdapter = OphthaInfoBannerVPAdapter(this)
        ophthaInfoBannerAdapter.addFragment(OphthaInfoEventsFragment(ophthaInfoEventList))
        ophthaInfoBannerAdapter.addFragment(OphthaInfoReviewsFragment())
        ophthaInfoBannerAdapter.addFragment(OphthaInfoRatingsFragment())
        binding.ophthaInfoDetailsVp.adapter = ophthaInfoBannerAdapter
        binding.ophthaInfoDetailsVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    private fun addDetailsEvents() {

    }
}