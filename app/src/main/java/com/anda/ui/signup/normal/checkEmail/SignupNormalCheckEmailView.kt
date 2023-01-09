package com.anda.ui.signup.normal.checkEmail

import com.anda.ui.signup.normal.checkEmail.model.SignupNormalCheckEmailResponse

interface SignupNormalCheckEmailView {
    fun onCheckEmailSuccess(response: SignupNormalCheckEmailResponse)
    fun onCheckEmailFailure(code: Int, message: String)
}