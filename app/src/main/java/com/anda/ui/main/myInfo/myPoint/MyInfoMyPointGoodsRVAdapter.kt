package com.anda.ui.main.myInfo.myPoint

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.data.entities.ExMyOphtha
import com.anda.data.entities.ExMyPointGoods
import com.anda.databinding.ItemMyInfoMyPointGoodsBinding

class MyInfoMyPointGoodsRVAdapter(private val myInfoMyPointGoodsList: ArrayList<ExMyPointGoods>): RecyclerView.Adapter<MyInfoMyPointGoodsRVAdapter.ViewHolder>() {

    private lateinit var mItemClickListener: myInfoMyPointGoodsItemClickListener
    var mPosition = 0

    interface myInfoMyPointGoodsItemClickListener { fun onItemClick() {} }

    fun setMyInfoMyOphthaItemClickListener(itemClickListener: myInfoMyPointGoodsItemClickListener) {
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): MyInfoMyPointGoodsRVAdapter.ViewHolder {

        val binding: ItemMyInfoMyPointGoodsBinding = ItemMyInfoMyPointGoodsBinding.inflate(
            LayoutInflater.from(viewGroup.context), viewGroup, false
        )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: MyInfoMyPointGoodsRVAdapter.ViewHolder,
        position: Int
    ) {
        holder.bind(myInfoMyPointGoodsList[position])
        holder.itemView.setOnClickListener { mItemClickListener.onItemClick() }
    }

    override fun getItemCount(): Int = myInfoMyPointGoodsList.size

    inner class ViewHolder(val binding: ItemMyInfoMyPointGoodsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(pointGoodsInfo: ExMyPointGoods) {
            binding.myInfoPointGoodsImgIv.clipToOutline = true
            binding.myInfoPointGoodsImgIv.setImageResource(pointGoodsInfo.goodsImg!!)
            binding.myInfoPointGoodsNameTv.text = pointGoodsInfo.goodsName
            binding.myInfoPointGoodsPriceTv.text = pointGoodsInfo.goodsPrice.toString()
        }
    }


}