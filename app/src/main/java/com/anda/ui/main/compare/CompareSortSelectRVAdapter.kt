package com.anda.ui.main.compare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.data.entities.CompareSortSelect
import com.anda.databinding.ItemCompareSortSelectBinding


class CompareSortSelectRVAdapter(private var compareSortSelectList: ArrayList<CompareSortSelect>): RecyclerView.Adapter<CompareSortSelectRVAdapter.ViewHolder>() {

    interface compareItemClickListener{
        fun onItemClick(){

        }
    }

    private lateinit var mItemClickListener : compareItemClickListener
    fun setCompareItemClickListener(itemClickListener : compareItemClickListener){
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
        holder.itemView.setOnClickListener{ mItemClickListener.onItemClick()}
    }

    override fun getItemCount(): Int = compareSortSelectList.size

    inner class ViewHolder(val binding: ItemCompareSortSelectBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(compareSortSelect: CompareSortSelect) {
            binding.itemCompareSortSelectImgIv.setImageResource(compareSortSelect.image!!)
            if(compareSortSelect.isSelected!!){
                binding.itemCompareSortSelectImgIv.visibility = View.GONE
                binding.itemCompareSelectedTv.visibility = View.VISIBLE
            }
            else{
                binding.itemCompareSortSelectImgIv.visibility = View.VISIBLE
                binding.itemCompareSelectedTv.visibility = View.GONE
            }
        }
    }
}