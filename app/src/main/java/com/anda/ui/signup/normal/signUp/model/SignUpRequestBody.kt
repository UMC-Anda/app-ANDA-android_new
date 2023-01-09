package com.anda.ui.signup.normal.signUp.model

data class SignUpRequestBody(
    var email:String?,
    var password:String?,
    var nickname:String?,
    var recommendUserId:String?
)
