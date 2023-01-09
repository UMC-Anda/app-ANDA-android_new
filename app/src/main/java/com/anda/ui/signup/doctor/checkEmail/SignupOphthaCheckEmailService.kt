package com.anda.ui.signup.doctor.checkEmail

import android.util.Log
import com.anda.config.Application
import com.anda.ui.signup.doctor.checkEmail.model.SignupOphthaCheckEmailResponse
import com.anda.ui.signup.doctor.checkEmail.model.SignupOphthaCheckEmailRetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupOphthaCheckEmailService(var view: SignupOphthaCheckEmailView, private val email : String?){
    fun tryCheckEmail(){
        val retrofitInterface = Application.sRetrofit.create(SignupOphthaCheckEmailRetrofitInterface::class.java)
        retrofitInterface.getCheckEmail(email).enqueue(object : Callback<SignupOphthaCheckEmailResponse> {
            override fun onResponse(call: Call<SignupOphthaCheckEmailResponse>, response: Response<SignupOphthaCheckEmailResponse>){
                val resp : SignupOphthaCheckEmailResponse = response.body()!!
                when(val code = resp.code){
                    1000 -> view.onCheckEmailSuccess(resp)
                    else -> view.onCheckEmailFailure(code!!, resp.message!!)
                }
            }
            override fun onFailure(call: Call<SignupOphthaCheckEmailResponse>, t: Throwable){
                Log.d("OphthaCheckEmail",t.toString())
                view.onCheckEmailFailure(5001,t.message?:"이메일중복확인 통신 오류")
            }
        })
    }
}