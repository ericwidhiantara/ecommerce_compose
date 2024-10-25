package com.luckyfrog.ecommerceapp.domain.repository

import androidx.paging.PagingData
import com.luckyfrog.ecommerceapp.domain.entity.ProductEntity
import kotlinx.coroutines.flow.Flow

interface ProductRepository {

    suspend fun getProducts(): Flow<PagingData<ProductEntity>>
}