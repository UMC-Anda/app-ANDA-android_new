package com.anda.ui.main.home.ranking.selectLocation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentHomeSelectLocationBinding
import com.anda.ui.main.compare.CompareSortSelectedLocationRVAdapter
import com.anda.ui.main.home.HomeFragment

class HomeSelectLocationFragment: Fragment(), View.OnClickListener {
    lateinit var binding: FragmentHomeSelectLocationBinding
    private var selectAllLocation = arrayListOf<String>("강남구", "강동구", "강북구", "강서구", "관악구", "광진구", "구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구", "마포구", "서대문구", "서초구", "성동구", "성북구", "송파구", "양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구")

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeSelectLocationBinding.inflate(inflater, container, false)

        binding.homeSelectLocationBackImgIv.setOnClickListener(this)
        binding.homeSelectLocationInitBtnIv.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulAll.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulGangnam.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulGangdong.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulGangbuk.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulGangseo.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulGwanak.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulGwangjin.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulGuro.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulGeumcheon.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulNowon.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulDobong.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulDdm.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulDongjak.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulMapo.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulSdm.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulSeocho.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulSeongdong.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulSeongbuk.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulSongpa.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulYangcheon.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulYeongdeungpo.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulYongsan.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulEunpyeong.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulJongno.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulJunggu.setOnClickListener(this)
        binding.homeSelectLocationCitySeoulJungnang.setOnClickListener(this)

        setSelectedLocationRV()

