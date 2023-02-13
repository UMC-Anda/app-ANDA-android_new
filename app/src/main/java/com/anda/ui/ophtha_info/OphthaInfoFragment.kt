package com.anda.ui.ophtha_info

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.View.VISIBLE
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.anda.R
import com.anda.data.entities.ExOphthaInfoEvent
import com.anda.data.entities.ExOphthaInfoReview
import com.anda.data.entities.OphthaInfoEvent
import com.anda.data.entities.OphthaInfoReview
import com.anda.databinding.FragmentOphthaInfoBinding
import com.google.android.material.tabs.TabLayoutMediator

class OphthaInfoFragment() : Fragment(), OnClickListener {

    val ophthaInfoEventDatas = ArrayList<ExOphthaInfoEvent>()
    val ophthaInfoReviewDatas = ArrayList<ExOphthaInfoReview>()
    lateinit var binding: FragmentOphthaInfoBinding
    var isLikeChecked : Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOphthaInfoBinding.inflate(inflater, container, false)


        binding.ophthaInfoDetailsEventBackgroundIv.setOnClickListener(this)
        binding.ophthaInfoDetailsEventTxtTv.setOnClickListener(this)
        binding.ophthaInfoDetailsReviewBackgroundIv.setOnClickListener(this)
        binding.ophthaInfoDetailsReviewTxtTv.setOnClickListener(this)
        binding.ophthaInfoDetailsRatingSortBackgroundIv.setOnClickListener(this)
        binding.ophthaInfoDetailsRatingSortTxtTv.setOnClickListener(this)
        binding.ophthaInfoOphthaLikeIv.setOnClickListener(this)

        binding.ophthaInfoDetailsVp.clipToOutline = true
        optionDetails()

