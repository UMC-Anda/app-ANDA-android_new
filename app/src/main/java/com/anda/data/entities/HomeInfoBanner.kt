package com.anda.data.entities

data class HomeInfoBanner(
    var andaInfoName: String? = null,
    var andaInfoThumbnailPicture : Int? = 0, //썸네일 사진
    var andaInfoContentPicture : Int? = 0, //세부내용 사진
    var andaInfoText: String? = ""
)
