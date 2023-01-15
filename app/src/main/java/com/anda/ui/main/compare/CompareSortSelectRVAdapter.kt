package com.anda.ui.main.compare

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.R
import com.anda.data.entities.CompareSortSelect
import com.anda.databinding.ItemCompareSortSelectBinding


class CompareSortSelectRVAdapter(private var compareSortSelectList: ArrayList<CompareSortSelect>): RecyclerView.Adapter<CompareSortSelectRVAdapter.ViewHolder>() {

    var rvIndex = 0

    interface compareSortItemClickListener{
        fun onItemClick(position: Int, itemCnt : Int){}
        fun setElevation(position: Int){

        }
    }

    private lateinit var mItemClickListener : compareSortItemClickListener
    fun setCompareItemClickListener(itemClickListener : compareSortItemClickListener){
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): CompareSortSelectRVAdapter.ViewHolder {

        val binding: ItemCompareSortSelectBinding = ItemCompareSortSelectBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CompareSortSelectRVAdapter.ViewHolder, position: Int) {
        holder.bind(compareSortSelectList[position])
        holder.itemView.setOnClickListener{
            mItemClickListener.onItemClick(position, itemCount)
            rvIndex = holder.adapterPosition
            notifyItemChanged(rvIndex)
        }
    }

    override fun getItemCount(): Int = compareSortSelectList.size

    inner class ViewHolder(val binding: ItemCompareSortSelectBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(compareSortSelect: CompareSortSelect) {
            binding.itemCompareSortSelectImgIv.setImageResource(compareSortSelect.image!!)
            if(compareSortSelect.isSelected!!){
                binding.itemCompareSortSelectImgIv.visibility = View.GONE
            }
            else{
                binding.itemCompareSortSelectImgIv.visibility = View.VISIBLE
            }
        }
    }
}