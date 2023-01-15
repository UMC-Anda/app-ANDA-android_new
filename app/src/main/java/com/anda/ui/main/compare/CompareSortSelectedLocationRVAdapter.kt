package com.anda.ui.main.compare

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.data.entities.CompareSortSelectedOption
import com.anda.databinding.ItemCompareSortSelectedLocationBinding
import com.anda.databinding.ItemCompareSortSelectedOperationBinding


class CompareSortSelectedLocationRVAdapter(private var compareSortSelectedLocationList: ArrayList<String>?): RecyclerView.Adapter<CompareSortSelectedLocationRVAdapter.ViewHolder>() {

    var rvIndex = 0

    interface compareSortedLocationItemClickListener{
        fun onItemClick(position : Int)
    }

    private lateinit var mItemClickListener : compareSortedLocationItemClickListener
    fun setCompareSortSelectedLocationItemClickListener(itemClickListener : compareSortedLocationItemClickListener){
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): CompareSortSelectedLocationRVAdapter.ViewHolder {

        val binding: ItemCompareSortSelectedLocationBinding = ItemCompareSortSelectedLocationBinding.inflate(LayoutInflater.from(viewGroup.context), viewGroup, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CompareSortSelectedLocationRVAdapter.ViewHolder, position: Int) {
        var content = compareSortSelectedLocationList!![0]
        for(i: Int in 1..compareSortSelectedLocationList!!.size - 1){
            if(i < 3) {
                content = content + " / " + compareSortSelectedLocationList!![i]
            }
            else {
                content += "..."
                break
            }
        }
        holder.bind(content)
        holder.itemView.setOnClickListener{
            mItemClickListener.onItemClick(position)
            rvIndex = holder.adapterPosition
            notifyItemChanged(rvIndex)
        }
    }

    override fun getItemCount(): Int = 1

    inner class ViewHolder(val binding: ItemCompareSortSelectedLocationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(compareSortSelectedLocation: String) {
            binding.itemCompareSelectedLocationTv.text = compareSortSelectedLocation
        }
    }
}