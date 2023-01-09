package com.anda.ui.login

import android.util.Log
import com.anda.config.Application
import com.anda.ui.login.model.LoginRequestBody
import com.anda.ui.login.model.LoginResponse
import com.anda.ui.login.model.LoginRetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginService (var view: LoginView, private val userinfo : LoginRequestBody){
    fun tryLogin(){
        val retrofitInterface = Application.sRetrofit.create(LoginRetrofitInterface::class.java)
        retrofitInterface.postLogin(userinfo).enqueue(object : Callback<LoginResponse> {
            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>){
                val resp : LoginResponse = response.body()!!
                when(val code = resp.code){
                    1000 -> view.onLoginSuccess(resp)
                    else -> view.onLoginFailure(code!!, resp.message!!)
                }
            }
            override fun onFailure(call: Call<LoginResponse>, t: Throwable){
                Log.d("Login",t.toString())
                view.onLoginFailure(5001,t.message?:"로그인 통신 오류")
            }
        })
    }
}