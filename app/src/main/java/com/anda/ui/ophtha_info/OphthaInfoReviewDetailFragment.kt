package com.anda.ui.ophtha_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.databinding.FragmentOphthaInfoReviewDetailBinding

class OphthaInfoReviewDetailFragment()  : Fragment() {

    lateinit var binding: FragmentOphthaInfoReviewDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOphthaInfoReviewDetailBinding.inflate(inflater, container, false)


        binding.ophthaInfoReviewDetailReviewImg1Iv.clipToOutline = true
        binding.ophthaInfoReviewDetailReviewImg2Iv.clipToOutline = true



        return binding.root
    }
}
