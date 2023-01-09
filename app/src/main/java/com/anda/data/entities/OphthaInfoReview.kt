package com.anda.data.entities

data class OphthaInfoReview(
    var ophthaReviewId : Int? = 0, //안과 리뷰 고유 ID
    var ophthaReviewLikeCnt : Int? = 0, //이 리뷰가 받은 좋아요 개수
    var operationCategory:String? = "", // 수술 카테고리
    var operationPrice:Int? = 0, //수술 가격
    var operationDoctor:String? = "", //수술을 진행한 의사
    var totalRating: Int? = 0, //총 별점
    var ratingKind: Int? = 0, //친절도 별점
    var ratingWating: Int? = 0, //기다린 정도 별점
    var ratingPrice: Int? = 0, //가격 별점
    var ratingInfo: Int? = 0, //의사가 정보를 잘 알려줬는지에 대한 별점
    var ratingeffective: Int? = 0, //수술이 효과적이었는지 별점
    var operateImg: Int? = 0, //영수증 사진
    var idReceipted: Boolean? = null, //영수증 인증 유무
    var reviewTxt: String? = null, //리뷰 텍스트
    var reviewUserId : Int? = 0 //리뷰를 작성한 유저 ID
)
