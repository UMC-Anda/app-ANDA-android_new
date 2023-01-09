package com.anda.ui.signup.doctor.checkNickname

import com.anda.ui.signup.doctor.checkNickname.model.SignupOphthaCheckNicknameResponse


interface SignupOphthaCheckNicknameView {
    fun onCheckNicknameSuccess(response: SignupOphthaCheckNicknameResponse)
    fun onCheckNicknameFailure(code: Int, message: String)
}