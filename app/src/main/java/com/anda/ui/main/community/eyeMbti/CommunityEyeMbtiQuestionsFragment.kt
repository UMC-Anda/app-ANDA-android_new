package com.anda.ui.main.community.eyeMbti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentCommunityEyeMbtiQuestionsBinding

class CommunityEyeMbtiQuestionsFragment (val eyeMbtiQuestion: String?, val currentQuestion : Int) : Fragment() {
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

    private fun clickSetting() {
        binding.eyeMbtiSelectCircleYes3Civ.setOnClickListener {
            resetSelectCircle()
            binding.eyeMbtiSelectCircleYes3Civ.setImageResource(R.color.Main)
            (context as MainActivity).eyeMbtiQuestionIsSelect = true
        }
        binding.eyeMbtiSelectCircleYes2Civ.setOnClickListener {
            resetSelectCircle()
            binding.eyeMbtiSelectCircleYes2Civ.setImageResource(R.color.MAIN_70)
            (context as MainActivity).eyeMbtiQuestionIsSelect = true
        }
        binding.eyeMbtiSelectCircleYes1Civ.setOnClickListener {
            resetSelectCircle()
            binding.eyeMbtiSelectCircleYes1Civ.setImageResource(R.color.MAIN_50)
            (context as MainActivity).eyeMbtiQuestionIsSelect = true
        }
        binding.eyeMbtiSelectCircleSosoCiv.setOnClickListener {
            resetSelectCircle()
            binding.eyeMbtiSelectCircleSosoCiv.setImageResource(R.color.MAIN_10)
            (context as MainActivity).eyeMbtiQuestionIsSelect = true
        }
        binding.eyeMbtiSelectCircleNo1Civ.setOnClickListener {
            resetSelectCircle()
            binding.eyeMbtiSelectCircleNo1Civ.setImageResource(R.color.MAIN_50)
            (context as MainActivity).eyeMbtiQuestionIsSelect = true
        }
        binding.eyeMbtiSelectCircleNo2Civ.setOnClickListener {
            resetSelectCircle()
            binding.eyeMbtiSelectCircleNo2Civ.setImageResource(R.color.MAIN_70)
            (context as MainActivity).eyeMbtiQuestionIsSelect = true
        }
        binding.eyeMbtiSelectCircleNo3Civ.setOnClickListener {
            resetSelectCircle()
            binding.eyeMbtiSelectCircleNo3Civ.setImageResource(R.color.Main)
            (context as MainActivity).eyeMbtiQuestionIsSelect = true
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