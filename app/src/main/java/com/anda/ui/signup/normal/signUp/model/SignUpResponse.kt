package com.anda.ui.signup.normal.signUp.model

import com.google.gson.annotations.SerializedName

data class SignUpResponse(
    @SerializedName("isSuccess") var isSuccess : Boolean?,
    @SerializedName("code") var code : Int?,
    @SerializedName("message") var message : String?,
    @SerializedName("result") var result : Result?
)
data class Result(
    @SerializedName("email") var email : String?
)