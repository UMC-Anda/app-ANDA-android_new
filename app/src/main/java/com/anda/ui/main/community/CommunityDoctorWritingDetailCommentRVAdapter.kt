package com.anda.ui.main.community

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.R
import com.anda.data.entities.ExAskDoctorDetailComment
import com.anda.databinding.ItemCommunityCommunityWritingDetailCommentBinding
import com.anda.databinding.ItemCommunityDoctorWritingDetailCommentBinding

class CommunityDoctorWritingDetailCommentRVAdapter (private var askDoctorDetailCommentList: ArrayList<ExAskDoctorDetailComment>): RecyclerView.Adapter<CommunityDoctorWritingDetailCommentRVAdapter.ViewHolder>() {

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
    ): CommunityDoctorWritingDetailCommentRVAdapter.ViewHolder {

        val binding: ItemCommunityDoctorWritingDetailCommentBinding = ItemCommunityDoctorWritingDetailCommentBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommunityDoctorWritingDetailCommentRVAdapter.ViewHolder, position: Int) {
        holder.bind(askDoctorDetailCommentList[position])
        holder.itemView.setOnClickListener{ mItemClickListener.onItemClick()}
    }

    override fun getItemCount(): Int = askDoctorDetailCommentList.size

    inner class ViewHolder(val binding: ItemCommunityDoctorWritingDetailCommentBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(askDoctorDetailComment: ExAskDoctorDetailComment) {
            binding.itemCommunityDoctorWritingDetailCommentUserProfileIv.setImageResource(askDoctorDetailComment.commentUserProfile!!)
            binding.itemCommunityDoctorWritingDetailCommentUserNicknameTv.text = askDoctorDetailComment.commentUserNickname
            binding.itemCommunityDoctorWritingDetailCommentUserLevelTv.text = "Level " + askDoctorDetailComment.commentUserLevel.toString()
            binding.itemCommunityDoctorWritingDetailCommentUserEmailTv.text = askDoctorDetailComment.commentUserEmail
            binding.itemCommunityDoctorWritingDetailCommentContentTv.text = askDoctorDetailComment.commentContent
            if(askDoctorDetailComment.commentIsReplyed!!){
                binding.itemCommunityDoctorWritingDetailCommentReplyedIv.setImageResource(R.drawable.checkcircle_checked)
            }else{
                binding.itemCommunityDoctorWritingDetailCommentReplyedIv.setImageResource(R.drawable.checkcircle_unchecked)
            }
        }
    }



}