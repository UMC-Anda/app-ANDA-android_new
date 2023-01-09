package com.anda.ui.signup.normal.signUp

import android.util.Log
import com.anda.config.Application
import com.anda.ui.login.model.LoginRequestBody
import com.anda.ui.login.model.LoginResponse
import com.anda.ui.login.model.LoginRetrofitInterface
import com.anda.ui.signup.normal.signUp.model.SignUpRequestBody
import com.anda.ui.signup.normal.signUp.model.SignUpResponse
import com.anda.ui.signup.normal.signUp.model.SignUpRetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpService (var view: SignUpView, private val userinfo : SignUpRequestBody){
    fun trySignUp(){
        val retrofitInterface = Application.sRetrofit.create(SignUpRetrofitInterface::class.java)
        retrofitInterface.postSignUp(userinfo).enqueue(object : Callback<SignUpResponse> {
            override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>){
                val resp : SignUpResponse = response.body()!!
                when(val code = resp.code){
                    1000 -> view.onSignUpSuccess(resp)
                    else -> view.onSignUpFailure(code!!, resp.message!!)
                }
            }
            override fun onFailure(call: Call<SignUpResponse>, t: Throwable){
                Log.d("SignUp",t.toString())
                view.onSignUpFailure(5001,t.message?:"회원가입 통신 오류")
            }
        })
    }
}