package com.anda.ui.main.management.after.operation

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentOperationMbtiBinding
import com.anda.ui.main.community.eyeMbti.CommunityEyeMbtiFragment
import com.anda.ui.main.community.eyeMbti.CommunityEyeMbtiResultFragment
import com.anda.ui.write_review.WriteReview2Fragment

class OperationMbtiFragment : Fragment() {

    private lateinit var binding: FragmentOperationMbtiBinding
    private lateinit var myOperationsharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOperationMbtiBinding.inflate(inflater, container, false)
        myOperationsharedPreferences = requireContext().getSharedPreferences("MyOperation", Context.MODE_PRIVATE)

        var myOperation = myOperationsharedPreferences.getString("myOperation", "").toString()
        when(myOperation){
            "라식" ->  binding.operationMbtiImg.setImageResource(R.drawable.eye_mbti_result_lasik)
            "라섹" ->  binding.operationMbtiImg.setImageResource(R.drawable.eye_mbti_result_lasek)
            "스마일 라식" ->  binding.operationMbtiImg.setImageResource(R.drawable.eye_mbti_result_smile)
            "렌즈 삽입술" ->  binding.operationMbtiImg.setImageResource(R.drawable.eye_mbti_result_lens)
        }
        Log.d("mbti결과", myOperation)

        binding.operationMbtiImg.setOnClickListener {
            // 버튼 클릭 시 원하는 동작을 수행하도록 구현
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, CommunityEyeMbtiResultFragment(myOperation))
                .commitAllowingStateLoss()
        }
        binding.reSurveyBtn.setOnClickListener {
            // 버튼 클릭 시 원하는 동작을 수행하도록 구현
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, CommunityEyeMbtiFragment())
                .commitAllowingStateLoss()
        }
        return binding.root
    }
}