package com.anda.ui.signup.normal

import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.content.Intent
import android.graphics.Typeface
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.anda.MainActivity
import com.anda.R
import com.anda.databinding.ActivityNormalSignupBinding
import com.anda.ui.login.LoginActivity
import com.anda.ui.signup.doctor.DoctorSignupActivity
import com.anda.ui.signup.normal.checkEmail.SignupNormalCheckEmailService
import com.anda.ui.signup.normal.checkEmail.SignupNormalCheckEmailView
import com.anda.ui.signup.normal.checkEmail.model.SignupNormalCheckEmailResponse
import com.anda.ui.signup.normal.checkNickname.SignupNormalCheckNicknameService
import com.anda.ui.signup.normal.checkNickname.SignupNormalCheckNicknameView
import com.anda.ui.signup.normal.checkNickname.model.SignupNormalCheckNicknameResponse
import com.anda.ui.signup.normal.signUp.SignUpService
import com.anda.ui.signup.normal.signUp.SignUpView
import com.anda.ui.signup.normal.signUp.model.SignUpRequestBody
import com.anda.ui.signup.normal.signUp.model.SignUpResponse

class NormalSignupActivity : AppCompatActivity(), SignupNormalCheckEmailView, SignupNormalCheckNicknameView, SignUpView, View.OnClickListener {

    private lateinit var binding: ActivityNormalSignupBinding
    private var isnicknameBtnPossible :Boolean = false
    private var isNicknamePossible : Boolean = false
    private var isEmptyEmailFirst : Boolean = true
    private var isEmptyEmailLast : Boolean = true
    private var isEmptyPw : Boolean = true
    private var isEmptyPwCheck : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNormalSignupBinding.inflate(layoutInflater)
        binding.signUpNickNameCheckButtonIv.clipToOutline = true

        binding.signupUpGoOphthaSignUpTv.setOnClickListener(this)
        binding.signUpSelectEmailBtnIv.setOnClickListener(this)
        binding.signUpSelectEmailEtcBackgroundIv.setOnClickListener(this)
        binding.signUpSelectEmailGoogleBackgroundIv.setOnClickListener(this)
        binding.signUpSelectEmailNaverBackgroundIv.setOnClickListener(this)
        binding.signUpSelectEmailNateBackgroundIv.setOnClickListener(this)
        binding.signUpSelectEmailDaumBackgroundIv.setOnClickListener(this)
        binding.signUpNickNameCheckButtonIv.setOnClickListener(this)
        binding.signUpSignUpBtnIv.setOnClickListener(this)
        binding.signUpBackIv.setOnClickListener(this)

        binding.signUpSignUpBtnIv.clipToOutline = true


