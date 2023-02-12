package com.anda.ui.main.community.askDoctor

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentCommunityAskDoctorBinding
import com.anda.ui.main.community.CommunityWritingListFragment

class CommunityAskDoctorFragment : Fragment() ,OnClickListener{
    var theme:String = "의사질문"

    lateinit var binding: FragmentCommunityAskDoctorBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityAskDoctorBinding.inflate(inflater, container, false)

        binding.communityAskDoctorMyWritingImgIv.setOnClickListener(this)
        binding.communityAskDoctorMyLikeImgIv.setOnClickListener(this)
        binding.communityAskDoctorMyScrapImgIv.setOnClickListener(this)
        binding.communityAskDoctorSideEffectTxt.setOnClickListener(this)
        binding.communityAskDoctorLasikTxt.setOnClickListener(this)
        binding.communityAskDoctorLasekTxt.setOnClickListener(this)
        binding.communityAskDoctorSmileTxt.setOnClickListener(this)
        binding.communityAskDoctorLensTxt.setOnClickListener(this)
        binding.communityAskDoctorBackTxt.setOnClickListener(this)
        binding.communityAskDoctorNormalTxt.setOnClickListener(this)

        return binding.root
    }
    override fun onClick(v: View?) {
        if(v == null) return
        when(v){
            binding.communityAskDoctorMyWritingImgIv ->{
                var subject:String? = "질문"
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, CommunityWritingListFragment(theme, subject))
                    .commitAllowingStateLoss()
            }
            binding.communityAskDoctorMyLikeImgIv ->{
                var subject:String? = "좋아요"
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, CommunityWritingListFragment(theme, subject))
                    .commitAllowingStateLoss()
            }
            binding.communityAskDoctorMyScrapImgIv ->{
                var subject:String? = "스크랩"
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, CommunityWritingListFragment(theme, subject))
                    .commitAllowingStateLoss()
            }
            binding.communityAskDoctorSideEffectTxt ->{
                var subject:String? = "부작용 관리"
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, CommunityWritingListFragment(theme, subject))
                    .commitAllowingStateLoss()
            }
            binding.communityAskDoctorLasikTxt ->{
                var subject:String? = "라식"
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, CommunityWritingListFragment(theme, subject))
                    .commitAllowingStateLoss()
            }
            binding.communityAskDoctorLasekTxt ->{
                var subject:String? = "라섹"
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, CommunityWritingListFragment(theme, subject))
                    .commitAllowingStateLoss()
            }
            binding.communityAskDoctorSmileTxt ->{
                var subject:String? = "스마일 라식"
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, CommunityWritingListFragment(theme, subject))
                    .commitAllowingStateLoss()
            }
            binding.communityAskDoctorLensTxt->{
                var subject:String? = "렌즈 삽입술"
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, CommunityWritingListFragment(theme, subject))
                    .commitAllowingStateLoss()
            }
            binding.communityAskDoctorBackTxt->{
                var subject:String? = "백내장"
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, CommunityWritingListFragment(theme, subject))
                    .commitAllowingStateLoss()
            }
            binding.communityAskDoctorNormalTxt->{
                var subject:String? = "일반 진료"
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, CommunityWritingListFragment(theme, subject))
                    .commitAllowingStateLoss()
            }
        }
    }
}