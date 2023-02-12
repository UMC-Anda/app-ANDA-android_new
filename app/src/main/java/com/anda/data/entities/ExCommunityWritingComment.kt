package com.anda.data.entities

data class ExCommunityWrtingComment(
    var userName:String? = null,
    var userLevel:Int? = null,
    var userEmail:String? = null,
    var userProfile: Int? = null,
    var writingTitle:String? = null,
    var writingContent:String? = null,
    var comments : ArrayList<Comments>?
)
data class Comments(
    var userName:String? = null,
    var userLevel:Int? = null,
    var userEmail:String? = null,
    var userProfile: Int? = null,
    var commentContent:String? = null,
    var cinnebtLike:Int? = null
)