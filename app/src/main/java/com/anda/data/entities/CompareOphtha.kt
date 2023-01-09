package com.anda.data.entities

data class CompareOphtha(
    var name: String? = null, //안과 이름
    var location: String? = null,  //안과 위치 -> 00구
    var picture: Int? = 0, //안과 사진
    var ratingAvg: Double = 0.0, //안과 리뷰(별점) 총 평균
    var reviewCnt: Int? = 0, //안과 리뷰(별점) 총 개수
    var reviews: ArrayList<CompareOphthaReview>? = null //안과 리뷰
)
