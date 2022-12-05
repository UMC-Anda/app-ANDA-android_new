package com.anda

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.anda.databinding.ActivityMainBinding
import com.anda.ui.main.community.CommunityFragment
import com.anda.ui.main.compare.CompareFragment
import com.anda.ui.main.home.HomeFragment
import com.anda.ui.main.map.MapFragment
import com.anda.ui.main.myInfo.MyInfoFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initBottomNavigation()
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