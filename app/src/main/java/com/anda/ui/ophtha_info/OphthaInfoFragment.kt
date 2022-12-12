package com.anda.ui.ophtha_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.anda.R
import com.anda.data.entities.HomeAndaRankingOphtha
import com.anda.data.entities.OphthaInfoEvent
import com.anda.databinding.FragmentOphthaInfoBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class OphthaInfoFragment() : Fragment() {

    val ophthaInfoEventList = ArrayList<OphthaInfoEvent>()
    lateinit var binding: FragmentOphthaInfoBinding
    private val information = arrayListOf("이벤트", "리뷰", "별점요약")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOphthaInfoBinding.inflate(inflater, container, false)

        optionDetails()

        val andaOphthaInfoAdapter = OphthaInfoBannerVPAdapter(this)
        binding.ophthaInfoDetailsVp.adapter = andaOphthaInfoAdapter
        TabLayoutMediator(binding.ophthaInfoDetailsTb, binding.ophthaInfoDetailsVp){
                tab, position -> tab.text = information[position]
        }.attach()

        return binding.root
    }

    private fun optionDetails() {
        addDetailsEvents()

        val ophthaInfoBannerAdapter = OphthaInfoBannerVPAdapter(this)
        ophthaInfoBannerAdapter.addFragment(OphthaInfoEventsFragment(ophthaInfoEventList))
        ophthaInfoBannerAdapter.addFragment(OphthaInfoReviewsFragment())
        ophthaInfoBannerAdapter.addFragment(OphthaInfoRatingsFragment())
        binding.ophthaInfoDetailsVp.adapter = ophthaInfoBannerAdapter
        binding.ophthaInfoDetailsVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    private fun addDetailsEvents() {
        ophthaInfoEventList.apply {
            add(OphthaInfoEvent(
                R.drawable.ex_img,
                "이벤트 이름1",
                "라식",
                "2021.02.04 ~ 2021.03.01"))
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