package com.appdeveloper.demo1.model.reqres

data class ListResourceResponse(
    val data: ArrayList<DataX>,
    val page: Int,
    val per_page: Int,
    val support: SupportX,
    val total: Int,
    val total_pages: Int
)