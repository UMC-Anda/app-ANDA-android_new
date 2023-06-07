package com.anda.ui.main.home.ranking

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.R
import com.anda.data.entities.HomeAndaRankingOphtha
import com.anda.databinding.ItemHomeAndaRankingOphthaBinding
import com.anda.ui.main.management.after.challenge.ManagementChallengeRVAdapter

class HomeAndaRankingRVAdapter(private var andaRankingList: ArrayList<HomeAndaRankingOphtha>): RecyclerView.Adapter<HomeAndaRankingRVAdapter.ViewHolder>() {

    private lateinit var mItemClickListener: homeandaRankingOphthaItemClickListener

    interface homeandaRankingOphthaItemClickListener { fun onItemClick(homeAndaRankingOphtha: HomeAndaRankingOphtha) {} }

    fun setHomeandaRankingOphthaItemClickListener(itemClickListener: homeandaRankingOphthaItemClickListener) {
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemHomeAndaRankingOphthaBinding = ItemHomeAndaRankingOphthaBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(andaRankingList[position])
        holder.itemView.setOnClickListener{mItemClickListener.onItemClick(andaRankingList[position])}
    }

    override fun getItemCount(): Int = andaRankingList.size

    inner class ViewHolder(val binding: ItemHomeAndaRankingOphthaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(andaRankingOphtha: HomeAndaRankingOphtha) {
            binding.itemHomeRankingOphthaNameTv.text = andaRankingOphtha.ophthaName
            binding.itemHomeRankingOphthaLocationTv.text = andaRankingOphtha.ophthaLocation
            binding.itemHomeRankingRatingAvgTv.text = andaRankingOphtha.ophthaRatingAvg.toString()
            binding.itemHomeRankingRatingCntTv.text = andaRankingOphtha.ophthaRatingCnt.toString()
            binding.itemHomeRankingOphthaImgIv.setImageResource(andaRankingOphtha.ophthaImg!!)
            when(andaRankingOphtha.ophthaRank){
                1-> binding.itemHomeRankingNumImgIv.setImageResource(R.drawable.home_anda_ranking_ophtha_num1_img)
                2-> binding.itemHomeRankingNumImgIv.setImageResource(R.drawable.home_anda_ranking_ophtha_num2_img)
                3-> binding.itemHomeRankingNumImgIv.setImageResource(R.drawable.home_anda_ranking_ophtha_num3_img)
                4-> binding.itemHomeRankingNumImgIv.setImageResource(R.drawable.home_anda_ranking_ophtha_num4_img)
                5-> binding.itemHomeRankingNumImgIv.setImageResource(R.drawable.home_anda_ranking_ophtha_num5_img)
                6-> binding.itemHomeRankingNumImgIv.setImageResource(R.drawable.home_anda_ranking_ophtha_num6_img)
                7-> binding.itemHomeRankingNumImgIv.setImageResource(R.drawable.home_anda_ranking_ophtha_num7_img)
                8-> binding.itemHomeRankingNumImgIv.setImageResource(R.drawable.home_anda_ranking_ophtha_num8_img)
                9-> binding.itemHomeRankingNumImgIv.setImageResource(R.drawable.home_anda_ranking_ophtha_num9_img)
            }
        }
    }
}