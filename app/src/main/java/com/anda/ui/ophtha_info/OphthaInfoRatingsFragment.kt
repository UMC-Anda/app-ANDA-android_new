package com.anda.ui.ophtha_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.databinding.FragmentOphthaInfoRatingsBinding

class OphthaInfoRatingsFragment : Fragment() {

    lateinit var binding: FragmentOphthaInfoRatingsBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOphthaInfoRatingsBinding.inflate(inflater, container, false)

        setInfos()

        return binding.root
    }

    private fun setInfos() {

    }

    override fun onResume() {
        super.onResume()
        binding.root.requestLayout()
    }
}