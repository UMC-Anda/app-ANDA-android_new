package com.anda.ui.main.management.after

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.anda.data.entities.ChallengeItem
import com.anda.databinding.FragmentManagementChallengeBinding

class ManagementChallengeFragment : Fragment() {

    private lateinit var binding: FragmentManagementChallengeBinding
    private lateinit var challengeAdapter: ChallengeRVAdapter
    private val challenges: ArrayList<ChallengeItem> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentManagementChallengeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        challengeAdapter = ChallengeRVAdapter(challenges)
        binding.dateRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.dateRecyclerView.adapter = challengeAdapter

        binding.completeButton.setOnClickListener {
            // 도전과제 완료 버튼 클릭 시 동작 처리
        }
    }
}
