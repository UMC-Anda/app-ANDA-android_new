package com.anda.ui.signup.normal.signUp

import com.anda.ui.signup.normal.signUp.model.SignUpResponse


interface SignUpView {
    fun onSignUpLoading()
    fun onSignUpSuccess(response: SignUpResponse)
    fun onSignUpFailure(code: Int, message: String)
}