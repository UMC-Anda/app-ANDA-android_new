package com.anda.ui.main.compare

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.anda.MainActivity
import com.anda.R
import com.anda.data.entities.ChallengeItem
import com.anda.data.entities.CompareOphtha
import com.anda.data.entities.CompareSortSelect
import com.anda.data.entities.HomeAndaRankingOphtha
import com.anda.databinding.FragmentCompareBinding
import com.anda.ui.main.compare.option.CompareOptionSelectLocationFragment
import com.anda.ui.main.compare.option.CompareOptionSelectOperationFragment
import com.anda.ui.main.compare.option.CompareOptionSelectSortFragment
import com.anda.ui.main.compare.option.CompareOptionVPAdapter
import com.anda.ui.main.home.ranking.HomeAndaRankingRVAdapter
import com.anda.ui.main.management.after.challenge.ChallengeHistoryDetailFragment
import com.anda.ui.main.management.after.challenge.ManagementChallengeRVAdapter
import com.anda.ui.ophtha_info.OphthaInfoFragment
import com.anda.ui.write_review.WriteReview2Fragment
import com.google.gson.Gson


class CompareFragment() : Fragment(), View.OnClickListener {

    //바인딩
    lateinit var binding: FragmentCompareBinding
    private var compareSortSelectDatas = ArrayList<CompareSortSelect>()
    private var compareOphthaDatas = ArrayList<CompareOphtha>()
    private var compareSortSelectedOperationDatas = ArrayList<String>()
    private var compareSortSelectedSortStandardDatas = ArrayList<String>()
    private var compareSortSelectedLocationDatas = ArrayList<String>()




    //라식
    private lateinit var ophthaSharedPreferences1 : SharedPreferences
    private lateinit var ophthaSharedPreferences7 : SharedPreferences
    private lateinit var ophthaSharedPreferences12: SharedPreferences
    private lateinit var ophthaSharedPreferences17: SharedPreferences

    //라섹
    private lateinit var ophthaSharedPreferences2 : SharedPreferences
    private lateinit var ophthaSharedPreferences8 : SharedPreferences
    private lateinit var ophthaSharedPreferences13 : SharedPreferences
    private lateinit var ophthaSharedPreferences18 : SharedPreferences

    //스마일라식
    private lateinit var ophthaSharedPreferences3: SharedPreferences
    private lateinit var ophthaSharedPreferences9: SharedPreferences
    private lateinit var ophthaSharedPreferences14: SharedPreferences
    private lateinit var ophthaSharedPreferences19: SharedPreferences

    //투데이라섹
    private lateinit var ophthaSharedPreferences4: SharedPreferences
    private lateinit var ophthaSharedPreferences10: SharedPreferences
    private lateinit var ophthaSharedPreferences15: SharedPreferences
    private lateinit var ophthaSharedPreferences20: SharedPreferences

    //렌즈삽입술
    private lateinit var ophthaSharedPreferences5: SharedPreferences
    private lateinit var ophthaSharedPreferences11: SharedPreferences
    private lateinit var ophthaSharedPreferences16 :SharedPreferences

    //백내장
    private lateinit var ophthaSharedPreferences6: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCompareBinding.inflate(inflater, container, false)

        val compareSortSelectRVAdapter = initSortSelectButton()


