package com.anda.ui.main.home

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.anda.MainActivity
import com.anda.R
import com.anda.data.entities.HomeAndaRankingSelect
import com.anda.data.entities.HomeOphthaEvent
import com.anda.data.entities.HomeAndaRankingOphtha
import com.anda.data.entities.OphthaInfoEvent
import com.anda.databinding.FragmentHomeBinding
import com.anda.ui.main.map.MapFragment

class HomeFragment : Fragment() {

    private var isDoReviewClicked = false
    private var ophthaEventDatas = ArrayList<HomeOphthaEvent>()
    private var homeAndaRankingSelecDatas = ArrayList<HomeAndaRankingSelect>()
    val homeAndaRankingP1Datas = ArrayList<HomeAndaRankingOphtha>()
    val homeAndaRankingP2Datas = ArrayList<HomeAndaRankingOphtha>()
    val homeAndaRankingP3Datas = ArrayList<HomeAndaRankingOphtha>()
    val ophthaInfoEventList = ArrayList<OphthaInfoEvent>()

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
                currentPosition = position
            }
        })



        clickSetting()
        addAndaRankingSelect()
        addOphthaEvent()
        optionAdsBanner()
        optionAndaInfoBanner()
        optionAndaRankingOphtha()

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
        val pagerAdapter = HomeAndaRankingBannerVPAdapter(this)
        binding.homeRankingVp.adapter = pagerAdapter
        binding.homeRankingVp.setCurrentItem(1,true)
        binding.homeRankingDotsIndicator.setViewPager2(binding.homeRankingVp)

        val andaRankingBannerAdapter = HomeAndaRankingBannerVPAdapter(this)
        andaRankingBannerAdapter.addFragment(HomeAndaRankingBannerFragment(homeAndaRankingP1Datas))
        andaRankingBannerAdapter.addFragment(HomeAndaRankingBannerFragment(homeAndaRankingP2Datas))
        andaRankingBannerAdapter.addFragment(HomeAndaRankingBannerFragment(homeAndaRankingP3Datas))
        binding.homeRankingVp.adapter = andaRankingBannerAdapter
        binding.homeRankingVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL


    }

    private fun addAndaRankingOphtha() {
        addOphthaInfoEvent()
        homeAndaRankingP1Datas.apply {
            add(HomeAndaRankingOphtha("김안과병원1","서울특별시 영등포구",1, R.drawable.ophtha_ex_img, 3.5, 12, ophthaInfoEventList!!))
            add(HomeAndaRankingOphtha("김안과병원2","서울특별시 영등포구",2, R.drawable.ophtha_ex_img, 4.5, 2,ophthaInfoEventList!!))
            add(HomeAndaRankingOphtha("김안과병원3","서울특별시 영등포구",3, R.drawable.ophtha_ex_img, 5.0, 8,ophthaInfoEventList!!))
        }
        homeAndaRankingP2Datas.apply {
            add(HomeAndaRankingOphtha("김안과병원4","서울특별시 영등포구",4, R.drawable.ophtha_ex_img, 3.5, 12, ophthaInfoEventList!!))
            add(HomeAndaRankingOphtha("김안과병원5","서울특별시 영등포구",5, R.drawable.ophtha_ex_img, 4.5, 2, ophthaInfoEventList!!))
            add(HomeAndaRankingOphtha("김안과병원6","서울특별시 영등포구",6, R.drawable.ophtha_ex_img, 5.0, 8, ophthaInfoEventList!!))
        }
        homeAndaRankingP3Datas.apply {
            add(HomeAndaRankingOphtha("김안과병원7","서울특별시 영등포구",7, R.drawable.ophtha_ex_img, 3.5, 12, ophthaInfoEventList!!))
            add(HomeAndaRankingOphtha("김안과병원8","서울특별시 영등포구",8, R.drawable.ophtha_ex_img, 4.5, 2, ophthaInfoEventList!!))
            add(HomeAndaRankingOphtha("김안과병원9","서울특별시 영등포구",9, R.drawable.ophtha_ex_img, 5.0, 8, ophthaInfoEventList!!))
        }
    }

    private fun optionAdsBanner() {
        val adsBannerAdapter = HomeAdsBannerVPAdapter(this)
        adsBannerAdapter.addFragment(HomeAdsBannerFragment(R.drawable.ophtha_ex_img))
        adsBannerAdapter.addFragment(HomeAdsBannerFragment(R.drawable.ex_img))
        binding.homeAdsVp.adapter = adsBannerAdapter
        binding.homeAdsVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }
    private fun optionAndaInfoBanner() {
        //dotsIndicator
        val pagerAdapter = HomeAndaInfoBannerVPAdapter(this)
        binding.homeAndaInfoVp.adapter = pagerAdapter
        binding.homeAndaInfoVp.setCurrentItem(1,true)
        binding.homeAndaInfoDotsIndicator.setViewPager2(binding.homeAndaInfoVp)

        //다음 배너 미리 보기
        /* 여백, 너비에 대한 정의 */
        val pageMarginPx = resources.getDimensionPixelOffset(R.dimen.pageMargin) // dimen 파일 안에 크기를 정의해두었다.
        val pagerWidth = resources.getDimensionPixelOffset(R.dimen.pageWidth) // dimen 파일이 없으면 생성해야함
        val screenWidth = resources.displayMetrics.widthPixels // 스마트폰의 너비 길이를 가져옴
        val offsetPx = screenWidth - pageMarginPx - pagerWidth

        binding.homeAndaInfoVp.setPageTransformer { page, position ->
            page.translationX = position * -offsetPx
        }
        //배너 추가 및 생성
        val andaInfoBannerAdapter = HomeAndaInfoBannerVPAdapter(this)
        andaInfoBannerAdapter.itemCount
        andaInfoBannerAdapter.addFragment(HomeAndaInfoBannerFragment(R.drawable.ex_img))
        andaInfoBannerAdapter.addFragment(HomeAndaInfoBannerFragment(R.drawable.ex_img))
        andaInfoBannerAdapter.addFragment(HomeAndaInfoBannerFragment(R.drawable.ex_img))
        andaInfoBannerAdapter.addFragment(HomeAndaInfoBannerFragment(R.drawable.ex_img))
        andaInfoBannerAdapter.addFragment(HomeAndaInfoBannerFragment(R.drawable.ex_img))
        binding.homeAndaInfoVp.offscreenPageLimit = 1 // 몇 개의 페이지를 미리 로드 해둘것인지
        binding.homeAndaInfoVp.adapter = andaInfoBannerAdapter
        binding.homeAndaInfoVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
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
   private fun addOphthaInfoEvent(){
       ophthaInfoEventList.apply {
           add(OphthaInfoEvent(R.drawable.ex_img, "이벤트 이름1", "라식", "2021.02.04 ~ 2021.03.01"))
           add(
               OphthaInfoEvent(
                   R.drawable.real_ophtha_ex_img,
                   "이벤트 이름2",
                   "라섹",
                   "2021.02.04 ~ 2021.03.01"
               )
           )
           add(
               OphthaInfoEvent(
                   R.drawable.ophtha_ex_img,
                   "이벤트 이름3",
                   "기타진료",
                   "2021.02.04 ~ 2021.03.01"
               )
           )
           add(OphthaInfoEvent(R.drawable.ex_img, "이벤트 이름4", "라식", "2021.02.04 ~ 2021.03.01"))
           add(
               OphthaInfoEvent(
                   R.drawable.real_ophtha_ex_img,
                   "이벤트 이름5",
                   "라섹",
                   "2021.02.04 ~ 2021.03.01"
               )
           )
           add(OphthaInfoEvent(R.drawable.ophtha_ex_img, "이벤트 이름6", "백내장"))
           add(OphthaInfoEvent(R.drawable.ex_img, "이벤트 이름7", "라식", "2021.02.04 ~ 2021.03.01"))
           add(OphthaInfoEvent(R.drawable.real_ophtha_ex_img, "이벤트 이름8", "라섹"))
           add(OphthaInfoEvent(R.drawable.ophtha_ex_img, "이벤트 이름9", "기타진료"))
           add(OphthaInfoEvent(R.drawable.ex_img, "이벤트 이름10", "라식", "2021.02.04 ~ 2021.03.01"))
           add(OphthaInfoEvent(R.drawable.real_ophtha_ex_img, "이벤트 이름11", "라섹"))
           add(OphthaInfoEvent(R.drawable.ophtha_ex_img, "이벤트 이름12", "스마일라식"))
           add(OphthaInfoEvent(R.drawable.ex_img, "이벤트 이름13", "라식"))
           add(
               OphthaInfoEvent(
                   R.drawable.real_ophtha_ex_img,
                   "이벤트 이름14",
                   "라섹",
                   "2021.02.04 ~ 2021.03.01"
               )
           )
           add(OphthaInfoEvent(R.drawable.ophtha_ex_img, "이벤트 이름15", "기타진료"))
           add(OphthaInfoEvent(R.drawable.ex_img, "이벤트 이름16", "라식"))
           add(
               OphthaInfoEvent(
                   R.drawable.real_ophtha_ex_img,
                   "이벤트 이름17",
                   "백내장",
                   "2021.02.04 ~ 2021.03.01"
               )
           )
           add(OphthaInfoEvent(R.drawable.ophtha_ex_img, "이벤트 이름18", "백내장"))
           add(OphthaInfoEvent(R.drawable.ex_img, "이벤트 이름19", "렌즈삽입술", "2021.02.04 ~ 2021.03.01"))
           add(OphthaInfoEvent(R.drawable.real_ophtha_ex_img, "이벤트 이름20", "라섹"))
           add(
               OphthaInfoEvent(
                   R.drawable.ophtha_ex_img,
                   "이벤트 이름21",
                   "기타진료",
                   "2021.02.04 ~ 2021.03.01"
               )
           )
           add(OphthaInfoEvent(R.drawable.ex_img, "이벤트 이름22", "라식", "2021.02.04 ~ 2021.03.01"))
           add(
               OphthaInfoEvent(
                   R.drawable.real_ophtha_ex_img,
                   "이벤트 이름23",
                   "라섹",
                   "2021.02.04 ~ 2021.03.01"
               )
           )
           add(OphthaInfoEvent(R.drawable.ophtha_ex_img, "이벤트 이름24", "기타진료"))
       }
   }
    private fun addOphthaEvent() {
        ophthaEventDatas.apply {
            add(
                HomeOphthaEvent(
                    "김안과병원",
                    "서울특별시 영등포구",
                    R.drawable.ophtha_ex_img,
                    "라식 할인"
                )
            )
            add(
                HomeOphthaEvent(
                    "안다 병원",
                    "서울특별시 마포구",
                    R.drawable.ophtha_ex_img,
                    "라섹 할인"
                )
            )
            add(
                HomeOphthaEvent(
                    "모른다 병원",
                    "서울특별시 광진구",
                    R.drawable.ophtha_ex_img,
                    "스마일 라식 무료"
                )
            )
            add(
                HomeOphthaEvent(
                    "알지도 병원",
                    "서울특별시 관악구",
                    R.drawable.ophtha_ex_img,
                    "전부 다 할인"
                )
            )
            add(
                HomeOphthaEvent(
                    "알아라 병원",
                    "서울특별시 광진구",
                    R.drawable.ophtha_ex_img,
                    "이것만 무료"
                )
            )
        }
        val ophthaEventRVAdapter = HomeOphthaEventRVAdapter(ophthaEventDatas)
        binding.homeEventRv.adapter = ophthaEventRVAdapter
        binding.homeEventRv.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
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
                .replace(R.id.nav_host_fragment_container, MapFragment())
                .commitAllowingStateLoss()
        }
    }
}