package com.anda.ui.main.myInfo.myPoint.goods

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.MainActivity
import com.anda.R
import com.anda.data.entities.ExMyPointGoods
import com.anda.databinding.FragmentMyInfoMyPointGoodsDetailBinding

class MyInfoMyPointGoodsDetailFragment(var myInfoMyPointGoods : ExMyPointGoods) : Fragment(), OnClickListener{


    lateinit var binding: FragmentMyInfoMyPointGoodsDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyInfoMyPointGoodsDetailBinding.inflate(inflater, container, false)

        binding.myInfoMyPointGoodsDetailBuyProductConfirm.visibility = View.GONE

        binding.myInfoMyPointGoodsDetailBackImgCiv.setOnClickListener(this)
        binding.myInfoMyPointGoodsDetailBuyProductBtn.setOnClickListener(this)
        binding.myInfoMyPointGoodsDetailBuyProductConfirmBtn.setOnClickListener(this)
        binding.myInfoMyPointGoodsDetailBuyProductConfirmCancelIv.setOnClickListener(this)
        binding.myInfoMyPointGoodsDetailWarningTitleTv.setOnClickListener(this)
        binding.myInfoMyPointGoodsDetailWarningTitleArrowTv.setOnClickListener(this)

        binding.myInfoMyPointGoodsDetailGoodsNameTv.text = myInfoMyPointGoods.goodsName
        binding.myInfoMyPointGoodsDetailGoodsImgIv.setImageResource(myInfoMyPointGoods.goodsImg!!)
        binding.myInfoMyPointGoodsDetailGoodsPriceTv.text = myInfoMyPointGoods.goodsPrice.toString()

        binding.myInfoMyPointGoodsDetailGoodsImgIv.clipToOutline = true

        return binding.root
    }

    override fun onClick(v: View?) {
        if(v == null) return
        when(v){
            binding.myInfoMyPointGoodsDetailBackImgCiv ->{//이전 화면
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, MyInfoMyPointGoodsFragment())
                    .commitAllowingStateLoss()
            }
            binding.myInfoMyPointGoodsDetailBuyProductBtn ->{//상품 보내주기
                binding.myInfoMyPointGoodsDetailBuyProductConfirm.visibility = View.VISIBLE
            }
            binding.myInfoMyPointGoodsDetailBuyProductConfirmCancelIv ->{//상품 보내주기
                binding.myInfoMyPointGoodsDetailBuyProductConfirm.visibility = View.GONE
            }
            binding.myInfoMyPointGoodsDetailBuyProductConfirmBtn ->{//상품 보내주기

            }
            binding.myInfoMyPointGoodsDetailWarningTitleTv  ->{//유의사항 뺏다 꼈다
                if(binding.myInfoMyPointGoodsDetailWarningContentTv.visibility == View.GONE){
                    var rotationValue = 90.0
                    binding.myInfoMyPointGoodsDetailWarningContentTv.visibility = View.VISIBLE
                    binding.myInfoMyPointGoodsDetailWarningTitleArrowTv.rotation = rotationValue.toFloat()
                } else{
                    var rotationValue = 0

                    binding.myInfoMyPointGoodsDetailWarningContentTv.visibility = View.GONE
                    binding.myInfoMyPointGoodsDetailWarningTitleArrowTv.rotation = rotationValue.toFloat()
                }
            }
            binding.myInfoMyPointGoodsDetailWarningTitleArrowTv ->{
                if(binding.myInfoMyPointGoodsDetailWarningContentTv.visibility == View.GONE){
                    var rotationValue = 90.0
                    binding.myInfoMyPointGoodsDetailWarningContentTv.visibility = View.VISIBLE
                    binding.myInfoMyPointGoodsDetailWarningTitleArrowTv.rotation = rotationValue.toFloat()
                } else{
                    var rotationValue = 0

                    binding.myInfoMyPointGoodsDetailWarningContentTv.visibility = View.GONE
                    binding.myInfoMyPointGoodsDetailWarningTitleArrowTv.rotation = rotationValue.toFloat()
                }
            }

        }
    }
}