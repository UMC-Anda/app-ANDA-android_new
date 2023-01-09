package com.anda.ui.signup.normal.checkNickname.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SignupNormalCheckNicknameRetrofitInterface {
    @GET("users/signup/verify/nickname")
    fun getCheckNickname(
        @Query("nickname")nickname : String?
    ): Call<SignupNormalCheckNicknameResponse>
}