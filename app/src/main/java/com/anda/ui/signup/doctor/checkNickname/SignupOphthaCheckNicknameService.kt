package com.anda.ui.signup.doctor.checkNickname

import android.util.Log
import com.anda.config.Application
import com.anda.ui.signup.doctor.checkNickname.model.SignupOphthaCheckNicknameResponse
import com.anda.ui.signup.doctor.checkNickname.model.SignupOphthaCheckNicknameRetrofitInterface

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupOphthaCheckNicknameService(var view: SignupOphthaCheckNicknameView, private val nickname : String?){
    fun tryCheckNickname(){
        val retrofitInterface = Application.sRetrofit.create(
            SignupOphthaCheckNicknameRetrofitInterface::class.java)
        retrofitInterface.getCheckNickname(nickname).enqueue(object : Callback<SignupOphthaCheckNicknameResponse> {
            override fun onResponse(call: Call<SignupOphthaCheckNicknameResponse>, response: Response<SignupOphthaCheckNicknameResponse>){
                val resp : SignupOphthaCheckNicknameResponse = response.body()!!
                when(val code = resp.code){
                    1000 -> view.onCheckNicknameSuccess(resp)
                    else -> view.onCheckNicknameFailure(code!!, resp.message!!)
                }
            }
            override fun onFailure(call: Call<SignupOphthaCheckNicknameResponse>, t: Throwable){
                Log.d("NormalCheckNickname",t.toString())
                view.onCheckNicknameFailure(5001,t.message?:"닉네임중복확인 통신 오류")
            }
        })
    }
}