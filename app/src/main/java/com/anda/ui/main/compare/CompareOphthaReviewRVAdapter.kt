package com.anda.ui.main.compare

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.R
import com.anda.data.entities.CompareOphthaReview
import com.anda.databinding.ItemCompareOphthaReviewBinding

class CompareOphthaReviewRVAdapter  (private var compareOphthaReviewsList: ArrayList<CompareOphthaReview>): RecyclerView.Adapter<CompareOphthaReviewRVAdapter.ViewHolder>() {

    interface compareReviewItemClickListener{
        fun onItemClick(){

        }
    }




    private lateinit var mItemClickListener : compareReviewItemClickListener
    fun setCompareItemClickListener(itemClickListener : compareReviewItemClickListener){
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
        holder.itemView.setOnClickListener{ mItemClickListener.onItemClick()}
    }

    override fun getItemCount(): Int = compareOphthaReviewsList.size

    inner class ViewHolder(val binding: ItemCompareOphthaReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(compareOphthaReviews: CompareOphthaReview) {
            //            안과 정보 넣기
            binding.itemCompareOphthaReviewUserProfileIv.setImageResource(compareOphthaReviews.profileImg!!)
            binding.itemCompareOphthaReviewUserNameTv.text = compareOphthaReviews.userName
            binding.itemCompareOphthaReviewUserLevelTv.text = "Level " + compareOphthaReviews.userLevel.toString()
            binding.itemCompareOphthaReviewRatingRb.rating = compareOphthaReviews.totalRating!!.toFloat()
            binding.itemCompareOphthaReviewTextTv.text = compareOphthaReviews.reviewTxt
        }
    }
}