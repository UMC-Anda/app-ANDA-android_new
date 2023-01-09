package com.anda.data.entities

data class ExOphthaInfoReview(
    var operationCategory : String? = "",
    var operationPrice : Int? = 0,
    var operationDoctor : String? = "",
    var totalRating : Double? = 0.0,
    var isReceipted : Boolean? = null,
    var reviewTxt : String? = ""
)
