package com.anda.ui.main.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.anda.R
import com.anda.databinding.FragmentCommunityBinding
import com.anda.ui.main.home.ranking.HomeAndaRankingBannerFragment
import com.anda.ui.main.home.ranking.HomeAndaRankingBannerVPAdapter

class CommunityFragment : Fragment(), OnClickListener {
    private val MIN_SCALE = 0.5f // 뷰가 몇퍼센트로 줄어들 것인지
    private val MIN_ALPHA = 0.5f // 어두워지는 정도를 나타낸 듯 하다.
    lateinit var binding: FragmentCommunityBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityBinding.inflate(inflater, container, false)

        binding.communityCommunityNameBarIv.clipToOutline = true
        binding.communityQnaNameBarIv.clipToOutline = true
        binding.communityEyeMbtiNameBarIv.clipToOutline = true

        binding.communityCommunityNameBarIv.setOnClickListener(this)
        binding.communityQnaNameBarIv.setOnClickListener(this)
        binding.communityEyeMbtiNameBarIv.setOnClickListener(this)

        val communityVPAdapter = CommunityVPAdapter(this)
        communityVPAdapter.addFragment(CommunityCommunityFragment())
        communityVPAdapter.addFragment(CommunityAskDoctorFragment())
        binding.communityContentVp.adapter = communityVPAdapter
        binding.communityContentVp.orientation = ViewPager2.ORIENTATION_HORIZONTAL
//        binding.communityContentVp.setPageTransformer(ZoomOutPageTransformer())

        return binding.root
    }

    override fun onClick(v: View?) {
        if(v == null) return
        when(v){
            binding.communityCommunityNameBarIv ->{
                binding.communityContentVp.setCurrentItem(0,true)
                binding.communityCommunityNameBarIv.setImageResource(R.color.white)
                binding.communityQnaNameBarIv.setImageResource(R.color.background)
                binding.communityEyeMbtiNameBarIv.setImageResource(R.color.background)
                binding.communityCommunityNameBarTv.setTextColor((resources.getColor(R.color.Main)))
                binding.communityQnaNameBarTv.setTextColor((resources.getColor(R.color.MAIN_50)))
                binding.communityEyeMbtiNameBarTv.setTextColor((resources.getColor(R.color.MAIN_50)))
            }
            binding.communityQnaNameBarIv ->{
                binding.communityContentVp.setCurrentItem(1,true)
                binding.communityCommunityNameBarIv.setImageResource(R.color.background)
                binding.communityQnaNameBarIv.setImageResource(R.color.white)
                binding.communityEyeMbtiNameBarIv.setImageResource(R.color.background)
                binding.communityCommunityNameBarTv.setTextColor((resources.getColor(R.color.MAIN_50)))
                binding.communityQnaNameBarTv.setTextColor((resources.getColor(R.color.Main)))
                binding.communityEyeMbtiNameBarTv.setTextColor((resources.getColor(R.color.MAIN_50)))
            }
            binding.communityEyeMbtiNameBarIv ->{
                binding.communityContentVp.setCurrentItem(2,true)
                binding.communityCommunityNameBarIv.setImageResource(R.color.background)
                binding.communityQnaNameBarIv.setImageResource(R.color.background)
                binding.communityEyeMbtiNameBarIv.setImageResource(R.color.white)
                binding.communityCommunityNameBarTv.setTextColor((resources.getColor(R.color.MAIN_50)))
                binding.communityQnaNameBarTv.setTextColor((resources.getColor(R.color.MAIN_50)))
                binding.communityEyeMbtiNameBarTv.setTextColor((resources.getColor(R.color.Main)))
            }
        }
    }
    inner class ZoomOutPageTransformer : ViewPager2.PageTransformer {
        override fun transformPage(view: View, position: Float) {
            view.apply {
                val pageWidth = width
                val pageHeight = height
                when {
                    position < -1 -> { // [-Infinity,-1)
                        // This page is way off-screen to the left.
                        alpha = 0f
                    }
                    position <= 1 -> { // [-1,1]
                        // Modify the default slide transition to shrink the page as well
                        val scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position))
                        val vertMargin = pageHeight * (1 - scaleFactor) / 2
                        val horzMargin = pageWidth * (1 - scaleFactor) / 2
                        translationX = if (position < 0) {
                            horzMargin - vertMargin / 2
                        } else {
                            horzMargin + vertMargin / 2
                        }

                        // Scale the page down (between MIN_SCALE and 1)
                        scaleX = scaleFactor
                        scaleY = scaleFactor

                        // Fade the page relative to its size.
                        alpha = (MIN_ALPHA +
                                (((scaleFactor - MIN_SCALE) / (1 - MIN_SCALE)) * (1 - MIN_ALPHA)))
                    }
                    else -> { // (1,+Infinity]
                        // This page is way off-screen to the right.
                        alpha = 0f
                    }
                }
            }
        }
    }
}