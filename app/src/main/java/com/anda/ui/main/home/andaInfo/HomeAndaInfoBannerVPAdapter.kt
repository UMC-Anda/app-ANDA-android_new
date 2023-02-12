package com.anda.ui.main.home.andaInfo

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.anda.ui.main.home.andaInfo.model.AndaInfoBanners
import com.anda.ui.main.home.andaInfo.model.AndaInfoResult

class HomeAndaInfoBannerVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment){

    private val fragmentList : ArrayList<Fragment> = ArrayList()

    override fun getItemCount(): Int = 2000

    override fun createFragment(position: Int): Fragment = fragmentList[position]


    fun addFragment(fragment: Fragment){
        fragmentList.add(fragment)
        notifyItemInserted(fragmentList.size - 1 )
        Log.d("페이저 추가", fragmentList.size.toString())
    }
}