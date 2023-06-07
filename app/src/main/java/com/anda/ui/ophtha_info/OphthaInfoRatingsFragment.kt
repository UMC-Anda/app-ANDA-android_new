package com.anda.ui.ophtha_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.data.entities.ExOphthaInfoRating
import com.anda.data.entities.ExOphthaInfoReview
import com.anda.databinding.FragmentOphthaInfoRatingsBinding

class OphthaInfoRatingsFragment(val ophthaInfoReviewsData:ExOphthaInfoRating?) : Fragment() {

    private val reviewCnt:Int = ophthaInfoReviewsData!!.reviewCnt!!
    private val totalRating : Float = ophthaInfoReviewsData!!.totalRating!!
    private val kindnessAvg : Float = ophthaInfoReviewsData!!.kindnessAvg!!
    private val effectiveAvg : Float = ophthaInfoReviewsData!!.effectiveAvg!!
    private val WaitingAvg : Float = ophthaInfoReviewsData!!.WaitingAvg!!
    private val informationAvg : Float = ophthaInfoReviewsData!!.informationAvg!!
    private val priceAvg : Float = ophthaInfoReviewsData!!.priceAvg!!

    lateinit var binding: FragmentOphthaInfoRatingsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOphthaInfoRatingsBinding.inflate(inflater, container, false)


        binding.ophthaInfoRatingKindRatingProgressbarPb.clipToOutline = true
        binding.ophthaInfoRatingWaitingRatingProgressbarPb.clipToOutline = true
        binding.ophthaInfoRatingPriceRatingProgressbarPb.clipToOutline = true
        binding.ophthaInfoRatingInformationRatingProgressbarPb.clipToOutline = true
        binding.ophthaInfoRatingEffectiveRatingProgressbarPb.clipToOutline = true
        binding.ophthaInfoRatingKindRatingProgressbarPb.clipToOutline = true
        setInfos()

        return binding.root
    }

    private fun setInfos() {
        binding.ophthaInfoRatingsReviewCntTv.text = reviewCnt.toString()
        binding.ophthaInfoRatingsTotalAvgRatingTv.text = totalRating.toString()
        binding.ophthaInfoRatingKindRatingTxtTv.text = "(" + kindnessAvg.toString() + "/2)"
        binding.ophthaInfoRatingEffectiveRatingTxtTv.text = "(" + effectiveAvg.toString() + "/2)"
        binding.ophthaInfoRatingWaitingRatingTxtTv.text = "(" + WaitingAvg.toString() + "/2)"
        binding.ophthaInfoRatingInformationTxtTv.text = "(" + informationAvg.toString() + "/2)"
        binding.ophthaInfoRatingPriceTxtTv.text = "(" + priceAvg.toString() + "/2)"
    }

    override fun onResume() {
        super.onResume()
        binding.root.requestLayout()
    }
}