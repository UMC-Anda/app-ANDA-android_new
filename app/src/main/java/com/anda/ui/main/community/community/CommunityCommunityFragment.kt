package com.anda.ui.main.community.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentCommunityCommunityBinding
import com.anda.ui.main.community.CommunityWritingListFragment

class CommunityCommunityFragment : Fragment(), OnClickListener {

    lateinit var binding: FragmentCommunityCommunityBinding
    var theme:String = "커뮤니티"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityCommunityBinding.inflate(inflater, container, false)

        binding.communityCommunityMyWritingImgIv.setOnClickListener(this)
        binding.communityCommunityMyLikeImgIv.setOnClickListener(this)
        binding.communityCommunityMyScrapImgIv.setOnClickListener(this)
        binding.communitySideEffectTxt.setOnClickListener(this)
        binding.communityLasikTxt.setOnClickListener(this)
        binding.communityLasekTxt.setOnClickListener(this)
        binding.communitySmileTxt.setOnClickListener(this)
        binding.communityLensTxt.setOnClickListener(this)
        binding.communityBackTxt.setOnClickListener(this)
        binding.communityNormalTxt.setOnClickListener(this)


        return binding.root
    }

    override fun onClick(v: View?) {
        if(v == null) return
        when(v){
            binding.communityCommunityMyWritingImgIv ->{
                var subject:String? = "질문"
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, CommunityWritingListFragment(theme, subject))
                    .commitAllowingStateLoss()
            }
            binding.communityCommunityMyLikeImgIv ->{
                var subject:String? = "좋아요"
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, CommunityWritingListFragment(theme, subject))
                    .commitAllowingStateLoss()
            }
            binding.communityCommunityMyScrapImgIv ->{
                var subject:String? = "스크랩"
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, CommunityWritingListFragment(theme, subject))
                    .commitAllowingStateLoss()
            }
            binding.communitySideEffectTxt ->{
                var subject:String? = "부작용 관리"
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, CommunityWritingListFragment(theme, subject))
                    .commitAllowingStateLoss()
            }
            binding.communityLasikTxt ->{
                var subject:String? = "라식"
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, CommunityWritingListFragment(theme, subject))
                    .commitAllowingStateLoss()
            }
            binding.communityLasekTxt ->{
                var subject:String? = "라섹"
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, CommunityWritingListFragment(theme, subject))
                    .commitAllowingStateLoss()
            }
            binding.communitySmileTxt ->{
                var subject:String? = "스마일 라식"
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, CommunityWritingListFragment(theme, subject))
                    .commitAllowingStateLoss()
            }
            binding.communityLensTxt->{
                var subject:String? = "렌즈 삽입술"
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, CommunityWritingListFragment(theme, subject))
                    .commitAllowingStateLoss()
            }
            binding.communityBackTxt->{
                var subject:String? = "백내장"
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, CommunityWritingListFragment(theme, subject))
                    .commitAllowingStateLoss()
            }
            binding.communityNormalTxt->{
                var subject:String? = "일반 진료"
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, CommunityWritingListFragment(theme, subject))
                    .commitAllowingStateLoss()
            }
        }
    }
}