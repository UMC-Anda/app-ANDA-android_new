package com.anda.ui.main.home.andaInfo

import android.util.Log
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.anda.R
import com.anda.ui.main.home.andaInfo.model.AndaInfoBanners
import com.anda.ui.main.home.andaInfo.model.AndaInfoResult
import com.anda.ui.ophtha_info.OphthaInfoEventsFragment
import com.anda.ui.ophtha_info.OphthaInfoRatingsFragment
import com.anda.ui.ophtha_info.OphthaInfoReviewsFragment

class HomeAndaInfoBannerVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment){

    private val fragmentList : ArrayList<Fragment> = ArrayList()

    override fun getItemCount(): Int = fragmentList.size

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> HomeAndaInfoBannerFragment(R.drawable.anda_info1)
            else -> HomeAndaInfoBannerFragment(R.drawable.anda_info2)
        }
    }
    fun addFragment(fragment: Fragment){
        fragmentList.add(fragment)
        notifyItemInserted(fragmentList.size - 1 )
        Log.d("페이저 추가", fragmentList.size.toString())
    }
}