        ophthaSharedPreferences1 = requireContext().getSharedPreferences("Ophtha1", Context.MODE_PRIVATE)
        ophthaSharedPreferences2 = requireContext().getSharedPreferences("Ophtha2", Context.MODE_PRIVATE)
        ophthaSharedPreferences3 = requireContext().getSharedPreferences("Ophtha3", Context.MODE_PRIVATE)
        ophthaSharedPreferences4 = requireContext().getSharedPreferences("Ophtha4", Context.MODE_PRIVATE)
        ophthaSharedPreferences5 = requireContext().getSharedPreferences("Ophtha5", Context.MODE_PRIVATE)
        ophthaSharedPreferences6 = requireContext().getSharedPreferences("Ophtha6", Context.MODE_PRIVATE)
        ophthaSharedPreferences7 = requireContext().getSharedPreferences("Ophtha7", Context.MODE_PRIVATE)
        ophthaSharedPreferences8 = requireContext().getSharedPreferences("Ophtha8", Context.MODE_PRIVATE)
        ophthaSharedPreferences9 = requireContext().getSharedPreferences("Ophtha9", Context.MODE_PRIVATE)
        ophthaSharedPreferences10 = requireContext().getSharedPreferences("Ophtha10", Context.MODE_PRIVATE)
        ophthaSharedPreferences11 = requireContext().getSharedPreferences("Ophtha11", Context.MODE_PRIVATE)
        ophthaSharedPreferences12 = requireContext().getSharedPreferences("Ophtha12", Context.MODE_PRIVATE)
        ophthaSharedPreferences13 = requireContext().getSharedPreferences("Ophtha13", Context.MODE_PRIVATE)
        ophthaSharedPreferences14 = requireContext().getSharedPreferences("Ophtha14", Context.MODE_PRIVATE)
        ophthaSharedPreferences15 = requireContext().getSharedPreferences("Ophtha15", Context.MODE_PRIVATE)
        ophthaSharedPreferences16 = requireContext().getSharedPreferences("Ophtha16", Context.MODE_PRIVATE)
        ophthaSharedPreferences17 = requireContext().getSharedPreferences("Ophtha17", Context.MODE_PRIVATE)
        ophthaSharedPreferences18 = requireContext().getSharedPreferences("Ophtha18", Context.MODE_PRIVATE)
        ophthaSharedPreferences19 = requireContext().getSharedPreferences("Ophtha19", Context.MODE_PRIVATE)
        ophthaSharedPreferences20 = requireContext().getSharedPreferences("Ophtha20", Context.MODE_PRIVATE)



        addOphthaInit()

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
        binding.compareDoReviewBtn.setOnClickListener(this)
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

