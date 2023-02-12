package com.anda.ui.main.myInfo.myPoint.history

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.data.entities.ExMyPointGetHistory
import com.anda.data.entities.ExMyPointUseHistory
import com.anda.databinding.ItemMyInfoMyPointHistoryGetContentBinding
import com.anda.databinding.ItemMyInfoMyPointHistoryUseContentBinding

class MyInfoMyPointHistoryGetRVAdapter(private val myInfoMyPointHistoryList: ArrayList<ExMyPointGetHistory>): RecyclerView.Adapter<MyInfoMyPointHistoryGetRVAdapter.ViewHolder>() {



    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val binding: ItemMyInfoMyPointHistoryGetContentBinding = ItemMyInfoMyPointHistoryGetContentBinding.inflate(
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

    inner class ViewHolder(val binding: ItemMyInfoMyPointHistoryGetContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pointHistoryInfo: ExMyPointGetHistory) {
            binding.itemMyInfoMyPointHistoryHowToGetTv.text = pointHistoryInfo.howToGetPoint
            binding.itemMyInfoMyPointHistoryGetPointContentTv.text = pointHistoryInfo.getPointContent.toString() + "P"
            binding.itemMyInfoMyPointHistoryGetDateTv.text = pointHistoryInfo.getDate
            binding.itemMyInfoMyPointHistoryCanUseDateTv.text = pointHistoryInfo.canUseDate
        }
    }


}