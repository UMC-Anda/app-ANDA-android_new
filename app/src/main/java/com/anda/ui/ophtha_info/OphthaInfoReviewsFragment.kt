package com.anda.ui.ophtha_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.databinding.FragmentOphthaInfoReviewsBinding

class OphthaInfoReviewsFragment : Fragment() {

    lateinit var binding: FragmentOphthaInfoReviewsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOphthaInfoReviewsBinding.inflate(inflater, container, false)

        return binding.root
    }
}