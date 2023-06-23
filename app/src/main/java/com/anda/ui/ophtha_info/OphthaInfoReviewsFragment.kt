package com.anda.ui.ophtha_info

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.anda.MainActivity
import com.anda.R
import com.anda.data.entities.ExOphthaInfoReview
import com.anda.databinding.FragmentOphthaInfoReviewsBinding

class OphthaInfoReviewsFragment (val ophthaInfoReviewsDatas:ArrayList<ExOphthaInfoReview>?) : Fragment() {


    lateinit var binding: FragmentOphthaInfoReviewsBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOphthaInfoReviewsBinding.inflate(inflater, container, false)

        val ophthaInfoReviewsRVAdapter = OphthaInfoReviewsRVAdapter(ophthaInfoReviewsDatas!!)
        binding.ophthaInfoReviwesRv.adapter = ophthaInfoReviewsRVAdapter
        binding.ophthaInfoReviwesRv.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        ophthaInfoReviewsRVAdapter.setOphthaInfoReviewsItemClickListener(object :OphthaInfoReviewsRVAdapter.ophthaInfoReviewsItemClickListener{
            override fun onItemClick(ophthaReview : ExOphthaInfoReview) {
                (activity as MainActivity).changeFragment(OphthaInfoDetailReviewFragment(ophthaReview))
            } })

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        binding.root.requestLayout()
    }
}