        return binding.root
    }


    private fun optionDetails() {
        addDetailsEvents()
        addDetailsReviews()

        val andaOphthaInfoAdapter =
            OphthaInfoBannerVPAdapter(this, ophthaInfoEventDatas, ophthaInfoReviewDatas)
        binding.ophthaInfoDetailsVp.adapter = andaOphthaInfoAdapter

        andaOphthaInfoAdapter.addFragment(OphthaInfoEventsFragment(ophthaInfoEventDatas))
        andaOphthaInfoAdapter.addFragment(OphthaInfoReviewsFragment(ophthaInfoReviewDatas))
        andaOphthaInfoAdapter.addFragment(OphthaInfoRatingsFragment())
        binding.ophthaInfoDetailsVp.adapter = andaOphthaInfoAdapter
        binding.ophthaInfoDetailsVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    private fun addDetailsReviews() {
        ophthaInfoReviewDatas.apply {

            add(
                ExOphthaInfoReview(
                    "라식",
                    5000,
                    "의사A",
                    5.0,
                    true,
                    "속이 더부룩하고 신물 올라와서 방문했는데 병원도 나름 깔끔하고 버스 정류장도 가까워서 더운날에 멀지않아 좋았어요. 아픈데 거리도 있으면 너무 힘들것같아 가까운곳으로 찾아봤는데 너무 좋았던 것 같아요!!"
                )
            )
            add(
                ExOphthaInfoReview(
                    "라식",
                    5000,
                    "의사B",
                    5.0,
                    false,
                    "최고에요!!"
                )
            )
            add(
                ExOphthaInfoReview(
                    "라식",
                    5000,
                    "의사C",
                    5.0,
                    true,
                    "속이 더부룩하고 신물 올라와서 방문했는데 병원도 나름 깔끔하고 버스 정류장도 가까워서 더운날에 멀지않아 좋았어요."
                )
            )
            add(
                ExOphthaInfoReview(
                    "라식",
                    5000,
                    "의사D",
                    5.0,
                    false,
                    "리뷰4"
                )
            )
            add(
                ExOphthaInfoReview(
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
                ExOphthaInfoEvent(
                    R.drawable.ex_img,
                    "이벤트 이름1",
                    "라식",
                    "2021.02.04 ~ 2021.03.01"
                )
            )
            add(
                ExOphthaInfoEvent(
                    R.drawable.real_ophtha_ex_img,
                    "이벤트 이름2",
                    "라섹",
                    "2021.02.04 ~ 2021.03.01"
                )
            )
            add(
                ExOphthaInfoEvent(
                    R.drawable.ophtha_ex_img,
                    "이벤트 이름3",
                    "기타진료",
                    "2021.02.04 ~ 2021.03.01"
                )
            )
            add(ExOphthaInfoEvent(R.drawable.ex_img, "이벤트 이름4", "라식", "2021.02.04 ~ 2021.03.01"))
            add(
                ExOphthaInfoEvent(
                    R.drawable.real_ophtha_ex_img,
                    "이벤트 이름5",
                    "라섹",
                    "2021.02.04 ~ 2021.03.01"
                )
            )
            add(
                ExOphthaInfoEvent(
                    R.drawable.ophtha_ex_img,
                    "이벤트 이름6",
                    "백내장"
                )
            )
            add(
                ExOphthaInfoEvent(
                    R.drawable.ex_img,
                    "이벤트 이름7",
                    "라식",
                    "2021.02.04 ~ 2021.03.01"
                )
            )
            add(
                ExOphthaInfoEvent(
                    R.drawable.real_ophtha_ex_img,
                    "이벤트 이름8",
                    "라섹"
                )
            )
            add(
                ExOphthaInfoEvent(
                    R.drawable.ophtha_ex_img,
                    "이벤트 이름9",
                    "기타진료"
                )
            )
            add(
                ExOphthaInfoEvent(
                    R.drawable.ex_img,
                    "이벤트 이름10",
                    "라식",
                    "2021.02.04 ~ 2021.03.01"
                )
            )
            add(
                ExOphthaInfoEvent(
                    R.drawable.real_ophtha_ex_img,
                    "이벤트 이름11",
                    "라섹"
                )
            )
            add(
                ExOphthaInfoEvent(
                    R.drawable.ophtha_ex_img,
                    "이벤트 이름12",
                    "스마일라식"
                )
            )
            add(
                ExOphthaInfoEvent(
                    R.drawable.ex_img,
                    "이벤트 이름13",
                    "라식"
                )
            )
            add(
                ExOphthaInfoEvent(
                    R.drawable.real_ophtha_ex_img,
                    "이벤트 이름14",
                    "라섹",
                    "2021.02.04 ~ 2021.03.01"
                )
            )
            add(
                ExOphthaInfoEvent(
                R.drawable.ophtha_ex_img,
                "이벤트 이름15",
                "기타진료"
                )
            )
            add(
                ExOphthaInfoEvent(
                R.drawable.ex_img,
                "이벤트 이름16",
                "라식"
                )
            )
            add(
                ExOphthaInfoEvent(
                    R.drawable.real_ophtha_ex_img,
                    "이벤트 이름17",
                    "백내장",
                    "2021.02.04 ~ 2021.03.01"
                )
            )
            add(
                ExOphthaInfoEvent(
                    R.drawable.ophtha_ex_img,
                    "이벤트 이름18",
                    "백내장"))
            add(
                ExOphthaInfoEvent(
                    R.drawable.ex_img,
                    "이벤트 이름19",
                    "렌즈삽입술",
                    "2021.02.04 ~ 2021.03.01"
                )
            )
            add(
                ExOphthaInfoEvent(
                    R.drawable.real_ophtha_ex_img,
                    "이벤트 이름20",
                    "라섹"
                )
            )
            add(
                ExOphthaInfoEvent(
                    R.drawable.ophtha_ex_img,
                    "이벤트 이름21",
                    "기타진료",
                    "2021.02.04 ~ 2021.03.01"
                )
            )
            add(
                ExOphthaInfoEvent(
                    R.drawable.ex_img,
                    "이벤트 이름22",
                    "라식",
                    "2021.02.04 ~ 2021.03.01"
                )
            )
            add(
                ExOphthaInfoEvent(
                    R.drawable.real_ophtha_ex_img,
                    "이벤트 이름23",
                    "라섹",
                    "2021.02.04 ~ 2021.03.01"
                )
            )
            add(
                ExOphthaInfoEvent(
                    R.drawable.ophtha_ex_img,
                    "이벤트 이름24",
                    "기타진료"
                )
            )
        }
    }

    override fun onClick(v: View?) {
        if (v == null) return
        when(v){
            binding.ophthaInfoDetailsEventBackgroundIv ->{
                resetTbSetting()
                binding.ophthaInfoDetailsEventBackgroundIv.setImageResource(R.drawable.ophtha_info_details_tb_background)
                binding.ophthaInfoDetailsEventTxtTv.setTextColor(resources.getColor(R.color.MAIN_50))
                binding.ophthaInfoDetailsVp.setCurrentItem(0, true)
            }
            binding.ophthaInfoDetailsEventTxtTv ->{
                resetTbSetting()
                binding.ophthaInfoDetailsEventBackgroundIv.setImageResource(R.drawable.ophtha_info_details_tb_background)
                binding.ophthaInfoDetailsEventTxtTv.setTextColor(resources.getColor(R.color.MAIN_50))
                binding.ophthaInfoDetailsVp.setCurrentItem(0, true)
            }
            binding.ophthaInfoDetailsReviewBackgroundIv ->{
                resetTbSetting()
                binding.ophthaInfoDetailsReviewBackgroundIv.setImageResource(R.drawable.ophtha_info_details_tb_background)
                binding.ophthaInfoDetailsReviewTxtTv.setTextColor(resources.getColor(R.color.MAIN_50))
                binding.ophthaInfoDetailsVp.setCurrentItem(1, true)
            }
            binding.ophthaInfoDetailsReviewTxtTv ->{
                resetTbSetting()
                binding.ophthaInfoDetailsReviewBackgroundIv.setImageResource(R.drawable.ophtha_info_details_tb_background)
                binding.ophthaInfoDetailsReviewTxtTv.setTextColor(resources.getColor(R.color.MAIN_50))
                binding.ophthaInfoDetailsVp.setCurrentItem(1, true)
            }
            binding.ophthaInfoDetailsRatingSortBackgroundIv ->{
                resetTbSetting()
                binding.ophthaInfoDetailsRatingSortBackgroundIv.setImageResource(R.drawable.ophtha_info_details_tb_background)
                binding.ophthaInfoDetailsRatingSortTxtTv.setTextColor(resources.getColor(R.color.MAIN_50))
                binding.ophthaInfoDetailsVp.setCurrentItem(2, true)
            }
            binding.ophthaInfoDetailsRatingSortTxtTv ->{
                resetTbSetting()
                binding.ophthaInfoDetailsRatingSortBackgroundIv.setImageResource(R.drawable.ophtha_info_details_tb_background)
                binding.ophthaInfoDetailsRatingSortTxtTv.setTextColor(resources.getColor(R.color.MAIN_50))
                binding.ophthaInfoDetailsVp.setCurrentItem(2,true)
            }

            binding.ophthaInfoOphthaLikeIv ->{
                if(isLikeChecked){
                    isLikeChecked = false
                    binding.ophthaInfoOphthaLikeIv.setImageResource(R.drawable.ophtha_info_unchecked_heart)

                } else{
                    isLikeChecked = true
                    binding.ophthaInfoOphthaLikeIv.setImageResource(R.drawable.ophtha_info_checked_heart)
                }
            }
        }
    }

    private fun resetTbSetting() {
        binding.ophthaInfoDetailsEventTxtTv.setTextColor(resources.getColor(R.color.MAIN_50))
        binding.ophthaInfoDetailsReviewTxtTv.setTextColor(resources.getColor(R.color.MAIN_50))
        binding.ophthaInfoDetailsRatingSortTxtTv.setTextColor(resources.getColor(R.color.MAIN_50))
        binding.ophthaInfoDetailsEventBackgroundIv.setImageResource(R.color.gray)
        binding.ophthaInfoDetailsReviewBackgroundIv.setImageResource(R.color.gray)
        binding.ophthaInfoDetailsRatingSortBackgroundIv.setImageResource(R.color.gray)
    }
}