        detectEt()
        setContentView(binding.root)
    }
    private fun detectEt() {
        binding.signUpNickNameEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var nicknameMessage: String = binding.signUpNickNameEt.text.toString()
                if(nicknameMessage.isEmpty()){
                    binding.signUpNickNameCheckButtonIv.setImageResource(R.color.gray)
                    binding.signUpNickNameCheckButtonTv.setTextColor(resources.getColor(R.color.black))
                    binding.signUpNickNameCheckButtonTv.setTypeface(null, Typeface.NORMAL)
                    isnicknameBtnPossible = false
                }
                else{
                    binding.signUpNickNameCheckButtonIv.setImageResource(R.color.Main)
                    binding.signUpNickNameCheckButtonTv.setTextColor(resources.getColor(R.color.white))
                    binding.signUpNickNameCheckButtonTv.setTypeface(null, Typeface.BOLD)
                    isnicknameBtnPossible = true
                }
                if(!isEmptyEmailFirst && !isEmptyEmailLast && !isEmptyPw && !isEmptyPwCheck && isNicknamePossible){
                    binding.signUpSignUpBtnIv.setImageResource(R.color.Main)
                    binding.signUpSignUpBtnTv.setTextColor(resources.getColor(R.color.white))
                    binding.signUpSignUpBtnTv.setTypeface(null, Typeface.BOLD)
                } else {
                    binding.signUpSignUpBtnIv.setImageResource(R.color.gray)
                    binding.signUpSignUpBtnTv.setTextColor(resources.getColor(R.color.black))
                    binding.signUpSignUpBtnTv.setTypeface(null, Typeface.NORMAL)
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
        binding.signUpIdEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val emailMessage : String? = binding.signUpIdEt.text.toString()
                val email : String? = binding.signUpIdEt.text.toString() + "@" + binding.signUpDirectInputEt.text.toString()
                if(emailMessage!!.isEmpty()){
                    binding.signUpEmailErrorTv.visibility = View.GONE
                }
                else {
                    checkEmail(email)
                }
                var message: String = binding.signUpIdEt.text.toString()
                isEmptyEmailFirst = message.isEmpty()
                if(!isEmptyEmailFirst && !isEmptyEmailLast && !isEmptyPw && !isEmptyPwCheck && isNicknamePossible){
                    binding.signUpSignUpBtnIv.setImageResource(R.color.Main)
                    binding.signUpSignUpBtnTv.setTextColor(resources.getColor(R.color.white))
                    binding.signUpSignUpBtnTv.setTypeface(null, Typeface.BOLD)
                } else {
                    binding.signUpSignUpBtnIv.setImageResource(R.color.gray)
                    binding.signUpSignUpBtnTv.setTextColor(resources.getColor(R.color.black))
                    binding.signUpSignUpBtnTv.setTypeface(null, Typeface.NORMAL)
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
        binding.signUpDirectInputEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val email : String? = binding.signUpIdEt.text.toString() + "@" + binding.signUpDirectInputEt.text.toString()
                checkEmail(email)
                var message: String = binding.signUpDirectInputEt.text.toString()
                isEmptyEmailLast = message.isEmpty()
                if(!isEmptyEmailFirst && !isEmptyEmailLast && !isEmptyPw && !isEmptyPwCheck && isNicknamePossible){
                    binding.signUpSignUpBtnIv.setImageResource(R.color.Main)
                    binding.signUpSignUpBtnTv.setTextColor(resources.getColor(R.color.white))
                    binding.signUpSignUpBtnTv.setTypeface(null, Typeface.BOLD)
                } else {
                    binding.signUpSignUpBtnIv.setImageResource(R.color.gray)
                    binding.signUpSignUpBtnTv.setTextColor(resources.getColor(R.color.black))
                    binding.signUpSignUpBtnTv.setTypeface(null, Typeface.NORMAL)
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
        binding.signUpPasswordEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.signUpPasswordErrorTv.visibility = View.GONE
                checkPW()
                var message: String = binding.signUpPasswordEt.text.toString()
                isEmptyPw = message.isEmpty()

                if(!isEmptyEmailFirst && !isEmptyEmailLast && !isEmptyPw && !isEmptyPwCheck && isNicknamePossible){
                    binding.signUpSignUpBtnIv.setImageResource(R.color.Main)
                    binding.signUpSignUpBtnTv.setTextColor(resources.getColor(R.color.white))
                    binding.signUpSignUpBtnTv.setTypeface(null, Typeface.BOLD)
                } else {
                    binding.signUpSignUpBtnIv.setImageResource(R.color.gray)
                    binding.signUpSignUpBtnTv.setTextColor(resources.getColor(R.color.black))
                    binding.signUpSignUpBtnTv.setTypeface(null, Typeface.NORMAL)
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
        binding.signUpPasswordCheckEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkPW()
                var message: String = binding.signUpPasswordCheckEt.text.toString()
                isEmptyPwCheck = message.isEmpty()

                if(!isEmptyEmailFirst && !isEmptyEmailLast && !isEmptyPw && !isEmptyPwCheck && isNicknamePossible){
                    binding.signUpSignUpBtnIv.setImageResource(R.color.Main)
                    binding.signUpSignUpBtnTv.setTextColor(resources.getColor(R.color.white))
                    binding.signUpSignUpBtnTv.setTypeface(null, Typeface.BOLD)
                } else {
                    binding.signUpSignUpBtnIv.setImageResource(R.color.gray)
                    binding.signUpSignUpBtnTv.setTextColor(resources.getColor(R.color.black))
                    binding.signUpSignUpBtnTv.setTypeface(null, Typeface.NORMAL)
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
    }
    fun checkPW(){
        if(binding.signUpPasswordEt.text.toString() != binding.signUpPasswordCheckEt.text.toString()){
            binding.signUpPasswordCheckErrorTv.visibility = View.VISIBLE
            binding.signUpPasswordCheckErrorTv.text = "비밀번호가 일치하지 않습니다."
            binding.signUpPasswordCheckErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_error))
        }
        else{
            binding.signUpPasswordCheckErrorTv.visibility = View.VISIBLE
            binding.signUpPasswordCheckErrorTv.text = "비밀번호가 일치합니다."
            binding.signUpPasswordCheckErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_right))
        }
    }
    override fun onClick(v: View?) {
        if (v == null) return
        when (v) {
            binding.signUpNickNameCheckButtonIv->{
                if(isnicknameBtnPossible){
                    checkNickname()
                }
            }
            binding.signUpSignUpBtnIv->{
                signUp()
            }
            binding.signUpSelectEmailBtnIv -> {
                if (binding.signUpSelectEmail.visibility == View.GONE) {
                    binding.signUpSelectEmail.visibility = View.VISIBLE
                    val amimationEmailSelect: ValueAnimator = ObjectAnimator
                        .ofFloat(binding.signUpSelectEmail, "translationY", -50f, 0f)
                    amimationEmailSelect.duration = 50
                    amimationEmailSelect.start()
                } else {
                    val amimationEmailSelect: ValueAnimator = ObjectAnimator
                        .ofFloat(binding.signUpSelectEmail, "translationY", 0f, -50f)
                    amimationEmailSelect.duration = 50
                    amimationEmailSelect.start()
                    Handler(Looper.getMainLooper()).postDelayed({
                        binding.signUpSelectEmail.visibility = View.GONE
                    }, 50)
                }
            }
            binding.signUpSelectEmailEtcBackgroundIv -> {
                val message:String = binding.signUpDirectInputEt.text.toString()
                val amimationEmailSelect: ValueAnimator = ObjectAnimator
                    .ofFloat(binding.signUpSelectEmail, "translationY", 0f, -50f)
                amimationEmailSelect.duration = 50
                amimationEmailSelect.start()
                Handler(Looper.getMainLooper()).postDelayed({
                    binding.signUpSelectEmail.visibility = View.GONE
                }, 50)
                binding.signUpDirectInputEt.requestFocus()
                if(message == "google.com" || message == "naver.com" || message == "nate.com" || message == "daum.net"){
                    binding.signUpDirectInputEt.setText("")
                }
            }
            binding.signUpSelectEmailGoogleBackgroundIv -> {
                val amimationEmailSelect: ValueAnimator = ObjectAnimator
                    .ofFloat(binding.signUpSelectEmail, "translationY", 0f, -50f)
                amimationEmailSelect.duration = 50
                amimationEmailSelect.start()
                Handler(Looper.getMainLooper()).postDelayed({
                    binding.signUpSelectEmail.visibility = View.GONE
                }, 50)
                binding.signUpPasswordEt.requestFocus()
                binding.signUpDirectInputEt.setText(binding.signUpSelectEmailGoogleTv.text.toString())
            }
            binding.signUpSelectEmailNaverBackgroundIv -> {
                val amimationEmailSelect: ValueAnimator = ObjectAnimator
                    .ofFloat(binding.signUpSelectEmail, "translationY", 0f, -50f)
                amimationEmailSelect.duration = 50
                amimationEmailSelect.start()
                Handler(Looper.getMainLooper()).postDelayed({
                    binding.signUpSelectEmail.visibility = View.GONE
                }, 50)
                binding.signUpPasswordEt.requestFocus()
                binding.signUpDirectInputEt.setText(binding.signUpSelectEmailNaverTv.text.toString())
            }
            binding.signUpSelectEmailNateBackgroundIv -> {
                val amimationEmailSelect: ValueAnimator = ObjectAnimator
                    .ofFloat(binding.signUpSelectEmail, "translationY", 0f, -50f)
                amimationEmailSelect.duration = 50
                amimationEmailSelect.start()
                Handler(Looper.getMainLooper()).postDelayed({
                    binding.signUpSelectEmail.visibility = View.GONE
                }, 50)
                binding.signUpPasswordEt.requestFocus()
                binding.signUpDirectInputEt.setText(binding.signUpSelectEmailNateTv.text.toString())
            }
            binding.signUpSelectEmailDaumBackgroundIv -> {
                val amimationEmailSelect: ValueAnimator = ObjectAnimator
                    .ofFloat(binding.signUpSelectEmail, "translationY", 0f, -50f)
                amimationEmailSelect.duration = 50
                amimationEmailSelect.start()
                Handler(Looper.getMainLooper()).postDelayed({
                    binding.signUpSelectEmail.visibility = View.GONE
                }, 50)
                binding.signUpPasswordEt.requestFocus()
                binding.signUpDirectInputEt.setText(binding.signUpSelectEmailDaumTv.text.toString())
            }
            binding.signUpBackIv -> {
                startActivityWithClear(LoginActivity::class.java)
            }
            binding.signupUpGoOphthaSignUpTv ->{
                startActivityWithClear(DoctorSignupActivity::class.java)
            }
        }
    }
    fun checkEmail(email : String?){
        val service = SignupNormalCheckEmailService(this, email)
        service.tryCheckEmail()
    }
    fun checkNickname(){
        val nickname:String = binding.signUpNickNameEt.text.toString()
        val service = SignupNormalCheckNicknameService(this, nickname)
        service.tryCheckNickname()
        Log.d("닉네임체크", nickname.toString())
    }
    fun signUp(){
        if(binding.signUpDirectInputEt.text.isEmpty() || binding.signUpIdEt.text.isEmpty()){
            Toast.makeText(this, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show()
            binding.signUpEmailErrorTv.text = "이메일을 입력해주세요."
            binding.signUpEmailErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_error))
            binding.signUpEmailErrorTv.visibility = View.VISIBLE
            return
        }
        if(binding.signUpPasswordEt.text.isEmpty()){
            Toast.makeText(this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            binding.signUpPasswordErrorTv.text = "비밀번호를 입력해주세요."
            binding.signUpPasswordErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_error))
            binding.signUpPasswordErrorTv.visibility = View.VISIBLE
            return
        }
        if(binding.signUpPasswordEt.text.toString() != binding.signUpPasswordCheckEt.text.toString() || binding.signUpPasswordCheckEt.text.isEmpty()){
            Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
            binding.signUpPasswordCheckErrorTv.text = "비밀번호가 일치하지 않습니다."
            binding.signUpPasswordCheckErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_error))
            binding.signUpPasswordCheckErrorTv.visibility = View.VISIBLE
            return
        }
        if(binding.signUpNickNameEt.text.isEmpty() || !isNicknamePossible){
            Toast.makeText(this, "닉네임을 확인해주세요.", Toast.LENGTH_SHORT).show()
            binding.signUpNicknameErrorTv.text = "닉네임을 확인해주세요."
            binding.signUpNicknameErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_error))
            binding.signUpNicknameErrorTv.visibility = View.VISIBLE
            return
        }

        val email : String? = binding.signUpIdEt.text.toString() + "@" + binding.signUpDirectInputEt.text.toString()
        val password : String? = binding.signUpPasswordEt.text.toString()
        val nickname : String? = binding.signUpNickNameEt.text.toString()
        val recommendUserId : String? = binding.signUpRecommanderEt.text.toString()
        val userinfo = SignUpRequestBody(email, password, nickname, recommendUserId)
        val service = SignUpService(this, userinfo)
        service.trySignUp()

    }
    override fun onCheckEmailSuccess(response: SignupNormalCheckEmailResponse) {
        if (response.result!!.isUsable == true) {
            binding.signUpEmailErrorTv.text = response.result!!.resultMsg
            binding.signUpEmailErrorTv.visibility = View.VISIBLE
            binding.signUpEmailErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_right))
        } else {
            binding.signUpEmailErrorTv.text = response.result!!.resultMsg
            binding.signUpEmailErrorTv.visibility = View.VISIBLE
            binding.signUpEmailErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_error))
        }
        Log.d("이메일중복체크", "성공!")
    }
    override fun onCheckEmailFailure(code: Int, message: String) {
        binding.signUpEmailErrorTv.text = message
        binding.signUpEmailErrorTv.visibility = View.VISIBLE
        binding.signUpEmailErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_error))
        Log.d("이메일중복체크", "실패")
    }

    override fun onCheckNicknameSuccess(response: SignupNormalCheckNicknameResponse) {
        if (response.result!!.isUsable == true) {
            binding.signUpNicknameErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_right))
            isNicknamePossible = false
        } else {
            Toast.makeText(this, response.result!!.resultMsg, Toast.LENGTH_SHORT).show()
            binding.signUpNicknameErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_error))
            isNicknamePossible = true
        }
        binding.signUpNicknameErrorTv.text = response.result!!.resultMsg
        binding.signUpNicknameErrorTv.visibility = View.VISIBLE
        Log.d("닉네임중복체크", "성공!")
        Log.d("닉네임중복체크메시지", response.result!!.resultMsg.toString())
    }

    override fun onCheckNicknameFailure(code: Int, message: String) {
        binding.signUpNicknameErrorTv.text = message
        binding.signUpNicknameErrorTv.visibility = View.VISIBLE
        binding.signUpNicknameErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_error))
        Log.d("닉네임중복체크", "실패")
    }

    override fun onSignUpLoading() {
        binding.signUpLoadingPb.visibility = View.VISIBLE
    }

    override fun onSignUpSuccess(response: SignUpResponse) {
        binding.signUpLoadingPb.visibility = View.GONE
        Log.d("회원가입", "성공!")
        Toast.makeText(this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show()
        startActivityWithClear(MainActivity::class.java)
    }

    override fun onSignUpFailure(code: Int, message: String) {
        Log.d("회원가입", "실패!")
        binding.signUpLoadingPb.visibility = View.GONE
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    private fun startActivityWithClear(activity: Class<*>?) {
        val intent = Intent(this, activity)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}