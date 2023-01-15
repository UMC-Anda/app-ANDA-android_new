package com.anda.ui.main.myInfo.myPoint

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.anda.R
import com.anda.data.entities.ExMyOphtha
import com.anda.data.entities.ExMyPointGoods
import com.anda.databinding.FragmentMyInfoMyOphthaBinding
import com.anda.databinding.FragmentMyInfoMyPointGoodsBinding
import com.anda.ui.ophtha_info.OphthaInfoEventsRVAdapter
import com.anda.ui.ophtha_info.OphthaInfoReviewsRVAdapter

class MyInfoMyPointGoodsFragment : Fragment() {

    var isExist : Boolean = false
    lateinit var binding: FragmentMyInfoMyPointGoodsBinding
    var myInfoMyPointGoodsDatas = ArrayList<ExMyPointGoods>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyInfoMyPointGoodsBinding.inflate(inflater, container, false)

        myInfoMyPointGoodsDatas.apply {
            add(ExMyPointGoods(R.drawable.real_ophtha_ex_img, "상품명1", 2000))
            add(ExMyPointGoods(R.drawable.ex_img, "상품명2", 5000 ))
            add(ExMyPointGoods(R.drawable.ophtha_ex_img, "상품명3",3500 ))
            add(ExMyPointGoods(R.drawable.ex_img, "상품명4",4000 ))
            add(ExMyPointGoods(R.drawable.real_ophtha_ex_img, "상품명1", 2000))
            add(ExMyPointGoods(R.drawable.ex_img, "상품명2", 5000 ))
            add(ExMyPointGoods(R.drawable.ophtha_ex_img, "상품명3",3500 ))
            add(ExMyPointGoods(R.drawable.ex_img, "상품명4",4000 ))
            add(ExMyPointGoods(R.drawable.real_ophtha_ex_img, "상품명1", 2000))
            add(ExMyPointGoods(R.drawable.ex_img, "상품명2", 5000 ))
            add(ExMyPointGoods(R.drawable.ophtha_ex_img, "상품명3",3500 ))
            add(ExMyPointGoods(R.drawable.ex_img, "상품명4",4000 ))
            add(ExMyPointGoods(R.drawable.real_ophtha_ex_img, "상품명1", 2000))
            add(ExMyPointGoods(R.drawable.ex_img, "상품명2", 5000 ))
            add(ExMyPointGoods(R.drawable.ophtha_ex_img, "상품명3",3500 ))
            add(ExMyPointGoods(R.drawable.ex_img, "상품명4",4000 ))
            add(ExMyPointGoods(R.drawable.real_ophtha_ex_img, "상품명1", 2000))
            add(ExMyPointGoods(R.drawable.ex_img, "상품명2", 5000 ))
            add(ExMyPointGoods(R.drawable.ophtha_ex_img, "상품명3",3500 ))
            add(ExMyPointGoods(R.drawable.ex_img, "상품명4",4000 ))
        }
        if(isExist){
            binding.myInfoMyOphthaThereIsPointGoods.visibility = View.VISIBLE
            binding.myInfoMyPointGoodsThereIsNoPoingGoods.visibility = View.GONE
        }
        else{
            binding.myInfoMyOphthaThereIsPointGoods.visibility = View.GONE
            binding.myInfoMyPointGoodsThereIsNoPoingGoods.visibility = View.VISIBLE
        }
        val myinfoMyPointGoodsRVAdapter = MyInfoMyPointGoodsRVAdapter(myInfoMyPointGoodsDatas)
        binding.myInfoMyPointGoodsRv.adapter = myinfoMyPointGoodsRVAdapter
        binding.myInfoMyPointGoodsRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        return binding.root
    }
}