package com.luckyfrog.ecommerceapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.luckyfrog.ecommerceapp.core.app.Constants
import com.luckyfrog.ecommerceapp.data.datasource.remote.ProductRemoteDataSource
import com.luckyfrog.ecommerceapp.data.repository.paging.ProductPagingSource
import com.luckyfrog.ecommerceapp.domain.entity.ProductEntity
import com.luckyfrog.ecommerceapp.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val remoteDataSource: ProductRemoteDataSource
) : ProductRepository {

    override suspend fun getProducts(): Flow<PagingData<ProductEntity>> {
        return Pager(
            config = PagingConfig(pageSize = Constants.MAX_PAGE_SIZE, prefetchDistance = 2),
            pagingSourceFactory = {
                ProductPagingSource(remoteDataSource)
            }
        ).flow
    }
}