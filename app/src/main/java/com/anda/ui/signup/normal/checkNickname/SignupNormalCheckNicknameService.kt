package com.anda.ui.signup.normal.checkNickname

import android.util.Log
import com.anda.config.Application
import com.anda.ui.signup.normal.checkEmail.model.SignupNormalCheckEmailResponse
import com.anda.ui.signup.normal.checkEmail.model.SignupNormalCheckEmailRetrofitInterface
import com.anda.ui.signup.normal.checkNickname.model.SignupNormalCheckNicknameResponse
import com.anda.ui.signup.normal.checkNickname.model.SignupNormalCheckNicknameRetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignupNormalCheckNicknameService(var view: SignupNormalCheckNicknameView, private val nickname : String?){
    fun tryCheckNickname(){
        val retrofitInterface = Application.sRetrofit.create(
            SignupNormalCheckNicknameRetrofitInterface::class.java)
        retrofitInterface.getCheckNickname(nickname).enqueue(object : Callback<SignupNormalCheckNicknameResponse> {
            override fun onResponse(call: Call<SignupNormalCheckNicknameResponse>, response: Response<SignupNormalCheckNicknameResponse>){
                val resp : SignupNormalCheckNicknameResponse = response.body()!!
                when(val code = resp.code){
                    1000 -> view.onCheckNicknameSuccess(resp)
                    else -> view.onCheckNicknameFailure(code!!, resp.message!!)
                }
            }
            override fun onFailure(call: Call<SignupNormalCheckNicknameResponse>, t: Throwable){
                Log.d("NormalCheckNickname",t.toString())
                view.onCheckNicknameFailure(5001,t.message?:"닉네임중복확인 통신 오류")
            }
        })
    }
}