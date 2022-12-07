package com.anda.ui.ophtha_info

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.R
import com.anda.data.entities.OphthaInfoEvent

class OphthaInfoEventsRVAdapter  (private var ophthaInfoEventList: ArrayList<OphthaInfoEvent>): RecyclerView.Adapter<OphthaInfoEventsRVAdapter.ViewHolder>() {

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

        val binding: ItemHomeAndaRankingSelectBinding = ItemHomeAndaRankingSelectBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: OphthaInfoEventsRVAdapter.ViewHolder,
        position: Int
    ) {
        holder.bind(ophthaInfoEventList[position])
        setData(holder)
        holder.itemView.setOnClickListener {
            mItemClickListener.onItemClick(ophthaInfoEventList[position])
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

    override fun getItemCount(): Int = ophthaInfoEventList.size

    inner class ViewHolder(val binding: ItemHomeAndaRankingSelectBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(andaRankingSelect: OphthaInfoEvent) {
            binding.itemHomeRankingSelectImgIv.setImageResource(andaRankingSelect.andaRankingSelectImg!!)
        }
    }


}