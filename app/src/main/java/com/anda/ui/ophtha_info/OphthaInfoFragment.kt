package com.anda.ui.ophtha_info

import android.content.Context
import android.content.SharedPreferences
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
import com.anda.data.entities.*
import com.anda.databinding.FragmentOphthaInfoBinding
import com.google.android.material.tabs.TabLayoutMediator
import java.util.prefs.AbstractPreferences

class OphthaInfoFragment(private val ophthaId : Int) : Fragment(), OnClickListener {

    val ophthaInfoEventDatas = ArrayList<ExOphthaInfoEvent>()
    val ophthaInfoReviewDatas = ArrayList<ExOphthaInfoReview>()
    val ophthaInfoRatingData = ExOphthaInfoRating()
    lateinit var binding: FragmentOphthaInfoBinding
    private lateinit var ophthaSharedPreferences: SharedPreferences
    private lateinit var reviewSharedPreferences: SharedPreferences
    var isLikeChecked : Boolean = false

    var kindnessAvg : Float = 0f
    var effectiveAvg : Float = 0f
    var WaitingAvg : Float = 0f
    var informationAvg : Float = 0f
    var priceAvg : Float = 0f


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOphthaInfoBinding.inflate(inflater, container, false)

        ophthaSharedPreferences = requireContext().getSharedPreferences("Ophtha" + ophthaId.toString(), Context.MODE_PRIVATE)





        binding.ophthaInfoDetailsEventBackgroundIv.setOnClickListener(this)
        binding.ophthaInfoDetailsEventTxtTv.setOnClickListener(this)
        binding.ophthaInfoDetailsReviewBackgroundIv.setOnClickListener(this)
        binding.ophthaInfoDetailsReviewTxtTv.setOnClickListener(this)
        binding.ophthaInfoDetailsRatingSortBackgroundIv.setOnClickListener(this)
        binding.ophthaInfoDetailsRatingSortTxtTv.setOnClickListener(this)
        binding.ophthaInfoOphthaLikeIv.setOnClickListener(this)

        binding.ophthaInfoDetailsVp.isUserInputEnabled = false
        binding.ophthaInfoDetailsVp.clipToOutline = true

        binding.ophthaInfoOphthaNameTv.text = ophthaSharedPreferences.getString("name", "김안과의원")
        binding.ophthaInfoOphthaRatingAvgTv.text = "(" + ophthaSharedPreferences.getFloat("totalRating", 0f).toString() + ")"
        binding.ophthaInfoOphthaRatingCntTv.text = "(" + ophthaSharedPreferences.getInt("cnt", 0).toString() + ")"
        binding.ophthaInfoOphthaImageBackgroundIv.setImageResource(ophthaSharedPreferences.getInt("img", R.drawable.ophtha_info_details_tb_background))

        optionDetails()

        return binding.root
    }


    private fun optionDetails() {
        //addDetailsEvents()
        addDetailsReviews()

        ophthaInfoRatingData.reviewCnt = ophthaSharedPreferences.getInt("reviwCnt", 0)
        ophthaInfoRatingData.totalRating = ophthaSharedPreferences.getFloat("totalRating", 0f)
        ophthaInfoRatingData.kindnessAvg = kindnessAvg
        ophthaInfoRatingData.effectiveAvg = effectiveAvg
        ophthaInfoRatingData.WaitingAvg = WaitingAvg
        ophthaInfoRatingData.informationAvg = informationAvg
        ophthaInfoRatingData.priceAvg = priceAvg

        val andaOphthaInfoAdapter =
            OphthaInfoBannerVPAdapter(this, ophthaInfoEventDatas, ophthaInfoReviewDatas, ophthaInfoRatingData)
        binding.ophthaInfoDetailsVp.adapter = andaOphthaInfoAdapter


        andaOphthaInfoAdapter.addFragment(OphthaInfoEventsFragment(ophthaInfoEventDatas))
        andaOphthaInfoAdapter.addFragment(OphthaInfoReviewsFragment(ophthaInfoReviewDatas))
        andaOphthaInfoAdapter.addFragment(OphthaInfoRatingsFragment(ophthaInfoRatingData))
        binding.ophthaInfoDetailsVp.adapter = andaOphthaInfoAdapter
        binding.ophthaInfoDetailsVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
    }

    private fun addDetailsReviews() {
        val reviewCnt = ophthaSharedPreferences.getInt("reviwCnt", 0)
        kindnessAvg = 0f
        effectiveAvg  = 0f
        WaitingAvg = 0f
        informationAvg = 0f
        priceAvg = 0f
        for (i in 1..reviewCnt){
            reviewSharedPreferences = requireContext().getSharedPreferences("Ophtha${ophthaId}_review${i}", Context.MODE_PRIVATE)
            kindnessAvg += reviewSharedPreferences.getInt("ratingKindness", 0)
            effectiveAvg  += reviewSharedPreferences.getInt("ratingEffect", 0)
            WaitingAvg += reviewSharedPreferences.getInt("ratingWaitingTime", 0)
            informationAvg += reviewSharedPreferences.getInt("ratingInformation", 0)
            priceAvg += reviewSharedPreferences.getInt("ratingPrice", 0)
            ophthaInfoReviewDatas.apply{
                add(
                    ExOphthaInfoReview(
                        ophthaSharedPreferences.getString("operation", "라식"),
                        reviewSharedPreferences.getInt("price", 0),
                        "",
                        reviewSharedPreferences.getInt("totalRating", 0).toFloat(),
                        false,
                        reviewSharedPreferences.getString("review", "완전 좋았습니다!"),
                        reviewSharedPreferences.getInt("ratingKindness", 0).toInt(),
                        reviewSharedPreferences.getInt("ratingWaitingTime", 0).toInt(),
                        reviewSharedPreferences.getInt("ratingEffect", 0).toInt(),
                        reviewSharedPreferences.getInt("ratingInformation", 0).toInt(),
                        reviewSharedPreferences.getInt("ratingPrice", 0).toInt(),
                        reviewSharedPreferences.getString("nickName", "")
                    )
                )
            }
        }

        kindnessAvg /= reviewCnt
        effectiveAvg /= reviewCnt
        WaitingAvg /= reviewCnt
        informationAvg /= reviewCnt
        priceAvg /= reviewCnt
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