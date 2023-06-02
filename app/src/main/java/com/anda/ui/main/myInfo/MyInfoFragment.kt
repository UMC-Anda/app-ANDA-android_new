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
    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyInfoBinding.inflate(inflater, container, false)

        sharedPreferences = requireContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE)

        // 클릭 리스너 설정
//        binding.myInfoMyOphthaImgIv.setOnClickListener(this)
//        binding.myInfoMyPointImgIv.setOnClickListener(this)

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
