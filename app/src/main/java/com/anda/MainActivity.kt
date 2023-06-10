package com.anda

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.anda.data.entities.CompareSortSelectedOption
import com.anda.databinding.ActivityMainBinding
import com.anda.ui.main.compare.CompareFragment
import com.anda.ui.main.home.HomeFragment
import com.anda.ui.main.management.after.ManagementAfterOperationFragment
import com.anda.ui.main.management.before.ManagementBeforeOperationFragment
import com.anda.ui.main.myInfo.MyInfoFragment
import com.anda.ui.write_review.WriteReview1Fragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var checkReviewSharedPreferences: SharedPreferences

    //안과 데이터
    private lateinit var ophthaSharedPreferences1_lasik : SharedPreferences
    private lateinit var ophthaSharedPreferences1_lasik_review1 : SharedPreferences
    private lateinit var ophthaSharedPreferences1_lasik_review2 : SharedPreferences
    private lateinit var ophthaSharedPreferences1_lasik_review3 : SharedPreferences
    private lateinit var ophthaSharedPreferences1_lasik_review4 : SharedPreferences
    private lateinit var ophthaSharedPreferences1_lasik_review5 : SharedPreferences
    private lateinit var ophthaSharedPreferences1_lasik_review6 : SharedPreferences
    private lateinit var ophthaSharedPreferences7_lasik : SharedPreferences
    private lateinit var ophthaSharedPreferences7_lasik_review1 : SharedPreferences
    private lateinit var ophthaSharedPreferences7_lasik_review2 : SharedPreferences
    private lateinit var ophthaSharedPreferences7_lasik_review3 : SharedPreferences
    private lateinit var ophthaSharedPreferences7_lasik_review4 : SharedPreferences
    private lateinit var ophthaSharedPreferences12_lasik: SharedPreferences
    private lateinit var ophthaSharedPreferences12_lasik_review1 : SharedPreferences
    private lateinit var ophthaSharedPreferences12_lasik_review2 : SharedPreferences
    private lateinit var ophthaSharedPreferences12_lasik_review3 : SharedPreferences
    private lateinit var ophthaSharedPreferences12_lasik_review4 : SharedPreferences
    private lateinit var ophthaSharedPreferences17_lasik: SharedPreferences
    private lateinit var ophthaSharedPreferences17_lasik_review1 : SharedPreferences
    private lateinit var ophthaSharedPreferences17_lasik_review2 : SharedPreferences
    private lateinit var ophthaSharedPreferences17_lasik_review3 : SharedPreferences
    private lateinit var ophthaSharedPreferences17_lasik_review4 : SharedPreferences

    private lateinit var ophthaSharedPreferences2_lasek : SharedPreferences
    private lateinit var ophthaSharedPreferences2_lasek_review1 : SharedPreferences
    private lateinit var ophthaSharedPreferences2_lasek_review2 : SharedPreferences
    private lateinit var ophthaSharedPreferences2_lasek_review3 : SharedPreferences
    private lateinit var ophthaSharedPreferences8_lasek : SharedPreferences
    private lateinit var ophthaSharedPreferences8_lasek_review1 : SharedPreferences
    private lateinit var ophthaSharedPreferences8_lasek_review2 : SharedPreferences
    private lateinit var ophthaSharedPreferences8_lasek_review3 : SharedPreferences
    private lateinit var ophthaSharedPreferences13_lasek : SharedPreferences
    private lateinit var ophthaSharedPreferences13_lasek_review1 : SharedPreferences
    private lateinit var ophthaSharedPreferences13_lasek_review2 : SharedPreferences
    private lateinit var ophthaSharedPreferences13_lasek_review3 : SharedPreferences
    private lateinit var ophthaSharedPreferences13_lasek_review4 : SharedPreferences
    private lateinit var ophthaSharedPreferences13_lasek_review5 : SharedPreferences
    private lateinit var ophthaSharedPreferences18_lasek : SharedPreferences
    private lateinit var ophthaSharedPreferences18_lasek_review1 : SharedPreferences
    private lateinit var ophthaSharedPreferences18_lasek_review2 : SharedPreferences
    private lateinit var ophthaSharedPreferences18_lasek_review3 : SharedPreferences
    private lateinit var ophthaSharedPreferences18_lasek_review4 : SharedPreferences

    private lateinit var ophthaSharedPreferences3_smile: SharedPreferences
    private lateinit var ophthaSharedPreferences3_smile_review1: SharedPreferences
    private lateinit var ophthaSharedPreferences3_smile_review2: SharedPreferences
    private lateinit var ophthaSharedPreferences3_smile_review3: SharedPreferences
    private lateinit var ophthaSharedPreferences3_smile_review4: SharedPreferences
    private lateinit var ophthaSharedPreferences3_smile_review5: SharedPreferences
    private lateinit var ophthaSharedPreferences3_smile_review6: SharedPreferences
    private lateinit var ophthaSharedPreferences3_smile_review7: SharedPreferences
    private lateinit var ophthaSharedPreferences9_smile: SharedPreferences
    private lateinit var ophthaSharedPreferences9_smile_review1: SharedPreferences
    private lateinit var ophthaSharedPreferences9_smile_review2: SharedPreferences
    private lateinit var ophthaSharedPreferences9_smile_review3: SharedPreferences
    private lateinit var ophthaSharedPreferences9_smile_review4: SharedPreferences
    private lateinit var ophthaSharedPreferences14_smile: SharedPreferences
    private lateinit var ophthaSharedPreferences14_smile_review1: SharedPreferences
    private lateinit var ophthaSharedPreferences14_smile_review2: SharedPreferences
    private lateinit var ophthaSharedPreferences14_smile_review3: SharedPreferences
    private lateinit var ophthaSharedPreferences14_smile_review4: SharedPreferences
    private lateinit var ophthaSharedPreferences14_smile_review5: SharedPreferences
    private lateinit var ophthaSharedPreferences19_smile: SharedPreferences
    private lateinit var ophthaSharedPreferences19_smile_review1: SharedPreferences
    private lateinit var ophthaSharedPreferences19_smile_review2: SharedPreferences
    private lateinit var ophthaSharedPreferences19_smile_review3: SharedPreferences
    private lateinit var ophthaSharedPreferences19_smile_review4: SharedPreferences

    private lateinit var ophthaSharedPreferences4_today: SharedPreferences
    private lateinit var ophthaSharedPreferences4_today_review1: SharedPreferences
    private lateinit var ophthaSharedPreferences4_today_review2: SharedPreferences
    private lateinit var ophthaSharedPreferences4_today_review3: SharedPreferences
    private lateinit var ophthaSharedPreferences4_today_review4: SharedPreferences
    private lateinit var ophthaSharedPreferences4_today_review5: SharedPreferences
    private lateinit var ophthaSharedPreferences10_today: SharedPreferences
    private lateinit var ophthaSharedPreferences10_today_review1: SharedPreferences
    private lateinit var ophthaSharedPreferences10_today_review2: SharedPreferences
    private lateinit var ophthaSharedPreferences10_today_review3: SharedPreferences
    private lateinit var ophthaSharedPreferences10_today_review4: SharedPreferences
    private lateinit var ophthaSharedPreferences15_today: SharedPreferences
    private lateinit var ophthaSharedPreferences15_today_review1: SharedPreferences
    private lateinit var ophthaSharedPreferences15_today_review2: SharedPreferences
    private lateinit var ophthaSharedPreferences15_today_review3: SharedPreferences
    private lateinit var ophthaSharedPreferences20_today: SharedPreferences
    private lateinit var ophthaSharedPreferences20_today_review1: SharedPreferences
    private lateinit var ophthaSharedPreferences20_today_review2: SharedPreferences
    private lateinit var ophthaSharedPreferences20_today_review3: SharedPreferences
    private lateinit var ophthaSharedPreferences20_today_review4: SharedPreferences
    private lateinit var ophthaSharedPreferences20_today_review5: SharedPreferences

    private lateinit var ophthaSharedPreferences5_lens: SharedPreferences
    private lateinit var ophthaSharedPreferences5_lens_review1: SharedPreferences
    private lateinit var ophthaSharedPreferences5_lens_review2: SharedPreferences
    private lateinit var ophthaSharedPreferences5_lens_review3: SharedPreferences
    private lateinit var ophthaSharedPreferences5_lens_review4: SharedPreferences
    private lateinit var ophthaSharedPreferences5_lens_review5: SharedPreferences
    private lateinit var ophthaSharedPreferences5_lens_review6: SharedPreferences
    private lateinit var ophthaSharedPreferences11_lens: SharedPreferences
    private lateinit var ophthaSharedPreferences11_lens_review1: SharedPreferences
    private lateinit var ophthaSharedPreferences11_lens_review2: SharedPreferences
    private lateinit var ophthaSharedPreferences11_lens_review3: SharedPreferences
    private lateinit var ophthaSharedPreferences11_lens_review4: SharedPreferences
    private lateinit var ophthaSharedPreferences11_lens_review5: SharedPreferences
    private lateinit var ophthaSharedPreferences16_lens: SharedPreferences
    private lateinit var ophthaSharedPreferences16_lens_review1: SharedPreferences
    private lateinit var ophthaSharedPreferences16_lens_review2: SharedPreferences
    private lateinit var ophthaSharedPreferences16_lens_review3: SharedPreferences
    private lateinit var ophthaSharedPreferences16_lens_review4: SharedPreferences

    private lateinit var ophthaSharedPreferences6_back: SharedPreferences
    private lateinit var ophthaSharedPreferences6_back_review1: SharedPreferences
    private lateinit var ophthaSharedPreferences6_back_review2: SharedPreferences
    private lateinit var ophthaSharedPreferences6_back_review3: SharedPreferences
    private lateinit var ophthaSharedPreferences6_back_review4: SharedPreferences


    private var isReviewRegistered = false

    public var compareSortSelectedLocation = arrayListOf<String>("강남구")
    public var compareSortSelectedOption = CompareSortSelectedOption("라식", "별점순", compareSortSelectedLocation)
    public var homeSelectLocation = arrayListOf<String>("강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // SharedPreferences 인스턴스 초기화
        checkReviewSharedPreferences = getSharedPreferences("UserInfo", MODE_PRIVATE)

        ophthaSharedPreferences1_lasik = getSharedPreferences("Ophtha1", MODE_PRIVATE)
        ophthaSharedPreferences2_lasek = getSharedPreferences("Ophtha2", MODE_PRIVATE)
        ophthaSharedPreferences3_smile = getSharedPreferences("Ophtha3", MODE_PRIVATE)
        ophthaSharedPreferences4_today = getSharedPreferences("Ophtha4", MODE_PRIVATE)
        ophthaSharedPreferences5_lens = getSharedPreferences("Ophtha5", MODE_PRIVATE)
        ophthaSharedPreferences6_back = getSharedPreferences("Ophtha6", MODE_PRIVATE)
        ophthaSharedPreferences7_lasik = getSharedPreferences("Ophtha7", MODE_PRIVATE)
        ophthaSharedPreferences8_lasek = getSharedPreferences("Ophtha8", MODE_PRIVATE)
        ophthaSharedPreferences9_smile = getSharedPreferences("Ophtha9", MODE_PRIVATE)
        ophthaSharedPreferences10_today = getSharedPreferences("Ophtha10", MODE_PRIVATE)
        ophthaSharedPreferences11_lens = getSharedPreferences("Ophtha11", MODE_PRIVATE)
        ophthaSharedPreferences12_lasik = getSharedPreferences("Ophtha12", MODE_PRIVATE)
        ophthaSharedPreferences13_lasek = getSharedPreferences("Ophtha13", MODE_PRIVATE)
        ophthaSharedPreferences14_smile = getSharedPreferences("Ophtha14", MODE_PRIVATE)
        ophthaSharedPreferences15_today = getSharedPreferences("Ophtha15", MODE_PRIVATE)
        ophthaSharedPreferences16_lens = getSharedPreferences("Ophtha16", MODE_PRIVATE)
        ophthaSharedPreferences17_lasik = getSharedPreferences("Ophtha17", MODE_PRIVATE)
        ophthaSharedPreferences18_lasek = getSharedPreferences("Ophtha18", MODE_PRIVATE)
        ophthaSharedPreferences19_smile = getSharedPreferences("Ophtha19", MODE_PRIVATE)
        ophthaSharedPreferences20_today = getSharedPreferences("Ophtha20", MODE_PRIVATE)

        ophthaSharedPreferences1_lasik_review1 = getSharedPreferences("Ophtha1_review1", MODE_PRIVATE)
        ophthaSharedPreferences1_lasik_review2 = getSharedPreferences("Ophtha1_review2", MODE_PRIVATE)
        ophthaSharedPreferences1_lasik_review3 = getSharedPreferences("Ophtha1_review3", MODE_PRIVATE)
        ophthaSharedPreferences1_lasik_review4 = getSharedPreferences("Ophtha1_review4", MODE_PRIVATE)
        ophthaSharedPreferences1_lasik_review5 = getSharedPreferences("Ophtha1_review5", MODE_PRIVATE)
        ophthaSharedPreferences1_lasik_review6 = getSharedPreferences("Ophtha1_review6", MODE_PRIVATE)

        ophthaSharedPreferences7_lasik_review1 = getSharedPreferences("Ophtha7_review1", MODE_PRIVATE)
        ophthaSharedPreferences7_lasik_review2 = getSharedPreferences("Ophtha7_review2", MODE_PRIVATE)
        ophthaSharedPreferences7_lasik_review3 = getSharedPreferences("Ophtha7_review3", MODE_PRIVATE)
        ophthaSharedPreferences7_lasik_review4 = getSharedPreferences("Ophtha7_review4", MODE_PRIVATE)

        ophthaSharedPreferences12_lasik_review1 = getSharedPreferences("Ophtha12_review1", MODE_PRIVATE)
        ophthaSharedPreferences12_lasik_review2 = getSharedPreferences("Ophtha12_review2", MODE_PRIVATE)
        ophthaSharedPreferences12_lasik_review3 = getSharedPreferences("Ophtha12_review3", MODE_PRIVATE)
        ophthaSharedPreferences12_lasik_review4 = getSharedPreferences("Ophtha12_review4", MODE_PRIVATE)

        ophthaSharedPreferences17_lasik_review1 = getSharedPreferences("Ophtha17_review1", MODE_PRIVATE)
        ophthaSharedPreferences17_lasik_review2 = getSharedPreferences("Ophtha17_review2", MODE_PRIVATE)
        ophthaSharedPreferences17_lasik_review3 = getSharedPreferences("Ophtha17_review3", MODE_PRIVATE)
        ophthaSharedPreferences17_lasik_review4 = getSharedPreferences("Ophtha17_review4", MODE_PRIVATE)

        ophthaSharedPreferences2_lasek_review1 = getSharedPreferences("Ophtha2_review1", MODE_PRIVATE)
        ophthaSharedPreferences2_lasek_review2 = getSharedPreferences("Ophtha2_review2", MODE_PRIVATE)
        ophthaSharedPreferences2_lasek_review3 = getSharedPreferences("Ophtha2_review3", MODE_PRIVATE)

        ophthaSharedPreferences8_lasek_review1 = getSharedPreferences("Ophtha8_review1", MODE_PRIVATE)
        ophthaSharedPreferences8_lasek_review2 = getSharedPreferences("Ophtha8_review2", MODE_PRIVATE)
        ophthaSharedPreferences8_lasek_review3 = getSharedPreferences("Ophtha8_review3", MODE_PRIVATE)

        ophthaSharedPreferences13_lasek_review1 = getSharedPreferences("Ophtha13_review1", MODE_PRIVATE)
        ophthaSharedPreferences13_lasek_review2 = getSharedPreferences("Ophtha13_review2", MODE_PRIVATE)
        ophthaSharedPreferences13_lasek_review3 = getSharedPreferences("Ophtha13_review3", MODE_PRIVATE)
        ophthaSharedPreferences13_lasek_review4 = getSharedPreferences("Ophtha13_review4", MODE_PRIVATE)
        ophthaSharedPreferences13_lasek_review5 = getSharedPreferences("Ophtha13_review5", MODE_PRIVATE)

        ophthaSharedPreferences18_lasek_review1 = getSharedPreferences("Ophtha18_review1", MODE_PRIVATE)
        ophthaSharedPreferences18_lasek_review2 = getSharedPreferences("Ophtha18_review2", MODE_PRIVATE)
        ophthaSharedPreferences18_lasek_review3 = getSharedPreferences("Ophtha18_review3", MODE_PRIVATE)
        ophthaSharedPreferences18_lasek_review4 = getSharedPreferences("Ophtha18_review4", MODE_PRIVATE)

        ophthaSharedPreferences3_smile_review1 = getSharedPreferences("Ophtha3_review1", MODE_PRIVATE)
        ophthaSharedPreferences3_smile_review2 = getSharedPreferences("Ophtha3_review2", MODE_PRIVATE)
        ophthaSharedPreferences3_smile_review3 = getSharedPreferences("Ophtha3_review3", MODE_PRIVATE)
        ophthaSharedPreferences3_smile_review4 = getSharedPreferences("Ophtha3_review4", MODE_PRIVATE)
        ophthaSharedPreferences3_smile_review5 = getSharedPreferences("Ophtha3_review5", MODE_PRIVATE)
        ophthaSharedPreferences3_smile_review6 = getSharedPreferences("Ophtha3_review6", MODE_PRIVATE)
        ophthaSharedPreferences3_smile_review7 = getSharedPreferences("Ophtha3_review7", MODE_PRIVATE)

        ophthaSharedPreferences9_smile_review1 = getSharedPreferences("Ophtha9_review1", MODE_PRIVATE)
        ophthaSharedPreferences9_smile_review2 = getSharedPreferences("Ophtha9_review2", MODE_PRIVATE)
        ophthaSharedPreferences9_smile_review3 = getSharedPreferences("Ophtha9_review3", MODE_PRIVATE)
        ophthaSharedPreferences9_smile_review4 = getSharedPreferences("Ophtha9_review4", MODE_PRIVATE)

        ophthaSharedPreferences14_smile_review1 = getSharedPreferences("Ophtha14_review1", MODE_PRIVATE)
        ophthaSharedPreferences14_smile_review2 = getSharedPreferences("Ophtha14_review2", MODE_PRIVATE)
        ophthaSharedPreferences14_smile_review3 = getSharedPreferences("Ophtha14_review3", MODE_PRIVATE)
        ophthaSharedPreferences14_smile_review4 = getSharedPreferences("Ophtha14_review4", MODE_PRIVATE)
        ophthaSharedPreferences14_smile_review5 = getSharedPreferences("Ophtha14_review5", MODE_PRIVATE)

        ophthaSharedPreferences19_smile_review1 = getSharedPreferences("Ophtha19_review1", MODE_PRIVATE)
        ophthaSharedPreferences19_smile_review2 = getSharedPreferences("Ophtha19_review2", MODE_PRIVATE)
        ophthaSharedPreferences19_smile_review3 = getSharedPreferences("Ophtha19_review3", MODE_PRIVATE)
        ophthaSharedPreferences19_smile_review4 = getSharedPreferences("Ophtha19_review4", MODE_PRIVATE)

        ophthaSharedPreferences4_today_review1 = getSharedPreferences("Ophtha4_review1", MODE_PRIVATE)
        ophthaSharedPreferences4_today_review2 = getSharedPreferences("Ophtha4_review2", MODE_PRIVATE)
        ophthaSharedPreferences4_today_review3 = getSharedPreferences("Ophtha4_review3", MODE_PRIVATE)
        ophthaSharedPreferences4_today_review4 = getSharedPreferences("Ophtha4_review4", MODE_PRIVATE)
        ophthaSharedPreferences4_today_review5 = getSharedPreferences("Ophtha4_review5", MODE_PRIVATE)

        ophthaSharedPreferences10_today_review1 = getSharedPreferences("Ophtha10_review1", MODE_PRIVATE)
        ophthaSharedPreferences10_today_review2 = getSharedPreferences("Ophtha10_review2", MODE_PRIVATE)
        ophthaSharedPreferences10_today_review3 = getSharedPreferences("Ophtha10_review3", MODE_PRIVATE)
        ophthaSharedPreferences10_today_review4 = getSharedPreferences("Ophtha10_review4", MODE_PRIVATE)

        ophthaSharedPreferences15_today_review1 = getSharedPreferences("Ophtha15_review1", MODE_PRIVATE)
        ophthaSharedPreferences15_today_review2 = getSharedPreferences("Ophtha15_review2", MODE_PRIVATE)
        ophthaSharedPreferences15_today_review3 = getSharedPreferences("Ophtha15_review3", MODE_PRIVATE)

        ophthaSharedPreferences20_today_review1 = getSharedPreferences("Ophtha20_review1", MODE_PRIVATE)
        ophthaSharedPreferences20_today_review2 = getSharedPreferences("Ophtha20_review2", MODE_PRIVATE)
        ophthaSharedPreferences20_today_review3 = getSharedPreferences("Ophtha20_review3", MODE_PRIVATE)
        ophthaSharedPreferences20_today_review4 = getSharedPreferences("Ophtha20_review4", MODE_PRIVATE)
        ophthaSharedPreferences20_today_review5 = getSharedPreferences("Ophtha20_review5", MODE_PRIVATE)

        ophthaSharedPreferences5_lens_review1 = getSharedPreferences("Ophtha5_review1", MODE_PRIVATE)
        ophthaSharedPreferences5_lens_review2 = getSharedPreferences("Ophtha5_review2", MODE_PRIVATE)
        ophthaSharedPreferences5_lens_review3 = getSharedPreferences("Ophtha5_review3", MODE_PRIVATE)
        ophthaSharedPreferences5_lens_review4 = getSharedPreferences("Ophtha5_review4", MODE_PRIVATE)
        ophthaSharedPreferences5_lens_review5 = getSharedPreferences("Ophtha5_review5", MODE_PRIVATE)
        ophthaSharedPreferences5_lens_review6 = getSharedPreferences("Ophtha5_review6", MODE_PRIVATE)

        ophthaSharedPreferences11_lens_review1 = getSharedPreferences("Ophtha11_review1", MODE_PRIVATE)
        ophthaSharedPreferences11_lens_review2 = getSharedPreferences("Ophtha11_review2", MODE_PRIVATE)
        ophthaSharedPreferences11_lens_review3 = getSharedPreferences("Ophtha11_review3", MODE_PRIVATE)
        ophthaSharedPreferences11_lens_review4 = getSharedPreferences("Ophtha11_review4", MODE_PRIVATE)
        ophthaSharedPreferences11_lens_review5 = getSharedPreferences("Ophtha11_review5", MODE_PRIVATE)

        ophthaSharedPreferences16_lens_review1 = getSharedPreferences("Ophtha16_review1", MODE_PRIVATE)
        ophthaSharedPreferences16_lens_review2 = getSharedPreferences("Ophtha16_review2", MODE_PRIVATE)
        ophthaSharedPreferences16_lens_review3 = getSharedPreferences("Ophtha16_review3", MODE_PRIVATE)
        ophthaSharedPreferences16_lens_review4 = getSharedPreferences("Ophtha16_review4", MODE_PRIVATE)

        ophthaSharedPreferences6_back_review1 = getSharedPreferences("Ophtha6_review1", MODE_PRIVATE)
        ophthaSharedPreferences6_back_review2 = getSharedPreferences("Ophtha6_review2", MODE_PRIVATE)
        ophthaSharedPreferences6_back_review3 = getSharedPreferences("Ophtha6_review3", MODE_PRIVATE)
        ophthaSharedPreferences6_back_review4 = getSharedPreferences("Ophtha6_review4", MODE_PRIVATE)



        setOphtha()


        // 저장된 리뷰 작성 여부 불러오기
        checkIsReview()
        initBottomNavigation()
    }

    private fun setOphtha() {

        setReviews()

    }

    private fun setReviews() {
        var totalAvg :Float = 0f

        // ophthaSharedPreferences1
        // ophthaSharedPreferences1_lasik_review1
        ophthaSharedPreferences1_lasik_review1.edit()
            .putString("nickName", "환불불가")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 0)
            .putInt("ratingInformation", 2)
            .putInt("ratingPrice", 1)
            .putInt("totalRating", 5)
            .putInt("price", 120)
            .putString("review", "마취안약? 넣고 대기후 3분정도 뒤에 수술이 끝났어요")
            .apply()
        // ophthaSharedPreferences1_lasik_review2
        ophthaSharedPreferences1_lasik_review2.edit()
            .putString("nickName", "딸기슈크림라떼")
            .putInt("ratingKindness", 2)
            .putInt("ratingWaitingTime", 0)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 1)
            .putInt("totalRating", 6)
            .putInt("price", 100)
            .putString("review", "좋았어요!")
            .apply()
        // ophthaSharedPreferences1_lasik_review3
        ophthaSharedPreferences1_lasik_review3.edit()
            .putString("nickName", "형광펜요")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 2)
            .putInt("ratingEffect", 1)
            .putInt("ratingInformation", 2)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 8)
            .putInt("price", 70)
            .putString("review", "의사쌤 최고!")
            .apply()
        // ophthaSharedPreferences1_lasik_review4
        ophthaSharedPreferences1_lasik_review4.edit()
            .putString("nickName", "드르렁졸려")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 1)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 0)
            .putInt("totalRating", 4)
            .putInt("price", 140)
            .putString("review", "별로 아프지않았고 수술할때 솔직히 의사선생님이 좀 불친절했음 하지만 결과가 좋으니 대만족")
            .apply()
        // ophthaSharedPreferences1_lasik_review5
        ophthaSharedPreferences1_lasik_review5.edit()
            .putString("nickName", "화굥이")
            .putInt("ratingKindness", 2)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 1)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 7)
            .putInt("price", 70)
            .putString("review", "나뭇잎이 하나하나 분리되어 있다는 걸 새삼 느꼈고 밤하늘의 별이 그렇게 많다는 것을 알게되었어요")
            .apply()
        // ophthaSharedPreferences1_lasik_review6
        ophthaSharedPreferences1_lasik_review6.edit()
            .putString("nickName", "괴로운유유")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 0)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 2)
            .putInt("ratingPrice", 1)
            .putInt("totalRating", 6)
            .putInt("price", 80)
            .putString("review", "아주 만족해요! 다만 수술 정보를 더 자세히 알려면 따로 노력해서 번거로웠어요")
            .apply()
        totalAvg = (5+6+8+4+7+6) / 6f
        ophthaSharedPreferences1_lasik.edit().putFloat("totalRating",totalAvg.toFloat()).apply()
        ophthaSharedPreferences1_lasik.edit().putInt("img",R.drawable.ophtha_ex_img).apply()
        ophthaSharedPreferences1_lasik.edit().putInt("reviwCnt",6).apply()
        ophthaSharedPreferences1_lasik.edit().putString("id","1").apply()
        ophthaSharedPreferences1_lasik.edit().putString("operation","lasik").apply()
        ophthaSharedPreferences1_lasik.edit().putString("name","천리안 안과").apply()

        // ophthaSharedPreferences7
        // ophthaSharedPreferences7_lasik_review1
        ophthaSharedPreferences7_lasik_review1.edit()
            .putString("nickName", "다징")
            .putInt("ratingKindness", 2)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 1)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 0)
            .putInt("totalRating", 5)
            .putInt("price", 90)
            .putString("review", "마취안약? 넣고 대기후 3분정도 뒤에 수술이 끝났어요")
            .apply()
        // ophthaSharedPreferences7_lasik_review2
        ophthaSharedPreferences7_lasik_review2.edit()
            .putString("nickName", "보자")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 2)
            .putInt("ratingEffect", 1)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 1)
            .putInt("totalRating", 6)
            .putInt("price", 79)
            .putString("review", "마취안약? 넣고 대기후 3분정도 뒤에 수술이 끝났어요")
            .apply()
        // ophthaSharedPreferences7_lasik_review3
        ophthaSharedPreferences7_lasik_review3.edit()
            .putString("nickName", "박차")
            .putInt("ratingKindness", 2)
            .putInt("ratingWaitingTime", 2)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 2)
            .putInt("ratingPrice", 1)
            .putInt("totalRating", 9)
            .putInt("price", 110)
            .putString("review", "짱좋음. 세상을 렌즈를 통해서가 아닌 내 눈으로 직접 접할 수 있다는게 얼마나 큰 축복인지 시력 좋게 태어난 사람들은 절대 모르지. 근데 제가받은 수술은 무통라섹인지 뭔지 해서 하나도 안아프긴 했는데 수술후에 6개월동안 안압약이랑 무슨 안약 넣고 매달 병원가서 시력검사받고 귀찮긴했음. 그래도 세상 공기를 내 각막으로 직접 느낀다는게 얼마나 감사한 일인데. 현대기술 짱짱.")
            .apply()
        // ophthaSharedPreferences7_lasik_review4
        ophthaSharedPreferences7_lasik_review4.edit()
            .putString("nickName", "가톨리시즘")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 1)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 1)
            .putInt("totalRating", 5)
            .putInt("price", 120)
            .putString("review", "눈이 잘 보이고 회복이 짧았으며 확실히 난시는 교정되지 않음")
            .apply()
        totalAvg = (5+6+9+5) / 4f
        ophthaSharedPreferences7_lasik.edit().putFloat("totalRating",totalAvg.toFloat()).apply()
        ophthaSharedPreferences7_lasik.edit().putInt("img", R.drawable.ophtha_ex_img7).apply()
        ophthaSharedPreferences7_lasik.edit().putInt("reviwCnt", 4).apply()
        ophthaSharedPreferences7_lasik.edit().putString("id","7").apply()
        ophthaSharedPreferences7_lasik.edit().putString("operation","lasik").apply()
        ophthaSharedPreferences7_lasik.edit().putString("name","누리 안과").apply()

        // ophthaSharedPreferences12
        // ophthaSharedPreferences12_lasik_review1
        ophthaSharedPreferences12_lasik_review1.edit()
            .putString("nickName", "사브로민화물")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 6)
            .putInt("price", 90)
            .putString("review", "완전 좋았습니다!")
            .apply()
        // ophthaSharedPreferences12_lasik_review2
        ophthaSharedPreferences12_lasik_review2.edit()
            .putString("nickName", "큰멋쟁이나비")
            .putInt("ratingKindness", 0)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 6)
            .putInt("price", 78)
            .putString("review", "마취안약? 넣고 대기후 3분정도 뒤에 수술이 끝났어요")
            .apply()
        // ophthaSharedPreferences12_lasik_review3
        ophthaSharedPreferences12_lasik_review3.edit()
            .putString("nickName", "크앰")
            .putInt("ratingKindness", 2)
            .putInt("ratingWaitingTime", 2)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 9)
            .putInt("price", 70)
            .putString("review", "당일 진료받고 바로 수술했는데, 친절하게 상담해주셔서 좋았습니다.!" +
                    "스마일라식 후, 첫날에만 뿌옇게 잘 보이지 않았고 다음날부터 잘 보이기 시작했어요. 다만 건조증이 조금 심해서 인공눈물을 자주 넣었습니다.")
            .apply()
        // ophthaSharedPreferences12_lasik_review4
        ophthaSharedPreferences12_lasik_review4.edit()
            .putString("nickName", "딕욤")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 7)
            .putInt("price", 85)
            .putString("review", "완전 짱!")
            .apply()
        totalAvg = (6+6+9+7) / 4f
        ophthaSharedPreferences12_lasik.edit().putFloat("totalRating",totalAvg.toFloat()).apply()
        ophthaSharedPreferences12_lasik.edit().putInt("img",R.drawable.ophtha_ex_img12).apply()
        ophthaSharedPreferences12_lasik.edit().putInt("reviwCnt",4).apply()
        ophthaSharedPreferences12_lasik.edit().putString("id","12").apply()
        ophthaSharedPreferences12_lasik.edit().putString("operation","lasik").apply()
        ophthaSharedPreferences12_lasik.edit().putString("name","제일 안과").apply()

        // ophthaSharedPreferences17
        // ophthaSharedPreferences17_lasik_review1
        ophthaSharedPreferences17_lasik_review1.edit()
            .putString("nickName", "브롬크레졸자홍")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 6)
            .putInt("price", 80)
            .putString("review", "수술할때 조금 아팠다 수술 후 회복은 하루정도 걸렸다")
            .apply()
        // ophthaSharedPreferences17_lasik_review2
        ophthaSharedPreferences17_lasik_review2.edit()
            .putString("nickName", "모나르키아니즘")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 7)
            .putInt("price", 90)
            .putString("review", "완전 좋았습니다!")
            .apply()
        // ophthaSharedPreferences17_lasik_review3
        ophthaSharedPreferences17_lasik_review3.edit()
            .putString("nickName", "퓸겟죽")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 2)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 8)
            .putInt("price", 100)
            .putString("review", "대기시간은 정말 길고 수술은 정말 짧아요 너무 친절하고 회복이 빨라 넘 잘보였습니당\n")
            .apply()
        // ophthaSharedPreferences17_lasik_review4
        ophthaSharedPreferences17_lasik_review4.edit()
            .putString("nickName", "꼭쳅신")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 0)
            .putInt("totalRating", 4)
            .putInt("price", 120)
            .putString("review", "사람마다 다르겠지만 하루는 잠을 못 잘정도의 통증이 있었음\n")
            .apply()
        totalAvg = (6+7+8+4) / 4f
        ophthaSharedPreferences17_lasik.edit().putFloat("totalRating",totalAvg.toFloat()).apply()
        ophthaSharedPreferences17_lasik.edit().putInt("img",R.drawable.ophtha_ex_img17).apply()
        ophthaSharedPreferences17_lasik.edit().putInt("reviwCnt",4).apply()
        ophthaSharedPreferences17_lasik.edit().putString("id", "17").apply()
        ophthaSharedPreferences17_lasik.edit().putString("operation", "lasik").apply()
        ophthaSharedPreferences17_lasik.edit().putString("name", "가나다 안과").apply()

        // ophthaSharedPreferences2
        // ophthaSharedPreferences2_lasek_review1
        ophthaSharedPreferences2_lasek_review1.edit()
            .putString("nickName", "인형술사")
            .putInt("ratingKindness", 0)
            .putInt("ratingWaitingTime", 2)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 6)
            .putInt("price", 100)
            .putString("review", "수술받는데 마취 안약 제대로 안넣었으면서 아프다니까 움직이지 말라고함. 아니 환자가 아프다는데.. 왜 의사 본인이 짜증을 내는지 모르겠음.\n" +
                    "그리고 병원자체가 눈알공장느낌 물씬.\n" +
                    "그래도 병원이 체계가 잘 잡혀있는것같아서 좋았음.\n" +
                    "수술후 눈이 건조하여 뿌옇게 보이는 부작용이 있었음.")
            .apply()
        // ophthaSharedPreferences2_lasek_review2
        ophthaSharedPreferences2_lasek_review2.edit()
            .putString("nickName", "브라이디")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 6)
            .putInt("price", 80)
            .putString("review", "아주 만족해요! 다만 수술 정보를 더 자세히 알려면 따로 노력해서 번거로웠어요\n")
            .apply()
        // ophthaSharedPreferences2_lasek_review3
        ophthaSharedPreferences2_lasek_review3.edit()
            .putString("nickName", "바닷바람")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 5)
            .putInt("price", 220)
            .putString("review", "완전 좋았습니다!")
            .apply()
        totalAvg = (6+6+5) / 3f
        ophthaSharedPreferences2_lasek.edit().putFloat("totalRating",totalAvg.toFloat()).apply()
        ophthaSharedPreferences2_lasek.edit().putInt("img", R.drawable.ophtha_ex_img2).apply()
        ophthaSharedPreferences2_lasek.edit().putInt("reviwCnt", 3).apply()
        ophthaSharedPreferences2_lasek.edit().putString("id", "2").apply()
        ophthaSharedPreferences2_lasek.edit().putString("operation", "lasek").apply()
        ophthaSharedPreferences2_lasek.edit().putString("name", "사랑 안과").apply()

        // ophthaSharedPreferences8
        // ophthaSharedPreferences8_lasek_review1
        ophthaSharedPreferences8_lasek_review1.edit()
            .putString("nickName", "진할아버지")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 6)
            .putInt("price", 110)
            .putString("review", "완전 짱!!")
            .apply()
        // ophthaSharedPreferences8_lasek_review2
        ophthaSharedPreferences8_lasek_review2.edit()
            .putString("nickName", "성수일가동")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 2)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 8)
            .putInt("price", 90)
            .putString("review", "완전 좋았습니다!")
            .apply()
        // ophthaSharedPreferences8_lasek_review3
        ophthaSharedPreferences8_lasek_review3.edit()
            .putString("nickName", "칠중대나마")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 2)
            .putInt("ratingEffect", 1)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 7)
            .putInt("price", 120)
            .putString("review", "마취안약? 넣고 대기후 3분정도 뒤에 수술이 끝났어요\n!")
            .apply()
        totalAvg = (6+7+8) / 3f
        ophthaSharedPreferences8_lasek.edit().putFloat("totalRating",totalAvg.toFloat()).apply()
        ophthaSharedPreferences8_lasek.edit().putInt("img", R.drawable.ophtha_ex_img8).apply()
        ophthaSharedPreferences8_lasek.edit().putInt("reviwCnt", 3).apply()
        ophthaSharedPreferences8_lasek.edit().putString("id", "8").apply()
        ophthaSharedPreferences8_lasek.edit().putString("operation", "lasek").apply()
        ophthaSharedPreferences8_lasek.edit().putString("name", "소원 안과").apply()

        // ophthaSharedPreferences13
        // ophthaSharedPreferences13_lasek_review1
        ophthaSharedPreferences13_lasek_review1.edit()
            .putString("nickName", "설박탐나트륨")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 2)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 8)
            .putInt("price", 90)
            .putString("review", "완전 좋았습니다!")
            .apply()
        // ophthaSharedPreferences13_lasek_review2
        ophthaSharedPreferences13_lasek_review2.edit()
            .putString("nickName", "높은음자리표")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 6)
            .putInt("price", 120)
            .putString("review", "나뭇잎이 하나하나 분리되어 있다는 걸 새삼 느꼈고 밤하늘의 별이 그렇게 많다는 것을 알게되었어요\n!")
            .apply()
        // ophthaSharedPreferences13_lasek_review3
        ophthaSharedPreferences13_lasek_review3.edit()
            .putString("nickName", "녑첵")
            .putInt("ratingKindness", 2)
            .putInt("ratingWaitingTime", 0)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 7)
            .putInt("price", 89)
            .putString("review", "눈 잘보여요")
            .apply()
        // ophthaSharedPreferences13_lasek_review4
        ophthaSharedPreferences13_lasek_review4.edit()
            .putString("nickName", "뻬횃")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 1)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 5)
            .putInt("price", 99)
            .putString("review", "아주 만족해요! 다만 수술 정보를 더 자세히 알려면 따로 노력해서 번거로웠어요\n")
            .apply()
        // ophthaSharedPreferences13_lasek_review5
        ophthaSharedPreferences13_lasek_review5.edit()
            .putString("nickName", "붓깟")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 1)
            .putInt("totalRating", 5)
            .putInt("price", 220)
            .putString("review", "수술은 들어간지 15분도 안 되서 끝났어요.거의 공장느낌.수술 후 3일은 눈 시림이 너무 심해서 눈을 잘 못 떴고 눈앞이 뿌연 느낌이 있었어요. 일주일 뒤부터는 통증이 없어졌고 한동안은 빛번짐이 심했어요. 6개월동안 약간 눈이 건조해서 인공 눈물 꾸준히 넣어줬고 2년이 지난 지금 전혀 불편함이 없어요. 왕추천")
            .apply()
        totalAvg = (6+7+8 +5 +5) / 5f
        ophthaSharedPreferences13_lasek.edit().putFloat("totalRating",totalAvg.toFloat()).apply()
        ophthaSharedPreferences13_lasek.edit().putInt("img", R.drawable.ophtha_ex_img13).apply()
        ophthaSharedPreferences13_lasek.edit().putInt("reviwCnt", 5).apply()
        ophthaSharedPreferences13_lasek.edit().putString("id","13").apply()
        ophthaSharedPreferences13_lasek.edit().putString("operation","lasek").apply()
        ophthaSharedPreferences13_lasek.edit().putString("name","강남 안과").apply()

        // ophthaSharedPreferences18
        // ophthaSharedPreferences18_lasek_review1
        ophthaSharedPreferences18_lasek_review1.edit()
            .putString("nickName", "사이클로헵테인")
            .putInt("ratingKindness", 0)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 5)
            .putInt("price", 120)
            .putString("review", "별로 아프지않았고 수술할때 솔직히 의사선생님이 좀 불친절했음 하지만 결과가 좋으니 대만족!")
            .apply()
        // ophthaSharedPreferences18_lasek_review2
        ophthaSharedPreferences18_lasek_review2.edit()
            .putString("nickName", "벌레잡이제비꽃")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 6)
            .putInt("price", 220)
            .putString("review", "나뭇잎이 하나하나 분리되어 있다는 걸 새삼 느꼈고 밤하늘의 별이 그렇게 많다는 것을 알게되었어요")
            .apply()
        // ophthaSharedPreferences18_lasek_review3
        ophthaSharedPreferences18_lasek_review3.edit()
            .putString("nickName", "웅놘펏")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 2)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 2)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 9)
            .putInt("price", 250)
            .putString("review", "수술은 들어간지 15분도 안 되서 끝났어요.거의 공장느낌.수술 후 3일은 눈 시림이 너무 심해서 눈을 잘 못 떴고 눈앞이 뿌연 느낌이 있었어요. 일주일 뒤부터는 통증이 없어졌고 한동안은 빛번짐이 심했어요. 6개월동안 약간 눈이 건조해서 인공 눈물 꾸준히 넣어줬고 2년이 지난 지금 전혀 불편함이 없어요. 왕추천")
            .apply()
        // ophthaSharedPreferences18_lasek_review4
        ophthaSharedPreferences18_lasek_review4.edit()
            .putString("nickName", "키쁘륨")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 6)
            .putInt("price", 190)
            .putString("review", "완전 좋았습니다!")
            .apply()
        totalAvg =  (5+6+9+6)/ 4f
        ophthaSharedPreferences18_lasek.edit().putFloat("totalRating",totalAvg.toFloat()).apply()
        ophthaSharedPreferences18_lasek.edit().putInt("img", R.drawable.ophtha_ex_img18).apply()
        ophthaSharedPreferences18_lasek.edit().putInt("reviwCnt", 4).apply()
        ophthaSharedPreferences18_lasek.edit().putString("id","18").apply()
        ophthaSharedPreferences18_lasek.edit().putString("operation","lasek").apply()
        ophthaSharedPreferences18_lasek.edit().putString("name","은혜 안과").apply()

        // ophthaSharedPreferences3
        // ophthaSharedPreferences3_smile_review1
        ophthaSharedPreferences3_smile_review1.edit()
            .putString("nickName", "를루아르")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 5)
            .putInt("price", 220)
            .putString("review", "완전 좋았습니다!")
            .apply()
        // ophthaSharedPreferences3_smile_review2
        ophthaSharedPreferences3_smile_review2.edit()
            .putString("nickName", "파라콰트")
            .putInt("ratingKindness", 2)
            .putInt("ratingWaitingTime", 2)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 2)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 10)
            .putInt("price", 198)
            .putString("review", "원장님도 친절하시고, 대기시간도 정말 짧았습니다. 다들 추천해요!!")
            .apply()
        // ophthaSharedPreferences3_smile_review3
        ophthaSharedPreferences3_smile_review3.edit()
            .putString("nickName", "샹그릴라")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 1)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 5)
            .putInt("price", 215)
            .putString("review", "나뭇잎이 하나하나 분리되어 있다는 걸 새삼 느꼈고 밤하늘의 별이 그렇게 많다는 것을 알게되었어요")
            .apply()
        // ophthaSharedPreferences3_smile_review4
        ophthaSharedPreferences3_smile_review4.edit()
            .putString("nickName", "마리깔")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 2)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 2)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 9)
            .putInt("price", 200)
            .putString("review", "별로 아프지않았고 수술할때 솔직히 의사선생님이 좀 불친절했음 하지만 결과가 좋으니 대만족")
            .apply()
        // ophthaSharedPreferences3_smile_review5
        ophthaSharedPreferences3_smile_review5.edit()
            .putString("nickName", "사무처")
            .putInt("ratingKindness", 2)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 1)
            .putInt("totalRating", 7)
            .putInt("price", 220)
            .putString("review", "눈이 잘 보이고 회복이 짧았으며 확실히 난시는 교정되지 않음")
            .apply()
        // ophthaSharedPreferences3_smile_review6
        ophthaSharedPreferences3_smile_review6.edit()
            .putString("nickName", "하방장")
            .putInt("ratingKindness", 2)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 8)
            .putInt("price", 195)
            .putString("review", "당일 진료받고 바로 수술했는데, 친절하게 상담해주셔서 좋았습니다.!\n" +
                    "스마일라식 후, 첫날에만 뿌옇게 잘 보이지 않았고 다음날부터 잘 보이기 시작했어요. 다만 건조증이 조금 심해서 인공눈물을 자주 넣었습니다.")
            .apply()
        // ophthaSharedPreferences3_smile_review7
        ophthaSharedPreferences3_smile_review7.edit()
            .putString("nickName", "가구리")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 7)
            .putInt("price", 230)
            .putString("review", "완전 좋았습니다!")
            .apply()
        totalAvg =  (5+10+5+9+7+8+7)/ 7f
        ophthaSharedPreferences3_smile.edit().putFloat("totalRating",totalAvg.toFloat()).apply()
        ophthaSharedPreferences3_smile.edit().putInt("img", R.drawable.ophtha_ex_img3).apply()
        ophthaSharedPreferences3_smile.edit().putInt("reviwCnt", 7).apply()
        ophthaSharedPreferences3_smile.edit().putString("id", "3").apply()
        ophthaSharedPreferences3_smile.edit().putString("operation", "smile").apply()
        ophthaSharedPreferences3_smile.edit().putString("name", "밝은 안과").apply()

        // ophthaSharedPreferences9
        // ophthaSharedPreferences9_smile_review1
        ophthaSharedPreferences9_smile_review1.edit()
            .putString("nickName", "감자크로켓")
            .putInt("ratingKindness", 2)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 1)
            .putInt("ratingInformation", 2)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 8)
            .putInt("price", 220)
            .putString("review", "마취안약? 넣고 대기후 3분정도 뒤에 수술이 끝났어요")
            .apply()
        // ophthaSharedPreferences9_smile_review2
        ophthaSharedPreferences9_smile_review2.edit()
            .putString("nickName", "두메바늘꽃")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 2)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 8)
            .putInt("price", 220)
            .putString("review", "눈이 잘 보이고 회복이 짧았으며 확실히 난시는 교정되지 않음")
            .apply()
        // ophthaSharedPreferences9_smile_review3
        ophthaSharedPreferences9_smile_review3.edit()
            .putString("nickName", "대만파나마")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 7)
            .putInt("price", 220)
            .putString("review", "아주 만족해요! 다만 수술 정보를 더 자세히 알려면 따로 노력해서 번거로웠어요")
            .apply()
        // ophthaSharedPreferences9_smile_review4
        ophthaSharedPreferences9_smile_review4.edit()
            .putString("nickName", "산대추나무")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 6)
            .putInt("price", 220)
            .putString("review", "대기시간은 정말 길고 수술은 정말 짧아요 너무 친절하고 회복이 빨라 넘 잘보였습니당")
            .apply()
        totalAvg =  (8+8+7+6)/ 4f
        ophthaSharedPreferences9_smile.edit().putFloat("totalRating",totalAvg.toFloat()).apply()
        ophthaSharedPreferences9_smile.edit().putInt("img", R.drawable.ophtha_ex_img9).apply()
        ophthaSharedPreferences9_smile.edit().putInt("reviwCnt", 4).apply()
        ophthaSharedPreferences9_smile.edit().putString("id","9").apply()
        ophthaSharedPreferences9_smile.edit().putString("operation","smile").apply()
        ophthaSharedPreferences9_smile.edit().putString("name","미소 안과").apply()

        // ophthaSharedPreferences14
        // ophthaSharedPreferences14_smile_review1
        ophthaSharedPreferences14_smile_review1.edit()
            .putString("nickName", "검둥오리사촌")
            .putInt("ratingKindness", 2)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 8)
            .putInt("price", 220)
            .putString("review", "짱좋음. 세상을 렌즈를 통해서가 아닌 내 눈으로 직접 접할 수 있다는게 얼마나 큰 축복인지 시력 좋게 태어난 사람들은 절대 모르지. 근데 제가받은 수술은 무통라섹인지 뭔지 해서 하나도 안아프긴 했는데 수술후에 6개월동안 안압약이랑 무슨 안약 넣고 매달 병원가서 시력검사받고 귀찮긴했음. 그래도 세상 공기를 내 각막으로 직접 느낀다는게 얼마나 감사한 일인데. 현대기술 짱짱.")
            .apply()
        // ophthaSharedPreferences14_smile_review2
        ophthaSharedPreferences14_smile_review2.edit()
            .putString("nickName", "라디올라리아")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 1)
            .putInt("totalRating", 6)
            .putInt("price", 210)
            .putString("review", "수술받는데 마취 안약 제대로 안넣었으면서 아프다니까 움직이지 말라고함. 아니 환자가 아프다는데.. 왜 의사 본인이 짜증을 내는지 모르겠음.\n" +
                    "그리고 병원자체가 눈알공장느낌 물씬.\n" +
                    "그래도 병원이 체계가 잘 잡혀있는것같아서 좋았음.\n" +
                    "수술후 눈이 건조하여 뿌옇게 보이는 부작용이 있었음.")
            .apply()
        // ophthaSharedPreferences14_smile_review3
        ophthaSharedPreferences14_smile_review3.edit()
            .putString("nickName", "렘헹깁")
            .putInt("ratingKindness", 2)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 7)
            .putInt("price", 220)
            .putString("review", "나뭇잎이 하나하나 분리되어 있다는 걸 새삼 느꼈고 밤하늘의 별이 그렇게 많다는 것을 알게되었어요")
            .apply()
        // ophthaSharedPreferences14_smile_review4
        ophthaSharedPreferences14_smile_review4.edit()
            .putString("nickName", "닥푠본")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 1)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 5)
            .putInt("price", 220)
            .putString("review", "별로 아프지않았고 수술할때 솔직히 의사선생님이 좀 불친절했음 하지만 결과가 좋으니 대만족")
            .apply()
        // ophthaSharedPreferences14_smile_review5
        ophthaSharedPreferences14_smile_review5.edit()
            .putString("nickName", "땃쭘팜")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 2)
            .putInt("ratingEffect", 0)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 0)
            .putInt("totalRating", 3)
            .putInt("price", 250)
            .putString("review", "마취안약? 넣고 대기후 3분정도 뒤에 수술이 끝났어요")
            .apply()
        totalAvg =  (8+6+7+5+3)/ 5f
        ophthaSharedPreferences14_smile.edit().putFloat("totalRating",totalAvg.toFloat()).apply()
        ophthaSharedPreferences14_smile.edit().putInt("img", R.drawable.ophtha_ex_img14).apply()
        ophthaSharedPreferences14_smile.edit().putInt("reviwCnt", 5).apply()
        ophthaSharedPreferences14_smile.edit().putString("id", "14").apply()
        ophthaSharedPreferences14_smile.edit().putString("operation", "smile").apply()
        ophthaSharedPreferences14_smile.edit().putString("name", "다보임 안과").apply()

        // ophthaSharedPreferences19
        // ophthaSharedPreferences19_smile_review1
        ophthaSharedPreferences19_smile_review1.edit()
            .putString("nickName", "체노디옥시콜산")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 6)
            .putInt("price", 220)
            .putString("review", "눈이 잘 보이고 회복이 짧았으며 확실히 난시는 교정되지 않음")
            .apply()
        // ophthaSharedPreferences19_smile_review2
        ophthaSharedPreferences19_smile_review2.edit()
            .putString("nickName", "일부다처주의자")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 1)
            .putInt("totalRating", 5)
            .putInt("price", 220)
            .putString("review", "아주 만족해요! 다만 수술 정보를 더 자세히 알려면 따로 노력해서 번거로웠어요")
            .apply()
        // ophthaSharedPreferences19_smile_review3
        ophthaSharedPreferences19_smile_review3.edit()
            .putString("nickName", "콜라마시고싶다")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 2)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 8)
            .putInt("price", 195)
            .putString("review", "대기시간은 정말 길고 수술은 정말 짧아요 너무 친절하고 회복이 빨라 넘 잘보였습니당")
            .apply()
        // ophthaSharedPreferences19_smile_review4
        ophthaSharedPreferences19_smile_review4.edit()
            .putString("nickName", "선택받은")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 1)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 1)
            .putInt("totalRating", 5)
            .putInt("price", 230)
            .putString("review", "수술할때 조금 아팠다 수술 후 회복은 하루정도 걸렸다")
            .apply()
        totalAvg =  (6+5+8+5)/ 4f
        ophthaSharedPreferences19_smile.edit().putFloat("totalRating",totalAvg.toFloat()).apply()
        ophthaSharedPreferences19_smile.edit().putInt("img", R.drawable.ophtha_ex_img19).apply()
        ophthaSharedPreferences19_smile.edit().putInt("reviwCnt", 4).apply()
        ophthaSharedPreferences19_smile.edit().putString("id", "19").apply()
        ophthaSharedPreferences19_smile.edit().putString("operation", "smile").apply()
        ophthaSharedPreferences19_smile.edit().putString("name", "초롱 안과").apply()

        // ophthaSharedPreferences4
        // ophthaSharedPreferences4_today_review1
        ophthaSharedPreferences4_today_review1.edit()
            .putString("nickName", "종차")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 6)
            .putInt("price", 220)
            .putString("review", "완전 좋았습니다!")
            .apply()
        // ophthaSharedPreferences4_today_review2
        ophthaSharedPreferences4_today_review2.edit()
            .putString("nickName", "자망")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 0)
            .putInt("totalRating", 4)
            .putInt("price", 250)
            .putString("review", "별로에요")
            .apply()
        // ophthaSharedPreferences4_today_review3
        ophthaSharedPreferences4_today_review3.edit()
            .putString("nickName", "나신")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 6)
            .putInt("price", 220)
            .putString("review", "완전 짱~!!~!!!")
            .apply()
        // ophthaSharedPreferences4_today_review4
        ophthaSharedPreferences4_today_review4.edit()
            .putString("nickName", "추하")
            .putInt("ratingKindness", 2)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 1)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 6)
            .putInt("price", 210)
            .putString("review", "사람마다 다르겠지만 하루는 잠을 못 잘정도의 통증이 있었음")
            .apply()
        // ophthaSharedPreferences4_today_review5
        ophthaSharedPreferences4_today_review5.edit()
            .putString("nickName", "타깃층")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 6)
            .putInt("price", 190)
            .putString("review", "수술할때 조금 아팠다 수술 후 회복은 하루정도 걸렸다")
            .apply()
        totalAvg =  (6+4+6+6+6)/ 5f
        ophthaSharedPreferences4_today.edit().putFloat("totalRating",totalAvg.toFloat()).apply()
        ophthaSharedPreferences4_today.edit().putInt("img", R.drawable.ophtha_ex_img4).apply()
        ophthaSharedPreferences4_today.edit().putInt("reviwCnt", 5).apply()
        ophthaSharedPreferences4_today.edit().putString("id","4").apply()
        ophthaSharedPreferences4_today.edit().putString("operation","today").apply()
        ophthaSharedPreferences4_today.edit().putString("name","하늘 안과").apply()

        // ophthaSharedPreferences10
        // ophthaSharedPreferences10_today_review1
        ophthaSharedPreferences10_today_review1.edit()
            .putString("nickName", "파동편모충증")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 6)
            .putInt("price", 220)
            .putString("review", "완전 좋았습니다!")
            .apply()
        // ophthaSharedPreferences10_today_review2
        ophthaSharedPreferences10_today_review2.edit()
            .putString("nickName", "글라디올러스")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 2)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 2)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 9)
            .putInt("price", 190)
            .putString("review", "짱좋음. 세상을 렌즈를 통해서가 아닌 내 눈으로 직접 접할 수 있다는게 얼마나 큰 축복인지 시력 좋게 태어난 사람들은 절대 모르지. 근데 제가받은 수술은 무통라섹인지 뭔지 해서 하나도 안아프긴 했는데 수술후에 6개월동안 안압약이랑 무슨 안약 넣고 매달 병원가서 시력검사받고 귀찮긴했음. 그래도 세상 공기를 내 각막으로 직접 느낀다는게 얼마나 감사한 일인데. 현대기술 짱짱.")
            .apply()
        // ophthaSharedPreferences10_today_review3
        ophthaSharedPreferences10_today_review3.edit()
            .putString("nickName", "쏸구")
            .putInt("ratingKindness", 2)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 8)
            .putInt("price", 220)
            .putString("review", "수술받는데 마취 안약 제대로 안넣었으면서 아프다니까 움직이지 말라고함. 아니 환자가 아프다는데.. 왜 의사 본인이 짜증을 내는지 모르겠음.\n" +
                    "그리고 병원자체가 눈알공장느낌 물씬.\n" +
                    "그래도 병원이 체계가 잘 잡혀있는것같아서 좋았음.\n" +
                    "수술후 눈이 건조하여 뿌옇게 보이는 부작용이 있었음.")
            .apply()
        // ophthaSharedPreferences10_today_review4
        ophthaSharedPreferences10_today_review4.edit()
            .putString("nickName", "윰짠")
            .putInt("ratingKindness", 2)
            .putInt("ratingWaitingTime", 2)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 2)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 10)
            .putInt("price", 196)
            .putString("review", "당일 진료받고 바로 수술했는데, 친절하게 상담해주셔서 좋았습니다.!\n" +
                    "스마일라식 후, 첫날에만 뿌옇게 잘 보이지 않았고 다음날부터 잘 보이기 시작했어요. 다만 건조증이 조금 심해서 인공눈물을 자주 넣었습니다.")
            .apply()
        totalAvg =  (6+9+8+10)/ 4f
        ophthaSharedPreferences10_today.edit().putFloat("totalRating",totalAvg.toFloat()).apply()
        ophthaSharedPreferences10_today.edit().putInt("img", R.drawable.ophtha_ex_img10).apply()
        ophthaSharedPreferences10_today.edit().putInt("reviwCnt", 4).apply()
        ophthaSharedPreferences10_today.edit().putString("id", "10").apply()
        ophthaSharedPreferences10_today.edit().putString("operation", "today").apply()
        ophthaSharedPreferences10_today.edit().putString("name", "좋은 안과").apply()

        // ophthaSharedPreferences15
        // ophthaSharedPreferences15_today_review1
        ophthaSharedPreferences15_today_review1.edit()
            .putString("nickName", "크립토코쿠스증")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 6)
            .putInt("price", 220)
            .putString("review", "완전 좋았습니다!")
            .apply()
        // ophthaSharedPreferences15_today_review2
        ophthaSharedPreferences15_today_review2.edit()
            .putString("nickName", "네오세라토더스")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 1)
            .putInt("totalRating", 5)
            .putInt("price", 220)
            .putString("review", "나뭇잎이 하나하나 분리되어 있다는 걸 새삼 느꼈고 밤하늘의 별이 그렇게 많다는 것을 알게되었어요")
            .apply()
        // ophthaSharedPreferences15_today_review3
        ophthaSharedPreferences15_today_review3.edit()
            .putString("nickName", "챔딩끙")
            .putInt("ratingKindness", 0)
            .putInt("ratingWaitingTime", 2)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 2)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 8)
            .putInt("price", 220)
            .putString("review", "별로 아프지않았고 수술할때 솔직히 의사선생님이 좀 불친절했음 하지만 결과가 좋으니 대만족")
            .apply()
        totalAvg =  (6+5+8)/ 3f
        ophthaSharedPreferences15_today.edit().putFloat("totalRating",totalAvg.toFloat()).apply()
        ophthaSharedPreferences15_today.edit().putInt("img", R.drawable.ophtha_ex_img15).apply()
        ophthaSharedPreferences15_today.edit().putInt("reviwCnt", 3).apply()
        ophthaSharedPreferences15_today.edit().putString("id", "15").apply()
        ophthaSharedPreferences15_today.edit().putString("operation", "today").apply()
        ophthaSharedPreferences15_today.edit().putString("name", "나라 안과").apply()

        // ophthaSharedPreferences20
        // ophthaSharedPreferences20_today_review1
        ophthaSharedPreferences20_today_review1.edit()
            .putString("nickName", "익명의꽃게")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 2)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 8)
            .putInt("price", 220)
            .putString("review", "당일 진료받고 바로 수술했는데, 친절하게 상담해주셔서 좋았습니다.!\n" +
                    "스마일라식 후, 첫날에만 뿌옇게 잘 보이지 않았고 다음날부터 잘 보이기 시작했어요. 다만 건조증이 조금 심해서 인공눈물을 자주 넣었습니다.")
            .apply()
        // ophthaSharedPreferences20_today_review2
        ophthaSharedPreferences20_today_review2.edit()
            .putString("nickName", "Dae갈")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 7)
            .putInt("price", 220)
            .putString("review", "마취안약? 넣고 대기후 3분정도 뒤에 수술이 끝났어요")
            .apply()
        // ophthaSharedPreferences20today_review3
        ophthaSharedPreferences20_today_review3.edit()
            .putString("nickName", "도도새치킨")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 0)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 5)
            .putInt("price", 220)
            .putString("review", "아주 만족해요! 다만 수술 정보를 더 자세히 알려면 따로 노력해서 번거로웠어요")
            .apply()
        // ophthaSharedPreferences20_today_review4
        ophthaSharedPreferences20_today_review4.edit()
            .putString("nickName", "MyBreakTime")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 7)
            .putInt("price", 220)
            .putString("review", "눈이 잘 보이고 회복이 짧았으며 확실히 난시는 교정되지 않음")
            .apply()
        // ophthaSharedPreferences20_today_review5
        ophthaSharedPreferences20_today_review5.edit()
            .putString("nickName", "그1자식")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 2)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 8)
            .putInt("price", 220)
            .putString("review", "완전 좋았습니다!")
            .apply()
        totalAvg =  (8+7+5+7+8)/ 5f
        ophthaSharedPreferences20_today.edit().putFloat("totalRating",totalAvg.toFloat()).apply()
        ophthaSharedPreferences20_today.edit().putInt("img", R.drawable.ophtha_ex_img20).apply()
        ophthaSharedPreferences20_today.edit().putInt("reviwCnt", 5).apply()
        ophthaSharedPreferences20_today.edit().putString("id", "20").apply()
        ophthaSharedPreferences20_today.edit().putString("operation", "today").apply()
        ophthaSharedPreferences20_today.edit().putString("name", "아름 안과").apply()

        // ophthaSharedPreferences5
        // ophthaSharedPreferences5_lens_review1
        ophthaSharedPreferences5_lens_review1.edit()
            .putString("nickName", "자소엽")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 7)
            .putInt("price", 220)
            .putString("review", "아주 만족해요! 다만 수술 정보를 더 자세히 알려면 따로 노력해서 번거로웠어요")
            .apply()
        // ophthaSharedPreferences5_lens_review2
        ophthaSharedPreferences5_lens_review2.edit()
            .putString("nickName", "청라면")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 6)
            .putInt("price", 220)
            .putString("review", "나뭇잎이 하나하나 분리되어 있다는 걸 새삼 느꼈고 밤하늘의 별이 그렇게 많다는 것을 알게되었어요")
            .apply()
        // ophthaSharedPreferences5_lens_review3
        ophthaSharedPreferences5_lens_review3.edit()
            .putString("nickName", "타액소")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 1)
            .putInt("totalRating", 5)
            .putInt("price", 220)
            .putString("review", "수술은 들어간지 15분도 안 되서 끝났어요.거의 공장느낌.수술 후 3일은 눈 시림이 너무 심해서 눈을 잘 못 떴고 눈앞이 뿌연 느낌이 있었어요. 일주일 뒤부터는 통증이 없어졌고 한동안은 빛번짐이 심했어요. 6개월동안 약간 눈이 건조해서 인공 눈물 꾸준히 넣어줬고 2년이 지난 지금 전혀 불편함이 없어요. 왕추천")
            .apply()
        // ophthaSharedPreferences5_lens_review4
        ophthaSharedPreferences5_lens_review4.edit()
            .putString("nickName", "다로기")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 2)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 8)
            .putInt("price", 220)
            .putString("review", "완전 좋았습니다!")
            .apply()
        // ophthaSharedPreferences5_lens_review5
        ophthaSharedPreferences5_lens_review5.edit()
            .putString("nickName", "로르카")
            .putInt("ratingKindness", 2)
            .putInt("ratingWaitingTime", 2)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 2)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 10)
            .putInt("price", 220)
            .putString("review", "당일 진료받고 바로 수술했는데, 친절하게 상담해주셔서 좋았습니다.!\n" +
                    "스마일라식 후, 첫날에만 뿌옇게 잘 보이지 않았고 다음날부터 잘 보이기 시작했어요. 다만 건조증이 조금 심해서 인공눈물을 자주 넣었습니다.")
            .apply()
        // ophthaSharedPreferences5_lens_review6
        ophthaSharedPreferences5_lens_review6.edit()
            .putString("nickName", "왕자귀나무")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 7)
            .putInt("price", 220)
            .putString("review", "마취안약? 넣고 대기후 3분정도 뒤에 수술이 끝났어요")
            .apply()
        totalAvg =  (7+6+5+8+10+7)/ 6f
        ophthaSharedPreferences5_lens.edit().putFloat("totalRating",totalAvg.toFloat()).apply()
        ophthaSharedPreferences5_lens.edit().putInt("img", R.drawable.ophtha_ex_img5).apply()
        ophthaSharedPreferences5_lens.edit().putInt("reviwCnt", 6).apply()
        ophthaSharedPreferences5_lens.edit().putString("id", "5").apply()
        ophthaSharedPreferences5_lens.edit().putString("operation", "lens").apply()
        ophthaSharedPreferences5_lens.edit().putString("name", "바다 안과").apply()

        // ophthaSharedPreferences11
        // ophthaSharedPreferences11_lens_review1
        ophthaSharedPreferences11_lens_review1.edit()
            .putString("nickName", "라아르헨티나")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 6)
            .putInt("price", 220)
            .putString("review", "완전 좋았습니다!")
            .apply()
        // ophthaSharedPreferences11_lens_review2
        ophthaSharedPreferences11_lens_review2.edit()
            .putString("nickName", "일본조팝나무")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 1)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 5)
            .putInt("price", 220)
            .putString("review", "눈이 잘 보이고 회복이 짧았으며 확실히 난시는 교정되지 않음")
            .apply()
        // ophthaSharedPreferences11_lens_review3
        ophthaSharedPreferences11_lens_review3.edit()
            .putString("nickName", "비쑨")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 7)
            .putInt("price", 220)
            .putString("review", "수술할때 조금 아팠다 수술 후 회복은 하루정도 걸렸다")
            .apply()
        // ophthaSharedPreferences11_lens_review4
        ophthaSharedPreferences11_lens_review4.edit()
            .putString("nickName", "탱컁")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 2)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 7)
            .putInt("price", 220)
            .putString("review", "낫 밷")
            .apply()
        // ophthaSharedPreferences11_lens_review5
        ophthaSharedPreferences11_lens_review5.edit()
            .putString("nickName", "탑꼽")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 1)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 7)
            .putInt("price", 220)
            .putString("review", "수술할때 너무 아팠다")
            .apply()
        totalAvg =  (6+5+7+7+7)/ 5f
        ophthaSharedPreferences11_lens.edit().putFloat("totalRating",totalAvg.toFloat()).apply()
        ophthaSharedPreferences11_lens.edit().putInt("img", R.drawable.ophtha_ex_img11).apply()
        ophthaSharedPreferences11_lens.edit().putInt("reviwCnt", 5).apply()
        ophthaSharedPreferences11_lens.edit().putString("id","11").apply()
        ophthaSharedPreferences11_lens.edit().putString("operation","lens").apply()
        ophthaSharedPreferences11_lens.edit().putString("name","튼튼 안과").apply()

        // ophthaSharedPreferences16
        // ophthaSharedPreferences16_lens_review1
        ophthaSharedPreferences16_lens_review1.edit()
            .putString("nickName", "오이간장장아찌")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 6)
            .putInt("price", 220)
            .putString("review", "사람마다 다르겠지만 하루는 잠을 못 잘정도의 통증이 있었음")
            .apply()
        // ophthaSharedPreferences16_lens_review2
        ophthaSharedPreferences16_lens_review2.edit()
            .putString("nickName", "아라비노갈락탄")
            .putInt("ratingKindness", 0)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 5)
            .putInt("price", 220)
            .putString("review", "눈이 잘 보이고 회복이 짧았으며 확실히 난시는 교정되지 않음")
            .apply()
        // ophthaSharedPreferences16_lens_review3
        ophthaSharedPreferences16_lens_review3.edit()
            .putString("nickName", "한쪄촹")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 2)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 8)
            .putInt("price", 220)
            .putString("review", "완전 좋았습니다!")
            .apply()
        // ophthaSharedPreferences16_lens_review4
        ophthaSharedPreferences16_lens_review4.edit()
            .putString("nickName", "꺼탯린")
            .putInt("ratingKindness", 2)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 7)
            .putInt("price", 220)
            .putString("review", "대기시간은 정말 길고 수술은 정말 짧아요 너무 친절하고 회복이 빨라 넘 잘보였습니당")
            .apply()
        totalAvg =  (6+5+8+7)/ 4f
        ophthaSharedPreferences16_lens.edit().putFloat("totalRating",totalAvg.toFloat()).apply()
        ophthaSharedPreferences16_lens.edit().putInt("img", R.drawable.ophtha_ex_img16).apply()
        ophthaSharedPreferences16_lens.edit().putInt("reviwCnt", 4).apply()
        ophthaSharedPreferences16_lens.edit().putString("id","16").apply()
        ophthaSharedPreferences16_lens.edit().putString("operation","lens").apply()
        ophthaSharedPreferences16_lens.edit().putString("name","국민 안과").apply()

        // ophthaSharedPreferences6
        // ophthaSharedPreferences6_back_review1
        ophthaSharedPreferences6_back_review1.edit()
            .putString("nickName", "신카나리아")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 1)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 5)
            .putInt("price", 220)
            .putString("review", "완전 좋았습니다!")
            .apply()
        // ophthaSharedPreferences6_back_review2
        ophthaSharedPreferences6_back_review2.edit()
            .putString("nickName", "차폭")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 6)
            .putInt("price", 220)
            .putString("review", "수술은 잘됐어요")
            .apply()
        // ophthaSharedPreferences6_back_review3
        ophthaSharedPreferences6_back_review3.edit()
            .putString("nickName", "영아")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 1)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 1)
            .putInt("totalRating", 5)
            .putInt("price", 220)
            .putString("review", "완전 좋았습니다!")
            .apply()
        // ophthaSharedPreferences6_back_review4
        ophthaSharedPreferences6_back_review4.edit()
            .putString("nickName", "인바")
            .putInt("ratingKindness", 1)
            .putInt("ratingWaitingTime", 0)
            .putInt("ratingEffect", 2)
            .putInt("ratingInformation", 0)
            .putInt("ratingPrice", 2)
            .putInt("totalRating", 5)
            .putInt("price", 220)
            .putString("review", "별로 아프지않았고 수술할때 솔직히 의사선생님이 좀 불친절했음 하지만 결과가 좋으니 대만족")
            .apply()
        totalAvg =  (5+6+5+5)/ 4f
        ophthaSharedPreferences6_back.edit().putFloat("totalRating",totalAvg.toFloat()).apply()
        ophthaSharedPreferences6_back.edit().putInt("img", R.drawable.ophtha_ex_img6).apply()
        ophthaSharedPreferences6_back.edit().putInt("reviwCnt", 4).apply()
        ophthaSharedPreferences6_back.edit().putString("id", "6").apply()
        ophthaSharedPreferences6_back.edit().putString("operation", "back").apply()
        ophthaSharedPreferences6_back.edit().putString("name", "한빛 안과").apply()
    }


    public fun checkIsReview() {
        isReviewRegistered = checkReviewSharedPreferences.getBoolean("isReviewRegistered", false)
    }

    public fun bottomNavigationControl() {
        if (binding.mainBottomNavigation.visibility == View.VISIBLE) {
            binding.mainBottomNavigation.visibility = View.GONE

        } else {
            binding.mainBottomNavigation.visibility = View.VISIBLE
        }
    }

    private fun initBottomNavigation() {
        supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container, HomeFragment()).commitAllowingStateLoss()

        binding.mainBottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container, HomeFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
//                R.id.mapFragment -> {
//                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container, WriteReview1Fragment()).commitAllowingStateLoss()
//                    return@setOnItemSelectedListener true
//                }
                R.id.compareFragment -> {
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container, CompareFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.communityFragment -> {
                    val fragment = if (isReviewRegistered) {
                        ManagementAfterOperationFragment()
                    } else {
                        ManagementBeforeOperationFragment()
                    }
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container, fragment).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
                R.id.myInfoFragment -> {
                    supportFragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container, MyInfoFragment()).commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }
            }
            false
        }
    }
}
