package com.anda.ui.write_review


import android.content.Context
import android.content.SharedPreferences
import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentWriteReview3Binding
import com.anda.ui.main.home.HomeFragment

class WriteReview3Fragment : Fragment() {

    private lateinit var binding: FragmentWriteReview3Binding
    private lateinit var sharedPreferences: SharedPreferences


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWriteReview3Binding.inflate(inflater, container, false)

        sharedPreferences = requireContext().getSharedPreferences("isReviewRegistered", Context.MODE_PRIVATE)

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

        setupClickListeners()

        return binding.root
    }

    private fun setupClickListeners() {
        binding.writeReview3NextBtnIv.setOnClickListener {
            // 저장된 SharedPreferences 수정
            sharedPreferences.edit().putBoolean("isReviewRegistered", true).apply()
            (activity as MainActivity).checkIsReview()

            (requireActivity() as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, HomeFragment())
                .commitAllowingStateLoss()
        }
    }
}
