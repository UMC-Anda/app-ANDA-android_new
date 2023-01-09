package com.anda.ui.main.compare.option

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anda.MainActivity
import com.anda.R
import com.anda.data.entities.CompareOphtha
import com.anda.data.entities.CompareOphthaReview
import com.anda.data.entities.CompareSortSelect
import com.anda.databinding.FragmentCompareBinding
import com.anda.databinding.FragmentCompareOptionSelectSortBinding
import com.anda.databinding.ItemCompareOphthaBinding
import com.anda.ui.main.map.MapFragment
import com.anda.ui.write_review.WriteCommunityWritingFragment

class CompareOptionSelectSortFragment() : Fragment(), View.OnClickListener {

    //바인딩
    lateinit var binding: FragmentCompareOptionSelectSortBinding

    private var isRatingChecked = true
    private var isReviewCntChecked = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCompareOptionSelectSortBinding.inflate(inflater, container, false)

        binding.compareOptionSelectSortRating.setOnClickListener(this)
        binding.compareOptionSelectSortReviewCnt.setOnClickListener(this)

        return binding.root
    }

    override fun onClick(v: View?) {
        if (v == null) return
        when (v) {
            binding.compareOptionSelectSortRating -> {
                if (isRatingChecked) {
                    binding.compareOptionSelectSortRatingCheckboxIv.setImageResource(R.drawable.checkbox_unchecked)
                    binding.compareOptionSelectSortRatingCheckboxIv.elevation = 0f
                    binding.compareOptionSelectSortReviewCntCheckboxIv.setImageResource(R.drawable.checkbox_checked)
                    binding.compareOptionSelectSortReviewCntCheckboxIv.elevation = 11f
                    isRatingChecked = false
                    isReviewCntChecked = true
                } else {
                    binding.compareOptionSelectSortRatingCheckboxIv.setImageResource(R.drawable.checkbox_checked)
                    binding.compareOptionSelectSortRatingCheckboxIv.elevation = 11f
                    binding.compareOptionSelectSortReviewCntCheckboxIv.setImageResource(R.drawable.checkbox_unchecked)
                    binding.compareOptionSelectSortReviewCntCheckboxIv.elevation = 0f
                    isRatingChecked = true
                    isReviewCntChecked = false
                }
            }
            binding.compareOptionSelectSortReviewCnt -> {
                if (isReviewCntChecked) {
                    binding.compareOptionSelectSortRatingCheckboxIv.setImageResource(R.drawable.checkbox_checked)
                    binding.compareOptionSelectSortRatingCheckboxIv.elevation = 11f
                    binding.compareOptionSelectSortReviewCntCheckboxIv.setImageResource(R.drawable.checkbox_unchecked)
                    binding.compareOptionSelectSortReviewCntCheckboxIv.elevation = 0f
                    isRatingChecked = true
                    isReviewCntChecked = false
                } else {
                    binding.compareOptionSelectSortRatingCheckboxIv.setImageResource(R.drawable.checkbox_unchecked)
                    binding.compareOptionSelectSortRatingCheckboxIv.elevation = 0f
                    binding.compareOptionSelectSortReviewCntCheckboxIv.setImageResource(R.drawable.checkbox_checked)
                    binding.compareOptionSelectSortReviewCntCheckboxIv.elevation = 11f
                    isRatingChecked = false
                    isReviewCntChecked = true
                }

            }
        }
    }
}

