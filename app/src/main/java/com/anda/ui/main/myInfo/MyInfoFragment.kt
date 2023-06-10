package com.anda.ui.main.myInfo


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentMyInfoBinding
import com.anda.ui.main.myInfo.myOphtha.MyInfoMyOphthaFragment
import com.anda.ui.main.myInfo.myPoint.MyInfoMyPointFragment

class MyInfoFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentMyInfoBinding
    private lateinit var myPointSharedPreferences: SharedPreferences
    private var myPoint =0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyInfoBinding.inflate(inflater, container, false)

        myPointSharedPreferences = requireContext().getSharedPreferences("MyPoint", Context.MODE_PRIVATE)
        myPoint = myPointSharedPreferences.getInt("MyPoint", 0)
        // 클릭 리스너 설정
//        binding.myInfoMyOphthaImgIv.setOnClickListener(this)
//        binding.myInfoMyPointImgIv.setOnClickListener(this)

        binding.myPointCurrentPointTv.text = myPoint.toString() + " P"
        return binding.root
    }



    override fun onClick(v: View?) {
        if (v == null) return

        when (v) {
//            R.id.myInfoMyOphthaImgIv -> {
//                (requireActivity() as MainActivity).supportFragmentManager.beginTransaction()
//                    .replace(R.id.nav_host_fragment_container, MyInfoMyOphthaFragment())
//                    .commitAllowingStateLoss()
//            }
//            R.id.myInfoMyPointImgIv -> {
//                (requireActivity() as MainActivity).supportFragmentManager.beginTransaction()
//                    .replace(R.id.nav_host_fragment_container, MyInfoMyPointFragment())
//                    .commitAllowingStateLoss()
//            }
        }
    }
}
