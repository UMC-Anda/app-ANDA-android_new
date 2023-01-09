package com.anda.ui.main.compare.option

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
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
                    binding.compareOptionSelectLocationGangnamTv.elevation = 0f
                    binding.compareOptionSelectLocationGangnamCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationGangnamTv.isChecked = !binding.compareOptionSelectLocationGangnamTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationGangnamTv.elevation = 11f
                    binding.compareOptionSelectLocationGangnamCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationGangnamTv.isChecked = !binding.compareOptionSelectLocationGangnamTv.isChecked
                }
            }
            //동대문구
            binding.compareOptionSelectLocationDongdaemun ->{
                if(binding.compareOptionSelectLocationDongdaemunTv.isChecked){
                    binding.compareOptionSelectLocationDongdaemunTv.elevation = 0f
                    binding.compareOptionSelectLocationDongdaemunCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationDongdaemunTv.isChecked = !binding.compareOptionSelectLocationDongdaemunTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationDongdaemunTv.elevation = 11f
                    binding.compareOptionSelectLocationDongdaemunCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationDongdaemunTv.isChecked = !binding.compareOptionSelectLocationDongdaemunTv.isChecked
                }
            }
            //용산구
            binding.compareOptionSelectLocationYongsan ->{
                if(binding.compareOptionSelectLocationYongsanTv.isChecked){
                    binding.compareOptionSelectLocationYongsanTv.elevation = 0f
                    binding.compareOptionSelectLocationYongsanCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationYongsanTv.isChecked = !binding.compareOptionSelectLocationYongsanTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationYongsanTv.elevation = 11f
                    binding.compareOptionSelectLocationYongsanCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationYongsanTv.isChecked = !binding.compareOptionSelectLocationYongsanTv.isChecked
                }
            }
            //강동구
            binding.compareOptionSelectLocationGangdong ->{
                if(binding.compareOptionSelectLocationGangdongTv.isChecked){
                    binding.compareOptionSelectLocationGangdongTv.elevation = 0f
                    binding.compareOptionSelectLocationGangdongCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationGangdongTv.isChecked = !binding.compareOptionSelectLocationGangdongTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationGangdongTv.elevation = 11f
                    binding.compareOptionSelectLocationGangdongCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationGangdongTv.isChecked = !binding.compareOptionSelectLocationGangdongTv.isChecked
                }
            }
            //동작구
            binding.compareOptionSelectLocationDongjak ->{
                if(binding.compareOptionSelectLocationDongjakTv.isChecked){
                    binding.compareOptionSelectLocationDongjakTv.elevation = 0f
                    binding.compareOptionSelectLocationDongjakCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationDongjakTv.isChecked = !binding.compareOptionSelectLocationDongjakTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationDongjakTv.elevation = 11f
                    binding.compareOptionSelectLocationDongjakCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationDongjakTv.isChecked = !binding.compareOptionSelectLocationDongjakTv.isChecked
                }
            }
            //은평구
            binding.compareOptionSelectLocationEunpyeong ->{
                if(binding.compareOptionSelectLocationEunpyeongTv.isChecked){
                    binding.compareOptionSelectLocationEunpyeongTv.elevation = 0f
                    binding.compareOptionSelectLocationEunpyeongCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationEunpyeongTv.isChecked = !binding.compareOptionSelectLocationEunpyeongTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationEunpyeongTv.elevation = 11f
                    binding.compareOptionSelectLocationEunpyeongCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationEunpyeongTv.isChecked = !binding.compareOptionSelectLocationEunpyeongTv.isChecked
                }
            }
            //강북구
            binding.compareOptionSelectLocationGangbuk ->{
                if(binding.compareOptionSelectLocationGangbukTv.isChecked){
                    binding.compareOptionSelectLocationGangbukTv.elevation = 0f
                    binding.compareOptionSelectLocationGangbukCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationGangbukTv.isChecked = !binding.compareOptionSelectLocationGangbukTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationGangbukTv.elevation = 11f
                    binding.compareOptionSelectLocationGangbukCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationGangbukTv.isChecked = !binding.compareOptionSelectLocationGangbukTv.isChecked
                }
            }
            //마포구
            binding.compareOptionSelectLocationMapo ->{
                if(binding.compareOptionSelectLocationMapoTv.isChecked){
                    binding.compareOptionSelectLocationMapoTv.elevation = 0f
                    binding.compareOptionSelectLocationMapoCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationMapoTv.isChecked = !binding.compareOptionSelectLocationMapoTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationMapoTv.elevation = 11f
                    binding.compareOptionSelectLocationMapoCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationMapoTv.isChecked = !binding.compareOptionSelectLocationMapoTv.isChecked
                }
            }
            //종로구
            binding.compareOptionSelectLocationJongno ->{
                if(binding.compareOptionSelectLocationJongnoTv.isChecked){
                    binding.compareOptionSelectLocationJongnoTv.elevation = 0f
                    binding.compareOptionSelectLocationJongnoCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationJongnoTv.isChecked = !binding.compareOptionSelectLocationJongnoTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationJongnoTv.elevation = 11f
                    binding.compareOptionSelectLocationJongnoCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationJongnoTv.isChecked = !binding.compareOptionSelectLocationJongnoTv.isChecked
                }
            }
            //강서구
            binding.compareOptionSelectLocationGangseo ->{
                if(binding.compareOptionSelectLocationGangseoTv.isChecked){
                    binding.compareOptionSelectLocationGangseoTv.elevation = 0f
                    binding.compareOptionSelectLocationGangseoCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationGangseoTv.isChecked = !binding.compareOptionSelectLocationGangseoTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationGangseoTv.elevation = 11f
                    binding.compareOptionSelectLocationGangseoCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationGangseoTv.isChecked = !binding.compareOptionSelectLocationGangseoTv.isChecked
                }
            }
            //서대문구
            binding.compareOptionSelectLocationSeodaemun ->{
                if(binding.compareOptionSelectLocationSeodaemunTv.isChecked){
                    binding.compareOptionSelectLocationSeodaemunTv.elevation = 0f
                    binding.compareOptionSelectLocationSeodaemunCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationSeodaemunTv.isChecked = !binding.compareOptionSelectLocationSeodaemunTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationSeodaemunTv.elevation = 11f
                    binding.compareOptionSelectLocationSeodaemunCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationSeodaemunTv.isChecked = !binding.compareOptionSelectLocationSeodaemunTv.isChecked
                }
            }
            //중구
            binding.compareOptionSelectLocationJung ->{
                if(binding.compareOptionSelectLocationJungTv.isChecked){
                    binding.compareOptionSelectLocationJungTv.elevation = 0f
                    binding.compareOptionSelectLocationJungCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationJungTv.isChecked = !binding.compareOptionSelectLocationJungTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationJungTv.elevation = 11f
                    binding.compareOptionSelectLocationJungCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationJungTv.isChecked = !binding.compareOptionSelectLocationJungTv.isChecked
                }
            }
            //관악구
            binding.compareOptionSelectLocationGwanak ->{
                if(binding.compareOptionSelectLocationGwanakTv.isChecked){
                    binding.compareOptionSelectLocationGwanakTv.elevation = 0f
                    binding.compareOptionSelectLocationGwanakCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationGwanakTv.isChecked = !binding.compareOptionSelectLocationGwanakTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationGwanakTv.elevation = 11f
                    binding.compareOptionSelectLocationGwanakCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationGwanakTv.isChecked = !binding.compareOptionSelectLocationGwanakTv.isChecked
                }
            }
            //서초구
            binding.compareOptionSelectLocationSeocho ->{
                if(binding.compareOptionSelectLocationSeochoTv.isChecked){
                    binding.compareOptionSelectLocationSeochoTv.elevation = 0f
                    binding.compareOptionSelectLocationSeochoCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationSeochoTv.isChecked = !binding.compareOptionSelectLocationSeochoTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationSeochoTv.elevation = 11f
                    binding.compareOptionSelectLocationSeochoCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationSeochoTv.isChecked = !binding.compareOptionSelectLocationSeochoTv.isChecked
                }
            }
            //중랑구
            binding.compareOptionSelectLocationJungnang ->{
                if(binding.compareOptionSelectLocationJungnangTv.isChecked){
                    binding.compareOptionSelectLocationJungnangTv.elevation = 0f
                    binding.compareOptionSelectLocationJungnangCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationJungnangTv.isChecked = !binding.compareOptionSelectLocationJungnangTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationJungnangTv.elevation = 11f
                    binding.compareOptionSelectLocationJungnangCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationJungnangTv.isChecked = !binding.compareOptionSelectLocationJungnangTv.isChecked
                }
            }
            //광진구
            binding.compareOptionSelectLocationGwangjin ->{
                if(binding.compareOptionSelectLocationGwangjinTv.isChecked){
                    binding.compareOptionSelectLocationGwangjinTv.elevation = 0f
                    binding.compareOptionSelectLocationGwangjinCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationGwangjinTv.isChecked = !binding.compareOptionSelectLocationGwangjinTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationGwangjinTv.elevation = 11f
                    binding.compareOptionSelectLocationGwangjinCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationGwangjinTv.isChecked = !binding.compareOptionSelectLocationGwangjinTv.isChecked
                }
            }
            //성동구
            binding.compareOptionSelectLocationSeongdong ->{
                if(binding.compareOptionSelectLocationSeongdongTv.isChecked){
                    binding.compareOptionSelectLocationSeongdongTv.elevation = 0f
                    binding.compareOptionSelectLocationSeongdongCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationSeongdongTv.isChecked = !binding.compareOptionSelectLocationSeongdongTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationSeongdongTv.elevation = 11f
                    binding.compareOptionSelectLocationSeongdongCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationSeongdongTv.isChecked = !binding.compareOptionSelectLocationSeongdongTv.isChecked
                }
            }
            //구로구
            binding.compareOptionSelectLocationGuro ->{
                if(binding.compareOptionSelectLocationGuroTv.isChecked){
                    binding.compareOptionSelectLocationGuroTv.elevation = 0f
                    binding.compareOptionSelectLocationGuroCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationGuroTv.isChecked = !binding.compareOptionSelectLocationGuroTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationGuroTv.elevation = 11f
                    binding.compareOptionSelectLocationGuroCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationGuroTv.isChecked = !binding.compareOptionSelectLocationGuroTv.isChecked
                }
            }
            //성북구
            binding.compareOptionSelectLocationSeongbuk ->{
                if(binding.compareOptionSelectLocationSeongbukTv.isChecked){
                    binding.compareOptionSelectLocationSeongbukTv.elevation = 0f
                    binding.compareOptionSelectLocationSeongbukCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationSeongbukTv.isChecked = !binding.compareOptionSelectLocationSeongbukTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationSeongbukTv.elevation = 11f
                    binding.compareOptionSelectLocationSeongbukCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationSeongbukTv.isChecked = !binding.compareOptionSelectLocationSeongbukTv.isChecked
                }
            }
            //금천구
            binding.compareOptionSelectLocationGeumcheon ->{
                if(binding.compareOptionSelectLocationGeumcheonTv.isChecked){
                    binding.compareOptionSelectLocationGeumcheonTv.elevation = 0f
                    binding.compareOptionSelectLocationGeumcheonCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationGeumcheonTv.isChecked = !binding.compareOptionSelectLocationGeumcheonTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationGeumcheonTv.elevation = 11f
                    binding.compareOptionSelectLocationGeumcheonCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationGeumcheonTv.isChecked = !binding.compareOptionSelectLocationGeumcheonTv.isChecked
                }
            }
            //송파구
            binding.compareOptionSelectLocationSongpa ->{
                if(binding.compareOptionSelectLocationSongpaTv.isChecked){
                    binding.compareOptionSelectLocationSongpaTv.elevation = 0f
                    binding.compareOptionSelectLocationSongpaCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationSongpaTv.isChecked = !binding.compareOptionSelectLocationSongpaTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationSongpaTv.elevation = 11f
                    binding.compareOptionSelectLocationSongpaCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationSongpaTv.isChecked = !binding.compareOptionSelectLocationSongpaTv.isChecked
                }
            }
            //노원구
            binding.compareOptionSelectLocationNowon ->{
                if(binding.compareOptionSelectLocationNowonTv.isChecked){
                    binding.compareOptionSelectLocationNowonTv.elevation = 0f
                    binding.compareOptionSelectLocationNowonCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationNowonTv.isChecked = !binding.compareOptionSelectLocationNowonTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationNowonTv.elevation = 11f
                    binding.compareOptionSelectLocationNowonCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationNowonTv.isChecked = !binding.compareOptionSelectLocationNowonTv.isChecked
                }
            }
            //양천구
            binding.compareOptionSelectLocationYangcheon ->{
                if(binding.compareOptionSelectLocationYangcheonTv.isChecked){
                    binding.compareOptionSelectLocationYangcheonTv.elevation = 0f
                    binding.compareOptionSelectLocationYangcheonCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationYangcheonTv.isChecked = !binding.compareOptionSelectLocationYangcheonTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationYangcheonTv.elevation = 11f
                    binding.compareOptionSelectLocationYangcheonCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationYangcheonTv.isChecked = !binding.compareOptionSelectLocationYangcheonTv.isChecked
                }
            }
            //도봉구
            binding.compareOptionSelectLocationDobong ->{
                if(binding.compareOptionSelectLocationDobongTv.isChecked){
                    binding.compareOptionSelectLocationDobongTv.elevation = 0f
                    binding.compareOptionSelectLocationDobongCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationDobongTv.isChecked = !binding.compareOptionSelectLocationDobongTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationDobongTv.elevation = 11f
                    binding.compareOptionSelectLocationDobongCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationDobongTv.isChecked = !binding.compareOptionSelectLocationDobongTv.isChecked
                }
            }
            //영등포구
            binding.compareOptionSelectLocationYeongdeungpo ->{
                if(binding.compareOptionSelectLocationYeongdeungpoTv.isChecked){
                    binding.compareOptionSelectLocationYeongdeungpoTv.elevation = 0f
                    binding.compareOptionSelectLocationYeongdeungpoCheckcircleIv.setImageResource(R.drawable.checkcircle_unchecked)
                    binding.compareOptionSelectLocationYeongdeungpoTv.isChecked = !binding.compareOptionSelectLocationYeongdeungpoTv.isChecked
                }
                else{
                    binding.compareOptionSelectLocationYeongdeungpoTv.elevation = 11f
                    binding.compareOptionSelectLocationYeongdeungpoCheckcircleIv.setImageResource(R.drawable.checkcircle_checked)
                    binding.compareOptionSelectLocationYeongdeungpoTv.isChecked = !binding.compareOptionSelectLocationYeongdeungpoTv.isChecked
                }
            }
        }

    }
}