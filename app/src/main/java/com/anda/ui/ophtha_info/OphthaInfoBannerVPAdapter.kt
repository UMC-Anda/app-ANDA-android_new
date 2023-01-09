package com.anda.ui.ophtha_info

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.anda.data.entities.ExOphthaInfoEvent
import com.anda.data.entities.ExOphthaInfoReview
import com.anda.data.entities.OphthaInfoEvent
import com.anda.data.entities.OphthaInfoReview

class OphthaInfoBannerVPAdapter(fragment:Fragment, val ophthaInfoEventDatas:ArrayList<ExOphthaInfoEvent>?, val ophthaInfoReviewDatas:ArrayList<ExOphthaInfoReview>?) : FragmentStateAdapter(fragment){

    private val fragmentList : ArrayList<Fragment> = ArrayList()
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> OphthaInfoEventsFragment(ophthaInfoEventDatas!!)
            1 -> OphthaInfoReviewsFragment(ophthaInfoReviewDatas!!)
            else -> OphthaInfoRatingsFragment()
        }
    }

    fun addFragment(fragment: Fragment){
        fragmentList.add(fragment)
        notifyItemInserted(fragmentList.size - 1)
    }
}