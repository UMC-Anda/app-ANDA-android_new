package com.anda.data.entities

data class ExOphthaInfoReview(
    var operationCategory : String? = "",
    var operationPrice : Int? = 0,
    var operationDoctor : String? = "",
    var totalRating : Float? = 0f,
    var isReceipted : Boolean? = null,
    var reviewTxt : String? = "",
    var kindnessRating : Int? = 0,
    var waitingRating : Int? = 0,
    var effectiveRating : Int? = 0,
    var informationRating : Int? = 0,
    var priceRating : Int? = 0,
    var nickName : String? = ""
)
