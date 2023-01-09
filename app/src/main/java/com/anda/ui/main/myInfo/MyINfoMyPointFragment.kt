package com.anda.ui.main.myInfo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.databinding.FragmentMyInfoMyPointBinding

class MyINfoMyPointFragment : Fragment() {

    lateinit var binding: FragmentMyInfoMyPointBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMyInfoMyPointBinding.inflate(inflater, container, false)

        return binding.root
    }
}