    private fun addOphthaInit() {
        compareOphthaDatas.apply {
            add(
                CompareOphtha(
                    1,
                    ophthaSharedPreferences1.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences1.getInt("img", R.color.Main),
                    ophthaSharedPreferences1.getFloat("totalRating", 0f),
                    ophthaSharedPreferences1.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    2,
                    ophthaSharedPreferences2.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences2.getInt("img", R.color.Main),
                    ophthaSharedPreferences2.getFloat("totalRating", 0f),
                    ophthaSharedPreferences2.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    3,
                    ophthaSharedPreferences3.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences3.getInt("img", R.color.Main),
                    ophthaSharedPreferences3.getFloat("totalRating", 0f),
                    ophthaSharedPreferences3.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    4,
                    ophthaSharedPreferences4.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences4.getInt("img", R.color.Main),
                    ophthaSharedPreferences4.getFloat("totalRating", 0f),
                    ophthaSharedPreferences4.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    5,
                    ophthaSharedPreferences5.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences5.getInt("img", R.color.Main),
                    ophthaSharedPreferences5.getFloat("totalRating", 0f),
                    ophthaSharedPreferences5.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    6,
                    ophthaSharedPreferences6.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences6.getInt("img", R.color.Main),
                    ophthaSharedPreferences6.getFloat("totalRating", 0f),
                    ophthaSharedPreferences6.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    7,
                    ophthaSharedPreferences7.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences7.getInt("img", R.color.Main),
                    ophthaSharedPreferences7.getFloat("totalRating", 0f),
                    ophthaSharedPreferences7.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    8,
                    ophthaSharedPreferences8.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences8.getInt("img", R.color.Main),
                    ophthaSharedPreferences8.getFloat("totalRating", 0f),
                    ophthaSharedPreferences8.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    9,
                    ophthaSharedPreferences9.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences9.getInt("img", R.color.Main),
                    ophthaSharedPreferences9.getFloat("totalRating", 0f),
                    ophthaSharedPreferences9.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    10,
                    ophthaSharedPreferences10.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences10.getInt("img", R.color.Main),
                    ophthaSharedPreferences10.getFloat("totalRating", 0f),
                    ophthaSharedPreferences10.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    11,
                    ophthaSharedPreferences11.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences11.getInt("img", R.color.Main),
                    ophthaSharedPreferences11.getFloat("totalRating", 0f),
                    ophthaSharedPreferences11.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    12,
                    ophthaSharedPreferences12.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences12.getInt("img", R.color.Main),
                    ophthaSharedPreferences12.getFloat("totalRating", 0f),
                    ophthaSharedPreferences12.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    13,
                    ophthaSharedPreferences13.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences13.getInt("img", R.color.Main),
                    ophthaSharedPreferences13.getFloat("totalRating", 0f),
                    ophthaSharedPreferences13.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    14,
                    ophthaSharedPreferences14.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences14.getInt("img", R.color.Main),
                    ophthaSharedPreferences14.getFloat("totalRating", 0f),
                    ophthaSharedPreferences14.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    15,
                    ophthaSharedPreferences15.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences15.getInt("img", R.color.Main),
                    ophthaSharedPreferences15.getFloat("totalRating", 0f),
                    ophthaSharedPreferences15.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    16,
                    ophthaSharedPreferences16.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences16.getInt("img", R.color.Main),
                    ophthaSharedPreferences16.getFloat("totalRating", 0f),
                    ophthaSharedPreferences16.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    17,
                    ophthaSharedPreferences17.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences17.getInt("img", R.color.Main),
                    ophthaSharedPreferences17.getFloat("totalRating", 0f),
                    ophthaSharedPreferences17.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    18,
                    ophthaSharedPreferences18.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences18.getInt("img", R.color.Main),
                    ophthaSharedPreferences18.getFloat("totalRating", 0f),
                    ophthaSharedPreferences18.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    19,
                    ophthaSharedPreferences19.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences19.getInt("img", R.color.Main),
                    ophthaSharedPreferences19.getFloat("totalRating", 0f),
                    ophthaSharedPreferences19.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    20,
                    ophthaSharedPreferences20.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences20.getInt("img", R.color.Main),
                    ophthaSharedPreferences20.getFloat("totalRating", 0f),
                    ophthaSharedPreferences20.getInt("reviwCnt", 0)
                )
            )
        }
        val compareOphthaRVAdapter = CompareOphthaRVAdapter(compareOphthaDatas, requireContext())
        binding.compareOphthaRv.adapter = compareOphthaRVAdapter
        binding.compareOphthaRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        compareOphthaRVAdapter.setItemClickListener(object :
            CompareOphthaRVAdapter.ItemClickListener {
            override fun onItemClick(compareOphtha: CompareOphtha) {
                // Fragment를 전환하고 Bundle을 전달합니다.
                (context as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, OphthaInfoFragment(compareOphtha.id!!)).commitAllowingStateLoss()
            }
        })
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
    private fun setSelectedOperation():CompareSortSelectedOperationRVAdapter{
        val compareSortSelectedOperationRVAdapter = CompareSortSelectedOperationRVAdapter(compareSortSelectedOperationDatas)
        binding.compareSelectSortSelectedOperationRv.adapter = compareSortSelectedOperationRVAdapter
        binding.compareSelectSortSelectedOperationRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        binding.compareSelectSortSelectedOperationRv.visibility = View.VISIBLE
        return compareSortSelectedOperationRVAdapter
    }
    private fun setSelectedSortStandard():CompareSortSelectedSortStandardRVAdapter{
        val compareSortSelectedSortStandardRVAdapter = CompareSortSelectedSortStandardRVAdapter(compareSortSelectedSortStandardDatas)
        binding.compareSelectSortSelectedSortStandardRv.adapter = compareSortSelectedSortStandardRVAdapter
        binding.compareSelectSortSelectedSortStandardRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        binding.compareSelectSortSelectedSortStandardRv.visibility = View.VISIBLE
        return compareSortSelectedSortStandardRVAdapter
    }

    private fun setSelectedLocation():CompareSortSelectedLocationRVAdapter{
        val compareSortSelectedLocationRVAdapter = CompareSortSelectedLocationRVAdapter(compareSortSelectedLocationDatas)
        binding.compareSelectSortSelectedLocationRv.adapter = compareSortSelectedLocationRVAdapter
        binding.compareSelectSortSelectedLocationRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        binding.compareSelectSortSelectedLocationRv.visibility = View.VISIBLE
        return compareSortSelectedLocationRVAdapter
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
            binding.compareDoReviewBtn -> {
                (context as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, WriteReview2Fragment())
                    .commitAllowingStateLoss()
            }
            binding.compareOptionCancelIv -> {
                //수술선택 클릭한 것 적용
                val selectedOperation =
                    (activity as MainActivity).compareSortSelectedOption.selectedOperation
                compareSortSelectedOperationDatas.clear()
                if (selectedOperation != null) compareSortSelectedOperationDatas.add(
                    selectedOperation!!
                )
                //정렬선택 클릭한 것 적용
                val selectedSortStandard =
                    (activity as MainActivity).compareSortSelectedOption.selectedSortStandard
                compareSortSelectedSortStandardDatas.clear()
                compareSortSelectedSortStandardDatas.add(selectedSortStandard!!)
                //정렬선택 클릭한 것 적용
                compareSortSelectedLocationDatas =
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!
                compareSortSelectedLocationDatas.sort()
                //모두 선택했는지 확인
                if (compareSortSelectedOperationDatas.size == 0 || compareSortSelectedSortStandardDatas.size == 0 || compareSortSelectedLocationDatas.size == 0) {
                    Toast.makeText(context, "옵션을 모두 선택해주세요", Toast.LENGTH_SHORT).show()
                    return
                }
                //수술선택 RVAdapter 적용
                val compareSortSelectedOperationRVAdapter = setSelectedOperation()
                compareSortSelectedOperationRVAdapter.setCompareSortSelectedOperationItemClickListener(
                    object :
                        CompareSortSelectedOperationRVAdapter.compareSortedOperationItemClickListener {
                        override fun onItemClick(position: Int) {
                            binding.compareSelectSortSelectedOperationRv.visibility = View.GONE
                            if (binding.compareSelectSortSelectedOperationRv.visibility == View.GONE && binding.compareSelectSortSelectedSortStandardRv.visibility == View.GONE && binding.compareSelectSortSelectedLocationRv.visibility == View.GONE) {
                                binding.compareSelectedOptionRerollBtnIv.visibility = View.GONE
                            }
                        }
                    })
                //정렬선택 RVAdapter 적용
                val compareSortSelectedSortStandardRVAdapter = setSelectedSortStandard()
                compareSortSelectedSortStandardRVAdapter.setCompareSortSelectedSortStandardItemClickListener(
                    object :
                        CompareSortSelectedSortStandardRVAdapter.compareSortedSortStandardItemClickListener {
                        override fun onItemClick(position: Int) {
                            binding.compareSelectSortSelectedSortStandardRv.visibility = View.GONE
                            if (binding.compareSelectSortSelectedOperationRv.visibility == View.GONE && binding.compareSelectSortSelectedSortStandardRv.visibility == View.GONE && binding.compareSelectSortSelectedLocationRv.visibility == View.GONE) {
                                binding.compareSelectedOptionRerollBtnIv.visibility = View.GONE
                            }
                        }
                    })
                //위치선택 RVAdapter 적용
                val compareSortSelectedLocationRVAdapter = setSelectedLocation()
                compareSortSelectedLocationRVAdapter.setCompareSortSelectedLocationItemClickListener(
                    object :
                        CompareSortSelectedLocationRVAdapter.compareSortedLocationItemClickListener {
                        override fun onItemClick(position: Int) {
                            binding.compareSelectSortSelectedLocationRv.visibility = View.GONE
                            if (binding.compareSelectSortSelectedOperationRv.visibility == View.GONE && binding.compareSelectSortSelectedSortStandardRv.visibility == View.GONE && binding.compareSelectSortSelectedLocationRv.visibility == View.GONE) {
                                binding.compareSelectedOptionRerollBtnIv.visibility = View.GONE
                            }
                        }
                    })
                binding.compareOptionCancelIv.visibility = View.GONE
                binding.compareSelectedOptionRerollBtnIv.visibility = View.VISIBLE
                val amimationEmailSelect: ValueAnimator = ObjectAnimator
                    .ofFloat(binding.compareOption, "translationY", 0f, 1000f)
                amimationEmailSelect.duration = 50
                amimationEmailSelect.start()
                Handler(Looper.getMainLooper()).postDelayed({
                    binding.compareOption.visibility = View.GONE
                    (activity as MainActivity).bottomNavigationControl()
                }, 50)



                //안과 비교 RV 초기화
                compareOphthaDatas.clear()
                when(selectedOperation){
                    "라식" ->{ addOphthaLasik(selectedSortStandard) }
                    "라섹" ->{ addOphthaLasek(selectedSortStandard) }
                    "스마일라식" ->{ addOphthaSmile(selectedSortStandard) }
                    "투데이라섹" ->{ addOphthaToday(selectedSortStandard) }
                    "렌즈삽입술" ->{ addOphthaLens(selectedSortStandard) }
                    "백내장" -> { addOphthaBack(selectedSortStandard) }
                }
                val compareOphthaRVAdapter = CompareOphthaRVAdapter(compareOphthaDatas, requireContext())
                binding.compareOphthaRv.adapter = compareOphthaRVAdapter
                binding.compareOphthaRv.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            }
            binding.compareOptionSelectOperationTv -> binding.compareOptionVp.setCurrentItem(0, false)
            binding.compareOptionSelectSortStandardTv -> binding.compareOptionVp.setCurrentItem(1, false)
            binding.compareOptionSelectLocationTv -> binding.compareOptionVp.setCurrentItem(2, false)
        }
    }

