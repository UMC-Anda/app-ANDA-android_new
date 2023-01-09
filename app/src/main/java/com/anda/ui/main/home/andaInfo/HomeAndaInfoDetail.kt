package com.anda.ui.main.home.andaInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.R
import com.anda.databinding.FragmentHomeAndaInfoDetailBinding
import com.anda.ui.main.home.andaInfo.model.AndaInfoBanners
import com.bumptech.glide.Glide

class HomeAndaInfoDetail(val andaInfoBanners: AndaInfoBanners?): Fragment() {

    lateinit var binding: FragmentHomeAndaInfoDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeAndaInfoDetailBinding.inflate(inflater, container, false)

        Glide
            .with(this)
            .load(andaInfoBanners!!.andaInfoContentPicture) // 불러올 이미지 url
            .placeholder(R.drawable.ex_img) // 이미지 로딩 시작하기 전 표시할 이미지
            .error(R.drawable.ex_img) // 로딩 에러 발생 시 표시할 이미지
            .fallback(R.drawable.ex_img) // 로드할 url 이 비어있을(null 등) 경우 표시할 이미지
            .into(binding.homeAndaInfoDetailImageIv) // 이미지를 넣을 뷰
        return binding.root
    }
}