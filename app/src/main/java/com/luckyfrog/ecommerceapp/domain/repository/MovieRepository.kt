package com.luckyfrog.ecommerceapp.domain.repository

import androidx.paging.PagingData
import com.luckyfrog.ecommerceapp.domain.model.ecommerce
import kotlinx.coroutines.flow.Flow

interface ecommerceRepository {

    suspend fun getecommerces(): Flow<PagingData<Movie>>
}