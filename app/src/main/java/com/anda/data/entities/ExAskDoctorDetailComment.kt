package com.anda.data.entities

data class ExAskDoctorDetailComment(
    var commentUserProfile : Int? = null,
    var commentUserNickname : String? = null,
    var commentUserLevel : Int? = null,
    var commentUserEmail : String? = null,
    var commentContent : String? = null,
    var commentIsReplyed : Boolean? = null
)
