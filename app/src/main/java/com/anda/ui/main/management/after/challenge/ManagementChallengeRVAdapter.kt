package com.anda.ui.main.management.after.challenge

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.data.entities.ChallengeItem
import com.anda.databinding.ItemChallengesBinding


class ManagementChallengeRVAdapter(private val challengeItems: List<ChallengeItem>) : RecyclerView.Adapter<ManagementChallengeRVAdapter.ChallengeViewHolder>() {


    interface ItemClickListener{ fun onItemClick(challengeItem: ChallengeItem){        } }

    private lateinit var mItemClickListener : ItemClickListener
    fun setItemClickListener(itemClickListener : ItemClickListener){
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemChallengesBinding.inflate(inflater, parent, false)
        return ChallengeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChallengeViewHolder, position: Int) {
        holder.bind(challengeItems[position])
        holder.itemView.setOnClickListener{ mItemClickListener.onItemClick(challengeItems[position])}
    }

    override fun getItemCount(): Int = challengeItems.size

    inner class ChallengeViewHolder(private val binding: ItemChallengesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(challengeItem: ChallengeItem) {
            binding.dateTextView.text = challengeItem.date
            binding.achievementRateTextView.text = challengeItem.achievementRate.toString()
            binding.dateProgress.progress = challengeItem.achievementRate
        }
    }
}
