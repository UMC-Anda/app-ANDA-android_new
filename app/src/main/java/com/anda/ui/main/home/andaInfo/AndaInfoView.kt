package com.anda.ui.main.home.andaInfo

import com.anda.ui.main.home.andaInfo.model.AndaInfoResponse

interface AndaInfoView {
    fun onAndaInfoSuccess(response: AndaInfoResponse)
    fun onAndaInfoFailure(code: Int, message: String)
}