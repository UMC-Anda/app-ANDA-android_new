package com.anda.ui.write_review

import android.graphics.Typeface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentWriteReview3Binding

class WriteReview3Fragment : Fragment() {

    lateinit var binding: FragmentWriteReview3Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWriteReview3Binding.inflate(inflater, container, false)

        val thinTxt: Typeface? = ResourcesCompat.getFont((context as MainActivity), R.font.pretendard_thin)
        val regularTxt: Typeface? = ResourcesCompat.getFont((context as MainActivity), R.font.pretendard_regular)
        val mediumTxt: Typeface? = ResourcesCompat.getFont((context as MainActivity), R.font.pretendard_medium)
        val semiBoldTxt: Typeface? = ResourcesCompat.getFont((context as MainActivity), R.font.pretendard_semi_bold)
        val boldTxt: Typeface? = ResourcesCompat.getFont((context as MainActivity), R.font.pretendard_bold)

        binding.writeReview3ReviewCertificationTv.typeface = semiBoldTxt
        binding.writeReview3ReviewCertificationExampleTv.typeface = semiBoldTxt
        binding.writeReview3ReviewCertificationExampleImg1Iv.clipToOutline = true
        binding.writeReview3ReviewCertificationExampleImg2Iv.clipToOutline = true
        binding.writeReview3ReviewCertificationExampleImg3Iv.clipToOutline = true

        clickSetting()
        return binding.root
    }
    private fun clickSetting() {


    }
}