package com.anda.data.entities

data class HomeAndaRankingOphtha(
    var ophthaName : String? = "", //안과 이름
    var ophthaLocation : String? = "", //안과 위치 -> 00구
    var ophthaRank : Int? = 0,
    var ophthaImg : Int? = 0, //안과 사진
    var ophthaRatingAvg : Double? = 0.0, //안과 리뷰(별점) 총 평균
    var ophthaRatingCnt : Int? = 0, //안과 리뷰(별점) 개수
    var ophthaEvents: ArrayList<OphthaInfoEvent>? = null, //안과 이벤트
    var ophthaReview:ArrayList<CompareOphthaReview>? = null // 안과 리뷰
)