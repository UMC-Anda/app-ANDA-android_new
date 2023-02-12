package com.anda.ui.main.community.community

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.R
import com.anda.data.entities.ExCommunityAskDoctor
import com.anda.data.entities.ExCommunityCommunity
import com.anda.data.entities.HomeAndaRankingOphtha
import com.anda.databinding.ItemCommunityAskDoctorContentBinding
import com.anda.databinding.ItemCommunityCommunityContentBinding
import com.anda.databinding.ItemHomeAndaRankingOphthaBinding

class CommunityCommunityRVAdapter(private var communityCommunityList: ArrayList<ExCommunityCommunity>): RecyclerView.Adapter<CommunityCommunityRVAdapter.ViewHolder>() {

    private lateinit var mItemClickListener: CommunityCommunityItemClickListener

    interface CommunityCommunityItemClickListener {
        fun onItemClick() {

        }
    }
    fun setCommunityCommunityItemClickListener(itemClickListener: CommunityCommunityItemClickListener) {
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemCommunityCommunityContentBinding = ItemCommunityCommunityContentBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(communityCommunityList[position])
        holder.itemView.setOnClickListener{mItemClickListener.onItemClick()}
    }

    override fun getItemCount(): Int = communityCommunityList.size

    inner class ViewHolder(val binding: ItemCommunityCommunityContentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(communityCommunity: ExCommunityCommunity) {
            binding.itemCommunityCommunityContentTitleTv.text = communityCommunity.name
            binding.itemCommunityCommunityContentContentTv.text = communityCommunity.content
            binding.itemCommunityCommunityContentThumbsUpCntTv.text = communityCommunity.likeCnt.toString()
        }
    }
}