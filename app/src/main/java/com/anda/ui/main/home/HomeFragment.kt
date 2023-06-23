package com.anda.ui.main.home

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.anda.MainActivity
import com.anda.R
import com.anda.data.entities.HomeAndaRankingSelect
import com.anda.data.entities.HomeAndaRankingOphtha
import com.anda.databinding.FragmentHomeBinding
import com.anda.ui.main.compare.CompareFragment
import com.anda.ui.main.compare.option.CompareOptionSelectSortFragment
import com.anda.ui.main.home.ads.HomeAdsBannerFragment
import com.anda.ui.main.home.ads.HomeAdsBannerVPAdapter
import com.anda.ui.main.home.andaInfo.AndaInfoService
import com.anda.ui.main.home.andaInfo.AndaInfoView
import com.anda.ui.main.home.andaInfo.HomeAndaInfoBannerFragment
import com.anda.ui.main.home.andaInfo.HomeAndaInfoBannerVPAdapter
import com.anda.ui.main.home.andaInfo.model.AndaInfoBanners
import com.anda.ui.main.home.andaInfo.model.AndaInfoResponse
import com.anda.ui.main.home.ranking.HomeAndaRankingBannerFragment
import com.anda.ui.main.home.ranking.HomeAndaRankingBannerVPAdapter
import com.anda.ui.main.home.ranking.HomeAndaRankingSelectRVAdapter
import com.anda.ui.main.home.ranking.selectLocation.HomeSelectLocationFragment
import com.anda.ui.write_review.WriteReview2Fragment
import java.util.*
import kotlin.collections.ArrayList

class HomeFragment : Fragment() {

    private val rankingOphthaList = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12","13","14","15","16","17","18","19", "20")
    private var isDoReviewClicked = false
    private var homeAndaRankingSelecDatas = ArrayList<HomeAndaRankingSelect>()
    val homeAndaInfoDatas = ArrayList<AndaInfoBanners>()
    private var homeAndaInfoDatasSize : Int = 0
    val homeAndaRankingP1Datas = ArrayList<HomeAndaRankingOphtha>()
    val homeAndaRankingP2Datas = ArrayList<HomeAndaRankingOphtha>()
    val homeAndaRankingP3Datas = ArrayList<HomeAndaRankingOphtha>()


    private lateinit var ophthaSharedPreferences1 : SharedPreferences
    private lateinit var ophthaSharedPreferences2 : SharedPreferences
    private lateinit var ophthaSharedPreferences3: SharedPreferences

