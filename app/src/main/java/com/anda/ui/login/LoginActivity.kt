package com.anda.ui.login

import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.text.Editable
import android.text.InputType
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.ActivityLoginBinding
import com.anda.ui.login.model.LoginRequestBody
import com.anda.ui.login.model.LoginResponse
import com.anda.ui.signup.normal.NormalSignupActivity

class LoginActivity : AppCompatActivity(), LoginView, View.OnClickListener {

    private lateinit var binding: ActivityLoginBinding
    private var isEmptyId : Boolean = true
    private var isEmptyPw : Boolean = true
    private var isPwVisible : Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //클릭 설정
        binding.loginSignUpTv.setOnClickListener(this)
        binding.loginSignInBtnIv.setOnClickListener(this)
        binding.loginSignInBtnTv.setOnClickListener(this)
        binding.loginFindIdTv.setOnClickListener(this)
        binding.loginShowPwIconIv.setOnClickListener(this)
        binding.loginSignInBtnIv.clipToOutline = true
        detectEt()
    }
    private fun detectEt() {
        binding.loginIdEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var idMessage: String = binding.loginIdEt.text.toString()
                isEmptyId = idMessage.isEmpty()
                if (!isEmptyId && !isEmptyPw) {
                    binding.loginSignInBtnIv.setImageResource(R.color.Main)
                    binding.loginSignInBtnTv.setTextColor(resources.getColor(R.color.white))
                    binding.loginSignInBtnTv.setTypeface(null, Typeface.BOLD)
                } else {
                    binding.loginSignInBtnIv.setImageResource(R.color.gray)
                    binding.loginSignInBtnTv.setTextColor(resources.getColor(R.color.black))
                    binding.loginSignInBtnTv.setTypeface(null, Typeface.NORMAL)
                }
            }

            override fun afterTextChanged(p0: Editable?) {}
        })
        binding.loginPasswordEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var idMessage: String = binding.loginPasswordEt.text.toString()
                isEmptyPw = idMessage.isEmpty()
                if (!isEmptyId && !isEmptyPw) {
                    binding.loginSignInBtnIv.setImageResource(R.color.Main)
                    binding.loginSignInBtnTv.setTextColor(resources.getColor(R.color.white))
                    binding.loginSignInBtnTv.setTypeface(null, Typeface.BOLD)
                } else {
                    binding.loginSignInBtnIv.setImageResource(R.color.gray)
                    binding.loginSignInBtnTv.setTextColor(resources.getColor(R.color.black))
                    binding.loginSignInBtnTv.setTypeface(null, Typeface.NORMAL)
                }
            }

            override fun afterTextChanged(p0: Editable?) {}
        })
    }

    override fun onLoginLoading() {
        binding.loginLoadingPb.visibility = View.VISIBLE
    }

    override fun onLoginSuccess(response: LoginResponse) {
        binding.loginLoadingPb.visibility = View.GONE

//        saveJwt(response.result!!.aceessJWT)
//        saveJwt(response.result!!.refreshJWT)
        Log.d("로그인", "성공!")
        startActivityWithClear(MainActivity::class.java)
    }
    override fun onLoginFailure(code: Int, message: String) {
        Log.d("로그인", "실패!")
        binding.loginLoadingPb.visibility = View.GONE
        binding.loginErrorTv.visibility = View.VISIBLE
        binding.loginErrorTv.text = message
    }

    override fun onClick(v: View?) {
        if (v == null) return

        when (v) {
            binding.loginSignUpTv -> startActivityWithClear(NormalSignupActivity::class.java)
//            binding.loginFindIdTv -> startActivityWithClear(FindIdActivity::class.java)
            binding.loginSignInBtnIv -> login()
            binding.loginSignInBtnTv -> login()
            binding.loginShowPwIconIv -> {
                if(isPwVisible){
                    binding.loginPasswordEt.inputType = 129//textPassword 번호
                    isPwVisible = !isPwVisible
                    Log.d("비밀번호보이기", "숨기기")
                }
                else{
                    binding.loginPasswordEt.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                    isPwVisible = !isPwVisible
                    Log.d("비밀번호보이기", "보이기")
                }
            }
        }
    }

    private fun login() {
        if (binding.loginIdEt.text.toString().isEmpty()) {
            Toast.makeText(this, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }

        if (binding.loginPasswordEt.text.toString().isEmpty()) {
            Toast.makeText(this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            return
        }

        val email = binding.loginIdEt.text.toString()
        val password = binding.loginPasswordEt.text.toString()
        val userinfo = LoginRequestBody(email, password)

        val service = LoginService(this, userinfo)
        service.tryLogin()
    }
    private fun startActivityWithClear(activity: Class<*>?) {
        val intent = Intent(this, activity)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}