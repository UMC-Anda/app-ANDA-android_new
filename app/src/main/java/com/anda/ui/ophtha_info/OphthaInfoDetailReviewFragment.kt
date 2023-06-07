package com.anda.ui.ophtha_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.data.entities.ExOphthaInfoReview
import com.anda.databinding.FragmentOphthaInfoReviewDetailBinding
import okhttp3.internal.wait

class OphthaInfoDetailReviewFragment(var ophthaReview : ExOphthaInfoReview)  : Fragment() {

    lateinit var binding: FragmentOphthaInfoReviewDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOphthaInfoReviewDetailBinding.inflate(inflater, container, false)


        binding.ophthaInfoReviewDetailReviewImg1Iv.clipToOutline = true
        binding.ophthaInfoReviewDetailReviewImg2Iv.clipToOutline = true

        binding.ophthaInfoReviewDetailUserNameTv.text = ophthaReview.nickName
        binding.ophthaInfoReviewDetailReviewTextTv.text = ophthaReview.reviewTxt
        binding.ophthaInfoReviewDetailOperationCategoryTv.text = ophthaReview.operationCategory
        binding.ophthaInfoReviewDetailOperationRatingRb.rating = ophthaReview.totalRating!! / 2f
        binding.ophthaInfoReviewDetailOperationRatingTb.text = ophthaReview.totalRating!!.toString()
        binding.ophthaInfoReviewDetailPriceCategoryTv.text = ophthaReview.operationPrice.toString()

        binding.ophthaInfoReviewDetailRatingKindRv.rating = ophthaReview.kindnessRating!! / 2f * 5f
        binding.ophthaInfoReviewDetailRatingEffectiveRv.rating = ophthaReview.effectiveRating!! / 2f* 5f
        binding.ophthaInfoReviewDetailRatingInformationRv.rating = ophthaReview.informationRating!! / 2f* 5f
        binding.ophthaInfoReviewDetailRatingWaitingRv.rating = ophthaReview.waitingRating!! / 2f* 5f

        binding.ophthaInfoReviewDetailPriceCategoryTv.text= when(ophthaReview.operationCategory){
            "lasik" -> "라식"
            "lasek" -> "라섹"
            "smile" -> "스마일 라식"
            "today" -> "투데이 라섹"
            "lens" -> "렌즈 삽입술"
            "back" -> "백내장"
            else -> ""
        }

        binding.ophthaInfoReviewDetailOperationCategoryTv.text = when(ophthaReview.operationCategory){
            "lasik" -> "라식"
            "lasek" -> "라섹"
            "smile" -> "스마일 라식"
            "today" -> "투데이 라섹"
            "lens" -> "렌즈 삽입술"
            "back" -> "백내장"
            else -> ""
        }





        return binding.root
    }
}
