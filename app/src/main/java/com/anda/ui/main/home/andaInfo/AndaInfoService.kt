package com.anda.ui.main.home.andaInfo

import android.util.Log
import com.anda.config.Application
import com.anda.ui.main.home.andaInfo.model.AndaInfoResponse
import com.anda.ui.main.home.andaInfo.model.AndaInfoRetrofitInterface
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class AndaInfoService(var view: AndaInfoView){
    fun tryAndaInfo(){
        val retrofitInterface = Application.sRetrofit.create(AndaInfoRetrofitInterface::class.java)
        retrofitInterface.getAndaInfo().enqueue(object : Callback<AndaInfoResponse> {
            override fun onResponse(call: Call<AndaInfoResponse>, response: Response<AndaInfoResponse>){
                val resp : AndaInfoResponse = response.body()!!
                when(val code = resp.code){
                    1000 -> view.onAndaInfoSuccess(resp)
                    else -> view.onAndaInfoFailure(code!!, resp.message!!)
                }
            }
            override fun onFailure(call: Call<AndaInfoResponse>, t: Throwable){
                Log.d("AndaInfo",t.toString())
                view.onAndaInfoFailure(5001,t.message?:"안다정보 통신 오류")
            }
        })
    }
}