package com.anda.ui.main.compare.option

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentCompareOptionSelectLocationBinding

class CompareOptionSelectLocationFragment() : Fragment(), View.OnClickListener {

    //바인딩
    lateinit var binding : FragmentCompareOptionSelectLocationBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCompareOptionSelectLocationBinding.inflate(inflater, container, false)

        binding.compareOptionSelectLocationGangnam.setOnClickListener(this)
        binding.compareOptionSelectLocationDongdaemun.setOnClickListener(this)
        binding.compareOptionSelectLocationYongsan.setOnClickListener(this)

        binding.compareOptionSelectLocationGangdong.setOnClickListener(this)
        binding.compareOptionSelectLocationDongjak.setOnClickListener(this)
        binding.compareOptionSelectLocationEunpyeong.setOnClickListener(this)

        binding.compareOptionSelectLocationGangbuk.setOnClickListener(this)
        binding.compareOptionSelectLocationMapo.setOnClickListener(this)
        binding.compareOptionSelectLocationJongno.setOnClickListener(this)

        binding.compareOptionSelectLocationGangseo.setOnClickListener(this)
        binding.compareOptionSelectLocationSeodaemun.setOnClickListener(this)
        binding.compareOptionSelectLocationJung.setOnClickListener(this)

        binding.compareOptionSelectLocationGwanak.setOnClickListener(this)
        binding.compareOptionSelectLocationSeocho.setOnClickListener(this)
        binding.compareOptionSelectLocationJungnang.setOnClickListener(this)

        binding.compareOptionSelectLocationGwangjin.setOnClickListener(this)
        binding.compareOptionSelectLocationSeongdong.setOnClickListener(this)

        binding.compareOptionSelectLocationGuro.setOnClickListener(this)
        binding.compareOptionSelectLocationSeongbuk.setOnClickListener(this)

        binding.compareOptionSelectLocationGeumcheon.setOnClickListener(this)
        binding.compareOptionSelectLocationSongpa.setOnClickListener(this)


        binding.compareOptionSelectLocationNowon.setOnClickListener(this)
        binding.compareOptionSelectLocationYangcheon.setOnClickListener(this)

        binding.compareOptionSelectLocationDobong.setOnClickListener(this)
        binding.compareOptionSelectLocationYeongdeungpo.setOnClickListener(this)

