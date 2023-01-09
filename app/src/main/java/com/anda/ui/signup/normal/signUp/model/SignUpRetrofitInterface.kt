package com.anda.ui.signup.normal.signUp.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface SignUpRetrofitInterface {
    @POST("users/signup")
    fun postSignUp(@Body userinfo : SignUpRequestBody): Call<SignUpResponse>
}