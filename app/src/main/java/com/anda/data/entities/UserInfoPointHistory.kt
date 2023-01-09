package com.anda.data.entities

data class UserInfoPointHistory(
    var point : Int? = 0, //포인트 적립금
    var pointDate : String? = "", //포인트 적립 날짜
    var pointReason : String? = "" //포인트 적립 이유
)