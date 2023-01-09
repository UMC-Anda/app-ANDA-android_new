package com.anda.ui.main.compare

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.anda.MainActivity
import com.anda.R
import com.anda.data.entities.CompareOphtha
import com.anda.data.entities.CompareSortSelect
import com.anda.databinding.FragmentCompareBinding
import com.anda.ui.main.compare.option.CompareOptionSelectLocationFragment
import com.anda.ui.main.compare.option.CompareOptionSelectOperationFragment
import com.anda.ui.main.compare.option.CompareOptionSelectSortFragment
import com.anda.ui.main.compare.option.CompareOptionVPAdapter


class CompareFragment() : Fragment(), View.OnClickListener {

    //바인딩
    lateinit var binding: FragmentCompareBinding
    private var compareSortSelectDatas = ArrayList<CompareSortSelect>()
    private var compareOphthaDatas = ArrayList<CompareOphtha>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCompareBinding.inflate(inflater, container, false)

        val compareSortSelectRVAdapter = initSortSelectButton()
        addOphtha()

        compareSortSelectRVAdapter.setCompareItemClickListener(object : CompareSortSelectRVAdapter.compareSortItemClickListener{
            override fun onItemClick(position : Int, ItemCnt : Int) {
                binding.compareOptionVp.setCurrentItem(position - (ItemCnt - 3), false)
                binding.compareOption.visibility = View.VISIBLE
                val amimationEmailSelect: ValueAnimator = ObjectAnimator
                    .ofFloat(binding.compareOption, "translationY", 1000f, 0f)
                amimationEmailSelect.duration = 50
                amimationEmailSelect.start()
                binding.compareOptionCancelIv.visibility = View.VISIBLE
                (activity as MainActivity).bottomNavigationControl()
            }
        })

        binding.compareOptionVp.isUserInputEnabled = false
        binding.compareOptionCancelIv.setOnClickListener(this)
        binding.compareOptionBackgroundIv.setOnClickListener(this)
        binding.compareOptionSelectOperationTv.setOnClickListener(this)
        binding.compareOptionSelectSortStandardTv.setOnClickListener(this)
        binding.compareOptionSelectLocationTv.setOnClickListener(this)

        val andaOphthaInfoAdapter = CompareOptionVPAdapter(this)

        andaOphthaInfoAdapter.addFragment(CompareOptionSelectOperationFragment())
        andaOphthaInfoAdapter.addFragment(CompareOptionSelectSortFragment())
        andaOphthaInfoAdapter.addFragment(CompareOptionSelectLocationFragment())
        binding.compareOptionVp.adapter = andaOphthaInfoAdapter
        binding.compareOptionVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        binding.compareOptionVp.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) { setData(position) }
        })

        return binding.root
    }

    private fun addOphtha() {
        compareOphthaDatas.apply {
            add(
                CompareOphtha(
                    "김안과병원",
                    "서울특별시 영등포구",
                    R.drawable.ex_img,
                    3.5,
                    2435,
                )
            )
            add(
                CompareOphtha(
                    "안다 병원",
                    "서울특별시 마포구",
                    R.drawable.ex_img,
                    3.5,
                    2435,
                )
            )
            add(
                CompareOphtha(
                    "모른다 병원",
                    "서울특별시 광진구",
                    R.drawable.ex_img,
                    3.5,
                    2435,
                )
            )
        }
        val compareOphthaRVAdapter = CompareOphthaRVAdapter(compareOphthaDatas)
        binding.compareOphthaRv.adapter = compareOphthaRVAdapter
        binding.compareOphthaRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
    }

    private fun initSortSelectButton(): CompareSortSelectRVAdapter {//초기 버튼 추가 함수
        compareSortSelectDatas.apply {
            add(CompareSortSelect(R.drawable.compare_select_operation_btn, false, ""))
            add(CompareSortSelect(R.drawable.compare_select_sort_btn, false, ""))
            add(CompareSortSelect(R.drawable.compare_select_location_btn, false, ""))
        }
        val compareSortSelectRVAdapter = CompareSortSelectRVAdapter(compareSortSelectDatas)
        binding.compareSelectSortRv.adapter = compareSortSelectRVAdapter
        binding.compareSelectSortRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        return compareSortSelectRVAdapter
    }


    private fun setData(mPosition : Int) {
        when (mPosition) {
            0 -> {
                binding.compareOptionSelectOperationTv.setTextColor(resources.getColor(R.color.Main))
                binding.compareOptionSelectSortStandardTv.setTextColor(resources.getColor(R.color.MAIN_50))
                binding.compareOptionSelectLocationTv.setTextColor(resources.getColor(R.color.MAIN_50))
            }
            1 -> {
                binding.compareOptionSelectOperationTv.setTextColor(resources.getColor(R.color.MAIN_50))
                binding.compareOptionSelectSortStandardTv.setTextColor(resources.getColor(R.color.Main))
                binding.compareOptionSelectLocationTv.setTextColor(resources.getColor(R.color.MAIN_50))
            }
            2 -> {
                binding.compareOptionSelectOperationTv.setTextColor(resources.getColor(R.color.MAIN_50))
                binding.compareOptionSelectSortStandardTv.setTextColor(resources.getColor(R.color.MAIN_50))
                binding.compareOptionSelectLocationTv.setTextColor(resources.getColor(R.color.Main))
            }
        }
    }

    override fun onClick(v: View?) {
        if (v == null) return
        when (v) {
            binding.compareOptionCancelIv -> {
                binding.compareOptionCancelIv.visibility = View.GONE
                val amimationEmailSelect: ValueAnimator = ObjectAnimator
                    .ofFloat(binding.compareOption, "translationY", 0f, 1000f)
                amimationEmailSelect.duration = 50
                amimationEmailSelect.start()
                Handler(Looper.getMainLooper()).postDelayed({
                    binding.compareOption.visibility = View.GONE
                    (activity as MainActivity).bottomNavigationControl()
                }, 50)
            }
            binding.compareOptionSelectOperationTv -> binding.compareOptionVp.setCurrentItem(0, false)
            binding.compareOptionSelectSortStandardTv -> binding.compareOptionVp.setCurrentItem(1, false)
            binding.compareOptionSelectLocationTv -> binding.compareOptionVp.setCurrentItem(2, false)
        }
    }

}