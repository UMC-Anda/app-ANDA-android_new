package com.anda.ui.write_review

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Typeface
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import androidx.fragment.app.Fragment
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentWriteReview2Binding
import com.anda.ui.main.community.WriteCommunityWritingFragment
import com.anda.ui.main.home.HomeFragment

class WriteReview2Fragment : Fragment(), OnClickListener {

    lateinit var binding: FragmentWriteReview2Binding
    private lateinit var sharedPreferences: SharedPreferences

    var clickable = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWriteReview2Binding.inflate(inflater, container, false)
        sharedPreferences = requireContext().getSharedPreferences("UserInfo", Context.MODE_PRIVATE)

        //kind
        binding.writeReview2KindSadIconIv.setOnClickListener(this)
        binding.writeReview2KindSosoIconIv.setOnClickListener(this)
        binding.writeReview2KindSmileIconIv.setOnClickListener(this)
        //waiting
        binding.writeReview2WaitingSadIconIv.setOnClickListener(this)
        binding.writeReview2WaitingSosoIconIv.setOnClickListener(this)
        binding.writeReview2WaitingSmileIconIv.setOnClickListener(this)
        //price
        binding.writeReview2PriceSadIconIv.setOnClickListener(this)
        binding.writeReview2PriceSosoIconIv.setOnClickListener(this)
        binding.writeReview2PriceSmileIconIv.setOnClickListener(this)
        //information
        binding.writeReview2InformationSadIconIv.setOnClickListener(this)
        binding.writeReview2InformationSosoIconIv.setOnClickListener(this)
        binding.writeReview2InformationSmileIconIv.setOnClickListener(this)
        //effective
        binding.writeReview2EffectiveSadIconIv.setOnClickListener(this)
        binding.writeReview2EffectiveSosoIconIv.setOnClickListener(this)
        binding.writeReview2EffectiveSmileIconIv.setOnClickListener(this)

