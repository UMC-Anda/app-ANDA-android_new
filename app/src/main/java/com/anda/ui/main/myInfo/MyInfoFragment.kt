package com.anda.ui.main.myInfo


import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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

        binding.giftButton.setOnClickListener(this)
        binding.giftIv.setOnClickListener(this)

        myPointSharedPreferences = requireContext().getSharedPreferences("UserInfo", Context.MODE_PRIVATE)
        myPoint = myPointSharedPreferences.getInt("MyPoint", 0)
        // 클릭 리스너 설정
//        binding.myInfoMyOphthaImgIv.setOnClickListener(this)
//        binding.myInfoMyPointImgIv.setOnClickListener(this)

        binding.giftIv.visibility = View.GONE
        binding.giftIv.bringToFront()

        binding.myPointCurrentPointTv.text = myPoint.toString() + " P"
        return binding.root
    }



    override fun onClick(v: View?) {
        if (v == null) return

        when (v) {
            binding.giftButton -> {
                if(myPoint >= 100) {
                    binding.giftIv.visibility = View.VISIBLE
                }else{
                    Toast.makeText(context, "100 Point 부터 열 수 있습니다.", Toast.LENGTH_SHORT).show()
                }
                Log.d("현재 포인트", myPoint.toString())
            }
            binding.giftIv -> {
                binding.giftIv.visibility = View.GONE
                binding.giftIv.bringToFront()
            }
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
