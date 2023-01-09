package com.anda.ui.splash

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.ActivityMainBinding
import com.anda.databinding.ActivitySplashBinding
import com.anda.ui.login.LoginActivity


class SplashActivity: AppCompatActivity(), SplashView {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //자동 로그인 코드
        /*Handler(Looper.getMainLooper()).postDelayed({
            autoLogin()
        }, 2000)*/
        splashAnimSetting() //초기 설정
        splashAnim() //애니메이션
        Handler(Looper.getMainLooper()).postDelayed({
            startActivityWithClear(LoginActivity::class.java)
        }, 3000)
    }

    private fun splashAnimSetting() {
        val animationLogo:ValueAnimator = ObjectAnimator
            .ofFloat(binding.splashDefaultIv, View.ALPHA,0f)
        val amimationTxt: ValueAnimator = ObjectAnimator
            .ofFloat(binding.splashTextIv, "translationX", -1000f)
        amimationTxt.duration = 0
        animationLogo.duration = 0
        amimationTxt.start()
        animationLogo.start()
    }

    private fun splashAnim(){
        val amimationLogo:ValueAnimator = ObjectAnimator
            .ofFloat(binding.splashDefaultIv, View.ALPHA,0f, 1f)
        amimationLogo.duration = 1000
        amimationLogo.start()
        Handler(Looper.getMainLooper()).postDelayed({
             val amimationTxt:ValueAnimator = ObjectAnimator
                .ofFloat(binding.splashTextIv,"translationX", -1000f, 0f,-50f,0f)
            amimationTxt.duration = 1500
            amimationTxt.start()
        }, 1000)
    }
    private fun autoLogin() {
//        AuthService.autoLogin(this)
    }

    override fun onAutoLoginLoading() {

    }

    override fun onAutoLoginSuccess() {
        startActivityWithClear(MainActivity::class.java)
    }

    override fun onAutoLoginFailure(code: Int, message: String) {
        startActivityWithClear(LoginActivity::class.java)
    }
    private fun startActivityWithClear(activity: Class<*>?) {
        val intent = Intent(this, activity)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}