package com.anda.ui.login.model

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginRetrofitInterface {
    @POST("users/signin")
    fun postLogin(@Body userinfo : LoginRequestBody): Call<LoginResponse>
}