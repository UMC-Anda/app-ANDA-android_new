package com.anda.ui.main.myInfo.myPoint

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentMyInfoMyPointBinding
import com.anda.ui.main.myInfo.myPoint.goods.MyInfoMyPointGoodsFragment
import com.anda.ui.main.myInfo.myPoint.history.MyInfoMyPointHistoryFragment

class MyInfoMyPointFragment : Fragment(), OnClickListener {

    lateinit var binding: FragmentMyInfoMyPointBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyInfoMyPointBinding.inflate(inflater, container, false)

        binding.myInfoMyPointBuyProductsBtn.setOnClickListener(this)
        binding.myInfoMyPointGoPointHistoryCv.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(v: View?) {
        if(v == null) return
        when(v){
            binding.myInfoMyPointBuyProductsBtn -> {
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, MyInfoMyPointGoodsFragment())
                    .commitAllowingStateLoss()
            }
            binding.myInfoMyPointGoPointHistoryCv -> {
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, MyInfoMyPointHistoryFragment())
                    .commitAllowingStateLoss()
            }
        }
    }
}