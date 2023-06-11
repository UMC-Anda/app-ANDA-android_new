package com.anda.ui.main.compare

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.R
import com.anda.data.entities.ChallengeItem
import com.anda.data.entities.CompareOphthaReview
import com.anda.data.entities.ExOphthaInfoReview
import com.anda.databinding.ItemCompareOphthaReviewBinding

class CompareOphthaReviewRVAdapter(private var compareOphthaReviewsList: ArrayList<ExOphthaInfoReview>) : RecyclerView.Adapter<CompareOphthaReviewRVAdapter.ViewHolder>() {

    interface ItemClickListener{ fun onItemClick(ophthaInfoReview : ExOphthaInfoReview){        } }

    private lateinit var mItemClickListener : ItemClickListener
    fun setItemClickListener(itemClickListener : ItemClickListener){
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): CompareOphthaReviewRVAdapter.ViewHolder {

        val binding: ItemCompareOphthaReviewBinding = ItemCompareOphthaReviewBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CompareOphthaReviewRVAdapter.ViewHolder, position: Int) {
        holder.bind(compareOphthaReviewsList[position])
        holder.itemView.setOnClickListener { mItemClickListener.onItemClick(compareOphthaReviewsList[position]) }
        var ophtha = compareOphthaReviewsList[position]
        Log.d("CompareOphthaRVAdapter122", "Item nickname: ${ophtha.nickName} Item nickname: ${position} reviewCnt ${itemCount}")
    }

    override fun getItemCount(): Int {
        return compareOphthaReviewsList.size
    }

    inner class ViewHolder(val binding: ItemCompareOphthaReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(compareOphthaReviews: ExOphthaInfoReview) {
            // 안과 정보 넣기
            binding.itemCompareOphthaReviewUserProfileIv.setImageResource(R.color.MAIN_70)
            binding.itemCompareOphthaReviewRatingRb.rating = compareOphthaReviews.totalRating!!.toFloat()/2
            binding.itemCompareOphthaReviewUserNameTv.text = compareOphthaReviews.nickName

            val lenth = compareOphthaReviews.reviewTxt!!.length
            val reviewText = if (lenth > 35) {
                compareOphthaReviews.reviewTxt!!.substring(0, 35) + "  ...더보기"
            } else {
                compareOphthaReviews.reviewTxt
            }
            binding.itemCompareOphthaReviewTextTv.text = reviewText

        }

    }
}