package com.anda.ui.ophtha_info

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.R
import com.anda.data.entities.ExOphthaInfoReview
import com.anda.data.entities.OphthaInfoEvent
import com.anda.data.entities.OphthaInfoReview
import com.anda.databinding.ItemOphthaInfoEventBinding
import com.anda.databinding.ItemOphthaInfoReviewBinding

class OphthaInfoReviewsRVAdapter (private val ophthaInfoReviewList: ArrayList<ExOphthaInfoReview>): RecyclerView.Adapter<OphthaInfoReviewsRVAdapter.ViewHolder>() {

    private lateinit var mItemClickListener: ophthaInfoReviewsItemClickListener
    var mPosition = 0

    interface ophthaInfoReviewsItemClickListener {
        fun onItemClick(ophthaReview : ExOphthaInfoReview) {

        }
    }

    fun setOphthaInfoReviewsItemClickListener(itemClickListener: ophthaInfoReviewsItemClickListener) {
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): OphthaInfoReviewsRVAdapter.ViewHolder {

        val binding: ItemOphthaInfoReviewBinding = ItemOphthaInfoReviewBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: OphthaInfoReviewsRVAdapter.ViewHolder,
        position: Int
    ) {
        holder.bind(ophthaInfoReviewList[position])
        holder.itemView.setOnClickListener { mItemClickListener.onItemClick(ophthaInfoReviewList[position]) }
    }


    override fun getItemCount(): Int = ophthaInfoReviewList.size

    inner class ViewHolder(val binding: ItemOphthaInfoReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(ophthaInfoReview: ExOphthaInfoReview) {
            if(ophthaInfoReview.isReceipted == true){
                binding.itemOphthaInfoReviewRecieptIv.setImageResource(R.drawable.item_ophtha_info_review_receipt)
            }
            else{
                binding.itemOphthaInfoReviewRecieptIv.setImageResource(R.color.white)
            }
            when(ophthaInfoReview.operationCategory){
                "lasik" -> binding.itemOphthaInfoReviewCategoryTv.text = "라식"
                "lasek" -> binding.itemOphthaInfoReviewCategoryTv.text = "라섹"
                "smile" -> binding.itemOphthaInfoReviewCategoryTv.text = "스마일 라식"
                "today" -> binding.itemOphthaInfoReviewCategoryTv.text = "투데이 라섹"
                "lens" -> binding.itemOphthaInfoReviewCategoryTv.text = "렌즈삽입술"
                "back" -> binding.itemOphthaInfoReviewCategoryTv.text = "백내장"
            }
            binding.itemOphthaInfoReviewTotalRatingRb.rating = ophthaInfoReview.totalRating!!.toFloat()/2
            binding.itemOphthaInfoReviewDoctorNameTv.text = ""
            binding.itemOphthaInfoReviewTotalRatingTv.text = ophthaInfoReview.totalRating!!.toString()
            binding.itemOphthaInfoReviewTextReviewTv.text = ophthaInfoReview.reviewTxt
            binding.itemOphthaInfoReviewPriceTv.text = ophthaInfoReview.operationPrice.toString()
            Log.d("리뷰",ophthaInfoReview.totalRating!!.toFloat().toString() + " / " + ophthaInfoReview.totalRating!!.toString())
        }
    }


}