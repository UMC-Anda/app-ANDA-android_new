package com.anda.data.entities

data class CommunityAdd(
    var profileImg : Int? = 0, //작성자 프로필 이미지
    var userName: String? = null, //작성자 이름
    var userLevel: Int? = 0, //작성자 레벨
    var date: Double? = 0.0, //작성일자
    var writingTitle: String? = "", //글 제목
    var writingPicture: Int? = 0, //글 사진
    var writingContent: String? = "" //글 내용
)
