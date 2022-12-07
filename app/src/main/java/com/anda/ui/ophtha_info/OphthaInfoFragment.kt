package com.anda.ui.ophtha_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.anda.R
import com.anda.data.entities.OphthaInfoEvent
import com.anda.databinding.FragmentOphthaInfoBinding
import com.anda.ui.main.home.HomeAdsBannerFragment
import com.anda.ui.main.home.HomeAdsBannerVPAdapter

class OphthaInfoFragment : Fragment() {

    val ophthaInfoEventList = ArrayList<OphthaInfoEvent>()
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
        val adsBannerAdapter = HomeAdsBannerVPAdapter(this)
        adsBannerAdapter.addFragment(HomeAdsBannerFragment(R.drawable.ophtha_ex_img))
        adsBannerAdapter.addFragment(HomeAdsBannerFragment(R.drawable.ex_img))
        binding.ophthaInfoDetailsVp.adapter = adsBannerAdapter
        binding.ophthaInfoDetailsVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }
}