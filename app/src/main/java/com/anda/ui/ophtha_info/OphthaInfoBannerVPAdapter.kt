package com.anda.ui.ophtha_info

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class OphthaInfoBannerVPAdapter(fragment:Fragment) : FragmentStateAdapter(fragment){

    private val fragmentList : ArrayList<Fragment> = ArrayList()
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> OphthaInfoEventsFragment()
            1 -> OphthaInfoReviewsFragment()
            else -> OphthaInfoRatingsFragment()

        }
    }

    fun addFragment(fragment: Fragment){
        fragmentList.add(fragment)
        notifyItemInserted(fragmentList.size - 1)
    }
}