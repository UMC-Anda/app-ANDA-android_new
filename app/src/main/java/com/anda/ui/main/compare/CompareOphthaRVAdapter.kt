package com.anda.ui.main.compare

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.anda.R
import com.anda.data.entities.CompareOphtha
import com.anda.data.entities.CompareOphthaReview
import com.anda.databinding.ItemCompareOphthaBinding

class CompareOphthaRVAdapter (private var compareOphthaList: ArrayList<CompareOphtha>): RecyclerView.Adapter<CompareOphthaRVAdapter.ViewHolder>() {

    private var compareOphthaReviewDatas = ArrayList<CompareOphthaReview>()

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): CompareOphthaRVAdapter.ViewHolder {

        val binding: ItemCompareOphthaBinding = ItemCompareOphthaBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false)
        addReviews(binding, viewGroup)

        return ViewHolder(binding)
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

    private fun addReviews(//            리뷰 넣기
        binding: ItemCompareOphthaBinding,
        viewGroup: ViewGroup
    ) {
        compareOphthaReviewDatas.apply {
            add(
                CompareOphthaReview(
                    R.drawable.ophtha_ex_img,
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
                    0,
                    "원장님 꼼꼼하게 설명해주시고,\n어려운 용어도 알아듣기 쉽게 설명해주셔서 정말 좋았어요. 지인들에게도 항상 이 병원을 추천한답니다 ㅎ_ㅎ"
                )
            )
            add(
                CompareOphthaReview(
                    R.drawable.ophtha_ex_img,
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
                    0,
                    "원장님 꼼꼼하게 설명해주시고,\n어려운 용어도 알아듣기 쉽게 설명해주셔서 정말 좋았어요. 지인들에게도 항상 이 병원을 추천한답니다 ㅎ_ㅎ"
                )
            )
            add(
                CompareOphthaReview(
                    R.drawable.ophtha_ex_img,
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
                    0,
                    "원장님 꼼꼼하게 설명해주시고,\n어려운 용어도 알아듣기 쉽게 설명해주셔서 정말 좋았어요. 지인들에게도 항상 이 병원을 추천한답니다 ㅎ_ㅎ"
                )
            )
            add(
                CompareOphthaReview(
                    R.drawable.ophtha_ex_img,
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
                    0,
                    "원장님 꼼꼼하게 설명해주시고,\n어려운 용어도 알아듣기 쉽게 설명해주셔서 정말 좋았어요. 지인들에게도 항상 이 병원을 추천한답니다 ㅎ_ㅎ"
                )
            )
            add(
                CompareOphthaReview(
                    R.drawable.ophtha_ex_img,
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
                    0,
                    "원장님 꼼꼼하게 설명해주시고,\n어려운 용어도 알아듣기 쉽게 설명해주셔서 정말 좋았어요. 지인들에게도 항상 이 병원을 추천한답니다 ㅎ_ㅎ"
                )
            )
        }
        val compareOphthaReviewRVAdapter = CompareOphthaReviewRVAdapter(compareOphthaReviewDatas)
        binding.itemCompareOphthaReviewsRv.adapter = compareOphthaReviewRVAdapter
        binding.itemCompareOphthaReviewsRv.layoutManager =
            LinearLayoutManager(viewGroup.context, LinearLayoutManager.HORIZONTAL, false)
    }

}
