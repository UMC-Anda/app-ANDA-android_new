package com.anda.ui.signup.normal.checkEmail.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SignupNormalCheckEmailRetrofitInterface {
    @GET("users/signup/verify/email")
    fun getCheckEmail(
        @Query("email")email : String?
    ): Call<SignupNormalCheckEmailResponse>
}