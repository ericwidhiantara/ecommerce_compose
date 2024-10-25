package com.luckyfrog.ecommerceapp.core.network

import com.luckyfrog.ecommerceapp.core.generic.dto.ResponseDto
import com.luckyfrog.ecommerceapp.data.model.remote.dto.response.ProductResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi {

    companion object {
        const val SERVER_URL = "https://dummyjson.com"
    }

    @GET("products")
    suspend fun getProducts(
        @Query("limit") limit: Int,
        @Query("skip") skip: Int
    ): ResponseDto<List<ProductResponseDto>>
}