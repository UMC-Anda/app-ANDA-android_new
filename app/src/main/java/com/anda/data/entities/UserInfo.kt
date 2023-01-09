package com.anda.data.entities

data class UserInfo(
    var userId : Int? = 0, //유저 고유 ID
    var profileImg : Int? = 0, //유저 프로필 이미지
    var userName: String? = null, //유저 닉네임
    var userLevel: Int? = 0, //유저 레벨
    var userEmail: String? = "", //유저 이메일 아이디
    var userPassword : String? = "", //유저 비밀번호
    var userPoint: Int? = 0, //유저 현재 포인트
    var userDisappearPoint :Int? = 0, //이번달에 사라지는 포인트
    var userUserInfoPointHistory : ArrayList<UserInfoPointHistory>? = null, //포인트 적립 내역
    var userUserInfoMyReview: ArrayList<UserInfoMyReview>? = null, //유저가 단 리뷰들
    var userUserInfoMyCommunity: ArrayList<UserInfoMyCommunity>? = null, //유저가 작성한 커뮤니티 글
    var userUserInfoMyAsk: ArrayList<UserInfoMyAsk>? = null, //유저가 작성한 의사질문 글
    var userUserInfoMyLikeOphtha: ArrayList<UserInfoMyLikeOphtha>? = null //유저가 좋아요 한 병원
)

