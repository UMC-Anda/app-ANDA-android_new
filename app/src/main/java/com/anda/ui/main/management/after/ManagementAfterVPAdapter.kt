package com.anda.ui.main.management.after

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class ManagementAfterVPAdapter(fragment: Fragment) : FragmentStateAdapter(fragment){

    private val fragmentList : ArrayList<Fragment> = ArrayList()
    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> CheckedinFragment()
            else -> OperationMbtiFragment()
        }
    }

    fun addFragment(fragment: Fragment){
        fragmentList.add(fragment)
        notifyItemInserted(fragmentList.size - 1)
    }
}