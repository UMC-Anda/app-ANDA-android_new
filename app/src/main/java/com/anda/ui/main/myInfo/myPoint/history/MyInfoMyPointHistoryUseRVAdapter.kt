package com.anda.ui.main.myInfo.myPoint.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.data.entities.ExMyPointUseHistory
import com.anda.databinding.ItemMyInfoMyPointHistoryUseContentBinding

class MyInfoMyPointHistoryUseRVAdapter(private val myInfoMyPointHistoryList: ArrayList<ExMyPointUseHistory>): RecyclerView.Adapter<MyInfoMyPointHistoryUseRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val binding: ItemMyInfoMyPointHistoryUseContentBinding = ItemMyInfoMyPointHistoryUseContentBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(myInfoMyPointHistoryList[position])
    }

    override fun getItemCount(): Int = myInfoMyPointHistoryList.size

    inner class ViewHolder(val binding: ItemMyInfoMyPointHistoryUseContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pointHistoryInfo: ExMyPointUseHistory) {
            binding.itemMyInfoMyPointHistoryHowToUseTv.text = pointHistoryInfo.howToUsePoint
            binding.itemMyInfoMyPointHistoryUsePointContentTv.text = pointHistoryInfo.usePointContent.toString() + "P"
            binding.itemMyInfoMyPointHistoryUseDateTv.text = pointHistoryInfo.useDate
        }
    }


}