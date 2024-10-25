package com.luckyfrog.ecommerceapp.data.datasource.remote

import com.luckyfrog.ecommerceapp.core.generic.dto.ResponseDto
import com.luckyfrog.ecommerceapp.core.network.ProductApi
import com.luckyfrog.ecommerceapp.data.model.remote.dto.response.ProductResponseDto
import javax.inject.Inject

class ProductRemoteDataSourceImpl @Inject constructor(
    private val api: ProductApi
) : ProductRemoteDataSource {

    override suspend fun getProducts(
        limit: Int,
        skip: Int
    ): ResponseDto<List<ProductResponseDto>> {
        return api.getProducts(limit = limit, skip = skip)
    }

}