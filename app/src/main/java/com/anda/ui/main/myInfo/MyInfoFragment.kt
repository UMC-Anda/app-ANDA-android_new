package com.anda.ui.main.myInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentMyInfoBinding
import com.anda.ui.main.myInfo.myOphtha.MyInfoMyOphthaFragment
import com.anda.ui.main.myInfo.myPoint.MyInfoMyPointGoodsFragment
import com.anda.ui.ophtha_info.OphthaInfoFragment

class MyInfoFragment : Fragment(), OnClickListener{

    lateinit var binding: FragmentMyInfoBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyInfoBinding.inflate(inflater, container, false)

        binding.myInfoMyOphthaImgIv.setOnClickListener(this)
        binding.myInfoMyPointImgIv.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(v: View?) {

        if(v == null) return
        when(v){
            binding.myInfoMyOphthaImgIv ->{
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, MyInfoMyOphthaFragment())
                    .commitAllowingStateLoss()
            }
            binding.myInfoMyPointImgIv ->{
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, MyInfoMyPointGoodsFragment())
                    .commitAllowingStateLoss()
            }
        }
    }
}