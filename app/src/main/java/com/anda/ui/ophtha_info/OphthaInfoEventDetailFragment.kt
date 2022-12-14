package com.anda.ui.ophtha_info

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.anda.databinding.FragmentOphthaInfoEventDetailBinding

class OphthaInfoEventDetailFragment() : Fragment() {

    lateinit var binding: FragmentOphthaInfoEventDetailBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOphthaInfoEventDetailBinding.inflate(inflater, container, false)

        clickSetting()




        return binding.root
    }

    private fun clickSetting() {
        binding.ophthaInfoEventDetailGoOphthaSiteBtn.setOnClickListener {
            var intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://team-anda.notion.site/ANDA-515af6f53a6d44a4b999ef04f139965b")
            )
            startActivity(intent)
        }
    }

}