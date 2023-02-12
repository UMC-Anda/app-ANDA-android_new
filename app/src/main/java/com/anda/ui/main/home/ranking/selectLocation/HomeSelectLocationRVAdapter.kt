package com.anda.ui.main.home.ranking.selectLocation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.data.entities.CompareSortSelectedOption
import com.anda.databinding.ItemCompareSortSelectedLocationBinding
import com.anda.databinding.ItemCompareSortSelectedOperationBinding


class HomeSelectLocationRVAdapter(private var homeSelectedLocationList : ArrayList<String>): RecyclerView.Adapter<HomeSelectLocationRVAdapter.ViewHolder>() {

    var rvIndex = 0

    interface homeSelectLocationItemClickListener{
        fun onItemClick(selectedLocation : String, position: Int){

        }
    }

    private lateinit var mItemClickListener : homeSelectLocationItemClickListener
    fun setHomeSelectLocationItemClickListener(itemClickListener : homeSelectLocationItemClickListener){
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): HomeSelectLocationRVAdapter.ViewHolder {

        val binding: ItemCompareSortSelectedLocationBinding = ItemCompareSortSelectedLocationBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: HomeSelectLocationRVAdapter.ViewHolder, position: Int) {
        holder.bind(homeSelectedLocationList[position])
        holder.itemView.setOnClickListener{
            mItemClickListener.onItemClick(homeSelectedLocationList[position], position)
            rvIndex = holder.adapterPosition
            notifyDataSetChanged()
        }
    }

    override fun getItemCount(): Int = homeSelectedLocationList.size

    inner class ViewHolder(val binding: ItemCompareSortSelectedLocationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(homeSelectLocationLocation: String) {
            binding.itemCompareSelectedLocationTv.text = homeSelectLocationLocation
        }
    }
}