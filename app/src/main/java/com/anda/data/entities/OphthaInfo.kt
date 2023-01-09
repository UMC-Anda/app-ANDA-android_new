package com.anda.data.entities

data class OphthaInfo(
    var ophthaId : Int? = 0, //안과 고유 ID
    var ophthaName : String? = "", //안과 이름
    var ophthaPicture : Int? = 0, //안과 사진
    var cityName : String? = "", //도시 이름(서울시)
    var townName : String? = "", //동네 이름(00구)
    var adress : String? = "", //서울특별시 강남구 도산대로 119 2,3층 (신사동)
    var phoneNumber : String? = "", //안과 번호
    var url : String? = "", //안과 URL
    var xCoordi : String? = "", //X좌표?
    var yCoordi : String? = "", //Y좌표?
    var reviewRatingAvg : Double? = 0.0, //모든 리뷰들의 총 별점 평균
    var revuewRatingCnt : Int? = 0, //리뷰들의 총 개수
    var ophthaReview : ArrayList<OphthaInfoReview>? = null, //리뷰들
    var ophthaEvent : ArrayList<OphthaInfoEvent>? = null //리뷰들
)
