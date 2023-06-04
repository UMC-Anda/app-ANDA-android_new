package com.anda.ui.main.community.eyeMbti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentCommunityEyeMbtiQuestionsBinding

class CommunityEyeMbtiQuestionsFragment(
    val eyeMbtiQuestion: String?,
    val currentQuestion: Int,
    val listener: OnOptionSelectedListener) : Fragment() {

    lateinit var binding: FragmentCommunityEyeMbtiQuestionsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityEyeMbtiQuestionsBinding.inflate(inflater, container, false)
        //binding.homeAndaInfoBannerImageIv.setImageResource(andaInfoResult)




        binding.communityEyeMbtiQuestionsNumTv.text = "Q" + currentQuestion.toString() + "."
        binding.communityEyeMbtiQuestionsContentTv.text = eyeMbtiQuestion
        clickSetting()
        return binding.root
    }
    interface OnOptionSelectedListener {
        fun onOptionSelected(isChecked: Boolean)
    }

    private fun clickSetting() {
        binding.eyeMbtiSelectCircleYes3Civ.setOnClickListener {
            resetSelectCircle()
            binding.eyeMbtiSelectCircleYes3Civ.setImageResource(R.color.Main)
            listener.onOptionSelected(true)
        }
        binding.eyeMbtiSelectCircleYes2Civ.setOnClickListener {
            resetSelectCircle()
            binding.eyeMbtiSelectCircleYes2Civ.setImageResource(R.color.MAIN_70)
            listener.onOptionSelected(true)
        }
        binding.eyeMbtiSelectCircleYes1Civ.setOnClickListener {
            resetSelectCircle()
            binding.eyeMbtiSelectCircleYes1Civ.setImageResource(R.color.MAIN_50)
            listener.onOptionSelected(true)
        }
        binding.eyeMbtiSelectCircleSosoCiv.setOnClickListener {
            resetSelectCircle()
            binding.eyeMbtiSelectCircleSosoCiv.setImageResource(R.color.MAIN_10)
            listener.onOptionSelected(true)
        }
        binding.eyeMbtiSelectCircleNo1Civ.setOnClickListener {
            resetSelectCircle()
            binding.eyeMbtiSelectCircleNo1Civ.setImageResource(R.color.MAIN_50)
            listener.onOptionSelected(true)
        }
        binding.eyeMbtiSelectCircleNo2Civ.setOnClickListener {
            resetSelectCircle()
            binding.eyeMbtiSelectCircleNo2Civ.setImageResource(R.color.MAIN_70)
            listener.onOptionSelected(true)
        }
        binding.eyeMbtiSelectCircleNo3Civ.setOnClickListener {
            resetSelectCircle()
            binding.eyeMbtiSelectCircleNo3Civ.setImageResource(R.color.Main)
            listener.onOptionSelected(true)
        }
    }

    private fun resetSelectCircle() {
        binding.eyeMbtiSelectCircleYes3Civ.setImageResource(R.color.white)
        binding.eyeMbtiSelectCircleYes2Civ.setImageResource(R.color.white)
        binding.eyeMbtiSelectCircleYes1Civ.setImageResource(R.color.white)
        binding.eyeMbtiSelectCircleSosoCiv.setImageResource(R.color.white)
        binding.eyeMbtiSelectCircleNo1Civ.setImageResource(R.color.white)
        binding.eyeMbtiSelectCircleNo2Civ.setImageResource(R.color.white)
        binding.eyeMbtiSelectCircleNo3Civ.setImageResource(R.color.white)
    }

}