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
import com.anda.databinding.FragmentWriteReview2Binding
import com.anda.ui.main.community.WriteCommunityWritingFragment

class WriteReview2Fragment : Fragment() {

    lateinit var binding: FragmentWriteReview2Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWriteReview2Binding.inflate(inflater, container, false)

        val thinTxt: Typeface? = ResourcesCompat.getFont((context as MainActivity), R.font.pretendard_thin)
        val regularTxt: Typeface? = ResourcesCompat.getFont((context as MainActivity), R.font.pretendard_regular)
        val mediumTxt: Typeface? = ResourcesCompat.getFont((context as MainActivity), R.font.pretendard_medium)
        val semiBoldTxt: Typeface? = ResourcesCompat.getFont((context as MainActivity), R.font.pretendard_semi_bold)
        val boldTxt: Typeface? = ResourcesCompat.getFont((context as MainActivity), R.font.pretendard_bold)

        binding.writeReview2QuestionOphthaRatingTv.typeface = semiBoldTxt
        binding.writeReview2QuestionDetailReviewTv.typeface = semiBoldTxt
        binding.writeReview2PhotoReviewTv.typeface = semiBoldTxt


        clickSetting()
        return binding.root
    }
    private fun clickSetting() {

        binding.writeReview2NextBtnIv.setOnClickListener{
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, WriteReview3Fragment())
                .commitAllowingStateLoss()
        }

    }
}