package com.anda.data.entities

data class HomeAdsBanner(
    var andaAdsName: String? = null, //광고 이름
    var andaAdsThumbnailPicture : Int? = 0, //광고 썸네일 사진
    var andaAdsContentPicture : Int? = 0, //광고 세부내용 사진
    var andaAdsText: String? = "", // 광고 관련 문구
    var andaAdsLink: String? = "" //광고 관련 링크
)
