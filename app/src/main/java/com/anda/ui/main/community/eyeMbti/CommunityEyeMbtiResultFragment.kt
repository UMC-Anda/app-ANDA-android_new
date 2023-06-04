package com.anda.ui.main.community.eyeMbti

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentCommunityEyeMbtiQuestionsBinding
import com.anda.databinding.FragmentCommunityEyeMbtiResultBinding

class CommunityEyeMbtiResultFragment(var operationName : String) : Fragment() {
    lateinit var binding: FragmentCommunityEyeMbtiResultBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityEyeMbtiResultBinding.inflate(inflater, container, false)

        binding.communityEyeMbtiResultOperationNameTv.text = operationName
        binding.communityEyeMbtiResultMyOperationExplanationTitleTv.text = operationName + "이란?"
        binding.communityEyeMbtiResultMyOperationExplanationSortTv.text = "수술에 대한 설명입니다. 자세한 설명은 애플리케이션 출시 후 업데이트 될 예정입니다. 우선은 느낌만 봐주시면 감사하겠습니다."

        when(operationName){
            "라식" ->  binding.communityEyeMbtiResultCharacterImgIv.setImageResource(R.drawable.eye_mbti_result_lasik)
            "라섹" ->  binding.communityEyeMbtiResultCharacterImgIv.setImageResource(R.drawable.eye_mbti_result_lasek)
            "스마일 라식" ->  binding.communityEyeMbtiResultCharacterImgIv.setImageResource(R.drawable.eye_mbti_result_smile)
            "렌즈 삽입술" ->  binding.communityEyeMbtiResultCharacterImgIv.setImageResource(R.drawable.eye_mbti_result_lens)
        }
        Log.d("mbti결과", operationName)


        return binding.root
    }


}