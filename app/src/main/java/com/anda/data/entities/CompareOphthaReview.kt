package com.anda.data.entities

data class CompareOphthaReview(
    var profileImg : Int? = 0, //작성자 프로필 이미지
    var userName: String? = null, //작성자 이름
    var userLevel: Int? = 0, //작성자 레벨
    var date: Double? = 0.0, //작성일자
    var totalRating: Int? = 0, //총 별점
    var ratingKind: Int? = 0, //친절도 별점
    var ratingWating: Int? = 0, //기다린 정도 별점
    var ratingPrice: Int? = 0, //가격 별점
    var ratingInfo: Int? = 0, //의사가 정보를 잘 알려줬는지에 대한 별점
    var ratingeffective: Int? = 0, //수술이 효과적이었는지 별점
    var operateImg: Int? = 0, //영수증 사진
    var idReceipted: Boolean? = null, //영수증 인증 됐는지
    var reviewTxt: String? = null //리뷰 텍스트
    )

