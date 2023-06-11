package com.anda.ui.main.home.andaInfo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentHomeAndaInfoBannerBinding
import com.anda.ui.main.home.andaInfo.model.AndaInfoBanners
import com.bumptech.glide.Glide

class HomeAndaInfoBannerFragment (val pictureImg: Int) : Fragment() {
    lateinit var binding: FragmentHomeAndaInfoBannerBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeAndaInfoBannerBinding.inflate(inflater, container, false)
        //binding.homeAndaInfoBannerImageIv.setImageResource(andaInfoResult)

        binding.homeAndaInfoBannerImageIv.setImageResource(pictureImg)

        clickSetting()
        return binding.root
    }

    private fun clickSetting() {
        binding.homeAndaInfoBannerImageIv.setOnClickListener {

            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("https://docs.google.com/forms/d/e/1FAIpQLSfdL9I2cN25yB4yWVvUdeflZ6XJ2LAoJUU87AS1lhX8JfPBrQ/viewform"))
            startActivity(intent)
        }
    }

}