        return binding.root
    }

    override fun onClick(v: View?) {
        if (v == null) return
        when (v) {
            //강남구
            binding.compareOptionSelectLocationGangnam ->{
                if(binding.compareOptionSelectLocationGangnamTv.isChecked){
                    binding.compareOptionSelectLocationGangnamCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationGangnamCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationGangnamTv.isChecked = !binding.compareOptionSelectLocationGangnamTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("강남구")
                }
                else{
                    binding.compareOptionSelectLocationGangnamCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationGangnamCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationGangnamTv.isChecked = !binding.compareOptionSelectLocationGangnamTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("강남구")
                }
            }
            //동대문구
            binding.compareOptionSelectLocationDongdaemun ->{
                if(binding.compareOptionSelectLocationDongdaemunTv.isChecked){
                    binding.compareOptionSelectLocationDongdaemunCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationDongdaemunCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationDongdaemunTv.isChecked = !binding.compareOptionSelectLocationDongdaemunTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("동대문구")
                }
                else{
                    binding.compareOptionSelectLocationDongdaemunCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationDongdaemunCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationDongdaemunTv.isChecked = !binding.compareOptionSelectLocationDongdaemunTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("동대문구")
                }
            }
            //용산구
            binding.compareOptionSelectLocationYongsan ->{
                if(binding.compareOptionSelectLocationYongsanTv.isChecked){
                    binding.compareOptionSelectLocationYongsanCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationYongsanCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationYongsanTv.isChecked = !binding.compareOptionSelectLocationYongsanTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("용산구")
                }
                else{
                    binding.compareOptionSelectLocationYongsanCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationYongsanCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationYongsanTv.isChecked = !binding.compareOptionSelectLocationYongsanTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("용산구")
                }
            }
            //강동구
            binding.compareOptionSelectLocationGangdong ->{
                if(binding.compareOptionSelectLocationGangdongTv.isChecked){
                    binding.compareOptionSelectLocationGangdongCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationGangdongCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationGangdongTv.isChecked = !binding.compareOptionSelectLocationGangdongTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("강동구")
                }
                else{
                    binding.compareOptionSelectLocationGangdongCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationGangdongCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationGangdongTv.isChecked = !binding.compareOptionSelectLocationGangdongTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("강동구")
                }
            }
            //동작구
            binding.compareOptionSelectLocationDongjak ->{
                if(binding.compareOptionSelectLocationDongjakTv.isChecked){
                    binding.compareOptionSelectLocationDongjakCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationDongjakCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationDongjakTv.isChecked = !binding.compareOptionSelectLocationDongjakTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("동작구")
                }
                else{
                    binding.compareOptionSelectLocationDongjakCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationDongjakCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationDongjakTv.isChecked = !binding.compareOptionSelectLocationDongjakTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("동작구")
                }
            }
            //은평구
            binding.compareOptionSelectLocationEunpyeong ->{
                if(binding.compareOptionSelectLocationEunpyeongTv.isChecked){
                    binding.compareOptionSelectLocationEunpyeongCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationEunpyeongCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationEunpyeongTv.isChecked = !binding.compareOptionSelectLocationEunpyeongTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("은평구")
                }
                else{
                    binding.compareOptionSelectLocationEunpyeongCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationEunpyeongCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationEunpyeongTv.isChecked = !binding.compareOptionSelectLocationEunpyeongTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("은평구")
                }
            }
            //강북구
            binding.compareOptionSelectLocationGangbuk ->{
                if(binding.compareOptionSelectLocationGangbukTv.isChecked){
                    binding.compareOptionSelectLocationGangbukCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationGangbukCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationGangbukTv.isChecked = !binding.compareOptionSelectLocationGangbukTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("강북구")
                }
                else{
                    binding.compareOptionSelectLocationGangbukCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationGangbukCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationGangbukTv.isChecked = !binding.compareOptionSelectLocationGangbukTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("강북구")
                }
            }
            //마포구
            binding.compareOptionSelectLocationMapo ->{
                if(binding.compareOptionSelectLocationMapoTv.isChecked){
                    binding.compareOptionSelectLocationMapoCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationMapoCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationMapoTv.isChecked = !binding.compareOptionSelectLocationMapoTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("마포구")
                }
                else{
                    binding.compareOptionSelectLocationMapoCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationMapoCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationMapoTv.isChecked = !binding.compareOptionSelectLocationMapoTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("마포구")
                }
            }
            //종로구
            binding.compareOptionSelectLocationJongno ->{
                if(binding.compareOptionSelectLocationJongnoTv.isChecked){
                    binding.compareOptionSelectLocationJongnoCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationJongnoCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationJongnoTv.isChecked = !binding.compareOptionSelectLocationJongnoTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("종로구")
                }
                else{
                    binding.compareOptionSelectLocationJongnoCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationJongnoCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationJongnoTv.isChecked = !binding.compareOptionSelectLocationJongnoTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("종로구")
                }
            }
            //강서구
            binding.compareOptionSelectLocationGangseo ->{
                if(binding.compareOptionSelectLocationGangseoTv.isChecked){
                    binding.compareOptionSelectLocationGangseoCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationGangseoCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationGangseoTv.isChecked = !binding.compareOptionSelectLocationGangseoTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("강서구")
                }
                else{
                    binding.compareOptionSelectLocationGangseoCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationGangseoCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationGangseoTv.isChecked = !binding.compareOptionSelectLocationGangseoTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("강서구")
                }
            }
            //서대문구
            binding.compareOptionSelectLocationSeodaemun ->{
                if(binding.compareOptionSelectLocationSeodaemunTv.isChecked){
                    binding.compareOptionSelectLocationSeodaemunCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationSeodaemunCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationSeodaemunTv.isChecked = !binding.compareOptionSelectLocationSeodaemunTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("서대문구")
                }
                else{
                    binding.compareOptionSelectLocationSeodaemunCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationSeodaemunCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationSeodaemunTv.isChecked = !binding.compareOptionSelectLocationSeodaemunTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("서대문구")
                }
            }
            //중구
            binding.compareOptionSelectLocationJung ->{
                if(binding.compareOptionSelectLocationJungTv.isChecked){
                    binding.compareOptionSelectLocationJungCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationJungCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationJungTv.isChecked = !binding.compareOptionSelectLocationJungTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("중구")
                }
                else{
                    binding.compareOptionSelectLocationJungCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationJungCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationJungTv.isChecked = !binding.compareOptionSelectLocationJungTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("중구")
                }
            }
            //관악구
            binding.compareOptionSelectLocationGwanak ->{
                if(binding.compareOptionSelectLocationGwanakTv.isChecked){
                    binding.compareOptionSelectLocationGwanakCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationGwanakCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationGwanakTv.isChecked = !binding.compareOptionSelectLocationGwanakTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("관악구")
                }
                else{
                    binding.compareOptionSelectLocationGwanakCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationGwanakCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationGwanakTv.isChecked = !binding.compareOptionSelectLocationGwanakTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("관악구")
                }
            }
            //서초구
            binding.compareOptionSelectLocationSeocho ->{
                if(binding.compareOptionSelectLocationSeochoTv.isChecked){
                    binding.compareOptionSelectLocationSeochoCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationSeochoCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationSeochoTv.isChecked = !binding.compareOptionSelectLocationSeochoTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("서초구")
                }
                else{
                    binding.compareOptionSelectLocationSeochoCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationSeochoCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationSeochoTv.isChecked = !binding.compareOptionSelectLocationSeochoTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("서초구")
                }
            }
            //중랑구
            binding.compareOptionSelectLocationJungnang ->{
                if(binding.compareOptionSelectLocationJungnangTv.isChecked){
                    binding.compareOptionSelectLocationJungnangCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationJungnangCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationJungnangTv.isChecked = !binding.compareOptionSelectLocationJungnangTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("중랑구")
                }
                else{
                    binding.compareOptionSelectLocationJungnangCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationJungnangCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationJungnangTv.isChecked = !binding.compareOptionSelectLocationJungnangTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("중랑구")
                }
            }
            //광진구
            binding.compareOptionSelectLocationGwangjin ->{
                if(binding.compareOptionSelectLocationGwangjinTv.isChecked){
                    binding.compareOptionSelectLocationGwangjinCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationGwangjinCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationGwangjinTv.isChecked = !binding.compareOptionSelectLocationGwangjinTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("광진구")
                }
                else{
                    binding.compareOptionSelectLocationGwangjinCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationGwangjinCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationGwangjinTv.isChecked = !binding.compareOptionSelectLocationGwangjinTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("광진구")
                }
            }
            //성동구
            binding.compareOptionSelectLocationSeongdong ->{
                if(binding.compareOptionSelectLocationSeongdongTv.isChecked){
                    binding.compareOptionSelectLocationSeongdongCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationSeongdongCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationSeongdongTv.isChecked = !binding.compareOptionSelectLocationSeongdongTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("성동구")
                }
                else{
                    binding.compareOptionSelectLocationSeongdongCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationSeongdongCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationSeongdongTv.isChecked = !binding.compareOptionSelectLocationSeongdongTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("성동구")
                }
            }
            //구로구
            binding.compareOptionSelectLocationGuro ->{
                if(binding.compareOptionSelectLocationGuroTv.isChecked){
                    binding.compareOptionSelectLocationGuroCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationGuroCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationGuroTv.isChecked = !binding.compareOptionSelectLocationGuroTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("구로구")
                }
                else{
                    binding.compareOptionSelectLocationGuroCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationGuroCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationGuroTv.isChecked = !binding.compareOptionSelectLocationGuroTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("구로구")
                }
            }
            //성북구
            binding.compareOptionSelectLocationSeongbuk ->{
                if(binding.compareOptionSelectLocationSeongbukTv.isChecked){
                    binding.compareOptionSelectLocationSeongbukCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationSeongbukCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationSeongbukTv.isChecked = !binding.compareOptionSelectLocationSeongbukTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("성북구")
                }
                else{
                    binding.compareOptionSelectLocationSeongbukCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationSeongbukCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationSeongbukTv.isChecked = !binding.compareOptionSelectLocationSeongbukTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("성북구")
                }
            }
            //금천구
            binding.compareOptionSelectLocationGeumcheon ->{
                if(binding.compareOptionSelectLocationGeumcheonTv.isChecked){
                    binding.compareOptionSelectLocationGeumcheonCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationGeumcheonCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationGeumcheonTv.isChecked = !binding.compareOptionSelectLocationGeumcheonTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("금천구")
                }
                else{
                    binding.compareOptionSelectLocationGeumcheonCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationGeumcheonCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationGeumcheonTv.isChecked = !binding.compareOptionSelectLocationGeumcheonTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("금천구")
                }
            }
            //송파구
            binding.compareOptionSelectLocationSongpa ->{
                if(binding.compareOptionSelectLocationSongpaTv.isChecked){
                    binding.compareOptionSelectLocationSongpaCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationSongpaCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationSongpaTv.isChecked = !binding.compareOptionSelectLocationSongpaTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("송파구")
                }
                else{
                    binding.compareOptionSelectLocationSongpaCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationSongpaCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationSongpaTv.isChecked = !binding.compareOptionSelectLocationSongpaTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("송파구")
                }
            }
            //노원구
            binding.compareOptionSelectLocationNowon ->{
                if(binding.compareOptionSelectLocationNowonTv.isChecked){
                    binding.compareOptionSelectLocationNowonCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationNowonCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationNowonTv.isChecked = !binding.compareOptionSelectLocationNowonTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("노원구")
                }
                else{
                    binding.compareOptionSelectLocationNowonCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationNowonCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationNowonTv.isChecked = !binding.compareOptionSelectLocationNowonTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("노원구")
                }
            }
            //양천구
            binding.compareOptionSelectLocationYangcheon ->{
                if(binding.compareOptionSelectLocationYangcheonTv.isChecked){
                    binding.compareOptionSelectLocationYangcheonCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationYangcheonCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationYangcheonTv.isChecked = !binding.compareOptionSelectLocationYangcheonTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("양천구")
                }
                else{
                    binding.compareOptionSelectLocationYangcheonCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationYangcheonCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationYangcheonTv.isChecked = !binding.compareOptionSelectLocationYangcheonTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("양천구")
                }
            }
            //도봉구
            binding.compareOptionSelectLocationDobong ->{
                if(binding.compareOptionSelectLocationDobongTv.isChecked){
                    binding.compareOptionSelectLocationDobongCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationDobongCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationDobongTv.isChecked = !binding.compareOptionSelectLocationDobongTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("도봉구")
                }
                else{
                    binding.compareOptionSelectLocationDobongCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationDobongCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationDobongTv.isChecked = !binding.compareOptionSelectLocationDobongTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("도봉구")
                }
            }
            //영등포구
            binding.compareOptionSelectLocationYeongdeungpo ->{
                if(binding.compareOptionSelectLocationYeongdeungpoTv.isChecked){
                    binding.compareOptionSelectLocationYeongdeungpoCheckcircleIv.elevation = 0f
                    binding.compareOptionSelectLocationYeongdeungpoCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationYeongdeungpoTv.isChecked = !binding.compareOptionSelectLocationYeongdeungpoTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.remove("영등포구")
                }
                else{
                    binding.compareOptionSelectLocationYeongdeungpoCheckcircleIv.elevation = 11f
                    binding.compareOptionSelectLocationYeongdeungpoCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationYeongdeungpoTv.isChecked = !binding.compareOptionSelectLocationYeongdeungpoTv.isChecked
                    (activity as MainActivity).compareSortSelectedOption.selectedLocation!!.add("영등포구")
                }
            }
        }

    }
}