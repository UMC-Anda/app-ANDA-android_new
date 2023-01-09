package com.anda.ui.main.myInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.databinding.FragmentMyInfoMyOphthaBinding

class MyINfoMyOphthaFragment : Fragment() {

    lateinit var binding: FragmentMyInfoMyOphthaBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyInfoMyOphthaBinding.inflate(inflater, container, false)

        return binding.root
    }
}