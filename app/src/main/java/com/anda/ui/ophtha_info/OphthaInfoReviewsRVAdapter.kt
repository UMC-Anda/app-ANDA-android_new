package com.anda.ui.ophtha_info

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.R
import com.anda.data.entities.OphthaInfoEvent
import com.anda.data.entities.OphthaInfoReview
import com.anda.databinding.ItemOphthaInfoEventBinding
import com.anda.databinding.ItemOphthaInfoReviewBinding

class OphthaInfoReviewsRVAdapter (private val ophthaInfoReviewList: ArrayList<OphthaInfoReview>): RecyclerView.Adapter<OphthaInfoReviewsRVAdapter.ViewHolder>() {

    private lateinit var mItemClickListener: ophthaInfoReviewsItemClickListener
    var mPosition = 0

    interface ophthaInfoReviewsItemClickListener {
        fun onItemClick() {

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
        holder.itemView.setOnClickListener { mItemClickListener.onItemClick() }
    }


    override fun getItemCount(): Int = ophthaInfoReviewList.size

    inner class ViewHolder(val binding: ItemOphthaInfoReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(ophthaInfoReview: OphthaInfoReview) {
            if(ophthaInfoReview.isReceipted == true){
                binding.itemOphthaInfoReviewRecieptIv.setImageResource(R.drawable.item_ophtha_info_review_receipt)
            }
            else{
                binding.itemOphthaInfoReviewRecieptIv.setImageResource(R.color.white)
            }
            binding.itemOphthaInfoReviewCategoryTv.text = ophthaInfoReview.operationCategory
            binding.itemOphthaInfoReviewTotalRatingRb.rating = ophthaInfoReview.totalRating!!.toFloat()
            binding.itemOphthaInfoReviewDoctorNameTv.text = ophthaInfoReview.operationDoctor
            binding.itemOphthaInfoReviewTextReviewTv.text = ophthaInfoReview.reviewTxt
            binding.itemOphthaInfoReviewPriceCategoryTv.text = ophthaInfoReview.operationCategory
            binding.itemOphthaInfoReviewPriceTv.text = ophthaInfoReview.operationPrice.toString()
        }
    }


}