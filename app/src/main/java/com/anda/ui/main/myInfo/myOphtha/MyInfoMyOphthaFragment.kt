package com.anda.ui.main.myInfo.myOphtha

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.anda.R
import com.anda.data.entities.ExMyOphtha
import com.anda.databinding.FragmentMyInfoMyOphthaBinding
import com.anda.ui.ophtha_info.OphthaInfoEventsRVAdapter
import com.anda.ui.ophtha_info.OphthaInfoReviewsRVAdapter

class MyInfoMyOphthaFragment : Fragment() {

    var isExist : Boolean = true
    lateinit var binding: FragmentMyInfoMyOphthaBinding
    var myInfoMyOphthaDatas = ArrayList<ExMyOphtha>()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyInfoMyOphthaBinding.inflate(inflater, container, false)

        myInfoMyOphthaDatas.apply {
            add(ExMyOphtha("김안과병원", "서울특별시 영등포구", R.drawable.ex_img, 2410, 5.0 ))
            add(ExMyOphtha("이안과병원", "서울특별시 영등포구", R.drawable.ophtha_ex_img, 2410, 5.0 ))
            add(ExMyOphtha("최안과병원", "서울특별시 영등포구", R.drawable.ex_img, 2410, 5.0 ))
            add(ExMyOphtha("정안과병원", "서울특별시 영등포구", R.drawable.real_ophtha_ex_img, 2410, 5.0 ))
            add(ExMyOphtha("김안과병원", "서울특별시 영등포구", R.drawable.ex_img, 2410, 5.0 ))
            add(ExMyOphtha("이안과병원", "서울특별시 영등포구", R.drawable.ophtha_ex_img, 2410, 5.0 ))
            add(ExMyOphtha("최안과병원", "서울특별시 영등포구", R.drawable.ex_img, 2410, 5.0 ))
            add(ExMyOphtha("정안과병원", "서울특별시 영등포구", R.drawable.real_ophtha_ex_img, 2410, 5.0 ))
            add(ExMyOphtha("김안과병원", "서울특별시 영등포구", R.drawable.ex_img, 2410, 5.0 ))
            add(ExMyOphtha("이안과병원", "서울특별시 영등포구", R.drawable.ophtha_ex_img, 2410, 5.0 ))
            add(ExMyOphtha("최안과병원", "서울특별시 영등포구", R.drawable.ex_img, 2410, 5.0 ))
            add(ExMyOphtha("정안과병원", "서울특별시 영등포구", R.drawable.real_ophtha_ex_img, 2410, 5.0 ))
            add(ExMyOphtha("김안과병원", "서울특별시 영등포구", R.drawable.ex_img, 2410, 5.0 ))
            add(ExMyOphtha("이안과병원", "서울특별시 영등포구", R.drawable.ophtha_ex_img, 2410, 5.0 ))
            add(ExMyOphtha("최안과병원", "서울특별시 영등포구", R.drawable.ex_img, 2410, 5.0 ))
            add(ExMyOphtha("정안과병원", "서울특별시 영등포구", R.drawable.real_ophtha_ex_img, 2410, 5.0 ))
        }
        if(isExist){
            binding.myInfoMyOphthaThereIsLikeOphtha.visibility = View.VISIBLE
            binding.myInfoMyOphthaThereIsNoLikeOphtha.visibility = View.GONE
        }
        else{
            binding.myInfoMyOphthaThereIsLikeOphtha.visibility = View.GONE
            binding.myInfoMyOphthaThereIsNoLikeOphtha.visibility = View.VISIBLE
        }
        val myinfoMyOphthaRVAdapter = MyInfoMyOphthaRVAdapter(myInfoMyOphthaDatas)
        binding.myInfoMyOphthaRv.adapter = myinfoMyOphthaRVAdapter
        binding.myInfoMyOphthaRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        return binding.root
    }
}