        binding.writeReview2DetailReviewEt.addTextChangedListener(object : TextWatcher {
            val error_color = ContextCompat.getColor(requireContext(), R.color.form_error)
            val pass_color = ContextCompat.getColor(requireContext(), R.color.Main)

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var idMessage: String = binding.writeReview2DetailReviewEt.text.toString()
                if (idMessage.length > 5) {
                    binding.writeReview2QuestionDetailReviewInfoTv.setTextColor(pass_color)
                    binding.writeReview2QuestionDetailReviewInfoTv.text = "(" + idMessage.length.toString() + "자 / 최소 5자)"
                    binding.writeReview2NextBtnIv.setImageResource(R.drawable.next_btn_able)
                    clickable = true
                } else {
                    binding.writeReview2QuestionDetailReviewInfoTv.setTextColor(error_color)
                    binding.writeReview2QuestionDetailReviewInfoTv.text = "(" + idMessage.length.toString() + "자 / 최소 5자)"
                    binding.writeReview2NextBtnIv.setImageResource(R.drawable.next_btn_unable)
                    clickable = false
                }
            }
            override fun afterTextChanged(p0: Editable?) {
            }
        })

        clickSetting()
        return binding.root
    }
    private fun clickSetting() {
        binding.writeReview2NextBtnIv.setOnClickListener {
            // 저장된 SharedPreferences 수정
            if (clickable) {
                sharedPreferences.edit().putBoolean("isReviewRegistered", true).apply()
                (activity as MainActivity).checkIsReview()

                (requireActivity() as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, HomeFragment())
                    .commitAllowingStateLoss()
            }
        }
    }

    override fun onClick(v: View?) {
        when(v){
            //kind
            binding.writeReview2KindSadIconIv -> {
                binding.writeReview2KindSadIconIv.setImageResource(R.drawable.icon_sad_checked)
                binding.writeReview2KindSosoIconIv.setImageResource(R.drawable.icon_soso_unchecked)
                binding.writeReview2KindSmileIconIv.setImageResource(R.drawable.icon_smile_unchecked)
            }
            binding.writeReview2KindSosoIconIv -> {
                binding.writeReview2KindSadIconIv.setImageResource(R.drawable.icon_sad_unchecked)
                binding.writeReview2KindSosoIconIv.setImageResource(R.drawable.icon_soso_checked)
                binding.writeReview2KindSmileIconIv.setImageResource(R.drawable.icon_smile_unchecked)
            }
            binding.writeReview2KindSmileIconIv -> {
                binding.writeReview2KindSadIconIv.setImageResource(R.drawable.icon_sad_unchecked)
                binding.writeReview2KindSosoIconIv.setImageResource(R.drawable.icon_soso_unchecked)
                binding.writeReview2KindSmileIconIv.setImageResource(R.drawable.icon_smile_checked)
            }
            //waiting
            binding.writeReview2WaitingSadIconIv -> {
                binding.writeReview2WaitingSadIconIv.setImageResource(R.drawable.icon_sad_checked)
                binding.writeReview2WaitingSosoIconIv.setImageResource(R.drawable.icon_soso_unchecked)
                binding.writeReview2WaitingSmileIconIv.setImageResource(R.drawable.icon_smile_unchecked)
            }
            binding.writeReview2WaitingSosoIconIv -> {
                binding.writeReview2WaitingSadIconIv.setImageResource(R.drawable.icon_sad_unchecked)
                binding.writeReview2WaitingSosoIconIv.setImageResource(R.drawable.icon_soso_checked)
                binding.writeReview2WaitingSmileIconIv.setImageResource(R.drawable.icon_smile_unchecked)
            }
            binding.writeReview2WaitingSmileIconIv -> {
                binding.writeReview2WaitingSadIconIv.setImageResource(R.drawable.icon_sad_unchecked)
                binding.writeReview2WaitingSosoIconIv.setImageResource(R.drawable.icon_soso_unchecked)
                binding.writeReview2WaitingSmileIconIv.setImageResource(R.drawable.icon_smile_checked)
            }
            //price
            binding.writeReview2PriceSadIconIv -> {
                binding.writeReview2PriceSadIconIv.setImageResource(R.drawable.icon_sad_checked)
                binding.writeReview2PriceSosoIconIv.setImageResource(R.drawable.icon_soso_unchecked)
                binding.writeReview2PriceSmileIconIv.setImageResource(R.drawable.icon_smile_unchecked)
            }
            binding.writeReview2PriceSosoIconIv -> {
                binding.writeReview2PriceSadIconIv.setImageResource(R.drawable.icon_sad_unchecked)
                binding.writeReview2PriceSosoIconIv.setImageResource(R.drawable.icon_soso_checked)
                binding.writeReview2PriceSmileIconIv.setImageResource(R.drawable.icon_smile_unchecked)
            }
            binding.writeReview2PriceSmileIconIv -> {
                binding.writeReview2PriceSadIconIv.setImageResource(R.drawable.icon_sad_unchecked)
                binding.writeReview2PriceSosoIconIv.setImageResource(R.drawable.icon_soso_unchecked)
                binding.writeReview2PriceSmileIconIv.setImageResource(R.drawable.icon_smile_checked)
            }
            //information
            binding.writeReview2InformationSadIconIv -> {
                binding.writeReview2InformationSadIconIv.setImageResource(R.drawable.icon_sad_checked)
                binding.writeReview2InformationSosoIconIv.setImageResource(R.drawable.icon_soso_unchecked)
                binding.writeReview2InformationSmileIconIv.setImageResource(R.drawable.icon_smile_unchecked)
            }
            binding.writeReview2InformationSosoIconIv -> {
                binding.writeReview2InformationSadIconIv.setImageResource(R.drawable.icon_sad_unchecked)
                binding.writeReview2InformationSosoIconIv.setImageResource(R.drawable.icon_soso_checked)
                binding.writeReview2InformationSmileIconIv.setImageResource(R.drawable.icon_smile_unchecked)
            }
            binding.writeReview2InformationSmileIconIv -> {
                binding.writeReview2InformationSadIconIv.setImageResource(R.drawable.icon_sad_unchecked)
                binding.writeReview2InformationSosoIconIv.setImageResource(R.drawable.icon_soso_unchecked)
                binding.writeReview2InformationSmileIconIv.setImageResource(R.drawable.icon_smile_checked)
            }
            //effective
            binding.writeReview2EffectiveSadIconIv -> {
                binding.writeReview2EffectiveSadIconIv.setImageResource(R.drawable.icon_sad_checked)
                binding.writeReview2EffectiveSosoIconIv.setImageResource(R.drawable.icon_soso_unchecked)
                binding.writeReview2EffectiveSmileIconIv.setImageResource(R.drawable.icon_smile_unchecked)
            }
            binding.writeReview2EffectiveSosoIconIv -> {
                binding.writeReview2EffectiveSadIconIv.setImageResource(R.drawable.icon_sad_unchecked)
                binding.writeReview2EffectiveSosoIconIv.setImageResource(R.drawable.icon_soso_checked)
                binding.writeReview2EffectiveSmileIconIv.setImageResource(R.drawable.icon_smile_unchecked)
            }
            binding.writeReview2EffectiveSmileIconIv -> {
                binding.writeReview2EffectiveSadIconIv.setImageResource(R.drawable.icon_sad_unchecked)
                binding.writeReview2EffectiveSosoIconIv.setImageResource(R.drawable.icon_soso_unchecked)
                binding.writeReview2EffectiveSmileIconIv.setImageResource(R.drawable.icon_smile_checked)
            }
        }
    }
}