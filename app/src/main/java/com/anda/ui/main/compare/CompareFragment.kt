package com.anda.ui.main.compare

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anda.MainActivity
import com.anda.R
import com.anda.data.entities.CompareOphtha
import com.anda.data.entities.CompareOphthaReview
import com.anda.data.entities.CompareSortSelect
import com.anda.databinding.FragmentCompareBinding
import com.anda.databinding.ItemCompareOphthaBinding
import com.anda.ui.main.map.MapFragment
import com.anda.ui.write_review.WriteCommunityWritingFragment

class CompareFragment() : Fragment() {

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
        ClickSetting()
        compareSortSelectRVAdapter.setCompareItemClickListener(object : CompareSortSelectRVAdapter.compareItemClickListener{
            override fun onItemClick() {

            }
        })
        return binding.root
    }

    private fun ClickSetting() {
        binding.compareDoReviewBtn.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, WriteCommunityWritingFragment())
                .commitAllowingStateLoss()
        }
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
}