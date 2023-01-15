package com.anda.ui.main.myInfo.myOphtha

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.R
import com.anda.data.entities.ExMyOphtha
import com.anda.databinding.ItemMyInfoMyOphthaBinding

class MyInfoMyOphthaRVAdapter(private val myInfoMyOphthaList: ArrayList<ExMyOphtha>): RecyclerView.Adapter<MyInfoMyOphthaRVAdapter.ViewHolder>() {

    private lateinit var mItemClickListener: myInfoMyOphthaItemClickListener
    var mPosition = 0

    interface myInfoMyOphthaItemClickListener { fun onItemClick() {} }

    fun setMyInfoMyOphthaItemClickListener(itemClickListener: myInfoMyOphthaItemClickListener) {
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): MyInfoMyOphthaRVAdapter.ViewHolder {

        val binding: ItemMyInfoMyOphthaBinding = ItemMyInfoMyOphthaBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyInfoMyOphthaRVAdapter.ViewHolder,
        position: Int
    ) {
        holder.bind(myInfoMyOphthaList[position])
        holder.itemView.setOnClickListener { mItemClickListener.onItemClick() }
    }

    override fun getItemCount(): Int = myInfoMyOphthaList.size

    inner class ViewHolder(val binding: ItemMyInfoMyOphthaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(ophthaInfoEvent: ExMyOphtha) {
            binding.myInfoOphthaImgCiv.setImageResource(ophthaInfoEvent.ophthaImg!!)
            binding.myInfoOphthaNameTv.text = ophthaInfoEvent.ophthaName
            binding.myInfoOphthaLocationTv.text = ophthaInfoEvent.ophthaLocation
            binding.myInfoOphthaRetingAvgTv.text = "(" + ophthaInfoEvent.ophthaRatingAvg + ")"
            binding.myInfoOphthaReviewCntTv.text = "(" + ophthaInfoEvent.ophthaReviewCnt + ")"
        }
    }


}