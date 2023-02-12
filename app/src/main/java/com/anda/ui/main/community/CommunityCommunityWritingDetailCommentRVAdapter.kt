package com.anda.ui.main.community

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.R
import com.anda.data.entities.ExAskDoctorDetailComment
import com.anda.data.entities.ExCommunityDetailComment
import com.anda.data.entities.ExCommunityWrtingComment
import com.anda.databinding.ItemCommunityCommunityWritingDetailCommentBinding

class CommunityCommunityWritingDetailCommentRVAdapter (private var communityDetailCommentList: ArrayList<ExCommunityDetailComment>,): RecyclerView.Adapter<CommunityCommunityWritingDetailCommentRVAdapter.ViewHolder>() {

    interface CommunityAskDoctorWritingDetailCommentListener{
        fun onItemClick(){

        }
    }

    private lateinit var mItemClickListener : CommunityAskDoctorWritingDetailCommentListener
    fun setHomeEventItemClickListener(itemClickListener : CommunityAskDoctorWritingDetailCommentListener){
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): CommunityCommunityWritingDetailCommentRVAdapter.ViewHolder {

        val binding: ItemCommunityCommunityWritingDetailCommentBinding = ItemCommunityCommunityWritingDetailCommentBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommunityCommunityWritingDetailCommentRVAdapter.ViewHolder, position: Int) {
        holder.bind(communityDetailCommentList[position])
        holder.itemView.setOnClickListener{ mItemClickListener.onItemClick()}
    }

    override fun getItemCount(): Int = communityDetailCommentList.size

    inner class ViewHolder(val binding: ItemCommunityCommunityWritingDetailCommentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(communityDetailComment: ExCommunityDetailComment) {
            binding.itemCommunityCommunityWritingDetailCommentUserProfileIv.setImageResource(communityDetailComment.commentUserProfile!!)
            binding.itemCommunityCommunityWritingDetailCommentUserNicknameTv.text = communityDetailComment.commentUserNickname
            binding.itemCommunityCommunityWritingDetailCommentUserLevelTv.text = "Level " + communityDetailComment.commentUserLevel.toString()
            binding.itemCommunityCommunityWritingDetailCommentUserEmailTv.text = communityDetailComment.commentUserEmail
            binding.itemCommunityCommunityWritingDetailCommentContentTv.text = communityDetailComment.commentContent
            if(communityDetailComment.commentIsReplyed!!){
                binding.itemCommunityCommunityWritingDetailCommentLikeIv.setImageResource(R.drawable.community_like_checked_icon)
            }else{
                binding.itemCommunityCommunityWritingDetailCommentLikeIv.setImageResource(R.drawable.community_like_unchecked_icon)
            }
        }
    }



}