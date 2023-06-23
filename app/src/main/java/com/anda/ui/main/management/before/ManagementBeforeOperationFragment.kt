package com.anda.ui.main.management.before

import android.content.Context
import android.content.SharedPreferences
import android.graphics.Color.blue
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.RotateAnimation
import android.widget.CalendarView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentManagementBeforeOperationBinding
import com.anda.ui.main.community.eyeMbti.CommunityEyeMbtiFragment
import com.anda.ui.main.management.after.operation.OperationMbtiFragment
import com.anda.ui.write_review.WriteReview1Fragment
import com.anda.ui.write_review.WriteReview2Fragment
import java.text.SimpleDateFormat
import java.util.*

class ManagementBeforeOperationFragment : Fragment() {

    private lateinit var binding: FragmentManagementBeforeOperationBinding
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var myOperationsharedPreferences: SharedPreferences
    private lateinit var myPointSharedPreferences: SharedPreferences
    private var myPoint =0

    private val items = listOf("5 point", "6 point", "7 point", "8 point", "9 point", "10 point")
    private var isSpinning = false
    private var rotateAnimation: RotateAnimation? = null
    private val currentDate = getCurrentDate()

    private val KEY_LAST_SPIN_TIME = "last_spin_time"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentManagementBeforeOperationBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences = requireContext().getSharedPreferences("CheckedInDates", Context.MODE_PRIVATE)
        myOperationsharedPreferences = requireContext().getSharedPreferences("UserInfo", Context.MODE_PRIVATE)
        myPointSharedPreferences = requireContext().getSharedPreferences("UserInfo", Context.MODE_PRIVATE)
        myPoint = myPointSharedPreferences.getInt("MyPoint", 0)

        binding.buttonCheckin.setOnClickListener { onCheckInButtonClick() }
        binding.resultTextView.setOnClickListener { onResultTextViewClick() }
        binding.bannerMbti.setOnClickListener { onBannerMbtiClick() }
        binding.bannerReview.setOnClickListener { onBannerReviewClick() }

        // 버튼 초기 상태 설정
        val lastSpinTime = sharedPreferences.getLong(KEY_LAST_SPIN_TIME, 0L)
        val currentTime = System.currentTimeMillis()
        val twentyFourHoursInMillis = 24 * 60 * 60 * 1000
        if (currentTime - lastSpinTime < twentyFourHoursInMillis) {
            disableButton()
        }

        //수술 추천 설정
        if(myOperationsharedPreferences.getBoolean("isRecommended", false)){
            myOperationsharedPreferences.edit().putBoolean("isRecommended", false).apply()
            var myOperation = myOperationsharedPreferences.getString("myOperation", "")
            binding.bannerMbti.text = "내 추천 수술은 ${myOperation}입니다"
        } else{
            myOperationsharedPreferences.edit().putBoolean("isRecommended", false).apply()
            binding.bannerMbti.text = "눈 유형 검사로 시력교정술 추천"
        }

        //출석체크 설정
        if(sharedPreferences.contains(currentDate)) {
            binding.getPointView.text = sharedPreferences.getString(currentDate, "")
            binding.getPointView.visibility = View.VISIBLE
        }
        val calendarView = view.findViewById<CalendarView>(R.id.calendar_view)
        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            val selectedDate = Calendar.getInstance().apply {
                set(year, month, dayOfMonth)
            }
            val formattedDate = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(selectedDate.time)

            val fileExists = sharedPreferences.contains(formattedDate)
            if (fileExists) {
                val earnedPoints = sharedPreferences.getString(formattedDate, "")
                showEarnedPointsDialog(earnedPoints)
            } else {
                showEarnedPointsDialog("")
            }
        }




    }
    private fun getCurrentDate(): String {
        val dateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return dateFormat.format(Date())
    }
    private fun onBannerMbtiClick() {
        if (myOperationsharedPreferences.getBoolean("isRecommended", false)) {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, OperationMbtiFragment())
                .commitAllowingStateLoss()
        } else {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, CommunityEyeMbtiFragment())
                .commitAllowingStateLoss()
        }
    }

    private fun onBannerReviewClick() {
        (context as MainActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_container, WriteReview2Fragment())
            .commitAllowingStateLoss()
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
            binding.getPointView.visibility = View.GONE
            val point = spinRoulette()
            sharedPreferences.edit().putLong(KEY_LAST_SPIN_TIME, currentTime).apply()

            sharedPreferences.edit().putString("${currentDate}", point).apply()

            disableButton()
        }
    }
    private fun onResultTextViewClick() {
        binding.resultTextView.visibility = View.GONE
        binding.rouletteImage.visibility = View.GONE
        binding.getPointView.visibility = View.VISIBLE
        binding.getPointText.visibility = View.GONE
        binding.getPointView.text = sharedPreferences.getString(currentDate, "")
        resetAnimation()
    }

    private fun spinRoulette(): String {
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
                when(selectedItem) {
                    "5 point" -> { myPoint += 5 }
                    "6 point" -> { myPoint += 6 }
                    "7 point" -> { myPoint += 7 }
                    "8 point" -> { myPoint += 8 }
                    "9 point" -> { myPoint += 9 }
                    "10 point" -> { myPoint += 10 }
                }
                binding.getPointText.text = myPoint.toString() + " point"
                binding.getPointText.visibility = View.VISIBLE
                myPointSharedPreferences.edit().putInt("MyPoint", myPoint).apply()
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })

        binding.rouletteImage.startAnimation(rotateAnimation)
        return selectedItem
    }

    private fun resetAnimation() {
        rotateAnimation?.cancel()
        rotateAnimation = null
        binding.rouletteImage.clearAnimation()
    }



    private fun disableButton() {
        binding.buttonCheckin.isEnabled = false
        binding.buttonCheckin.setBackgroundColor(resources.getColor(R.color.gray))
    }

    private fun enableButton() {
        binding.buttonCheckin.isEnabled = true
        binding.buttonCheckin.setBackgroundColor(resources.getColor(R.color.Main))
    }

    private fun showEarnedPointsDialog(earnedPoints: String?){
        binding.getPointView.text = earnedPoints ?: "" // null이면 빈 문자열로 대체
        binding.getPointView.visibility = View.VISIBLE
    }

}
