package com.anda.ui.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.anda.MainActivity
import com.anda.R
import com.anda.data.entities.HomeAndaRankingOphtha
import com.anda.databinding.FragmentHomeRankingBannerBinding
import com.anda.ui.ophtha_info.OphthaInfoFragment

class HomeAndaRankingBannerFragment (val homeAndaRankingDatas:ArrayList<HomeAndaRankingOphtha>?) : Fragment() {

    lateinit var binding: FragmentHomeRankingBannerBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeRankingBannerBinding.inflate(inflater, container, false)



        val andaRankingRVAdapter = HomeAndaRankingRVAdapter(homeAndaRankingDatas!!)
        binding.homeRankingBannerOphthaListRv.adapter = andaRankingRVAdapter
        binding.homeRankingBannerOphthaListRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        andaRankingRVAdapter.setHomeandaRankingOphthaItemClickListener(object : HomeAndaRankingRVAdapter.homeandaRankingOphthaItemClickListener{
            override fun onItemClick(andaRankingOphtha: HomeAndaRankingOphtha) {
                (context as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, OphthaInfoFragment(andaRankingOphtha))
                    .commitAllowingStateLoss()
            } })
        return binding.root
    }
}