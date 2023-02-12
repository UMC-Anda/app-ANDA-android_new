package com.anda.ui.main.community.eyeMbti

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentCommunityEyeMbtiQuestionsBinding
import com.anda.databinding.FragmentCommunityEyeMbtiResultBinding

class CommunityEyeMbtiResultFragment : Fragment() {
    lateinit var binding: FragmentCommunityEyeMbtiResultBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityEyeMbtiResultBinding.inflate(inflater, container, false)

        binding.communityEyeMbtiResultOperationNameTv.text = "스마일라식"
        binding.communityEyeMbtiResultCharacterImgIv.setImageResource(R.drawable.eye_mbti_result_smile)
        binding.communityEyeMbtiResultMyOperationExplanationTitleTv.text = "스마일라식" + "이란?"
        binding.communityEyeMbtiResultMyOperationExplanationSortTv.text = "아픈 건 싫고, 빨리 낳고 싶다?한 줄 요약 느낌) 설명설명~~ 너가 써~~ 설명설명~~ 너가 써~~" + "설명설명~~ 너가 써~~"
//        binding.communityEyeMbtiResultMyOperationExplanationContentTv.text = "아픈 건 싫고, 빨리 낳고 싶다?한 줄 요약 느낌) 설명설명~~ 너가 써~~ 설명설명~~ 너가 써~~" + "설명설명~~ 너가 써~~"


        return binding.root
    }


}