    private fun addOphthaBack(selectedSortStandard : String) {
        compareOphthaDatas.apply {
            add(
                CompareOphtha(
                    6,
                    ophthaSharedPreferences6.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences6.getInt("img", R.color.Main),
                    ophthaSharedPreferences6.getFloat("totalRating", 0f),
                    ophthaSharedPreferences6.getInt("reviwCnt", 0)
                )
            )
        }
    }

    private fun addOphthaLens(selectedSortStandard: String) {
        compareOphthaDatas.apply {
            add(
                CompareOphtha(
                    5,
                    ophthaSharedPreferences5.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences5.getInt("img", R.color.Main),
                    ophthaSharedPreferences5.getFloat("totalRating", 0f),
                    ophthaSharedPreferences5.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    11,
                    ophthaSharedPreferences11.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences11.getInt("img", R.color.Main),
                    ophthaSharedPreferences11.getFloat("totalRating", 0f),
                    ophthaSharedPreferences11.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    16,
                    ophthaSharedPreferences16.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences16.getInt("img", R.color.Main),
                    ophthaSharedPreferences16.getFloat("totalRating", 0f),
                    ophthaSharedPreferences16.getInt("reviwCnt", 0)
                )
            )
            if(selectedSortStandard == "별점순"){
                compareOphthaDatas.sortByDescending { it.ratingAvg }
            }else{
                compareOphthaDatas.sortByDescending { it.reviewCnt }
            }
        }
    }


