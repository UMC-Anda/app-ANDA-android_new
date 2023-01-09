package com.anda.ui.main.home.andaInfo.model

import com.google.gson.annotations.SerializedName

data class AndaInfoResponse(
    @SerializedName("isSuccess") var isSuccess : Boolean?,
    @SerializedName("code") var code : Int?,
    @SerializedName("message") var message : String?,
    @SerializedName("result") var result : AndaInfoResult?
)
data class AndaInfoResult(
    @SerializedName("banners") var andaInfoBanners : ArrayList<AndaInfoBanners>?
)
data class AndaInfoBanners(
    @SerializedName("andaInfoName") var andaInfoName : String? = null,
    @SerializedName("andaInfoThumbnailPicture") var andaInfoThumbnailPicture : String?= null,
    @SerializedName("andaInfoContentPicture") var andaInfoContentPicture : String?= null,
    @SerializedName("andaInfoText") var andaInfoText : String? = null
)