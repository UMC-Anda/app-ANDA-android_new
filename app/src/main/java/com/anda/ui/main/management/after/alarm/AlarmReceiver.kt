package com.anda.ui.main.management.after.alarm


import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        // 알람 이벤트를 처리하는 로직을 구현하세요
        Log.d("알람 수행","수행중~")
    }
}
