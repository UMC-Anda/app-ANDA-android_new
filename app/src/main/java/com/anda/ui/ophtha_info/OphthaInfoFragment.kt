package com.anda.ui.ophtha_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.anda.R
import com.anda.data.entities.OphthaInfoEvent
import com.anda.data.entities.OphthaInfoReview
import com.anda.databinding.FragmentOphthaInfoBinding
import com.google.android.material.tabs.TabLayoutMediator

class OphthaInfoFragment() : Fragment() {

    val ophthaInfoEventDatas = ArrayList<OphthaInfoEvent>()
    val ophthaInfoReviewDatas = ArrayList<OphthaInfoReview>()
    lateinit var binding: FragmentOphthaInfoBinding
    private val information = arrayListOf("이벤트", "리뷰", "별점요약")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOphthaInfoBinding.inflate(inflater, container, false)




        optionDetails()


        return binding.root
    }


    private fun optionDetails() {
        addDetailsEvents()
        addDetailsReviews()

        val andaOphthaInfoAdapter =
            OphthaInfoBannerVPAdapter(this, ophthaInfoEventDatas, ophthaInfoReviewDatas)
        binding.ophthaInfoDetailsVp.adapter = andaOphthaInfoAdapter
        TabLayoutMediator(
            binding.ophthaInfoDetailsTb,
            binding.ophthaInfoDetailsVp
        ) { tab, position ->
            tab.text = information[position]
        }.attach()

        andaOphthaInfoAdapter.addFragment(OphthaInfoEventsFragment(ophthaInfoEventDatas))
        andaOphthaInfoAdapter.addFragment(OphthaInfoReviewsFragment(ophthaInfoReviewDatas))
        andaOphthaInfoAdapter.addFragment(OphthaInfoRatingsFragment())
        binding.ophthaInfoDetailsVp.adapter = andaOphthaInfoAdapter
        binding.ophthaInfoDetailsVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    private fun addDetailsReviews() {
        ophthaInfoReviewDatas.apply {

            add(
                OphthaInfoReview(
                    "라식",
                    5000,
                    "의사A",
                    5.0,
                    true,
                    "속이 더부룩하고 신물 올라와서 방문했는데 병원도 나름 깔끔하고 버스 정류장도 가까워서 더운날에 멀지않아 좋았어요. 아픈데 거리도 있으면 너무 힘들것같아 가까운곳으로 찾아봤는데 너무 좋았던 것 같아요!!"
                )
            )
            add(
                OphthaInfoReview(
                    "라식",
                    5000,
                    "의사B",
                    5.0,
                    false,
                    "최고에요!!"
                )
            )
            add(
                OphthaInfoReview(
                    "라식",
                    5000,
                    "의사C",
                    5.0,
                    true,
                    "속이 더부룩하고 신물 올라와서 방문했는데 병원도 나름 깔끔하고 버스 정류장도 가까워서 더운날에 멀지않아 좋았어요."
                )
            )
            add(
                OphthaInfoReview(
                    "라식",
                    5000,
                    "의사D",
                    5.0,
                    false,
                    "리뷰4"
                )
            )
            add(
                OphthaInfoReview(
                    "라식",
                    5000,
                    "의사E",
                    5.0,
                    true,
                    "리뷰5"
                )
            )
        }
    }


    private fun addDetailsEvents() {
        ophthaInfoEventDatas.apply {
            add(
                OphthaInfoEvent(
                    R.drawable.ex_img,
                    "이벤트 이름1",
                    "라식",
                    "2021.02.04 ~ 2021.03.01"
                )
            )
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
            add(
                OphthaInfoEvent(
                    R.drawable.ophtha_ex_img,
                    "이벤트 이름6",
                    "백내장"
                )
            )
            add(
                OphthaInfoEvent(
                    R.drawable.ex_img,
                    "이벤트 이름7",
                    "라식",
                    "2021.02.04 ~ 2021.03.01"
                )
            )
            add(
                OphthaInfoEvent(
                    R.drawable.real_ophtha_ex_img,
                    "이벤트 이름8",
                    "라섹"
                )
            )
            add(
                OphthaInfoEvent(
                    R.drawable.ophtha_ex_img,
                    "이벤트 이름9",
                    "기타진료"
                )
            )
            add(
                OphthaInfoEvent(
                    R.drawable.ex_img,
                    "이벤트 이름10",
                    "라식",
                    "2021.02.04 ~ 2021.03.01"
                )
            )
            add(
                OphthaInfoEvent(
                    R.drawable.real_ophtha_ex_img,
                    "이벤트 이름11",
                    "라섹"
                )
            )
            add(
                OphthaInfoEvent(
                    R.drawable.ophtha_ex_img,
                    "이벤트 이름12",
                    "스마일라식"
                )
            )
            add(
                OphthaInfoEvent(
                    R.drawable.ex_img,
                    "이벤트 이름13",
                    "라식"
                )
            )
            add(
                OphthaInfoEvent(
                    R.drawable.real_ophtha_ex_img,
                    "이벤트 이름14",
                    "라섹",
                    "2021.02.04 ~ 2021.03.01"
                )
            )
            add(
                OphthaInfoEvent(
                R.drawable.ophtha_ex_img,
                "이벤트 이름15",
                "기타진료"
                )
            )
            add(
                OphthaInfoEvent(
                R.drawable.ex_img,
                "이벤트 이름16",
                "라식"
                )
            )
            add(
                OphthaInfoEvent(
                    R.drawable.real_ophtha_ex_img,
                    "이벤트 이름17",
                    "백내장",
                    "2021.02.04 ~ 2021.03.01"
                )
            )
            add(
                OphthaInfoEvent(
                    R.drawable.ophtha_ex_img,
                    "이벤트 이름18",
                    "백내장"))
            add(
                OphthaInfoEvent(
                    R.drawable.ex_img,
                    "이벤트 이름19",
                    "렌즈삽입술",
                    "2021.02.04 ~ 2021.03.01"
                )
            )
            add(
                OphthaInfoEvent(
                    R.drawable.real_ophtha_ex_img,
                    "이벤트 이름20",
                    "라섹"
                )
            )
            add(
                OphthaInfoEvent(
                    R.drawable.ophtha_ex_img,
                    "이벤트 이름21",
                    "기타진료",
                    "2021.02.04 ~ 2021.03.01"
                )
            )
            add(
                OphthaInfoEvent(
                    R.drawable.ex_img,
                    "이벤트 이름22",
                    "라식",
                    "2021.02.04 ~ 2021.03.01"
                )
            )
            add(
                OphthaInfoEvent(
                    R.drawable.real_ophtha_ex_img,
                    "이벤트 이름23",
                    "라섹",
                    "2021.02.04 ~ 2021.03.01"
                )
            )
            add(
                OphthaInfoEvent(
                    R.drawable.ophtha_ex_img,
                    "이벤트 이름24",
                    "기타진료"
                )
            )
        }
    }
}