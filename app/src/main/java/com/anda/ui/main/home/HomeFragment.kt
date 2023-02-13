package com.anda.ui.main.home

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
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

class HomeFragment : Fragment(), AndaInfoView {

    private var isDoReviewClicked = false
    private var homeAndaRankingSelecDatas = ArrayList<HomeAndaRankingSelect>()
    val homeAndaInfoDatas = ArrayList<AndaInfoBanners>()
    private var homeAndaInfoDatasSize : Int = 0
    val homeAndaRankingP1Datas = ArrayList<HomeAndaRankingOphtha>()
    val homeAndaRankingP2Datas = ArrayList<HomeAndaRankingOphtha>()
    val homeAndaRankingP3Datas = ArrayList<HomeAndaRankingOphtha>()

    lateinit var binding: FragmentHomeBinding
    var currentPosition:Int = 0
    //핸들러 설정
    //ui 변경하기
    val handler= Handler(Looper.getMainLooper()){
        setPage()
        true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)

        //뷰페이저 내용물 바뀔때마다 호출
        binding.homeAndaInfoVp.registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                //dotsindicator 이동
                val dpFloat : Float = binding.homeAndaInfoDotsIndicatorBackgroundIv.width.toFloat() / 6
                val amimationAndaInfoDotsIndicator: ValueAnimator = ObjectAnimator
                    .ofFloat(
                        binding.homeAndaInfoDotsIndicator,
                        "translationX",
                        (currentPosition % homeAndaInfoDatasSize) * dpFloat,
                        (position % homeAndaInfoDatasSize) * dpFloat
                    )
                amimationAndaInfoDotsIndicator.duration = 100
                amimationAndaInfoDotsIndicator.start()
                currentPosition = position
            }
        })
        clickSetting()
        addAndaRankingSelect()
        optionAdsBanner()
        optionAndaRankingOphtha()

        //안다정보 GET
        val service = AndaInfoService(this)
        service.tryAndaInfo()

        //2초마다 안다정보 VP 넘기기
        val thread=Thread(PagerRunnable())
        thread.start()

        return binding.root
    }


    //페이지 변경하기
    fun setPage(){
        if(currentPosition==5) currentPosition=0
        binding.homeAndaInfoVp.setCurrentItem(currentPosition,true)
        currentPosition+=1
    }
    //2초 마다 페이지 넘기기
    inner class PagerRunnable:Runnable{
        override fun run() {
            while(true){
                Thread.sleep(2000)
                handler.sendEmptyMessage(0)
            }
        }
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
        homeAndaRankingP1Datas.apply {
            add(HomeAndaRankingOphtha("김안과병원1","서울특별시 영등포구",1, R.drawable.ophtha_ex_img, 3.5, 12))
            add(HomeAndaRankingOphtha("김안과병원2","서울특별시 영등포구",2, R.drawable.ophtha_ex_img, 4.5, 2))
            add(HomeAndaRankingOphtha("김안과병원3","서울특별시 영등포구",3, R.drawable.ophtha_ex_img, 5.0, 8))
        }
        homeAndaRankingP2Datas.apply {
            add(HomeAndaRankingOphtha("김안과병원4","서울특별시 영등포구",4, R.drawable.ophtha_ex_img, 3.5, 12))
            add(HomeAndaRankingOphtha("김안과병원5","서울특별시 영등포구",5, R.drawable.ophtha_ex_img, 4.5, 2))
            add(HomeAndaRankingOphtha("김안과병원6","서울특별시 영등포구",6, R.drawable.ophtha_ex_img, 5.0, 8))
        }
        homeAndaRankingP3Datas.apply {
            add(HomeAndaRankingOphtha("김안과병원7","서울특별시 영등포구",7, R.drawable.ophtha_ex_img, 3.5, 12))
            add(HomeAndaRankingOphtha("김안과병원8","서울특별시 영등포구",8, R.drawable.ophtha_ex_img, 4.5, 2))
            add(HomeAndaRankingOphtha("김안과병원9","서울특별시 영등포구",9, R.drawable.ophtha_ex_img, 5.0, 8))
        }
    }

    private fun optionAdsBanner() {
        val adsBannerAdapter = HomeAdsBannerVPAdapter(this)
        adsBannerAdapter.addFragment(HomeAdsBannerFragment(R.drawable.ophtha_ex_img))
        adsBannerAdapter.addFragment(HomeAdsBannerFragment(R.drawable.ex_img))
        binding.homeAdsVp.adapter = adsBannerAdapter
        binding.homeAdsVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }
    private fun addAndaRankingSelect() {
        homeAndaRankingSelecDatas.apply {
            add(HomeAndaRankingSelect(0, R.drawable.home_ranking_unselected_lasik_img))
            add(HomeAndaRankingSelect(1, R.drawable.home_ranking_unselected_lasek_img))
            add(HomeAndaRankingSelect(2, R.drawable.home_ranking_unselected_smile_img))
            add(HomeAndaRankingSelect(3, R.drawable.home_ranking_unselected_lens_img))
            add(HomeAndaRankingSelect(4, R.drawable.home_ranking_unselected_back_img))
            add(HomeAndaRankingSelect(5, R.drawable.home_ranking_unselected_normal_img))
        }
        val andaRankingSelectRVAdapter = HomeAndaRankingSelectRVAdapter(homeAndaRankingSelecDatas)
        binding.homeRankingSelectRv.adapter = andaRankingSelectRVAdapter
        binding.homeRankingSelectRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        andaRankingSelectRVAdapter.setHomeandaRankingSelectItemClickListener(object : HomeAndaRankingSelectRVAdapter.homeandaRankingSelectItemClickListener{
            override fun onItemClick(andaRankingSelect: HomeAndaRankingSelect) { } })
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
            (context as MainActivity).supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment_container, CompareOptionSelectSortFragment())
            .commitAllowingStateLoss()

        }
        binding.homeRankingSelectLocation.setOnClickListener{
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, HomeSelectLocationFragment())
                .commitAllowingStateLoss()
        }
    }



    //안다정보
    override fun onAndaInfoSuccess(response: AndaInfoResponse) {
        //배너 추가 및 생성
        val andaInfoBannerAdapter = HomeAndaInfoBannerVPAdapter(this)
        homeAndaInfoDatasSize = response.result?.andaInfoBanners!!.size
        for (i: Int in 0..response.result?.andaInfoBanners!!.size - 1){
//            andaInfoBannerAdapter.addFragment(HomeAndaInfoBannerFragment(response.result?.andaInfoBanners!![i]))
            homeAndaInfoDatas.add(response.result?.andaInfoBanners!![i])
            Log.d("안다정보정보", response.result?.andaInfoBanners!![i].andaInfoName.toString())
        }
        for (i: Int in 0..2000){
            andaInfoBannerAdapter.addFragment(HomeAndaInfoBannerFragment(homeAndaInfoDatas[i % response.result?.andaInfoBanners!!.size]))
        }
        binding.homeAndaInfoVp.offscreenPageLimit = 1 // 몇 개의 페이지를 미리 로드 해둘것인지
        binding.homeAndaInfoVp.adapter = andaInfoBannerAdapter
        binding.homeAndaInfoVp.setCurrentItem(1000,true)
        binding.homeAndaInfoVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        Log.d("안다정보", "성공!")
        //dotsIndicator 모양 둥글게
        binding.homeAndaInfoDotsIndicator.clipToOutline = true
        binding.homeAndaInfoDotsIndicatorBackgroundIv.clipToOutline = true
        //다음 배너 미리 보기
        /* 여백, 너비에 대한 정의 */
        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin) // dimen 파일 안에 크기를 정의해두었다.
        val pagerWidth = resources.getDimensionPixelOffset(R.dimen.pageWidth) // dimen 파일이 없으면 생성해야함
        val screenWidth = resources.displayMetrics.widthPixels // 스마트폰의 너비 길이를 가져옴
        val offsetPx = screenWidth - pageMarginPx - pagerWidth

        binding.homeAndaInfoVp.setPageTransformer { page, position ->
            page.translationX = position * -offsetPx
        }
    }

    override fun onAndaInfoFailure(code: Int, message: String) {
        Log.d("안다정보", "실패!")
    }

}
