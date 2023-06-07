package com.anda.ui.ophtha_info

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.anda.data.entities.*

class OphthaInfoBannerVPAdapter(fragment:Fragment, val ophthaInfoEventDatas:ArrayList<ExOphthaInfoEvent>?, val ophthaInfoReviewDatas:ArrayList<ExOphthaInfoReview>?, val ophthaInfoRatingData:ExOphthaInfoRating?) : FragmentStateAdapter(fragment){

    private val fragmentList : ArrayList<Fragment> = ArrayList()
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> OphthaInfoEventsFragment(ophthaInfoEventDatas!!)
            1 -> OphthaInfoReviewsFragment(ophthaInfoReviewDatas!!)
            else -> OphthaInfoRatingsFragment(ophthaInfoRatingData!!)
        }
    }

    fun addFragment(fragment: Fragment){
        fragmentList.add(fragment)
        notifyItemInserted(fragmentList.size - 1)
    }
}