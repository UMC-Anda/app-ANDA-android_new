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
import com.anda.databinding.FragmentWriteReview1Binding
import com.anda.ui.main.community.WriteCommunityWritingFragment

class WriteReview1Fragment : Fragment() {

    lateinit var binding: FragmentWriteReview1Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWriteReview1Binding.inflate(inflater, container, false)
        clickSetting()


        val thinTxt: Typeface? = ResourcesCompat.getFont((context as MainActivity), R.font.pretendard_thin)
        val regularTxt: Typeface? = ResourcesCompat.getFont((context as MainActivity), R.font.pretendard_regular)
        val mediumTxt: Typeface? = ResourcesCompat.getFont((context as MainActivity), R.font.pretendard_medium)
        val semiBoldTxt: Typeface? = ResourcesCompat.getFont((context as MainActivity), R.font.pretendard_semi_bold)
        val boldTxt: Typeface? = ResourcesCompat.getFont((context as MainActivity), R.font.pretendard_bold)


        binding.writeReview1QuestionOphthaTv.typeface = semiBoldTxt

        return binding.root
    }
    private fun clickSetting() {

        binding.writeReview1NextBtnIv.setOnClickListener{
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, WriteReview2Fragment())
                .commitAllowingStateLoss()
        }

    }
}