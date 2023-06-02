package com.anda

import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.anda.data.entities.CompareSortSelectedOption
import com.anda.databinding.ActivityMainBinding
import com.anda.ui.main.compare.CompareFragment
import com.anda.ui.main.home.HomeFragment
import com.anda.ui.main.management.after.ManagementAfterOperationFragment
import com.anda.ui.main.management.before.ManagementBeforeOperationFragment
import com.anda.ui.main.myInfo.MyInfoFragment
import com.anda.ui.write_review.WriteReview1Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var sharedPreferences: SharedPreferences
    public var isReviewRegistered = false

    public var eyeMbtiQuestionIsSelect = false
    public var compareSortSelectedLocation = arrayListOf<String>("강남구")
    public var compareSortSelectedOption = CompareSortSelectedOption("라식", "별점순", compareSortSelectedLocation)
    public var homeSelectLocation = arrayListOf<String>("강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // SharedPreferences 인스턴스 초기화
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        // 저장된 리뷰 작성 여부 불러오기
        isReviewRegistered = sharedPreferences.getBoolean("isReviewRegistered", false)


        initBottomNavigation()
    }

    public fun bottomNavigationControl() {
        if (binding.mainBottomNavigation.visibility == View.VISIBLE) {
            binding.mainBottomNavigation.visibility = View.GONE

        } else {
            binding.mainBottomNavigation.visibility = View.VISIBLE
        }
    }

    private fun initBottomNavigation() {
        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container, HomeFragment()).commitAllowingStateLoss()

        binding.mainBottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container, HomeFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.mapFragment -> {
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container, WriteReview1Fragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.compareFragment -> {
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container, CompareFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.communityFragment -> {
                    val fragment = if (isReviewRegistered) {
                        ManagementAfterOperationFragment()
                    } else {
                        ManagementBeforeOperationFragment()
                    }
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container, fragment).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.myInfoFragment -> {
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container, MyInfoFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}
