package com.anda.ui.signup.doctor.checkEmail.model

import com.google.gson.annotations.SerializedName

data class SignupOphthaCheckEmailResponse(
    @SerializedName("isSuccess") var isSuccess : Boolean?,
    @SerializedName("code") var code : Int?,
    @SerializedName("message") var message : String?,
    @SerializedName("result") var result: Result?
)
data class Result(
    @SerializedName("isUsable") var isUsable : Boolean?,
    @SerializedName("resultMsg") var resultMsg : String?
)