package com.anda.ui.main.compare.option

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.anda.R
import com.anda.data.entities.ExOphthaInfoEvent
import com.anda.data.entities.ExOphthaInfoReview
import com.anda.data.entities.OphthaInfoEvent
import com.anda.data.entities.OphthaInfoReview
import com.anda.ui.main.home.ranking.HomeAndaRankingSelectRVAdapter

class CompareOptionVPAdapter(fragment:Fragment) : FragmentStateAdapter(fragment){

    private val fragmentList : ArrayList<Fragment> = ArrayList()
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> CompareOptionSelectOperationFragment()
            1 -> CompareOptionSelectSortFragment()
            else -> CompareOptionSelectLocationFragment()
        }
    }

    fun addFragment(fragment: Fragment){
        fragmentList.add(fragment)
        notifyItemInserted(fragmentList.size - 1)
    }


}