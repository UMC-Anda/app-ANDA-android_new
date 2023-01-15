package com.anda.ui.main.compare

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.data.entities.CompareSortSelectedOption
import com.anda.databinding.ItemCompareSortSelectedOperationBinding


class CompareSortSelectedOperationRVAdapter(private var compareSortSelectedOperationList: ArrayList<String>?): RecyclerView.Adapter<CompareSortSelectedOperationRVAdapter.ViewHolder>() {

    var rvIndex = 0

    interface compareSortedOperationItemClickListener{
        fun onItemClick(position : Int)
    }

    private lateinit var mItemClickListener : compareSortedOperationItemClickListener
    fun setCompareSortSelectedOperationItemClickListener(itemClickListener : compareSortedOperationItemClickListener){
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): CompareSortSelectedOperationRVAdapter.ViewHolder {

        val binding: ItemCompareSortSelectedOperationBinding = ItemCompareSortSelectedOperationBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CompareSortSelectedOperationRVAdapter.ViewHolder, position: Int) {
        holder.bind(compareSortSelectedOperationList!![position])
        holder.itemView.setOnClickListener{
            mItemClickListener.onItemClick(position)
            rvIndex = holder.adapterPosition
            notifyItemChanged(rvIndex)
        }
    }

    override fun getItemCount(): Int = 1

    inner class ViewHolder(val binding: ItemCompareSortSelectedOperationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(compareSortSelectedOperation: String) {
            binding.itemCompareSelectedOperationTv.text = compareSortSelectedOperation
        }
    }
}