package com.anda.ui.main.management.after

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.data.entities.ChallengeItem
import com.anda.databinding.ItemChallengesBinding


class ChallengeRVAdapter(private val challengeItems: List<ChallengeItem>) :
    RecyclerView.Adapter<ChallengeRVAdapter.ChallengeViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemChallengesBinding.inflate(inflater, parent, false)
        return ChallengeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ChallengeViewHolder, position: Int) {
        holder.bind(challengeItems[position])
    }

    override fun getItemCount(): Int = challengeItems.size

    inner class ChallengeViewHolder(private val binding: ItemChallengesBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(challengeItem: ChallengeItem) {
            binding.dateTextView.text = challengeItem.date
            binding.achievementRateTextView.text = challengeItem.achievementRate
        }
    }
}
