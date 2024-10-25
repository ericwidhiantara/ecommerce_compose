package com.luckyfrog.ecommerceapp.data.datasource.remote

import com.luckyfrog.ecommerceapp.core.generic.dto.ResponseDto
import com.luckyfrog.ecommerceapp.data.model.remote.dto.response.ProductResponseDto

interface ProductRemoteDataSource {

    suspend fun getProducts(
        limit: Int,
        skip: Int
    ): ResponseDto<List<ProductResponseDto>>

}
