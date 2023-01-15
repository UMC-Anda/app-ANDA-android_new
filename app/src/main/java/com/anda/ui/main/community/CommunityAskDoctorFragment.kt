package com.anda.ui.main.community

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.databinding.FragmentCommunityAskDoctorBinding
import com.anda.databinding.FragmentCommunityBinding
import com.anda.databinding.FragmentCommunityCommunityBinding

class CommunityAskDoctorFragment : Fragment() {

    lateinit var binding: FragmentCommunityAskDoctorBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCommunityAskDoctorBinding.inflate(inflater, container, false)



        return binding.root
    }
}