    private fun addOphthaToday(selectedSortStandard: String) {
        compareOphthaDatas.apply {
            add(
                CompareOphtha(
                    4,
                    ophthaSharedPreferences4.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences4.getInt("img", R.color.Main),
                    ophthaSharedPreferences4.getFloat("totalRating", 0f),
                    ophthaSharedPreferences4.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    10,
                    ophthaSharedPreferences10.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences10.getInt("img", R.color.Main),
                    ophthaSharedPreferences10.getFloat("totalRating", 0f),
                    ophthaSharedPreferences10.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    15,
                    ophthaSharedPreferences15.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences15.getInt("img", R.color.Main),
                    ophthaSharedPreferences15.getFloat("totalRating", 0f),
                    ophthaSharedPreferences15.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    20,
                    ophthaSharedPreferences20.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences20.getInt("img", R.color.Main),
                    ophthaSharedPreferences20.getFloat("totalRating", 0f),
                    ophthaSharedPreferences20.getInt("reviwCnt", 0)
                )
            )
        }
        if(selectedSortStandard == "별점순"){
            compareOphthaDatas.sortByDescending { it.ratingAvg }
        }else{
            compareOphthaDatas.sortByDescending { it.reviewCnt }
        }
    }

    private fun addOphthaSmile(selectedSortStandard: String) {
        compareOphthaDatas.apply {
            add(
                CompareOphtha(
                    3,
                    ophthaSharedPreferences3.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences3.getInt("img", R.color.Main),
                    ophthaSharedPreferences3.getFloat("totalRating", 0f),
                    ophthaSharedPreferences3.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    9,
                    ophthaSharedPreferences9.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences9.getInt("img", R.color.Main),
                    ophthaSharedPreferences9.getFloat("totalRating", 0f),
                    ophthaSharedPreferences9.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    14,
                    ophthaSharedPreferences14.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences14.getInt("img", R.color.Main),
                    ophthaSharedPreferences14.getFloat("totalRating", 0f),
                    ophthaSharedPreferences14.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    19,
                    ophthaSharedPreferences19.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences19.getInt("img", R.color.Main),
                    ophthaSharedPreferences19.getFloat("totalRating", 0f),
                    ophthaSharedPreferences19.getInt("reviwCnt", 0)
                )
            )
        }
        if(selectedSortStandard == "별점순"){
            compareOphthaDatas.sortByDescending { it.ratingAvg }
        }else{
            compareOphthaDatas.sortByDescending { it.reviewCnt }
        }
    }

