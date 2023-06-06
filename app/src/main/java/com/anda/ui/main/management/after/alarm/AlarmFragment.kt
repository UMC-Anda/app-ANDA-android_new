package com.anda.ui.main.management.after.alarm

import android.app.Dialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.text.format.DateFormat.is24HourFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.anda.data.entities.AlarmItem
import com.anda.databinding.FragmentAlarmBinding
import java.text.DateFormat
import java.util.*
import kotlin.collections.ArrayList

class AlarmFragment : Fragment() {

    private lateinit var binding: FragmentAlarmBinding
    private lateinit var alarmAdapter: AlarmRVAdapter
    private val alarms: ArrayList<AlarmItem> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAlarmBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        alarmAdapter = AlarmRVAdapter(alarms, this)
        binding.alarmRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.alarmRecyclerView.adapter = alarmAdapter

        updateAddButtonVisibility()

        binding.addButton.setOnClickListener {
            if (alarms.size < 3) {
                alarms.add(AlarmItem("", 0, 0))
                alarmAdapter.notifyItemInserted(alarms.size - 1)
                updateAddButtonVisibility()
            }
        }
    }

    private fun updateAddButtonVisibility() {
        if (alarms.size >= 3) {
            binding.addButton.isEnabled = false
            binding.addButton.alpha = 0.5f // 버튼의 투명도 조절하여 비활성화 효과
        } else {
            binding.addButton.isEnabled = true
            binding.addButton.alpha = 1f // 버튼의 투명도를 원래대로 복원
        }
    }
}
