package com.anda.ui.main.management.after

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Paint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.widget.ViewUtils
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentManagementAfterOperationBinding
import com.anda.ui.main.management.after.alarm.AlarmFragment
import com.anda.ui.main.management.after.challenge.ChallengeHistoryDetailFragment
import com.anda.ui.main.management.after.checkedin.CheckedinFragment
import com.anda.ui.main.management.after.challenge.ManagementChallengeFragment
import com.anda.ui.main.management.after.operation.OperationMbtiFragment
import java.text.SimpleDateFormat
import java.util.*

class ManagementAfterOperationFragment : Fragment() {



    private lateinit var binding: FragmentManagementAfterOperationBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var myOperationsharedPreferences: SharedPreferences
    private lateinit var challengeAchievementDatasSharedPreferences: SharedPreferences

    private val currentDate = getCurrentDate()
    private lateinit var currentDateDash : String
    private val todoList = listOf("안약 점약하기", "외출 시 썬글라스 착용", "비타민 복용", "안과 검진", "커튼으로 실내 햇빛 차단", "화장 안하기", "금주, 금연", "1시간 이상 전자기기 사용하지 않기")
    lateinit var todaysToDoList1 : String
    lateinit var todaysToDoList2 : String
    lateinit var todaysToDoList3 : String
    var totalAchievement = 0f

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentManagementAfterOperationBinding.inflate(inflater, container, false)


        // SharedPreferences 초기화
        sharedPreferences = requireContext().getSharedPreferences("ToDoList_${currentDate}", Context.MODE_PRIVATE)
        myOperationsharedPreferences = requireContext().getSharedPreferences("UserInfo", Context.MODE_PRIVATE)
        challengeAchievementDatasSharedPreferences = requireContext().getSharedPreferences("challengeAchievementDatas", Context.MODE_PRIVATE)

        //도전과제 달성률 세팅
        setProgressAchievement()


        // ToDoList 구현 시작
        loadToDoListState(currentDate)
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

