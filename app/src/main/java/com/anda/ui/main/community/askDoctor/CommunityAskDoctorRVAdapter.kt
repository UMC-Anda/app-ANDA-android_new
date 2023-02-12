package com.anda.ui.main.community.askDoctor

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.R
import com.anda.data.entities.ExCommunityAskDoctor
import com.anda.data.entities.HomeAndaRankingOphtha
import com.anda.databinding.ItemCommunityAskDoctorContentBinding
import com.anda.databinding.ItemHomeAndaRankingOphthaBinding

class CommunityAskDoctorRVAdapter(private var andaRankingList: ArrayList<ExCommunityAskDoctor>): RecyclerView.Adapter<CommunityAskDoctorRVAdapter.ViewHolder>() {

    private lateinit var mItemClickListener: CommunityAskDoctorItemClickListener

    interface CommunityAskDoctorItemClickListener {
        fun onItemClick() {
        }
    }
    fun setCommunityAskDoctorItemClickListener(itemClickListener: CommunityAskDoctorItemClickListener) {
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemCommunityAskDoctorContentBinding = ItemCommunityAskDoctorContentBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(andaRankingList[position])
        holder.itemView.setOnClickListener{mItemClickListener.onItemClick()}
    }

    override fun getItemCount(): Int = andaRankingList.size

    inner class ViewHolder(val binding: ItemCommunityAskDoctorContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(communityAskDoctor: ExCommunityAskDoctor) {
            binding.itemCommunityAskDoctorContentTitleTv.text = communityAskDoctor.name
            binding.itemCommunityAskDoctorContentContentTv.text = communityAskDoctor.content
            if(communityAskDoctor.isReplyed == true) binding.itemCommunityAskDoctorContentReplyedIv.visibility = View.VISIBLE
            else binding.itemCommunityAskDoctorContentReplyedIv.visibility = View.GONE
        }
    }
}