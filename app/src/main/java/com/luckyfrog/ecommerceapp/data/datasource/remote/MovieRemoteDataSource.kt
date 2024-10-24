package com.luckyfrog.ecommerceapp.data.datasource.remote

import com.luckyfrog.ecommerceapp.core.generic.dto.ResponseDto
import com.luckyfrog.ecommerceapp.data.model.remote.dto.response.ecommerceResponseDto

interface EcommerceRemoteDataSource {

    suspend fun getEcommerces(
        apiKey: String,
        pageNumber: Int
    ): ResponseDto<List<ecommerceResponseDto>>

}
