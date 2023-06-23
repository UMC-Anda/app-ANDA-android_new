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
        binding.communityEyeMbtiQuestionsProgressbarPb.progress = (currentQuestion - 1) * 10

        binding.communityEyeMbtiQuestionsVp.isUserInputEnabled = false


        optionEyeMbtiQuestions()

        return binding.root
    }

    private fun optionEyeMbtiQuestions() {
        val communityEyeMbtiQuestionAdapter = CommunityEyeMbtiQuestionsVPAdapter(this)
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "평소 아픔을 잘 참는다는 말을 많이 들으시나요?",
                1,
                this
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "일상생활로 빠르게 복귀해야 하나요?",
                2,
                this
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "눈을 위해서라면 돈을 아끼지 않으실 건가요?",
                3,
                this
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "주변에서 신중하다는 소리를 많이 들으셨나요?",
                4,
                this
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "운동을 좋아하시나요?",
                5,
                this
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "초고도근시나 원시가 있으신가요?",
                6,
                this
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "모임에 나가면 리더가 되는 편인가요?",
                7,
                this
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "수술 후 관리를 1년간 꾸준히 할 수 있으신가요?",
                8,
                this
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "수술 전 수술에 대해 많이 알아보시나요?",
                9,
                this
            )
        )
        communityEyeMbtiQuestionAdapter.addFragment(
            CommunityEyeMbtiQuestionsFragment(
                "자신이 활발하다고 생각하시나요?",
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
        binding.communityEyeMbtiQuestionsProgressbarPb.progress = (currentQuestion - 1) * 10
        binding.communityEyeMbtiQuestionsCurrentNumTv.text = currentQuestion.toString()
    }
}