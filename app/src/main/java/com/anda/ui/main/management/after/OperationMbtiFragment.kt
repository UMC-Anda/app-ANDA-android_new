package com.anda.ui.main.management.after

import android.os.Bundle
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


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOperationMbtiBinding.inflate(inflater, container, false)


        binding.operationMbtiImg.setOnClickListener {
            // 버튼 클릭 시 원하는 동작을 수행하도록 구현
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, CommunityEyeMbtiResultFragment())
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