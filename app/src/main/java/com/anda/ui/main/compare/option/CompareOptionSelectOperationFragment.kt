package com.anda.ui.main.compare.option

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.R
import com.anda.databinding.FragmentCompareOptionSelectOperationBinding

class CompareOptionSelectOperationFragment() : Fragment(), View.OnClickListener{

    //바인딩
    lateinit var binding : FragmentCompareOptionSelectOperationBinding

    private var isLasikSelected = true
    private var isLasekSelected = false
    private var isSmileSelected = false
    private var isLensSelected = false
    private var isBackSelected = false
    private var isNormalSelected = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCompareOptionSelectOperationBinding.inflate(inflater, container, false)

        binding.compareOptionSelectOperationLasikIv.setOnClickListener(this)
        binding.compareOptionSelectOperationLasekIv.setOnClickListener(this)
        binding.compareOptionSelectOperationSmileIv.setOnClickListener(this)
        binding.compareOptionSelectOperationLensIv.setOnClickListener(this)
        binding.compareOptionSelectOperationBackIv.setOnClickListener(this)
        binding.compareOptionSelectOperationNormalIv.setOnClickListener(this)

        return binding.root
    }

    override fun onClick(v: View?) {
        if (v == null) return
        when(v){
            //라식
            binding.compareOptionSelectOperationLasikIv ->{
                if(isLasikSelected){
                    binding.compareOptionSelectOperationLasikIv.setImageResource(R.drawable.home_ranking_unselected_lasik_img)
                    isLasikSelected = !isLasikSelected
                }
                else{
                    binding.compareOptionSelectOperationLasikIv.setImageResource(R.drawable.home_ranking_selected_lasik_img)
                    isLasikSelected = !isLasikSelected
                }
            }
            //라섹
            binding.compareOptionSelectOperationLasekIv ->{
                if(isLasekSelected){
                    binding.compareOptionSelectOperationLasekIv.setImageResource(R.drawable.home_ranking_unselected_lasek_img)
                    isLasekSelected = !isLasekSelected
                }
                else{
                    binding.compareOptionSelectOperationLasekIv.setImageResource(R.drawable.home_ranking_selected_lasek_img)
                    isLasekSelected = !isLasekSelected
                }
            }
            //스마일라식
            binding.compareOptionSelectOperationSmileIv ->{
                if(isSmileSelected){
                    binding.compareOptionSelectOperationSmileIv.setImageResource(R.drawable.home_ranking_unselected_smile_img)
                    isSmileSelected = !isSmileSelected
                }
                else{
                    binding.compareOptionSelectOperationSmileIv.setImageResource(R.drawable.home_ranking_selected_smile_img)
                    isSmileSelected = !isSmileSelected
                }
            }
            //렌즈삽입술
            binding.compareOptionSelectOperationLensIv ->{
                if(isLensSelected){
                    binding.compareOptionSelectOperationLensIv.setImageResource(R.drawable.home_ranking_unselected_lens_img)
                    isLensSelected = !isLensSelected
                }
                else{
                    binding.compareOptionSelectOperationLensIv.setImageResource(R.drawable.home_ranking_selected_lens_img)
                    isLensSelected = !isLensSelected
                }
            }
            //백내장
            binding.compareOptionSelectOperationBackIv ->{
                if(isBackSelected){
                    binding.compareOptionSelectOperationBackIv.setImageResource(R.drawable.home_ranking_unselected_back_img)
                    isBackSelected = !isBackSelected
                }
                else{
                    binding.compareOptionSelectOperationBackIv.setImageResource(R.drawable.home_ranking_selected_back_img)
                    isBackSelected = !isBackSelected
                }
            }
            //일반진료
            binding.compareOptionSelectOperationNormalIv ->{
                if(isNormalSelected){
                    binding.compareOptionSelectOperationNormalIv.setImageResource(R.drawable.home_ranking_unselected_normal_img)
                    isNormalSelected = !isNormalSelected
                }
                else{
                    binding.compareOptionSelectOperationNormalIv.setImageResource(R.drawable.home_ranking_selected_normal_img)
                    isNormalSelected = !isNormalSelected
                }
            }

        }
    }
}