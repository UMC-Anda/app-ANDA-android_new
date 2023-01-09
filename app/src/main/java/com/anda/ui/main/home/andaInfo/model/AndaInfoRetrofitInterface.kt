package com.anda.ui.main.home.andaInfo.model

import retrofit2.Call
import retrofit2.http.GET

interface AndaInfoRetrofitInterface {
    @GET("banners")
    fun getAndaInfo(): Call<AndaInfoResponse>
}
