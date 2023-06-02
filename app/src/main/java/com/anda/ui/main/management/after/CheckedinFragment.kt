package com.anda.ui.main.management.after

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.CalendarView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.anda.R
import com.anda.databinding.FragmentCheckedinBinding
import java.text.SimpleDateFormat
import java.util.*

class CheckedinFragment : Fragment() {
    private lateinit var binding: FragmentCheckedinBinding
    private lateinit var sharedPreferences: SharedPreferences
    private val items = listOf("5 point", "6 point", "7 point", "8 point", "9 point", "10 point")
    private var isSpinning = false
    private var rotateAnimation: RotateAnimation? = null

    private val CHECKED_IN_DATE_KEY = "checked_in_date"
    private val KEY_LAST_SPIN_TIME = "last_spin_time"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCheckedinBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireActivity().getPreferences(Context.MODE_PRIVATE)
        binding.buttonCheckin.setOnClickListener { onCheckInButtonClick() }
        binding.resultTextView.setOnClickListener { onResultTextViewClick() }

        // 버튼 초기 상태 설정
        val lastSpinTime = sharedPreferences.getLong(KEY_LAST_SPIN_TIME, 0L)
        val currentTime = System.currentTimeMillis()
        val twentyFourHoursInMillis = 24 * 60 * 60 * 1000
        if (currentTime - lastSpinTime < twentyFourHoursInMillis) {
            disableButton()
        }

        val calendarView = view.findViewById<CalendarView>(R.id.calendar_view)
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val selectedDate = Calendar.getInstance().apply {
                set(year, month, dayOfMonth)
            }
            val checkedDates = sharedPreferences.getStringSet(CHECKED_IN_DATE_KEY, mutableSetOf()) ?: mutableSetOf()
            Log.d("출첵된 날짜들", checkedDates.toString())
            val formattedDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(selectedDate.time)
            val checkedInDates = sharedPreferences.getStringSet(CHECKED_IN_DATE_KEY, mutableSetOf()) ?: mutableSetOf()
            if (checkedInDates.contains(formattedDate)) {
                val earnedPoints = getEarnedPoints(formattedDate)
                Log.d("출첵포인트",earnedPoints)
                showEarnedPointsDialog(earnedPoints)
            }else{
                showEarnedPointsDialog("")
            }

        }

        // 5월 13일부터 5월 20일까지 출석체크한 것으로 가정하고 출석 날짜 저장
        val startDate = Calendar.getInstance().apply {
            set(2023, Calendar.MAY, 13)
        }
        val endDate = Calendar.getInstance().apply {
            set(2023, Calendar.MAY, 20)
        }
        saveCheckedInDates(startDate, endDate)
    }


    private fun onCheckInButtonClick() {
        val lastSpinTime = sharedPreferences.getLong(KEY_LAST_SPIN_TIME, 0L)
        val currentTime = System.currentTimeMillis()

        // 자정 이후 출석체크 가능
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = currentTime
        calendar.set(Calendar.HOUR_OF_DAY, 0)
        calendar.set(Calendar.MINUTE, 0)
        calendar.set(Calendar.SECOND, 0)
        calendar.set(Calendar.MILLISECOND, 0)
        val midnightTime = calendar.timeInMillis

        if (!isSpinning && currentTime >= midnightTime && (currentTime - lastSpinTime >= 0)) {
            spinRoulette()
            sharedPreferences.edit().putLong(KEY_LAST_SPIN_TIME, currentTime).apply()
            disableButton()
        }
    }

    private fun onResultTextViewClick() {
        binding.resultTextView.visibility = View.GONE
        binding.rouletteImage.visibility = View.GONE
        resetAnimation()
    }

    private fun spinRoulette() {
        val randomIndex = Random().nextInt(items.size)
        val selectedItem = items[randomIndex]

        val fromDegrees = 0f
        val toDegrees = (360 * 5 + (randomIndex * (360 / items.size))).toFloat()
        rotateAnimation = RotateAnimation(
            fromDegrees, toDegrees,
            Animation.RELATIVE_TO_SELF, 0.5f,
            Animation.RELATIVE_TO_SELF, 0.5f
        )
        rotateAnimation?.duration = 2000
        rotateAnimation?.fillAfter = true

        binding.rouletteImage.visibility = View.VISIBLE

        rotateAnimation?.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                isSpinning = true
                binding.resultTextView.visibility = View.GONE
            }

            override fun onAnimationEnd(animation: Animation?) {
                isSpinning = false
                binding.resultTextView.visibility = View.VISIBLE
                binding.resultTextView.text = selectedItem
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        binding.rouletteImage.startAnimation(rotateAnimation)
    }

    private fun resetAnimation() {
        rotateAnimation?.cancel()
        rotateAnimation = null
        binding.rouletteImage.clearAnimation()
    }

    private fun saveCheckedInDates(startDate: Calendar, endDate: Calendar) {
        val checkedInDates = mutableSetOf<String>()
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        val calendar = startDate.clone() as Calendar
        while (!calendar.after(endDate)) {
            val formattedDate = dateFormat.format(calendar.time)
            checkedInDates.add(formattedDate)


            // 출석체크된 날짜에 해당하는 TextView 가져오기
            val dayOfMonthTextViewId = resources.getIdentifier(
                "calendar_day_" + calendar.get(Calendar.DAY_OF_MONTH),
                "id",
                requireActivity().packageName
            )
            val dayOfMonthTextView = view?.findViewById<TextView>(dayOfMonthTextViewId)
            dayOfMonthTextView?.setBackgroundColor(resources.getColor(R.color.Main))



            calendar.add(Calendar.DATE, 1)
        }
        sharedPreferences.edit().putStringSet(CHECKED_IN_DATE_KEY, checkedInDates).apply()
    }


    private fun disableButton() {
        binding.buttonCheckin.isEnabled = false
        binding.buttonCheckin.setBackgroundColor(resources.getColor(R.color.gray))
    }

    private fun enableButton() {
        binding.buttonCheckin.isEnabled = true
        binding.buttonCheckin.setBackgroundColor(resources.getColor(R.color.Main))
    }

    private fun getEarnedPoints(date: String): String {
        return when (date) {
            "2023-05-13" -> "5 point"
            "2023-05-14" -> "6 point"
            "2023-05-15" -> "7 point"
            "2023-05-16" -> "8 point"
            "2023-05-17" -> "9 point"
            "2023-05-18" -> "10 point"
            "2023-05-19" -> "5 point"
            "2023-05-20" -> "6 point"
            else -> "0 point"
        }
    }

    private fun showEarnedPointsDialog(earnedPoints: String){
        binding.getPointView.text = earnedPoints
        binding.getPointView.visibility = View.VISIBLE
    }
}

