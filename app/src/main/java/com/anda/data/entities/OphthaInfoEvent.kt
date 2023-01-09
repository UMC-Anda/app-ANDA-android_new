package com.anda.data.entities

data class OphthaInfoEvent(
    var ophthaEventID : Int? = 0, //이벤트 고유 ID
    val ophthaEventImg:Int? = 0, //이벤트 사진
    val ophthaEventName:String? = "", //이벤트 이름
    val ophthaEventCategory : String? = "", //이벤트 카테고리(라식, 라섹 등)
    val ophthaEventPrice : Double? = 0.0, //이벤트 가격(ex 59.4)
    val ophthaEventDate : String? = "",//이벤트 기간(0000년 00월 00일 ~ 0000년 00월 00일)
    val eventOphthaLink : String? = "", //이벤트하는 안과 URL
    var eventOphthaId : Int? = 0, //이벤트를 진행하는 안과의 고유 ID
)
