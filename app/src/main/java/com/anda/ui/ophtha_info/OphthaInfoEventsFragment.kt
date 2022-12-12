package com.anda.ui.ophtha_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.anda.data.entities.OphthaInfoEvent
import com.anda.databinding.FragmentOphthaInfoEventsBinding

class OphthaInfoEventsFragment () : Fragment() {

    lateinit var binding: FragmentOphthaInfoEventsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOphthaInfoEventsBinding.inflate(inflater, container, false)


        val ophthaINfoEventsRVAdapter = OphthaInfoEventsRVAdapter()
        binding.ophthaInfoEventRv.adapter = ophthaINfoEventsRVAdapter
        binding.ophthaInfoEventRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        return binding.root
    }
}