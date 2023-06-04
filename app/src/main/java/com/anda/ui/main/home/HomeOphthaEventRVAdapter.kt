package com.anda.ui.main.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.data.entities.HomeOphthaEvent
import com.anda.databinding.ItemHomeOphthaEventBinding

class HomeOphthaEventRVAdapter (private var ophthaEventList: ArrayList<HomeOphthaEvent>): RecyclerView.Adapter<HomeOphthaEventRVAdapter.ViewHolder>() {

    interface homeOphthaEventItemClickListener{
        fun onItemClick(){        }
    }

    private lateinit var mItemClickListener : homeOphthaEventItemClickListener
    fun setHomeEventItemClickListener(itemClickListener : homeOphthaEventItemClickListener){
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): HomeOphthaEventRVAdapter.ViewHolder {

        val binding: ItemHomeOphthaEventBinding = ItemHomeOphthaEventBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeOphthaEventRVAdapter.ViewHolder, position: Int) {
        holder.bind(ophthaEventList[position])
        holder.itemView.setOnClickListener{ mItemClickListener.onItemClick()}
    }

    override fun getItemCount(): Int = ophthaEventList.size

    inner class ViewHolder(val binding: ItemHomeOphthaEventBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(ophthaEvent: HomeOphthaEvent) {
            binding.itemHomeOphthaEventOphthaNameTv.text = ophthaEvent.ophthaName
            binding.itemHomeOphthaEventOphthaLocationTv.text = ophthaEvent.ophthaLocation
            binding.itemHomeOphthaEventNameTv.text = ophthaEvent.eventName
            binding.itemHomeOphthaEventOphthaPictureIv.setImageResource(ophthaEvent.eventImg!!)
            binding.itemHomeOphthaEventOphthaPictureIv.clipToOutline = true
        }
    }



}