package com.anda.ui.main.compare

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.databinding.ItemCompareSortSelectedSortStandardBinding


class CompareSortSelectedSortStandardRVAdapter(private var compareSortSelectedSortStandardList: ArrayList<String>?): RecyclerView.Adapter<CompareSortSelectedSortStandardRVAdapter.ViewHolder>() {

    var rvIndex = 0

    interface compareSortedSortStandardItemClickListener{
        fun onItemClick(position : Int)
    }

    private lateinit var mItemClickListener : compareSortedSortStandardItemClickListener
    fun setCompareSortSelectedSortStandardItemClickListener(itemClickListener : compareSortedSortStandardItemClickListener){
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): CompareSortSelectedSortStandardRVAdapter.ViewHolder {

        val binding: ItemCompareSortSelectedSortStandardBinding = ItemCompareSortSelectedSortStandardBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CompareSortSelectedSortStandardRVAdapter.ViewHolder, position: Int) {
        holder.bind(compareSortSelectedSortStandardList!![position])
        holder.itemView.setOnClickListener{
            mItemClickListener.onItemClick(position)
            rvIndex = holder.adapterPosition
            notifyItemChanged(rvIndex)
        }
    }

    override fun getItemCount(): Int = 1

    inner class ViewHolder(val binding: ItemCompareSortSelectedSortStandardBinding ) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(compareSortSelectedSortStandard: String) {
            binding.itemCompareSelectedSortStandardTv.text = compareSortSelectedSortStandard
        }
    }
}