    lateinit var binding: FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)


        setAndaInfo()

        clickSetting()
        addAndaRankingSelect()
        optionAdsBanner()
        optionAndaRankingOphtha()

        //안다정보 GET
        //val service = AndaInfoService(this)
        //service.tryAndaInfo()


        return binding.root
    }


    private fun optionAndaRankingOphtha() {
        addAndaRankingOphtha()

        //dotsIndicator
        val andaRankingBannerAdapter = HomeAndaRankingBannerVPAdapter(this)
        binding.homeRankingVp.adapter = andaRankingBannerAdapter
        binding.homeRankingVp.setCurrentItem(1,true)
        binding.homeRankingDotsIndicator.setViewPager2(binding.homeRankingVp)

        //vp
        andaRankingBannerAdapter.addFragment(HomeAndaRankingBannerFragment(homeAndaRankingP1Datas))
        andaRankingBannerAdapter.addFragment(HomeAndaRankingBannerFragment(homeAndaRankingP2Datas))
        andaRankingBannerAdapter.addFragment(HomeAndaRankingBannerFragment(homeAndaRankingP3Datas))
        binding.homeRankingVp.adapter = andaRankingBannerAdapter
        binding.homeRankingVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL


    }

    private fun addAndaRankingOphtha() {

        var randomElement1 = rankingOphthaList.random()
        var randomElement2 = rankingOphthaList.random()
        var randomElement3 = rankingOphthaList.random()
        ophthaSharedPreferences1 = requireContext().getSharedPreferences("Ophtha" + randomElement1, Context.MODE_PRIVATE)
        ophthaSharedPreferences2 = requireContext().getSharedPreferences("Ophtha" + randomElement2, Context.MODE_PRIVATE)
        ophthaSharedPreferences3 = requireContext().getSharedPreferences("Ophtha" + randomElement3, Context.MODE_PRIVATE)

        homeAndaRankingP1Datas.apply {
            add(HomeAndaRankingOphtha(ophthaSharedPreferences1.getString("id", "0")!!.toInt(), ophthaSharedPreferences1.getString("name", "김안과의원"),"서울특별시 영등포구",1, ophthaSharedPreferences1.getInt("img", R.drawable.ophtha_ex_img), ophthaSharedPreferences1.getFloat("totalRating", 0f)!!.toDouble(), 4))
            add(HomeAndaRankingOphtha(ophthaSharedPreferences2.getString("id", "0")!!.toInt(), ophthaSharedPreferences2.getString("name", "김안과의원"),"서울특별시 영등포구",2, ophthaSharedPreferences2.getInt("img", R.drawable.ophtha_ex_img), ophthaSharedPreferences2.getFloat("totalRating", 0f)!!.toDouble(), 4))
            add(HomeAndaRankingOphtha(ophthaSharedPreferences3.getString("id", "0")!!.toInt(), ophthaSharedPreferences3.getString("name", "김안과의원"),"서울특별시 영등포구",3, ophthaSharedPreferences1.getInt("img", R.drawable.ophtha_ex_img), ophthaSharedPreferences3.getFloat("totalRating", 0f)!!.toDouble(), 5))
        }
        randomElement1 = rankingOphthaList.random()
        randomElement2 = rankingOphthaList.random()
        randomElement3 = rankingOphthaList.random()
        ophthaSharedPreferences1 = requireContext().getSharedPreferences("Ophtha" + randomElement1, Context.MODE_PRIVATE)
        ophthaSharedPreferences2 = requireContext().getSharedPreferences("Ophtha" + randomElement2, Context.MODE_PRIVATE)
        ophthaSharedPreferences3 = requireContext().getSharedPreferences("Ophtha" + randomElement3, Context.MODE_PRIVATE)
        homeAndaRankingP2Datas.apply {
            add(HomeAndaRankingOphtha(ophthaSharedPreferences1.getString("id", "0")!!.toInt(),ophthaSharedPreferences1.getString("name", "김안과의원"),"서울특별시 영등포구",4, ophthaSharedPreferences1.getInt("img", R.drawable.ophtha_ex_img), ophthaSharedPreferences1.getFloat("totalRating", 0f)!!.toDouble(), 5))
            add(HomeAndaRankingOphtha(ophthaSharedPreferences2.getString("id", "0")!!.toInt(),ophthaSharedPreferences2.getString("name", "김안과의원"),"서울특별시 영등포구",5, ophthaSharedPreferences2.getInt("img", R.drawable.ophtha_ex_img), ophthaSharedPreferences2.getFloat("totalRating", 0f)!!.toDouble(), 4))
            add(HomeAndaRankingOphtha(ophthaSharedPreferences3.getString("id", "0")!!.toInt(),ophthaSharedPreferences3.getString("name", "김안과의원"),"서울특별시 영등포구",6, ophthaSharedPreferences3.getInt("img", R.drawable.ophtha_ex_img), ophthaSharedPreferences3.getFloat("totalRating", 0f)!!.toDouble(), 3))
        }
        randomElement1 = rankingOphthaList.random()
        randomElement2 = rankingOphthaList.random()
        randomElement3 = rankingOphthaList.random()
        ophthaSharedPreferences1 = requireContext().getSharedPreferences("Ophtha" + randomElement1, Context.MODE_PRIVATE)
        ophthaSharedPreferences2 = requireContext().getSharedPreferences("Ophtha" + randomElement2, Context.MODE_PRIVATE)
        ophthaSharedPreferences3 = requireContext().getSharedPreferences("Ophtha" + randomElement3, Context.MODE_PRIVATE)
        homeAndaRankingP3Datas.apply {
            add(HomeAndaRankingOphtha(ophthaSharedPreferences1.getString("id", "0")!!.toInt(), ophthaSharedPreferences1.getString("name", "김안과의원"),"서울특별시 영등포구",7, ophthaSharedPreferences1.getInt("img", R.drawable.ophtha_ex_img), ophthaSharedPreferences1.getFloat("totalRating", 0f)!!.toDouble(), 4))
            add(HomeAndaRankingOphtha(ophthaSharedPreferences2.getString("id", "0")!!.toInt(), ophthaSharedPreferences2.getString("name", "김안과의원"),"서울특별시 영등포구",8, ophthaSharedPreferences2.getInt("img", R.drawable.ophtha_ex_img), ophthaSharedPreferences2.getFloat("totalRating", 0f)!!.toDouble(), 2))
            add(HomeAndaRankingOphtha(ophthaSharedPreferences3.getString("id", "0")!!.toInt(), ophthaSharedPreferences3.getString("name", "김안과의원"),"서울특별시 영등포구",9, ophthaSharedPreferences3.getInt("img", R.drawable.ophtha_ex_img), ophthaSharedPreferences3.getFloat("totalRating", 0f)!!.toDouble(), 5))
        }
    }

    private fun optionAdsBanner() {
        val adsBannerAdapter = HomeAdsBannerVPAdapter(this)
        adsBannerAdapter.addFragment(HomeAdsBannerFragment(R.drawable.ophtha_ex_img))
        adsBannerAdapter.addFragment(HomeAdsBannerFragment(R.drawable.ex_img))
        //binding.homeAdsVp.adapter = adsBannerAdapter
    // binding.homeAdsVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }
    private fun addAndaRankingSelect() {
        homeAndaRankingSelecDatas.apply {
            add(HomeAndaRankingSelect(0, R.drawable.home_ranking_unselected_lasik_img))
            add(HomeAndaRankingSelect(1, R.drawable.home_ranking_unselected_lasek_img))
            add(HomeAndaRankingSelect(2, R.drawable.home_ranking_unselected_smile_img))
            add(HomeAndaRankingSelect(3, R.drawable.home_ranking_unselected_normal_img))
            add(HomeAndaRankingSelect(4, R.drawable.home_ranking_unselected_lens_img))
            add(HomeAndaRankingSelect(5, R.drawable.home_ranking_unselected_back_img))
        }
        val andaRankingSelectRVAdapter = HomeAndaRankingSelectRVAdapter(homeAndaRankingSelecDatas)
        binding.homeRankingSelectRv.adapter = andaRankingSelectRVAdapter
        binding.homeRankingSelectRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        andaRankingSelectRVAdapter.setHomeandaRankingSelectItemClickListener(object : HomeAndaRankingSelectRVAdapter.homeandaRankingSelectItemClickListener{
            override fun onItemClick(andaRankingSelect: HomeAndaRankingSelect) {
                // 데이터 소스를 비워주는 예시 코드
                homeAndaRankingP1Datas.clear() // dataList는 어댑터에서 사용하는 데이터 소스(List, ArrayList 등)
                homeAndaRankingP2Datas.clear() // dataList는 어댑터에서 사용하는 데이터 소스(List, ArrayList 등)
                homeAndaRankingP3Datas.clear() // dataList는 어댑터에서 사용하는 데이터 소스(List, ArrayList 등)
                optionAndaRankingOphtha()
            } })
    }
    private fun clickSetting() {
        binding.homeDoReviewBtn.setOnClickListener {
            if (!isDoReviewClicked) {
                binding.homeDoReviewTv.visibility = View.VISIBLE
                isDoReviewClicked = !isDoReviewClicked
            } else {
                binding.homeDoReviewTv.visibility = View.GONE
                isDoReviewClicked = !isDoReviewClicked
            }
        }
        binding.homeDoReviewTv.setOnClickListener {
            (context as MainActivity).changeFragment(WriteReview2Fragment())
//            (context as MainActivity).supportFragmentManager.beginTransaction()
//            .replace(R.id.nav_host_fragment_container, WriteReview2Fragment())
//            .commitAllowingStateLoss()
        }
        binding.homeRankingSelectLocation.setOnClickListener {
            (context as MainActivity).changeFragment(HomeSelectLocationFragment())
//            (context as MainActivity).supportFragmentManager.beginTransaction()
//                .replace(R.id.nav_host_fragment_container, HomeSelectLocationFragment())
//                .commitAllowingStateLoss()
        }
        binding.homeMoreReviewsIv.setOnClickListener{
            (context as MainActivity).changeFragment(CompareFragment())
//            (context as MainActivity).supportFragmentManager.beginTransaction()
//                .replace(R.id.nav_host_fragment_container, CompareFragment())
//                .commitAllowingStateLoss()
        }
    }


    private fun setAndaInfo(){
        //배너 추가 및 생성
        val andaInfoBannerAdapter = HomeAndaInfoBannerVPAdapter(this)
        andaInfoBannerAdapter.addFragment(HomeAndaInfoBannerFragment(R.drawable.anda_info1))
        andaInfoBannerAdapter.addFragment(HomeAndaInfoBannerFragment(R.drawable.anda_info2))
        binding.homeAndaInfoVp.adapter = andaInfoBannerAdapter
        binding.homeAndaInfoVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        binding.homeAndaInfoVp.setCurrentItem(1, true)
        binding.homeAndaInfoDotsIndicator.setViewPager2(binding.homeAndaInfoVp)
    }

}
