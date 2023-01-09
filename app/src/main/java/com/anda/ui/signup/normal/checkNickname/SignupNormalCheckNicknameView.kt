package com.anda.ui.signup.normal.checkNickname

import com.anda.ui.signup.normal.checkNickname.model.SignupNormalCheckNicknameResponse

interface SignupNormalCheckNicknameView {
    fun onCheckNicknameSuccess(response: SignupNormalCheckNicknameResponse)
    fun onCheckNicknameFailure(code: Int, message: String)
}