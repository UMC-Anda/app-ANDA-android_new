package com.anda.ui.signup.doctor

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
import com.anda.databinding.ActivityDoctorSignupBinding
import com.anda.ui.login.LoginActivity
import com.anda.ui.signup.doctor.checkEmail.SignupOphthaCheckEmailService
import com.anda.ui.signup.doctor.checkEmail.SignupOphthaCheckEmailView
import com.anda.ui.signup.doctor.checkEmail.model.SignupOphthaCheckEmailResponse
import com.anda.ui.signup.normal.checkEmail.SignupNormalCheckEmailService
import com.anda.ui.signup.normal.checkEmail.model.SignupNormalCheckEmailResponse
import com.anda.ui.signup.normal.checkNickname.SignupNormalCheckNicknameService
import com.anda.ui.signup.normal.checkNickname.SignupNormalCheckNicknameView
import com.anda.ui.signup.normal.checkNickname.model.SignupNormalCheckNicknameResponse
import com.anda.ui.signup.normal.signUp.SignUpService
import com.anda.ui.signup.normal.signUp.SignUpView
import com.anda.ui.signup.normal.signUp.model.SignUpRequestBody
import com.anda.ui.signup.normal.signUp.model.SignUpResponse

class DoctorSignupActivity : AppCompatActivity(), SignupOphthaCheckEmailView, SignupNormalCheckNicknameView, SignUpView, View.OnClickListener {

    private lateinit var binding: ActivityDoctorSignupBinding
    private var isNicknameBtnPossible :Boolean = false
    private var isOphthanamePossible : Boolean = false
    private var isEmptyEmailFirst : Boolean = true
    private var isEmptyEmailLast : Boolean = true
    private var isEmptyPw : Boolean = true
    private var isEmptyPwCheck : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDoctorSignupBinding.inflate(layoutInflater)
        binding.doctorSignUpOphthaNameCheckButtonIv.clipToOutline = true


        binding.doctorSignUpSelectEmailBtnIv.setOnClickListener(this)
        binding.doctorSignUpSelectEmailEtcBackgroundIv.setOnClickListener(this)
        binding.doctorSignUpSelectEmailGoogleBackgroundIv.setOnClickListener(this)
        binding.doctorSignUpSelectEmailNaverBackgroundIv.setOnClickListener(this)
        binding.doctorSignUpSelectEmailNateBackgroundIv.setOnClickListener(this)
        binding.doctorSignUpSelectEmailDaumBackgroundIv.setOnClickListener(this)
        binding.doctorSignUpOphthaNameCheckButtonIv.setOnClickListener(this)
        binding.doctorSignUpSignUpBtnIv.setOnClickListener(this)
        binding.doctorSignUpBackIv.setOnClickListener(this)

        binding.doctorSignUpSignUpBtnIv.clipToOutline = true


