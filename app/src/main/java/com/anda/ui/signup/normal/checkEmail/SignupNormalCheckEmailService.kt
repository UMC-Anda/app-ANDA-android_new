package com.anda.ui.signup.normal.checkEmail

import android.util.Log
import com.anda.config.Application
import com.anda.ui.signup.normal.checkEmail.model.SignupNormalCheckEmailResponse
import com.anda.ui.signup.normal.checkEmail.model.SignupNormalCheckEmailRetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupNormalCheckEmailService(var view: SignupNormalCheckEmailView, private val email : String?){
    fun tryCheckEmail(){
        val retrofitInterface = Application.sRetrofit.create(SignupNormalCheckEmailRetrofitInterface::class.java)
        retrofitInterface.getCheckEmail(email).enqueue(object : Callback<SignupNormalCheckEmailResponse> {
            override fun onResponse(call: Call<SignupNormalCheckEmailResponse>, response: Response<SignupNormalCheckEmailResponse>){
                val resp : SignupNormalCheckEmailResponse = response.body()!!
                when(val code = resp.code){
                    1000 -> view.onCheckEmailSuccess(resp)
                    else -> view.onCheckEmailFailure(code!!, resp.message!!)
                }
            }
            override fun onFailure(call: Call<SignupNormalCheckEmailResponse>, t: Throwable){
                Log.d("NormalCheckEmail",t.toString())
                view.onCheckEmailFailure(5001,t.message?:"이메일중복확인 통신 오류")
            }
        })
    }
}