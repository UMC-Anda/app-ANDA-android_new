package com.anda.ui.main.home.ranking

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.R
import com.anda.data.entities.HomeAndaRankingSelect
import com.anda.databinding.ItemHomeAndaRankingSelectBinding

class HomeAndaRankingSelectRVAdapter (private var andaRankingSelectList: ArrayList<HomeAndaRankingSelect>): RecyclerView.Adapter<HomeAndaRankingSelectRVAdapter.ViewHolder>() {

    private lateinit var mItemClickListener: homeandaRankingSelectItemClickListener
    var mPosition = 0

    interface homeandaRankingSelectItemClickListener {
        fun onItemClick(andaRankingSelect: HomeAndaRankingSelect) {

        }
    }

    fun setHomeandaRankingSelectItemClickListener(itemClickListener: homeandaRankingSelectItemClickListener) {
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val binding: ItemHomeAndaRankingSelectBinding = ItemHomeAndaRankingSelectBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int
    ) {
        holder.bind(andaRankingSelectList[position])
        setData(holder)
        holder.itemView.setOnClickListener {
            mItemClickListener.onItemClick(andaRankingSelectList[position])
            notifyItemChanged(mPosition)
            mPosition = holder.adapterPosition
            notifyItemChanged(mPosition)
            setData(holder)
        }
    }

    private fun setData(holder: ViewHolder) {
        if (mPosition == holder.adapterPosition) {
            when (mPosition) {
                0 -> holder.binding.itemHomeRankingSelectImgIv.setImageResource(R.drawable.home_ranking_selected_lasik_img)
                1 -> holder.binding.itemHomeRankingSelectImgIv.setImageResource(R.drawable.home_ranking_selected_lasek_img)
                2 -> holder.binding.itemHomeRankingSelectImgIv.setImageResource(R.drawable.home_ranking_selected_smile_img)
                3 -> holder.binding.itemHomeRankingSelectImgIv.setImageResource(R.drawable.home_ranking_selected_lens_img)
                4 -> holder.binding.itemHomeRankingSelectImgIv.setImageResource(R.drawable.home_ranking_selected_back_img)
                5 -> holder.binding.itemHomeRankingSelectImgIv.setImageResource(R.drawable.home_ranking_selected_normal_img)
            }
        }
    }

    override fun getItemCount(): Int = andaRankingSelectList.size

    inner class ViewHolder(val binding: ItemHomeAndaRankingSelectBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(andaRankingSelect: HomeAndaRankingSelect) {
            binding.itemHomeRankingSelectImgIv.setImageResource(andaRankingSelect.andaRankingSelectImg!!)
        }
    }


}