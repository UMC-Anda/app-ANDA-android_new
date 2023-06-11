package com.anda.ui.main.community.eyeMbti

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentCommunityEyeMbtiBinding
import java.util.*

class CommunityEyeMbtiFragment : Fragment() ,OnClickListener,
    CommunityEyeMbtiQuestionsFragment.OnOptionSelectedListener {

    private lateinit var myOperationsharedPreferences: SharedPreferences
    lateinit var binding: FragmentCommunityEyeMbtiBinding


    private val operations = listOf("라식", "라섹", "스마일 라식", "렌즈 삽입술")
    var currentQuestion = 1
    var isChecked = false

    override fun onOptionSelected(isChecked: Boolean) {
        this.isChecked = isChecked
        buttonEnabled()
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityEyeMbtiBinding.inflate(inflater, container, false)

        myOperationsharedPreferences = requireContext().getSharedPreferences("UserInfo", Context.MODE_PRIVATE)


        binding.communityEyeMbtiQuestionsNextBtnIv.setOnClickListener(this)
        binding.communityEyeMbtiQuestionsProgressbarPb.clipToOutline = true
        binding.communityEyeMbtiQuestionsProgressbarPb.progress = currentQuestion * 10

        binding.communityEyeMbtiQuestionsVp.isUserInputEnabled = false


        optionEyeMbtiQuestions()

        return binding.root
    }

    private fun optionEyeMbtiQuestions() {
        val communityEyeMbtiQuestionAdapter = CommunityEyeMbtiQuestionsVPAdapter(this)
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "라식수술이 필요하십니까?",
                1,
                this
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "라섹수술이 필요하십니까?",
                2,
                this
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "스마일라식수술이 필요하십니까?",
                3,
                this
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "렌즈삽입술이 필요하십니까?",
                4,
                this
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "백내장 수술이 필요하십니까?",
                5,
                this
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "무슨 수술이 필요하십니까?",
                6,
                this
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "활종을 많이 하십니까?",
                7,
                this
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "어떤 수술이 필요하십니까?",
                8,
                this
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "지금 수술이 필요하십니까?",
                9,
                this
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "수술을 받고 싶습니까?",
                10,
                this
            )
        )
        binding.communityEyeMbtiQuestionsVp.adapter = communityEyeMbtiQuestionAdapter
        binding.communityEyeMbtiQuestionsVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    override fun onClick(v: View?) {
        if (v == null) return
        when (v) {
            binding.communityEyeMbtiQuestionsNextBtnIv -> {
                if (isChecked) {
                    currentQuestion = currentQuestion + 1
                    isChecked = false
                    if(currentQuestion > 10) {
                        val randomIndex = Random().nextInt(operations.size)
                        val selectedItem = operations[randomIndex]
                        myOperationsharedPreferences.edit().putBoolean("isRecommended", true).apply()
                        myOperationsharedPreferences.edit().putString("myOperation", selectedItem).apply()
                        (context as MainActivity).supportFragmentManager.beginTransaction()
                            .replace(R.id.nav_host_fragment_container, CommunityEyeMbtiResultFragment(selectedItem))
                            .commitAllowingStateLoss()
                    }
                    buttonUnabled()
                }
            }
        }
    }
    fun buttonEnabled(){
        binding.communityEyeMbtiQuestionsNextBtnIv.setImageResource(R.drawable.next_btn_able)
    }
    private fun buttonUnabled() {
        binding.communityEyeMbtiQuestionsNextBtnIv.setImageResource(R.drawable.next_btn_unable)
        binding.communityEyeMbtiQuestionsVp.setCurrentItem(currentQuestion - 1, false)
        binding.communityEyeMbtiQuestionsProgressbarPb.progress = currentQuestion * 10
        binding.communityEyeMbtiQuestionsCurrentNumTv.text = currentQuestion.toString()
    }
}