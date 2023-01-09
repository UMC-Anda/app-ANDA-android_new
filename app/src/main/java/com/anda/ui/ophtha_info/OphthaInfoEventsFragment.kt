package com.anda.ui.ophtha_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.anda.MainActivity
import com.anda.R
import com.anda.data.entities.ExOphthaInfoEvent
import com.anda.databinding.FragmentOphthaInfoEventsBinding

class OphthaInfoEventsFragment (val ophthaInfoEventsDatas:ArrayList<ExOphthaInfoEvent>?) : Fragment() {


    lateinit var binding: FragmentOphthaInfoEventsBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOphthaInfoEventsBinding.inflate(inflater, container, false)




        val ophthaInfoEventsRVAdapter = OphthaInfoEventsRVAdapter(ophthaInfoEventsDatas!!)
        binding.ophthaInfoEventRv.adapter = ophthaInfoEventsRVAdapter
        binding.ophthaInfoEventRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        ophthaInfoEventsRVAdapter.setOphthaInfoEventsItemClickListener(object :OphthaInfoEventsRVAdapter.ophthaInfoEventsItemClickListener{
            override fun onItemClick() {
                (activity as MainActivity).supportFragmentManager.beginTransaction()
                    .replace(R.id.nav_host_fragment_container, OphthaInfoDetailEventFragment())
                    .commitAllowingStateLoss()
            }
        })

        return binding.root
    }
    override fun onResume() {
        super.onResume()
        binding.root.requestLayout()
    }
}
