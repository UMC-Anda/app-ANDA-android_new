package com.anda.ui.write_review

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.FragmentWriteCommunityWritingBinding

class WriteCommunityWritingFragment : Fragment() {

    lateinit var binding: FragmentWriteCommunityWritingBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWriteCommunityWritingBinding.inflate(inflater, container, false)
        clickSetting()
        return binding.root
    }
    private fun clickSetting() {
        binding.writeCommunityWritingTermsViewAllIv.setOnClickListener {
            (context as MainActivity).supportFragmentManager.beginTransaction()
                .replace(R.id.nav_host_fragment_container, WriteCommunityWritingFragment())
                .commitAllowingStateLoss()
        }
    }
}