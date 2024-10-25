package com.luckyfrog.ecommerceapp.core.generic.dto

import com.google.gson.annotations.SerializedName
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

class ResponseDto<T : Any?> {
    @SerializedName("products")
    val products: T? = null

    @SerializedName("total")
    val total: Int? = null

    @SerializedName("skip")
    val skip: Int? = null

    @SerializedName("limit")
    val limit: Int? = null
}