        setPopUpVPAdapter()
        binding.goToCheckedIn.setOnClickListener{
            clickGoToCheckedIn()
        }
        binding.goToOperation.setOnClickListener{
            clickGoToOperation()
        }
        binding.goToToDoList.setOnClickListener{
            (context as MainActivity).changeFragment(ManagementChallengeFragment())
        }
        binding.goToTimer.setOnClickListener{
            (context as MainActivity).changeFragment(AlarmFragment())
        }
        binding.popUpCloseBtn.setOnClickListener {
            binding.popUpVp.visibility = View.GONE
            binding.popUpBackgroundImg.visibility = View.GONE
            binding.popUpCloseBtn.visibility = View.GONE
        }
        binding.fixAchievement.setOnClickListener {
            (context as MainActivity).changeFragment(ManagementChallengeFragment())
        }
        return binding.root
    }

    private fun setProgressAchievement() {
        val keyList = ArrayList(challengeAchievementDatasSharedPreferences.all.keys)
        var progressDays = 0
        for (key in keyList) {
            var achievement = challengeAchievementDatasSharedPreferences.getInt(key, 0)
            totalAchievement += achievement
            progressDays += 1
            Log.d("keyName",key.toString())
            Log.d("achievement",achievement.toString())
            Log.d("totalAchievement",totalAchievement.toString())
        }
        totalAchievement = (totalAchievement.toFloat() / progressDays.toFloat())
        totalAchievement = (totalAchievement * 10).toInt() / 10f
        binding.currentProgressText.text = totalAchievement.toString() + "%"
        binding.progressDays.text = progressDays.toString() + "일간 진행 중"
        totalAchievement = 0f
    }

    private fun clickGoToOperation() {
        if (binding.popUpVp.visibility == View.GONE) {
            binding.popUpVp.setCurrentItem(1, false)
            binding.popUpVp.visibility = View.VISIBLE
            binding.popUpBackgroundImg.visibility = View.VISIBLE
            binding.popUpCloseBtn.visibility = View.VISIBLE
        }
    }

    private fun clickGoToCheckedIn() {
        if (binding.popUpVp.visibility == View.GONE) {
            binding.popUpVp.setCurrentItem(0, false)
            binding.popUpVp.visibility = View.VISIBLE
            binding.popUpCloseBtn.visibility = View.VISIBLE
            binding.popUpBackgroundImg.visibility = View.VISIBLE
        }
    }

    private fun setPopUpVPAdapter() {
        val managementAfterVPAdapter = ManagementAfterVPAdapter(this)
        binding.popUpVp.adapter = managementAfterVPAdapter

        managementAfterVPAdapter.addFragment(CheckedinFragment())
        managementAfterVPAdapter.addFragment(OperationMbtiFragment())
        binding.popUpVp.adapter = managementAfterVPAdapter
        binding.popUpVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    private fun loadToDoListState(date: String) {

        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        currentDateDash = dateFormat.format(Date())

        //일일과제 새로 고침
        var randomIndex : Int
        Log.d("Boolean",(!challengeAchievementDatasSharedPreferences.contains(currentDateDash)).toString())

        if(!challengeAchievementDatasSharedPreferences.contains(currentDateDash)) {
            randomIndex = Random().nextInt(todoList.size)
            todaysToDoList1 = todoList[randomIndex]
            do {
                randomIndex = Random().nextInt(todoList.size)
                todaysToDoList2 = todoList[randomIndex]
            }while(todaysToDoList1 == todoList[randomIndex])
            do {
                randomIndex = Random().nextInt(todoList.size)
                todaysToDoList3 = todoList[randomIndex]
            }while((todaysToDoList1 == todoList[randomIndex]) || (todaysToDoList2 == todoList[randomIndex]))
            sharedPreferences.edit().putBoolean(todaysToDoList1, false).apply()
            Log.d("뭑가 문제야", "1번과제 생성")
            sharedPreferences.edit().putBoolean(todaysToDoList2, false).apply()
            Log.d("뭑가 문제야", "2번과제 생성")
            sharedPreferences.edit().putBoolean(todaysToDoList3, false).apply()
            Log.d("뭑가 문제야", "3번과제 생성")
            challengeAchievementDatasSharedPreferences.edit().putInt(currentDateDash, 0).apply()
            Log.d("뭑가 문제야Shared", sharedPreferences.all.keys.toString())
        }else{
            val keyList = ArrayList(sharedPreferences.all.keys)
            Log.d("뭑가 문제야keyList", keyList.toString())
            todaysToDoList1 = keyList[0]
            todaysToDoList2 = keyList[1]
            todaysToDoList3 = keyList[2]
        }
        Log.d("뭑가 문제야", sharedPreferences.all.keys.toString())
        Log.d("뭑가 문제야", challengeAchievementDatasSharedPreferences.all.keys.toString())

        val checkBox1State = sharedPreferences.getBoolean(todaysToDoList1, false)
        val checkBox2State = sharedPreferences.getBoolean(todaysToDoList2, false)
        val checkBox3State = sharedPreferences.getBoolean(todaysToDoList3, false)

        binding.checkBox1.isChecked = checkBox1State
        binding.checkBox2.isChecked = checkBox2State
        binding.checkBox3.isChecked = checkBox3State

        binding.checkBox1.text = todaysToDoList1
        binding.checkBox2.text = todaysToDoList2
        binding.checkBox3.text = todaysToDoList3

        if (checkBox1State) {
            moveItemToBottom(binding.checkBox1)
            strikeThroughText(binding.checkBox1)
        }

        if (checkBox2State) {
            moveItemToBottom(binding.checkBox2)
            strikeThroughText(binding.checkBox2)
        }

        if (checkBox3State) {
            moveItemToBottom(binding.checkBox3)
            strikeThroughText(binding.checkBox3)
        }
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
            binding.checkBox1 -> editor.putBoolean(todaysToDoList1, binding.checkBox1.isChecked)
            binding.checkBox2 -> editor.putBoolean(todaysToDoList2, binding.checkBox2.isChecked)
            binding.checkBox3 -> editor.putBoolean(todaysToDoList3, binding.checkBox3.isChecked)
        }
        val checkedCount = listOf(binding.checkBox1, binding.checkBox2, binding.checkBox3).count { it.isChecked }
        Log.d("checkedCnt", checkedCount.toString())
        val progress = (checkedCount.toFloat()/3f*100f).toInt()
        challengeAchievementDatasSharedPreferences.edit().putInt(currentDateDash, progress).apply()
        setProgressAchievement()
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
