package com.luckyfrog.ecommerceapp.domain.usecase

import androidx.paging.PagingData
import com.luckyfrog.ecommerceapp.core.generic.usecase.UseCase
import com.luckyfrog.ecommerceapp.domain.entity.ProductEntity
import com.luckyfrog.ecommerceapp.domain.repository.ProductRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetProductsUseCase @Inject constructor(
    private val repository: ProductRepository
) : UseCase<Unit, Flow<PagingData<ProductEntity>>> {
    override suspend fun execute(input: Unit): Flow<PagingData<ProductEntity>> {
        return repository.getProducts()
    }
}