    private fun addOphthaLasek(selectedSortStandard: String) {
        compareOphthaDatas.apply {
            add(
                CompareOphtha(
                    2,
                    ophthaSharedPreferences2.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences2.getInt("img", R.color.Main),
                    ophthaSharedPreferences2.getFloat("totalRating", 0f),
                    ophthaSharedPreferences2.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    8,
                    ophthaSharedPreferences8.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences8.getInt("img", R.color.Main),
                    ophthaSharedPreferences8.getFloat("totalRating", 0f),
                    ophthaSharedPreferences8.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    13,
                    ophthaSharedPreferences13.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences13.getInt("img", R.color.Main),
                    ophthaSharedPreferences13.getFloat("totalRating", 0f),
                    ophthaSharedPreferences13.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    18,
                    ophthaSharedPreferences18.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences18.getInt("img", R.color.Main),
                    ophthaSharedPreferences18.getFloat("totalRating", 0f),
                    ophthaSharedPreferences18.getInt("reviwCnt", 0)
                )
            )
        }
        if(selectedSortStandard == "별점순"){
            compareOphthaDatas.sortByDescending { it.ratingAvg }
        }else{
            compareOphthaDatas.sortByDescending { it.reviewCnt }
        }
    }

    private fun addOphthaLasik(selectedSortStandard: String) {
        compareOphthaDatas.apply {

            add(
                CompareOphtha(
                    1,
                    ophthaSharedPreferences1.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences1.getInt("img", R.color.Main),
                    ophthaSharedPreferences1.getFloat("totalRating", 0f),
                    ophthaSharedPreferences1.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    7,
                    ophthaSharedPreferences7.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences7.getInt("img", R.color.Main),
                    ophthaSharedPreferences7.getFloat("totalRating", 0f),
                    ophthaSharedPreferences7.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    12,
                    ophthaSharedPreferences12.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences12.getInt("img", R.color.Main),
                    ophthaSharedPreferences12.getFloat("totalRating", 0f),
                    ophthaSharedPreferences12.getInt("reviwCnt", 0)
                )
            )
            add(
                CompareOphtha(
                    17,
                    ophthaSharedPreferences17.getString("name", "닉네임"),
                    "서울특별시 영등포구",
                    ophthaSharedPreferences17.getInt("img", R.color.Main),
                    ophthaSharedPreferences17.getFloat("totalRating", 0f),
                    ophthaSharedPreferences17.getInt("reviwCnt", 0)
                )
            )
        }
        if(selectedSortStandard == "별점순"){
            compareOphthaDatas.sortByDescending { it.ratingAvg }
        }else{
            compareOphthaDatas.sortByDescending { it.reviewCnt }
        }
    }

}