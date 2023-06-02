package com.anda.ui.main.management.after

import android.animation.Animator
import android.animation.ValueAnimator
import android.content.SharedPreferences
import android.graphics.Paint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.GridLayout
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentManagementAfterOperationBinding
import com.anda.ui.ophtha_info.OphthaInfoBannerVPAdapter
import com.anda.ui.ophtha_info.OphthaInfoEventsFragment
import com.anda.ui.ophtha_info.OphthaInfoRatingsFragment
import com.anda.ui.ophtha_info.OphthaInfoReviewsFragment
import com.anda.ui.write_review.WriteReview2Fragment

class ManagementAfterOperationFragment : Fragment() {

    private lateinit var binding: FragmentManagementAfterOperationBinding
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentManagementAfterOperationBinding.inflate(inflater, container, false)

        binding.progressBar.isIndeterminate = false
        binding.progressBar.progress = (binding.progressBar.max * 0.75).toInt()


        val managementAfterAdapter = ManagementAfterVPAdapter(this)
        binding.popUpVp.adapter = managementAfterAdapter

        managementAfterAdapter.addFragment(CheckedinFragment())
        managementAfterAdapter.addFragment(OperationMbtiFragment())
        binding.popUpVp.adapter = managementAfterAdapter
        binding.popUpVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // ToDoList 구현 시작
        binding.checkBox1.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                moveItemToBottom(binding.checkBox1)
                strikeThroughText(binding.checkBox1)
            } else {
                removeStrikeThroughText(binding.checkBox1)
            }
        }

        binding.checkBox2.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                moveItemToBottom(binding.checkBox2)
                strikeThroughText(binding.checkBox2)
            } else {
                removeStrikeThroughText(binding.checkBox2)
            }
        }

        binding.checkBox3.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                moveItemToBottom(binding.checkBox3)
                strikeThroughText(binding.checkBox3)
            } else {
                removeStrikeThroughText(binding.checkBox3)
            }
        }
        // ToDoList 구현 종료


        binding.goToOperation.setOnClickListener {
            // 버튼 클릭 시 원하는 동작을 수행하도록 구현
            binding.popUpVp.setCurrentItem(1,false)
            if(binding.popUpVp.visibility != View.VISIBLE){
                binding.popUpVp.visibility = View.VISIBLE
            }else{
                binding.popUpVp.visibility = View.GONE
            }
        }

        binding.goToToDoList.setOnClickListener {
            // 버튼 클릭 시 원하는 동작을 수행하도록 구현
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, ManagementChallengeFragment())
                .commitAllowingStateLoss()
        }

        binding.goToTimer.setOnClickListener {
            // 버튼 클릭 시 원하는 동작을 수행하도록 구현
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, AlarmFragment())
                .commitAllowingStateLoss()
        }

        binding.goToCheckedIn.setOnClickListener {
            // 버튼 클릭 시 원하는 동작을 수행하도록 구현
            binding.popUpVp.setCurrentItem(0,false)
            if(binding.popUpVp.visibility != View.VISIBLE){
                binding.popUpVp.visibility = View.VISIBLE
            }else{
                binding.popUpVp.visibility = View.GONE
            }
        }
    }

    private fun moveItemToBottom(view: View) {
        val parent = view.parent as ViewGroup
        parent.removeView(view)
        parent.addView(view)
    }

    private fun strikeThroughText(view: View) {
        if (view is CheckBox) {
            view.paintFlags = view.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        }
    }

    private fun removeStrikeThroughText(view: View) {
        if (view is CheckBox) {
            view.paintFlags = view.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
}
