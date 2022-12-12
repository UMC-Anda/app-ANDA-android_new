package com.anda.ui.ophtha_info

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.R
import com.anda.data.entities.OphthaInfoEvent
import com.anda.databinding.ItemOphthaInfoEventBinding

class OphthaInfoEventsRVAdapter(): RecyclerView.Adapter<OphthaInfoEventsRVAdapter.ViewHolder>() {

    private lateinit var ophthaInfoEventList: ArrayList<OphthaInfoEvent>
    private lateinit var mItemClickListener: ophthaInfoEventsItemClickListener
    var mPosition = 0

    interface ophthaInfoEventsItemClickListener {
        fun onItemClick(andaRankingSelect: OphthaInfoEvent) {

        }
    }

    fun ophthaInfoEventsItemClickListener(itemClickListener: ophthaInfoEventsItemClickListener) {
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): OphthaInfoEventsRVAdapter.ViewHolder {

        val binding: ItemOphthaInfoEventBinding = ItemOphthaInfoEventBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: OphthaInfoEventsRVAdapter.ViewHolder,
        position: Int
    ) {
        holder.bind(ophthaInfoEventList[position])
    }


    override fun getItemCount(): Int = ophthaInfoEventList.size

    inner class ViewHolder(val binding: ItemOphthaInfoEventBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(ophthaInfoEvent: OphthaInfoEvent) {
            binding.itemOphthaInfoEventImageIv.setImageResource(ophthaInfoEvent.eventImg!!)
            binding.itemOphthaInfoEventNameTv.text = ophthaInfoEvent.eventName
            binding.itemHomeOphthaEventDateTv.text = ophthaInfoEvent.eventDate
            when(ophthaInfoEvent.eventCategory){
                "라식" -> binding.itemOphthaInfoEventCategoryIv.setImageResource(R.drawable.item_ophtha_info_event_category_lasik)
                "라섹" -> binding.itemOphthaInfoEventCategoryIv.setImageResource(R.drawable.item_ophtha_info_event_category_lasek)
                "스마일라식" -> binding.itemOphthaInfoEventCategoryIv.setImageResource(R.drawable.item_ophtha_info_event_category_smile)
                "렌즈삽입술" -> binding.itemOphthaInfoEventCategoryIv.setImageResource(R.drawable.item_ophtha_info_event_category_lens)
                "백내장" -> binding.itemOphthaInfoEventCategoryIv.setImageResource(R.drawable.item_ophtha_info_event_category_back)
                "기타진료" -> binding.itemOphthaInfoEventCategoryIv.setImageResource(R.drawable.item_ophtha_info_event_category_etc)
            }
        }
    }


}