package com.anda.ui.main.community.eyeMbti

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentCommunityEyeMbtiBinding
import com.anda.ui.main.home.ranking.selectLocation.HomeSelectLocationFragment
import java.util.Timer
import kotlin.concurrent.timer

class CommunityEyeMbtiFragment : Fragment() ,OnClickListener {

    lateinit var binding: FragmentCommunityEyeMbtiBinding
    var currentQuestion = 1

    var timer : Timer? = null


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityEyeMbtiBinding.inflate(inflater, container, false)

        binding.communityEyeMbtiQuestionsNextBtnIv.setOnClickListener(this)

        binding.communityEyeMbtiQuestionsProgressbarPb.clipToOutline = true
        binding.communityEyeMbtiQuestionsProgressbarPb.progress = currentQuestion * 10

        binding.communityEyeMbtiQuestionsVp.isUserInputEnabled = false


        optionEyeMbtiQuestions()

        timerFun()
        return binding.root
    }

    private fun optionEyeMbtiQuestions() {
        val communityEyeMbtiQuestionAdapter = CommunityEyeMbtiQuestionsVPAdapter(this)
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "라식수술이 필요하십니까?",
                1
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "라섹수술이 필요하십니까?",
                2
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "스마일라식수술이 필요하십니까?",
                3
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "렌즈삽입술이 필요하십니까?",
                4
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "백내장 수술이 필요하십니까?",
                5
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "무슨 수술이 필요하십니까?",
                6
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "활종을 많이 하십니까?",
                7
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "어떤 수술이 필요하십니까?",
                8
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "지금 수술이 필요하십니까?",
                9
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "수술을 받고 싶습니까?",
                10
            )
        )
        binding.communityEyeMbtiQuestionsVp.adapter = communityEyeMbtiQuestionAdapter
        binding.communityEyeMbtiQuestionsVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    private fun timerFun(){
        timer = timer(period = 100){
            if(currentQuestion > 10) {
                cancel()
                (context as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, CommunityEyeMbtiResultFragment())
                    .commitAllowingStateLoss()
            }
            if((context as MainActivity).eyeMbtiQuestionIsSelect)  {
                binding.communityEyeMbtiQuestionsNextBtnIv.setImageResource(R.drawable.next_btn_able)
            }
            Log.d("MBTI1", currentQuestion.toString())
            Log.d("MBTI2", (context as MainActivity).eyeMbtiQuestionIsSelect.toString())
        }
    }
    override fun onClick(v: View?) {
        if (v == null) return
        when (v) {
            binding.communityEyeMbtiQuestionsNextBtnIv -> {
                if ((context as MainActivity).eyeMbtiQuestionIsSelect) {
                    currentQuestion = currentQuestion + 1
                    (context as MainActivity).eyeMbtiQuestionIsSelect = false
                    binding.communityEyeMbtiQuestionsNextBtnIv.setImageResource(R.drawable.next_btn_unable)
                    binding.communityEyeMbtiQuestionsVp.setCurrentItem(currentQuestion - 1, false)
                    binding.communityEyeMbtiQuestionsProgressbarPb.progress = currentQuestion*10
                    binding.communityEyeMbtiQuestionsCurrentNumTv.text = currentQuestion.toString()
                }
            }
        }
    }
}