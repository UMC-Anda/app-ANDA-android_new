package com.anda.ui.main.management.after.alarm

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anda.data.entities.AlarmItem
import com.anda.databinding.ItemAlarmBinding

class AlarmRVAdapter(private val alarms: MutableList<AlarmItem>, private val alarmFragment: AlarmFragment) :
    RecyclerView.Adapter<AlarmRVAdapter.AlarmViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemAlarmBinding.inflate(inflater, parent, false)
        return AlarmViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AlarmViewHolder, position: Int) {
        holder.bind(alarms[position])
    }

    override fun getItemCount(): Int = alarms.size

    inner class AlarmViewHolder(private val binding: ItemAlarmBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(alarmItem: AlarmItem) {
            binding.alarmMessageEditText.setText(alarmItem.message)
            binding.alarmTimePicker.hour = alarmItem.hour
            binding.alarmTimePicker.minute = alarmItem.minute

            binding.deleteButton.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    alarms.removeAt(position)
                    notifyItemRemoved(position)
                }
            }
            binding.saveButton.setOnClickListener {
                val hour = binding.alarmTimePicker.hour
                val minute = binding.alarmTimePicker.minute
                alarmFragment.saveAlarmTime(hour, minute)
                //이 부분에 AlarmFragment로 설정한 hour와 minute 값을 전달하고 싶어
            }
        }
    }
}