        detectEt()
        setContentView(binding.root)
    }
    private fun detectEt() {
        binding.doctorSignUpOphthaNameEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                var nicknameMessage: String = binding.doctorSignUpOphthaNameEt.text.toString()
                if(nicknameMessage.isEmpty()){
                    binding.doctorSignUpOphthaNameCheckButtonIv.setImageResource(R.color.gray)
                    binding.doctorSignUpOphthaNameCheckButtonTv.setTextColor(resources.getColor(R.color.black))
                    binding.doctorSignUpOphthaNameCheckButtonTv.setTypeface(null, Typeface.NORMAL)
                    isNicknameBtnPossible = false
                }
                else{
                    binding.doctorSignUpOphthaNameCheckButtonIv.setImageResource(R.color.Main)
                    binding.doctorSignUpOphthaNameCheckButtonTv.setTextColor(resources.getColor(R.color.white))
                    binding.doctorSignUpOphthaNameCheckButtonTv.setTypeface(null, Typeface.BOLD)
                    isNicknameBtnPossible = true
                }
                if(!isEmptyEmailFirst && !isEmptyEmailLast && !isEmptyPw && !isEmptyPwCheck && isOphthanamePossible){
                    binding.doctorSignUpSignUpBtnIv.setImageResource(R.color.Main)
                    binding.doctorSignUpSignUpBtnTv.setTextColor(resources.getColor(R.color.white))
                    binding.doctorSignUpSignUpBtnTv.setTypeface(null, Typeface.BOLD)
                } else {
                    binding.doctorSignUpSignUpBtnIv.setImageResource(R.color.gray)
                    binding.doctorSignUpSignUpBtnTv.setTextColor(resources.getColor(R.color.black))
                    binding.doctorSignUpSignUpBtnTv.setTypeface(null, Typeface.NORMAL)
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
        binding.doctorSignUpIdEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val emailMessage : String? = binding.doctorSignUpIdEt.text.toString()
                val email : String? = binding.doctorSignUpIdEt.text.toString() + "@" + binding.doctorSignUpDirectInputEt.text.toString()
                if(emailMessage!!.isEmpty()){
                    binding.doctorSignUpEmailErrorTv.visibility = View.GONE
                }
                else {
                    checkEmail(email)
                }
                var message: String = binding.doctorSignUpIdEt.text.toString()
                isEmptyEmailFirst = message.isEmpty()
                if(!isEmptyEmailFirst && !isEmptyEmailLast && !isEmptyPw && !isEmptyPwCheck && isOphthanamePossible){
                    binding.doctorSignUpSignUpBtnIv.setImageResource(R.color.Main)
                    binding.doctorSignUpSignUpBtnTv.setTextColor(resources.getColor(R.color.white))
                    binding.doctorSignUpSignUpBtnTv.setTypeface(null, Typeface.BOLD)
                } else {
                    binding.doctorSignUpSignUpBtnIv.setImageResource(R.color.gray)
                    binding.doctorSignUpSignUpBtnTv.setTextColor(resources.getColor(R.color.black))
                    binding.doctorSignUpSignUpBtnTv.setTypeface(null, Typeface.NORMAL)
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
        binding.doctorSignUpDirectInputEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                val email : String? = binding.doctorSignUpIdEt.text.toString() + "@" + binding.doctorSignUpDirectInputEt.text.toString()
                checkEmail(email)
                var message: String = binding.doctorSignUpDirectInputEt.text.toString()
                isEmptyEmailLast = message.isEmpty()
                if(!isEmptyEmailFirst && !isEmptyEmailLast && !isEmptyPw && !isEmptyPwCheck && isOphthanamePossible){
                    binding.doctorSignUpSignUpBtnIv.setImageResource(R.color.Main)
                    binding.doctorSignUpSignUpBtnTv.setTextColor(resources.getColor(R.color.white))
                    binding.doctorSignUpSignUpBtnTv.setTypeface(null, Typeface.BOLD)
                } else {
                    binding.doctorSignUpSignUpBtnIv.setImageResource(R.color.gray)
                    binding.doctorSignUpSignUpBtnTv.setTextColor(resources.getColor(R.color.black))
                    binding.doctorSignUpSignUpBtnTv.setTypeface(null, Typeface.NORMAL)
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
        binding.doctorSignUpPasswordEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                binding.doctorSignUpPasswordErrorTv.visibility = View.GONE
                checkPW()
                var message: String = binding.doctorSignUpPasswordEt.text.toString()
                isEmptyPw = message.isEmpty()

                if(!isEmptyEmailFirst && !isEmptyEmailLast && !isEmptyPw && !isEmptyPwCheck && isOphthanamePossible){
                    binding.doctorSignUpSignUpBtnIv.setImageResource(R.color.Main)
                    binding.doctorSignUpSignUpBtnTv.setTextColor(resources.getColor(R.color.white))
                    binding.doctorSignUpSignUpBtnTv.setTypeface(null, Typeface.BOLD)
                } else {
                    binding.doctorSignUpSignUpBtnIv.setImageResource(R.color.gray)
                    binding.doctorSignUpSignUpBtnTv.setTextColor(resources.getColor(R.color.black))
                    binding.doctorSignUpSignUpBtnTv.setTypeface(null, Typeface.NORMAL)
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
        binding.doctorSignUpPasswordCheckEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                checkPW()
                var message: String = binding.doctorSignUpPasswordCheckEt.text.toString()
                isEmptyPwCheck = message.isEmpty()

                if(!isEmptyEmailFirst && !isEmptyEmailLast && !isEmptyPw && !isEmptyPwCheck && isOphthanamePossible){
                    binding.doctorSignUpSignUpBtnIv.setImageResource(R.color.Main)
                    binding.doctorSignUpSignUpBtnTv.setTextColor(resources.getColor(R.color.white))
                    binding.doctorSignUpSignUpBtnTv.setTypeface(null, Typeface.BOLD)
                } else {
                    binding.doctorSignUpSignUpBtnIv.setImageResource(R.color.gray)
                    binding.doctorSignUpSignUpBtnTv.setTextColor(resources.getColor(R.color.black))
                    binding.doctorSignUpSignUpBtnTv.setTypeface(null, Typeface.NORMAL)
                }
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
    }
    fun checkPW(){
        if(binding.doctorSignUpPasswordEt.text.toString() != binding.doctorSignUpPasswordCheckEt.text.toString()){
            binding.doctorSignUpPasswordCheckErrorTv.visibility = View.VISIBLE
            binding.doctorSignUpPasswordCheckErrorTv.text = "비밀번호가 일치하지 않습니다."
            binding.doctorSignUpPasswordCheckErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_error))
        }
        else{
            binding.doctorSignUpPasswordCheckErrorTv.visibility = View.VISIBLE
            binding.doctorSignUpPasswordCheckErrorTv.text = "비밀번호가 일치합니다."
            binding.doctorSignUpPasswordCheckErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_right))
        }
    }
    override fun onClick(v: View?) {
        if (v == null) return
        when (v) {
            binding.doctorSignUpOphthaNameCheckButtonIv->{
                if(isNicknameBtnPossible){
                    checkNickname()
                }
            }
            binding.doctorSignUpSignUpBtnIv->{
                signUp()
            }
            binding.doctorSignUpSelectEmailBtnIv -> {
                if (binding.doctorSignUpSelectEmail.visibility == View.GONE) {
                    binding.doctorSignUpSelectEmail.visibility = View.VISIBLE
                    val amimationEmailSelect: ValueAnimator = ObjectAnimator
                        .ofFloat(binding.doctorSignUpSelectEmail, "translationY", -50f, 0f)
                    amimationEmailSelect.duration = 50
                    amimationEmailSelect.start()
                } else {
                    val amimationEmailSelect: ValueAnimator = ObjectAnimator
                        .ofFloat(binding.doctorSignUpSelectEmail, "translationY", 0f, -50f)
                    amimationEmailSelect.duration = 50
                    amimationEmailSelect.start()
                    Handler(Looper.getMainLooper()).postDelayed({
                        binding.doctorSignUpSelectEmail.visibility = View.GONE
                    }, 50)
                }
            }
            binding.doctorSignUpSelectEmailEtcBackgroundIv -> {
                val message:String = binding.doctorSignUpDirectInputEt.text.toString()
                val amimationEmailSelect: ValueAnimator = ObjectAnimator
                    .ofFloat(binding.doctorSignUpSelectEmail, "translationY", 0f, -50f)
                amimationEmailSelect.duration = 50
                amimationEmailSelect.start()
                Handler(Looper.getMainLooper()).postDelayed({
                    binding.doctorSignUpSelectEmail.visibility = View.GONE
                }, 50)
                binding.doctorSignUpDirectInputEt.requestFocus()
                if(message == "google.com" || message == "naver.com" || message == "nate.com" || message == "daum.net"){
                    binding.doctorSignUpDirectInputEt.setText("")
                }
            }
            binding.doctorSignUpSelectEmailGoogleBackgroundIv -> {
                val amimationEmailSelect: ValueAnimator = ObjectAnimator
                    .ofFloat(binding.doctorSignUpSelectEmail, "translationY", 0f, -50f)
                amimationEmailSelect.duration = 50
                amimationEmailSelect.start()
                Handler(Looper.getMainLooper()).postDelayed({
                    binding.doctorSignUpSelectEmail.visibility = View.GONE
                }, 50)
                binding.doctorSignUpPasswordEt.requestFocus()
                binding.doctorSignUpDirectInputEt.setText(binding.doctorSignUpSelectEmailGoogleTv.text.toString())
            }
            binding.doctorSignUpSelectEmailNaverBackgroundIv -> {
                val amimationEmailSelect: ValueAnimator = ObjectAnimator
                    .ofFloat(binding.doctorSignUpSelectEmail, "translationY", 0f, -50f)
                amimationEmailSelect.duration = 50
                amimationEmailSelect.start()
                Handler(Looper.getMainLooper()).postDelayed({
                    binding.doctorSignUpSelectEmail.visibility = View.GONE
                }, 50)
                binding.doctorSignUpPasswordEt.requestFocus()
                binding.doctorSignUpDirectInputEt.setText(binding.doctorSignUpSelectEmailNaverTv.text.toString())
            }
            binding.doctorSignUpSelectEmailNateBackgroundIv -> {
                val amimationEmailSelect: ValueAnimator = ObjectAnimator
                    .ofFloat(binding.doctorSignUpSelectEmail, "translationY", 0f, -50f)
                amimationEmailSelect.duration = 50
                amimationEmailSelect.start()
                Handler(Looper.getMainLooper()).postDelayed({
                    binding.doctorSignUpSelectEmail.visibility = View.GONE
                }, 50)
                binding.doctorSignUpPasswordEt.requestFocus()
                binding.doctorSignUpDirectInputEt.setText(binding.doctorSignUpSelectEmailNateTv.text.toString())
            }
            binding.doctorSignUpSelectEmailDaumBackgroundIv -> {
                val amimationEmailSelect: ValueAnimator = ObjectAnimator
                    .ofFloat(binding.doctorSignUpSelectEmail, "translationY", 0f, -50f)
                amimationEmailSelect.duration = 50
                amimationEmailSelect.start()
                Handler(Looper.getMainLooper()).postDelayed({
                    binding.doctorSignUpSelectEmail.visibility = View.GONE
                }, 50)
                binding.doctorSignUpPasswordEt.requestFocus()
                binding.doctorSignUpDirectInputEt.setText(binding.doctorSignUpSelectEmailDaumTv.text.toString())
            }
            binding.doctorSignUpBackIv -> {
                startActivityWithClear(LoginActivity::class.java)
            }
        }
    }
    fun checkEmail(email : String?){
        val service = SignupOphthaCheckEmailService(this, email)
        service.tryCheckEmail()
    }
    fun checkNickname(){
        val nickname:String = binding.doctorSignUpOphthaNameEt.text.toString()
        val service = SignupNormalCheckNicknameService(this, nickname)
        service.tryCheckNickname()
    }
    fun signUp(){
        if(binding.doctorSignUpDirectInputEt.text.isEmpty() || binding.doctorSignUpIdEt.text.isEmpty()){
            Toast.makeText(this, "이메일을 입력해주세요.", Toast.LENGTH_SHORT).show()
            binding.doctorSignUpEmailErrorTv.text = "이메일을 입력해주세요."
            binding.doctorSignUpEmailErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_error))
            binding.doctorSignUpEmailErrorTv.visibility = View.VISIBLE
            return
        }
        if(binding.doctorSignUpPasswordEt.text.isEmpty()){
            Toast.makeText(this, "비밀번호를 입력해주세요.", Toast.LENGTH_SHORT).show()
            binding.doctorSignUpPasswordErrorTv.text = "비밀번호를 입력해주세요."
            binding.doctorSignUpPasswordErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_error))
            binding.doctorSignUpPasswordErrorTv.visibility = View.VISIBLE
            return
        }
        if(binding.doctorSignUpPasswordEt.text.toString() != binding.doctorSignUpPasswordCheckEt.text.toString() || binding.doctorSignUpPasswordCheckEt.text.isEmpty()){
            Toast.makeText(this, "비밀번호가 일치하지 않습니다.", Toast.LENGTH_SHORT).show()
            binding.doctorSignUpPasswordCheckErrorTv.text = "비밀번호가 일치하지 않습니다."
            binding.doctorSignUpPasswordCheckErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_error))
            binding.doctorSignUpPasswordCheckErrorTv.visibility = View.VISIBLE
            return
        }
        if(binding.doctorSignUpOphthaNameEt.text.isEmpty() || !isOphthanamePossible){
            Toast.makeText(this, "닉네임을 확인해주세요.", Toast.LENGTH_SHORT).show()
            binding.doctorSignUpOphthanameErrorTv.text = "닉네임을 확인해주세요."
            binding.doctorSignUpOphthanameErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_error))
            binding.doctorSignUpOphthanameErrorTv.visibility = View.VISIBLE
            return
        }

        val email : String? = binding.doctorSignUpIdEt.text.toString() + "@" + binding.doctorSignUpDirectInputEt.text.toString()
        val password : String? = binding.doctorSignUpPasswordEt.text.toString()
        val nickname : String? = binding.doctorSignUpOphthaNameEt.text.toString()
