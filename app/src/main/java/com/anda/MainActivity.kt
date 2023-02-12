package com.anda

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.anda.data.entities.CompareSortSelectedOption
import com.anda.databinding.ActivityMainBinding
import com.anda.ui.main.community.CommunityFragment
import com.anda.ui.main.compare.CompareFragment
import com.anda.ui.main.home.HomeFragment
import com.anda.ui.main.map.MapFragment
import com.anda.ui.main.myInfo.MyInfoFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    public var eyeMbtiQuestionIsSelect = false
    public var compareSortSelectedLocation = arrayListOf<String>("강남구")
    public var compareSortSelectedOption = CompareSortSelectedOption("라식", "별점순", compareSortSelectedLocation)
    public var homeSelectLocation = arrayListOf<String>("강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()
    }

    public fun bottomNavigationControl() {
        if (binding.mainBottomNavigation.visibility == View.VISIBLE) {
            binding.mainBottomNavigation.visibility = View.GONE

        } else {
            binding.mainBottomNavigation.visibility = View.VISIBLE
        }
    }
    private fun initBottomNavigation(){

        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container, HomeFragment()).commitAllowingStateLoss()

        binding.mainBottomNavigation.setOnItemSelectedListener { item->
            when(item.itemId){
                R.id.homeFragment->{
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container,HomeFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.mapFragment->{
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container,MapFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.compareFragment->{
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container,CompareFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.communityFragment->{
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container,CommunityFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.myInfoFragment->{
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container,MyInfoFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}