        return binding.root
    }
    private fun setSelectedLocationRV():HomeSelectLocationRVAdapter{
        var homeSelectedLocationDatas  =  ArrayList<String>()
        homeSelectedLocationDatas.addAll((context as MainActivity).homeSelectLocation)
        val homeSelectedLocationRVAdapter = HomeSelectLocationRVAdapter(homeSelectedLocationDatas)
        binding.homeSelectLocationSelectedLocationsRv.adapter = homeSelectedLocationRVAdapter
        binding.homeSelectLocationSelectedLocationsRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        homeSelectedLocationRVAdapter.setHomeSelectLocationItemClickListener(
            object : HomeSelectLocationRVAdapter.homeSelectLocationItemClickListener{
                override fun onItemClick(selectedLocation : String, position : Int) {
                    (context as MainActivity).homeSelectLocation.remove(selectedLocation)
                    homeSelectedLocationDatas.removeAt(position)
                    Log.d("홈 위치 선택", (context as MainActivity).homeSelectLocation.toString())
                    when(selectedLocation){
                        "강남구"->{
                            binding.homeSelectLocationCitySeoulGangnamCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulGangnamCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false}
                        "강동구"->{
                            binding.homeSelectLocationCitySeoulGangdongCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulGangdongCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false }
                        "강북구"->{
                            binding.homeSelectLocationCitySeoulGangbukCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulGangbukCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false }
                        "강서구"->{
                            binding.homeSelectLocationCitySeoulGangseoCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulGangseoCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false }
                        "관악구"->{
                            binding.homeSelectLocationCitySeoulGwanakCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulGwanakCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false }
                        "광진구"->{
                            binding.homeSelectLocationCitySeoulGwangjinCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulGwangjinCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false}
                        "구로구"->{
                            binding.homeSelectLocationCitySeoulGuroCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulGuroCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false }
                        "금천구"->{
                            binding.homeSelectLocationCitySeoulGeumcheonCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulGeumcheonCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false }
                        "노원구"->{
                            binding.homeSelectLocationCitySeoulNowonCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulNowonCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false}
                        "도봉구"->{
                            binding.homeSelectLocationCitySeoulDobongCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulDobongCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false}
                        "동대문구"->{
                            binding.homeSelectLocationCitySeoulDdmCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulDdmCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false}
                        "동작구"->{
                            binding.homeSelectLocationCitySeoulDongjakCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulDongjakCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false}
                        "마포구"->{
                            binding.homeSelectLocationCitySeoulMapoCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulMapoCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false}
                        "서대문구"->{
                            binding.homeSelectLocationCitySeoulSdmCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulSdmCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false}
                        "서초구"->{
                            binding.homeSelectLocationCitySeoulSeochoCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulSeochoCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false}
                        "성동구"->{
                            binding.homeSelectLocationCitySeoulSeongdongCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulSeongdongCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false}
                        "성북구"->{
                            binding.homeSelectLocationCitySeoulSeongbukCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulSeongbukCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false}
                        "송파구"->{
                            binding.homeSelectLocationCitySeoulSongpaCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulSongpaCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false}
                        "양천구"->{
                            binding.homeSelectLocationCitySeoulYangcheonCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulYangcheonCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false}
                        "영등포구"->{
                            binding.homeSelectLocationCitySeoulYeongdeungpoCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulYeongdeungpoCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false}
                        "용산구"->{
                            binding.homeSelectLocationCitySeoulYongsanCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulYongsanCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false}
                        "은평구"->{
                            binding.homeSelectLocationCitySeoulEunpyeongCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulEunpyeongCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false}
                        "종로구"->{
                            binding.homeSelectLocationCitySeoulJongnoCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulJongnoCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false}
                        "중구"->{
                            binding.homeSelectLocationCitySeoulJungguCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulJungguCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false}
                        "중랑구"->{
                            binding.homeSelectLocationCitySeoulJungnangCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulJungnangCheckboxCb.isChecked
                            binding.homeSelectLocationCitySeoulAllCb.isChecked = false}
                    }
                }
            }
        )
        return homeSelectedLocationRVAdapter
    }
    override fun onClick(v: View?) {
        if(v == null) return
        when(v){
            binding.homeSelectLocationBackImgIv ->{
                (context as MainActivity).homeSelectLocation
                (context as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, HomeFragment())
                    .commitAllowingStateLoss()
            }
            binding.homeSelectLocationInitBtnIv ->{
                uncheckLocationAll()
                (context as MainActivity).homeSelectLocation.clear()
            }
            binding.homeSelectLocationCitySeoulAll ->{
                if(binding.homeSelectLocationCitySeoulAllCb.isChecked){
                    uncheckLocationAll()
                    (context as MainActivity).homeSelectLocation.clear()
                }else{
                    checkLocationAll()
                    (context as MainActivity).homeSelectLocation.clear()
                    (context as MainActivity).homeSelectLocation.addAll(selectAllLocation)
                }
            }
            binding.homeSelectLocationCitySeoulGangnam ->{
                binding.homeSelectLocationCitySeoulGangnamCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulGangnamCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulGangnamTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulGangdong ->{
                binding.homeSelectLocationCitySeoulGangdongCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulGangdongCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulGangdongTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulGangbuk ->{
                binding.homeSelectLocationCitySeoulGangbukCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulGangbukCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulGangbukTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulGangseo ->{
                binding.homeSelectLocationCitySeoulGangseoCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulGangseoCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulGangseoTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulGwanak ->{
                binding.homeSelectLocationCitySeoulGwanakCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulGwanakCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulGwanakTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulGwangjin ->{
                binding.homeSelectLocationCitySeoulGwangjinCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulGwangjinCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulGwangjinTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulGuro ->{
                binding.homeSelectLocationCitySeoulGuroCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulGuroCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulGuroTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulGeumcheon ->{
                binding.homeSelectLocationCitySeoulGeumcheonCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulGeumcheonCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulGeumcheonTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulNowon ->{
                binding.homeSelectLocationCitySeoulNowonCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulNowonCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulNowonTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulDobong -> {
                binding.homeSelectLocationCitySeoulDobongCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulDobongCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulDobongTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulDdm ->{
                binding.homeSelectLocationCitySeoulDdmCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulDdmCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulDdmTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulDongjak ->{
                binding.homeSelectLocationCitySeoulDongjakCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulDongjakCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulDongjakTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulMapo ->{
                binding.homeSelectLocationCitySeoulMapoCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulMapoCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulMapoTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulSdm ->{
                binding.homeSelectLocationCitySeoulSdmCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulSdmCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulSdmTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulSeocho ->{
                binding.homeSelectLocationCitySeoulSeochoCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulSeochoCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulSeochoTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulSeongdong ->{
                binding.homeSelectLocationCitySeoulSeongdongCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulSeongdongCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulSeongdongTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulSeongbuk ->{
                binding.homeSelectLocationCitySeoulSeongbukCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulSeongbukCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulSeongbukTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulSongpa ->{
                binding.homeSelectLocationCitySeoulSongpaCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulSongpaCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulSongpaTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulYangcheon ->{
                binding.homeSelectLocationCitySeoulYangcheonCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulYangcheonCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulYangcheonTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulYeongdeungpo ->{
                binding.homeSelectLocationCitySeoulYeongdeungpoCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulYeongdeungpoCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulYeongdeungpoTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulYongsan ->{
                binding.homeSelectLocationCitySeoulYongsanCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulYongsanCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulYongsanTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulEunpyeong ->{
                binding.homeSelectLocationCitySeoulEunpyeongCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulEunpyeongCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulEunpyeongTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulJongno ->{
                binding.homeSelectLocationCitySeoulJongnoCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulJongnoCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulJongnoTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulJunggu ->{
                binding.homeSelectLocationCitySeoulJungguCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulJungguCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulJungguTv.text.toString())
            }
            binding.homeSelectLocationCitySeoulJungnang ->{
                binding.homeSelectLocationCitySeoulJungnangCheckboxCb.isChecked = !binding.homeSelectLocationCitySeoulJungnangCheckboxCb.isChecked
                binding.homeSelectLocationCitySeoulAllCb.isChecked = false
                selectLocationSetting(binding.homeSelectLocationCitySeoulJungnangTv.text.toString())
            }
        }
        setSelectedLocationRV()
    }
    private fun checkLocationAll(){
        binding.homeSelectLocationCitySeoulAllCb.isChecked = true
        binding.homeSelectLocationCitySeoulGangnamCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulGangdongCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulGangbukCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulGangseoCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulGwanakCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulGwangjinCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulGuroCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulGeumcheonCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulNowonCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulDobongCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulDdmCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulDongjakCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulMapoCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulSdmCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulSeochoCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulSeongdongCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulSeongbukCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulSongpaCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulYangcheonCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulYeongdeungpoCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulYongsanCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulEunpyeongCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulJongnoCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulJungguCheckboxCb.isChecked = true
        binding.homeSelectLocationCitySeoulJungnangCheckboxCb.isChecked = true
    }
    private fun uncheckLocationAll(){
        binding.homeSelectLocationCitySeoulAllCb.isChecked = false
        binding.homeSelectLocationCitySeoulGangnamCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulGangdongCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulGangbukCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulGangseoCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulGwanakCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulGwangjinCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulGuroCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulGeumcheonCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulNowonCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulDobongCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulDdmCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulDongjakCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulMapoCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulSdmCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulSeochoCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulSeongdongCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulSeongbukCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulSongpaCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulYangcheonCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulYeongdeungpoCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulYongsanCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulEunpyeongCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulJongnoCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulJungguCheckboxCb.isChecked = false
        binding.homeSelectLocationCitySeoulJungnangCheckboxCb.isChecked = false
    }
    private fun selectLocationSetting(location : String){
        var isContain : Boolean = (context as MainActivity).homeSelectLocation.contains(location)
        var indexNum : Int = (context as MainActivity).homeSelectLocation.indexOf(location)
        if(isContain){
            (context as MainActivity).homeSelectLocation.remove(location)
            indexNum
        } else{
            (context as MainActivity).homeSelectLocation.add(location)
        }
        (context as MainActivity).homeSelectLocation.sort()
        Log.d("홈 위치 선택", (context as MainActivity).homeSelectLocation.toString())
    }
}