//        val recommendUserId : Int? = binding.doctorSignUpTakePictureIv.
        val userinfo = SignUpRequestBody(email, password, nickname, "")
        val service = SignUpService(this, userinfo)
        service.trySignUp()

    }
    override fun onCheckEmailSuccess(response: SignupOphthaCheckEmailResponse) {
        if (response.result!!.isUsable == true) {
            binding.doctorSignUpEmailErrorTv.text = response.result!!.resultMsg
            binding.doctorSignUpEmailErrorTv.visibility = View.VISIBLE
            binding.doctorSignUpEmailErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_right))
        } else {
            binding.doctorSignUpEmailErrorTv.text = response.result!!.resultMsg
            binding.doctorSignUpEmailErrorTv.visibility = View.VISIBLE
            binding.doctorSignUpEmailErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_error))
        }
        Log.d("이메일중복체크", "성공!")
    }
    override fun onCheckEmailFailure(code: Int, message: String) {
        binding.doctorSignUpEmailErrorTv.text = message
        binding.doctorSignUpEmailErrorTv.visibility = View.VISIBLE
        binding.doctorSignUpEmailErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_error))
        Log.d("이메일중복체크", "실패")
    }

    override fun onCheckNicknameSuccess(response: SignupNormalCheckNicknameResponse) {
        if (response.result!!.isUsable == true) {
            binding.doctorSignUpOphthanameErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_right))
            isOphthanamePossible = false
        } else {
            Toast.makeText(this, response.result!!.resultMsg, Toast.LENGTH_SHORT).show()
            binding.doctorSignUpOphthanameErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_error))
            isOphthanamePossible = true
        }
        binding.doctorSignUpOphthanameErrorTv.text = response.result!!.resultMsg
        binding.doctorSignUpOphthanameErrorTv.visibility = View.VISIBLE
        Log.d("닉네임중복체크", "성공!")
    }

    override fun onCheckNicknameFailure(code: Int, message: String) {
        binding.doctorSignUpOphthanameErrorTv.text = message
        binding.doctorSignUpOphthanameErrorTv.visibility = View.VISIBLE
        binding.doctorSignUpOphthanameErrorTv.setTextColor(ContextCompat.getColor(this, R.color.form_error))
        Log.d("닉네임중복체크", "실패")
    }

    override fun onSignUpLoading() {
        binding.doctorSignUpLoadingPb.visibility = View.VISIBLE
    }

    override fun onSignUpSuccess(response: SignUpResponse) {
        binding.doctorSignUpLoadingPb.visibility = View.GONE
        Log.d("회원가입", "성공!")
        Toast.makeText(this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show()
        startActivityWithClear(MainActivity::class.java)
    }

    override fun onSignUpFailure(code: Int, message: String) {
        Log.d("회원가입", "실패!")
        binding.doctorSignUpLoadingPb.visibility = View.GONE
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    private fun startActivityWithClear(activity: Class<*>?) {
        val intent = Intent(this, activity)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        startActivity(intent)
    }
}
