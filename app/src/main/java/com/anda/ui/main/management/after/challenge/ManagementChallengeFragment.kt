package com.anda.ui.main.management.after.challenge

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.anda.MainActivity
import com.anda.R
import com.anda.data.entities.ChallengeItem
import com.anda.databinding.FragmentManagementChallengeBinding
import com.google.gson.Gson
import kotlin.collections.ArrayList

class ManagementChallengeFragment : Fragment() {

    private lateinit var binding: FragmentManagementChallengeBinding
    private lateinit var challengeAdapter: ManagementChallengeRVAdapter
    private lateinit var sharedPreferences: SharedPreferences
    private val challengeAchievementDatas: ArrayList<ChallengeItem> = ArrayList()
    var totalAchievement = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentManagementChallengeBinding.inflate(inflater, container, false)
        sharedPreferences = requireContext().getSharedPreferences("challengeAchievementDatas", Context.MODE_PRIVATE)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //도전과제 달성률 가져오기
        setProgressAchievement()
        setChallengeAchievementRVapter()

    }
    private fun setProgressAchievement() {
        val keyList = java.util.ArrayList(sharedPreferences.all.keys)
        var progressDays = 0
        for (key in keyList) {
            var achievement = sharedPreferences.getInt(key, 0)
            totalAchievement += achievement
            progressDays++
            Log.d("keyName",key.toString())
            Log.d("achievement",achievement.toString())
            Log.d("totalAchievement",totalAchievement.toString())
        }
        binding.currentProgressText.text = totalAchievement.toString() + "%"
        binding.progressDays.text = progressDays.toString() + "일간 진행 중"
        totalAchievement = 0
    }

    private fun setChallengeAchievementRVapter() {
        //sortSharedPreferences를 정렬하여 다시 저장
        sortSharedPreferences()

        // SharedPreferences의 키를 오름차순으로 정렬
        val sortedKeys = sharedPreferences.all.keys.sorted()

        // 정렬된 키를 사용하여 값을 반복하고 처리
        for (key in sortedKeys) {
            val value = sharedPreferences.getInt(key, 0)

            //yy-MM-dd 를 MM/dd로 변경
            val parts = key.split("-")
            val year = parts[0]
            val month = parts[1]
            val day = parts[2]
            challengeAchievementDatas.apply { add(ChallengeItem("$year/$month/$day", value)) }
        }

        Log.d("challengeDates", challengeAchievementDatas.toString())
        challengeAdapter = ManagementChallengeRVAdapter(challengeAchievementDatas)
        binding.dateRecyclerView.adapter = challengeAdapter
        binding.dateRecyclerView.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        challengeAdapter.setItemClickListener(object :
            ManagementChallengeRVAdapter.ItemClickListener {
            override fun onItemClick(challengeItem: ChallengeItem) {

                // Fragment를 전환하고 Bundle을 전달합니다.
                (context as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, ChallengeHistoryDetailFragment().apply {
                        arguments = Bundle().apply {
                            val gson = Gson()
                            val challengeDateJson = gson.toJson(challengeItem)
                            putString("challengeDate", challengeDateJson)
                        }
                    })
                    .commitAllowingStateLoss()
            }
        })
    }

    private fun sortSharedPreferences() {
        // 모든 키를 가져와서 ArrayList에 저장
        val keyList = ArrayList(sharedPreferences.all.keys)

        // ArrayList를 오름차순으로 정렬
        keyList.sort()

        // 정렬된 값을 다시 SharedPreferences에 저장
        val editor = sharedPreferences.edit()
        for (key in keyList) {
            val value = sharedPreferences.getInt(key, 0)
            editor.putInt(key, value)
        }

        // 변경 사항 저장
        editor.apply()
    }
}
