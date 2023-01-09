package com.anda.ui.signup.doctor.checkEmail.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface SignupOphthaCheckEmailRetrofitInterface {
    @GET("users/signup/doctor/verify/email")
    fun getCheckEmail(
        @Query("email")email : String?
    ): Call<SignupOphthaCheckEmailResponse>
}