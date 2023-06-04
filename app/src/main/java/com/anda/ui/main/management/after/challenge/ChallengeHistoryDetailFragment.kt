package com.anda.ui.main.management.after.challenge

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.fragment.app.Fragment
import com.anda.data.entities.ChallengeItem
import com.anda.databinding.FragmentChallengeHistoryDetailBinding
import com.google.gson.Gson
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ChallengeHistoryDetailFragment : Fragment() {

    private lateinit var binding: FragmentChallengeHistoryDetailBinding
    private val checkBoxList = mutableListOf<CheckBox>()
    private var gson: Gson = Gson()
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var challengeAchievementDatasSharedPreferences: SharedPreferences
    private lateinit var date : String
    private val currentDate = getCurrentDate()
    private lateinit var currentDateDash : String

    private lateinit var checkBox1Name : String
    private lateinit var checkBox2Name : String
    private lateinit var checkBox3Name : String


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChallengeHistoryDetailBinding.inflate(inflater, container, false)

        //오늘 날짜 저장
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        currentDateDash = dateFormat.format(Date())

        //전달한 gson 꺼내기
        val challengeDateJson = arguments?.getString("challengeDate")
        val challengeDate = gson.fromJson(challengeDateJson, ChallengeItem::class.java)

        //yy-MM-dd 를 MM/dd로 변경
        val parts = challengeDate.date.split("/")
        var year = parts[0]
        year = year[2].toString() + year[3].toString()
        val month = parts[1]
        val day = parts[2]
        date = year + month + day

        sharedPreferences =
            requireContext().getSharedPreferences("ToDoList_" + date, Context.MODE_PRIVATE)
        challengeAchievementDatasSharedPreferences =
            requireContext().getSharedPreferences("challengeAchievementDatas", Context.MODE_PRIVATE)


        // ToDoList 구현 시작
        binding.title.text = challengeDate.date + " 도전 과제"
        binding.progressBar.progress = challengeAchievementDatasSharedPreferences.getInt(currentDateDash, 0)


        //체크박스 이름 저장(일일 도전과제)
        val keyList = ArrayList(sharedPreferences.all.keys)
        Log.d("일일과제 이름 확인", keyList.toString())
        checkBox1Name = keyList[0]
        checkBox2Name = keyList[1]
        checkBox3Name = keyList[2]

        //체크박스 인스턴스
        val checkBox1 = binding.checkBox1
        val checkBox2 = binding.checkBox2
        val checkBox3 = binding.checkBox3


        // 체크박스 초기 상태 가져오기
        val checkBox1Checked = sharedPreferences.getBoolean(checkBox1Name, false)
        val checkBox2Checked = sharedPreferences.getBoolean(checkBox2Name, false)
        val checkBox3Checked = sharedPreferences.getBoolean(checkBox3Name, false)

        // 체크박스 초기 상태에 따라 화면 구성
        checkBox1.isChecked = checkBox1Checked
        checkBox1.text = checkBox1Name
        if (checkBox1Checked) {
            moveItemToBottom(checkBox1)
            strikeThroughText(checkBox1)
        }
        checkBox2.isChecked = checkBox2Checked
        checkBox2.text = checkBox2Name
        if (checkBox2Checked) {
            moveItemToBottom(checkBox2)
            strikeThroughText(checkBox2)
        }
        checkBox3.isChecked = checkBox3Checked
        checkBox3.text = checkBox3Name
        if (checkBox3Checked) {
            moveItemToBottom(checkBox3)
            strikeThroughText(checkBox3)
        }

        checkBoxList.add(checkBox1)
        checkBoxList.add(checkBox2)
        checkBoxList.add(checkBox3)

        // ToDoList 구현 시작
        binding.checkBox1.setOnCheckedChangeListener { _, isChecked ->
            updateToDoItemState(binding.checkBox1, isChecked, currentDate)
        }
        binding.checkBox2.setOnCheckedChangeListener { _, isChecked ->
            updateToDoItemState(binding.checkBox2, isChecked, currentDate)
        }
        binding.checkBox3.setOnCheckedChangeListener { _, isChecked ->
            updateToDoItemState(binding.checkBox3, isChecked, currentDate)
        }
        // ToDoList 구현 종료

        return binding.root
    }


    private fun updateToDoItemState(checkBox: CheckBox, isChecked: Boolean, date: String) {
        if (isChecked) {
            moveItemToBottom(checkBox)
            strikeThroughText(checkBox)
        } else {
            removeStrikeThroughText(checkBox)
        }

        // ToDo 항목의 상태를 SharedPreferences에 저장
        val editor = sharedPreferences.edit()
        when (checkBox) {
            binding.checkBox1 -> editor.putBoolean(checkBox1Name, binding.checkBox1.isChecked)
            binding.checkBox2 -> editor.putBoolean(checkBox2Name, binding.checkBox2.isChecked)
            binding.checkBox3 -> editor.putBoolean(checkBox3Name, binding.checkBox3.isChecked)
        }
        val checkedCount = listOf(binding.checkBox1, binding.checkBox2, binding.checkBox3).count { it.isChecked }
        Log.d("checkedCnt", checkedCount.toString())
        val progress = (checkedCount.toFloat()/3f*100f).toInt()
        challengeAchievementDatasSharedPreferences.edit().putInt(currentDateDash, progress).apply()
        binding.progressBar.progress = progress
        editor.apply()
    }

    private fun moveItemToBottom(view: View) {
        val parent = view.parent as ViewGroup
        parent.removeView(view)
        parent.addView(view)
    }

    private fun strikeThroughText(view: View) {
        if (view is CheckBox) {
            view.paintFlags = view.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    private fun removeStrikeThroughText(view: View) {
        if (view is CheckBox) {
            view.paintFlags = view.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyMMdd", Locale.getDefault())
        return dateFormat.format(Date())
    }
}
