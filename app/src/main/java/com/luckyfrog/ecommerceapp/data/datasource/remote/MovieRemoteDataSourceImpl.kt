package com.luckyfrog.ecommerceapp.data.datasource.remote

import com.luckyfrog.ecommerceapp.core.generic.dto.ResponseDto
import com.luckyfrog.ecommerceapp.core.network.ecommerceApi
import com.luckyfrog.ecommerceapp.data.model.remote.dto.response.ecommerceResponseDto
import javax.inject.Inject

class EcommerceRemoteDataSourceImpl @Inject constructor(
    private val api: MovieApi
) : MovieRemoteDataSource {

    override suspend fun getMovies(
        apiKey: String,
        pageNumber: Int
    ): ResponseDto<List<MovieResponseDto>> {
        return api.getMovies(apiKey = apiKey, pageNumber = pageNumber)
    }

}