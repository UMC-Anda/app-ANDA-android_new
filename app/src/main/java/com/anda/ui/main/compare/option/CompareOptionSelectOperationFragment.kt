package com.anda.ui.main.compare.option

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.anda.MainActivity
import com.anda.R
import com.anda.data.entities.CompareSortSelect
import com.anda.data.entities.CompareSortSelectedOption
import com.anda.databinding.FragmentCompareOptionSelectOperationBinding
import com.anda.ui.main.compare.CompareFragment
import com.anda.ui.main.compare.CompareSortSelectedOperationRVAdapter

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
                    (activity as MainActivity).compareSortSelectedOption.selectedOperation = null
                }
                else{
                    binding.compareOptionSelectOperationLasikIv.setImageResource(R.drawable.home_ranking_selected_lasik_img)
                    binding.compareOptionSelectOperationLasekIv.setImageResource(R.drawable.home_ranking_unselected_lasek_img)
                    binding.compareOptionSelectOperationSmileIv.setImageResource(R.drawable.home_ranking_unselected_smile_img)
                    binding.compareOptionSelectOperationLensIv.setImageResource(R.drawable.home_ranking_unselected_lens_img)
                    binding.compareOptionSelectOperationBackIv.setImageResource(R.drawable.home_ranking_unselected_back_img)
                    binding.compareOptionSelectOperationNormalIv.setImageResource(R.drawable.home_ranking_unselected_normal_img)
                    (activity as MainActivity).compareSortSelectedOption.selectedOperation = "라식"
                    isLasikSelected = !isLasikSelected
                    isLasekSelected = false
                    isSmileSelected = false
                    isLensSelected = false
                    isBackSelected = false
                    isNormalSelected = false
                }
            }
            //라섹
            binding.compareOptionSelectOperationLasekIv ->{
                if(isLasekSelected){
                    binding.compareOptionSelectOperationLasekIv.setImageResource(R.drawable.home_ranking_unselected_lasek_img)
                    isLasekSelected = !isLasekSelected
                    (activity as MainActivity).compareSortSelectedOption.selectedOperation = null
                }
                else{
                    binding.compareOptionSelectOperationLasikIv.setImageResource(R.drawable.home_ranking_unselected_lasik_img)
                    binding.compareOptionSelectOperationLasekIv.setImageResource(R.drawable.home_ranking_selected_lasek_img)
                    binding.compareOptionSelectOperationSmileIv.setImageResource(R.drawable.home_ranking_unselected_smile_img)
                    binding.compareOptionSelectOperationLensIv.setImageResource(R.drawable.home_ranking_unselected_lens_img)
                    binding.compareOptionSelectOperationBackIv.setImageResource(R.drawable.home_ranking_unselected_back_img)
                    binding.compareOptionSelectOperationNormalIv.setImageResource(R.drawable.home_ranking_unselected_normal_img)
                    (activity as MainActivity).compareSortSelectedOption.selectedOperation = "라섹"
                    isLasekSelected = !isLasekSelected
                    isLasikSelected = false
                    isSmileSelected = false
                    isLensSelected = false
                    isBackSelected = false
                    isNormalSelected = false
                }
            }
            //스마일라식
            binding.compareOptionSelectOperationSmileIv ->{
                if(isSmileSelected){
                    binding.compareOptionSelectOperationSmileIv.setImageResource(R.drawable.home_ranking_unselected_smile_img)
                    isSmileSelected = !isSmileSelected
                    (activity as MainActivity).compareSortSelectedOption.selectedOperation = null
                }
                else{
                    binding.compareOptionSelectOperationLasekIv.setImageResource(R.drawable.home_ranking_unselected_lasek_img)
                    binding.compareOptionSelectOperationLasikIv.setImageResource(R.drawable.home_ranking_unselected_lasik_img)
                    binding.compareOptionSelectOperationSmileIv.setImageResource(R.drawable.home_ranking_selected_smile_img)
                    binding.compareOptionSelectOperationLensIv.setImageResource(R.drawable.home_ranking_unselected_lens_img)
                    binding.compareOptionSelectOperationBackIv.setImageResource(R.drawable.home_ranking_unselected_back_img)
                    binding.compareOptionSelectOperationNormalIv.setImageResource(R.drawable.home_ranking_unselected_normal_img)
                    (activity as MainActivity).compareSortSelectedOption.selectedOperation = "스마일라식"
                    isSmileSelected = !isSmileSelected
                    isLasikSelected = false
                    isLasekSelected = false
                    isLensSelected = false
                    isBackSelected = false
                    isNormalSelected = false
                }
            }
            //렌즈삽입술
            binding.compareOptionSelectOperationLensIv ->{
                if(isLensSelected){
                    binding.compareOptionSelectOperationLensIv.setImageResource(R.drawable.home_ranking_unselected_lens_img)
                    isLensSelected = !isLensSelected
                    (activity as MainActivity).compareSortSelectedOption.selectedOperation = null
                }
                else{
                    binding.compareOptionSelectOperationLasikIv.setImageResource(R.drawable.home_ranking_unselected_lasik_img)
                    binding.compareOptionSelectOperationLasekIv.setImageResource(R.drawable.home_ranking_unselected_lasek_img)
                    binding.compareOptionSelectOperationSmileIv.setImageResource(R.drawable.home_ranking_unselected_smile_img)
                    binding.compareOptionSelectOperationLensIv.setImageResource(R.drawable.home_ranking_selected_lens_img)
                    binding.compareOptionSelectOperationBackIv.setImageResource(R.drawable.home_ranking_unselected_back_img)
                    binding.compareOptionSelectOperationNormalIv.setImageResource(R.drawable.home_ranking_unselected_normal_img)
                    (activity as MainActivity).compareSortSelectedOption.selectedOperation = "렌즈삽입술"
                    isLensSelected = !isLensSelected
                    isLasikSelected = false
                    isLasekSelected = false
                    isSmileSelected = false
                    isBackSelected = false
                    isNormalSelected = false
                }
            }
            //백내장
            binding.compareOptionSelectOperationBackIv ->{
                if(isBackSelected){
                    binding.compareOptionSelectOperationBackIv.setImageResource(R.drawable.home_ranking_unselected_back_img)
                    isBackSelected = !isBackSelected
                    (activity as MainActivity).compareSortSelectedOption.selectedOperation = null
                }
                else{
                    binding.compareOptionSelectOperationLasikIv.setImageResource(R.drawable.home_ranking_unselected_lasik_img)
                    binding.compareOptionSelectOperationLasekIv.setImageResource(R.drawable.home_ranking_unselected_lasek_img)
                    binding.compareOptionSelectOperationSmileIv.setImageResource(R.drawable.home_ranking_unselected_smile_img)
                    binding.compareOptionSelectOperationLensIv.setImageResource(R.drawable.home_ranking_unselected_lens_img)
                    binding.compareOptionSelectOperationBackIv.setImageResource(R.drawable.home_ranking_selected_back_img)
                    binding.compareOptionSelectOperationNormalIv.setImageResource(R.drawable.home_ranking_unselected_normal_img)
                    (activity as MainActivity).compareSortSelectedOption.selectedOperation = "백내장"
                    isBackSelected = !isBackSelected
                    isLasikSelected = false
                    isLasekSelected = false
                    isSmileSelected = false
                    isLensSelected = false
                    isNormalSelected = false
                }
            }
            //일반진료
            binding.compareOptionSelectOperationNormalIv ->{
                if(isNormalSelected){
                    binding.compareOptionSelectOperationNormalIv.setImageResource(R.drawable.home_ranking_unselected_normal_img)
                    isNormalSelected = !isNormalSelected
                    (activity as MainActivity).compareSortSelectedOption.selectedOperation = null
                }
                else{
                    binding.compareOptionSelectOperationLasikIv.setImageResource(R.drawable.home_ranking_unselected_lasik_img)
                    binding.compareOptionSelectOperationLasekIv.setImageResource(R.drawable.home_ranking_unselected_lasek_img)
                    binding.compareOptionSelectOperationSmileIv.setImageResource(R.drawable.home_ranking_unselected_smile_img)
                    binding.compareOptionSelectOperationLensIv.setImageResource(R.drawable.home_ranking_unselected_lens_img)
                    binding.compareOptionSelectOperationBackIv.setImageResource(R.drawable.home_ranking_unselected_back_img)
                    binding.compareOptionSelectOperationNormalIv.setImageResource(R.drawable.home_ranking_selected_normal_img)
                    (activity as MainActivity).compareSortSelectedOption.selectedOperation = "일반진료"
                    isNormalSelected = !isNormalSelected
                    isLasikSelected = false
                    isLasekSelected = false
                    isSmileSelected = false
                    isLensSelected = false
                    isBackSelected = false
                }
            }
        }
    }
}