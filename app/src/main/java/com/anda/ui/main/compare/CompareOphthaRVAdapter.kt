package com.anda.ui.main.compare

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.anda.R
import com.anda.data.entities.CompareOphtha
import com.anda.data.entities.CompareOphthaReview
import com.anda.databinding.ItemCompareOphthaBinding


class CompareOphthaRVAdapter (private var compareOphthaList: ArrayList<CompareOphtha>): RecyclerView.Adapter<CompareOphthaRVAdapter.ViewHolder>() {

    private var compareOphthaReviewDatas = ArrayList<CompareOphthaReview>()

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int,
    ): CompareOphthaRVAdapter.ViewHolder {

        val binding: ItemCompareOphthaBinding = ItemCompareOphthaBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false
        )



        settingOphthaReviews(binding, viewGroup)
        return ViewHolder(binding)
    }

    private fun settingOphthaReviews(
        binding: ItemCompareOphthaBinding,
        viewGroup: ViewGroup
    ) {
        compareOphthaReviewDatas.apply {
            add(
                CompareOphthaReview(
                    R.color.Main,
                    "냥냥펀치",
                    3,
                    221.128,
                    4,
                    1,
                    0,
                    1,
                    1,
                    1,
                    0,
                    true,
                    "원장님 꼼꼼하게 설명해주시고,\n어려운 용어도 알아듣기 쉽게 설명해주셔서 정말 좋았어요."
                )
            )
            add(
                CompareOphthaReview(
                    R.color.Main,
                    "냥냥펀치",
                    2,
                    2211.28,
                    4,
                    1,
                    0,
                    1,
                    1,
                    1,
                    0,
                    false,
                    "원장님 꼼꼼하게 설명해주시고,\n 지인들에게도 항상 이 병원을 추천한답니다 ㅎ_ㅎ"
                )
            )
            add(
                CompareOphthaReview(
                    R.color.Main,
                    "냥냥펀치",
                    1,
                    2211.28,
                    2,
                    1,
                    0,
                    1,
                    1,
                    1,
                    0,
                    false,
                    "어려운 용어도 알아듣기 쉽게 설명해주셔서 정말 좋았어요.\n지인들에게도 항상 이 병원을 추천한답니다 ㅎ_ㅎ"
                )
            )
            add(
                CompareOphthaReview(
                    R.color.Main,
                    "냥냥펀치",
                    5,
                    221.128,
                    1,
                    1,
                    0,
                    1,
                    1,
                    1,
                    0,
                    true,
                    "원장님 꼼꼼하게 설명해주시고,\n어려운 용어도 알아듣기 쉽게 설명해주셔서 정말 좋았어요. 지인들에게도 항상 이 병원을 추천한답니다 ㅎ_ㅎ"
                )
            )
            add(
                CompareOphthaReview(
                    R.color.Main,
                    "냥냥펀치",
                    8,
                    22.1128,
                    5,
                    1,
                    0,
                    1,
                    1,
                    1,
                    0,
                    false,
                    "원장님 꼼꼼하게 설명해주시고,\n어려운 용어도 알아듣기 쉽게 설명해주셔서 정말 좋았어요. 지인들에게도 항상 이 병원을 추천한답니다 ㅎ_ㅎ"
                )
            )
        }

        val compareOphthaReviewRVAdapter = CompareOphthaReviewRVAdapter(compareOphthaReviewDatas)
        binding.itemCompareOphthaReviewsRv.adapter = compareOphthaReviewRVAdapter
        binding.itemCompareOphthaReviewsRv.layoutManager =
            LinearLayoutManager(viewGroup.context, LinearLayoutManager.HORIZONTAL, false)
        val snap = PagerSnapHelper()
        snap.attachToRecyclerView(binding.itemCompareOphthaReviewsRv)
        binding.itemCompareOphthaReviewsRv.scrollToPosition(1)
    }


    override fun onBindViewHolder(holder: CompareOphthaRVAdapter.ViewHolder, position: Int) {
        holder.bind(compareOphthaList[position])
    }

    override fun getItemCount(): Int = compareOphthaList.size

    inner class ViewHolder(val binding: ItemCompareOphthaBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(compareOphtha: CompareOphtha) {
            binding.itemCompareOphthaNameTv.text = compareOphtha.name
            binding.itemCompareOphthaLocationTv.text = compareOphtha.location
            binding.itemCompareOphthaTotalRatingTv.text = compareOphtha.ratingAvg.toString()
            binding.itemCompareOphthaReviewCntTv.text = compareOphtha.reviewCnt.toString()
            binding.itemCompareOphthaPictureCiv.setImageResource(compareOphtha.picture!!)
        }
    }

}

