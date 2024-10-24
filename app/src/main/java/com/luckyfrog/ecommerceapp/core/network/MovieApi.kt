package com.luckyfrog.ecommerceapp.core.network

import com.luckyfrog.ecommerceapp.core.generic.dto.ResponseDto
import com.luckyfrog.ecommerceapp.data.model.remote.dto.response.ecommerceResponseDto
import retrofit2.http.GET
import retrofit2.http.Query

interface ecommerceApi {

    companion object {
        const val SERVER_URL = "https://api.theecommercedb.org/3"
        const val API_URL = "$SERVER_URL/ecommerce/"
    }

    @GET("popular")
    suspend fun getecommerces(
        @Query("api_key") apiKey: String,
        @Query("page") pageNumber: Int
    ): ResponseDto<List<ecommerceResponseDto>>
}