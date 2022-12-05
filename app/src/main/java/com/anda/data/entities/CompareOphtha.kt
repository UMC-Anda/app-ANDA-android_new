package com.anda.data.entities

data class CompareOphtha(
    var name: String? = null,
    var location: String? = null,
    var picture: Int? = 0,
    var ratingAvg: Double = 0.0,
    var reviewCnt: Int? = 0,
    var reviews: ArrayList<CompareOphthaReview>? = null
)
