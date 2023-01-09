package com.anda.ui.signup.doctor.checkEmail

import com.anda.ui.signup.doctor.checkEmail.model.SignupOphthaCheckEmailResponse

interface SignupOphthaCheckEmailView {
    fun onCheckEmailSuccess(response: SignupOphthaCheckEmailResponse)
    fun onCheckEmailFailure(code: Int, message: String)
}