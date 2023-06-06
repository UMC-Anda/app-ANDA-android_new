package com.anda.ui.main.management.after.alarm

import android.app.AlarmManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TimePicker
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.recyclerview.widget.RecyclerView
import com.anda.MainActivity
import com.anda.data.entities.AlarmItem
import com.anda.databinding.ItemAlarmBinding
import java.text.DateFormat
import java.util.*

class AlarmRVAdapter(private val alarms: MutableList<AlarmItem>, private val alarmFragment: AlarmFragment) :
    RecyclerView.Adapter<AlarmRVAdapter.AlarmViewHolder>(){

    private val context: Context = alarmFragment.requireContext()


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
                Toast.makeText(context, "${hour}시 ${minute}분에 알람이 설정되었습니다.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

