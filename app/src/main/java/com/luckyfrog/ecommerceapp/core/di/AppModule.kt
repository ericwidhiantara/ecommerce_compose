package com.luckyfrog.ecommerceapp.core.di

import com.luckyfrog.ecommerceapp.core.network.ProductApi
import com.luckyfrog.ecommerceapp.data.datasource.remote.ProductRemoteDataSource
import com.luckyfrog.ecommerceapp.data.datasource.remote.ProductRemoteDataSourceImpl
import com.luckyfrog.ecommerceapp.data.repository.ProductRepositoryImpl
import com.luckyfrog.ecommerceapp.domain.repository.ProductRepository
import com.luckyfrog.ecommerceapp.domain.usecase.GetProductsUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providesProductRemoteDataSource(
        api: ProductApi
    ): ProductRemoteDataSource {
        return ProductRemoteDataSourceImpl(api)
    }

    @Singleton
    @Provides
    fun providesProductRepository(
        remoteDataSource: ProductRemoteDataSource
    ): ProductRepository {
        return ProductRepositoryImpl(remoteDataSource)
    }

    @Singleton
    @Provides
    fun providesGetProductsUseCase(
        repository: ProductRepository
    ): GetProductsUseCase {
        return GetProductsUseCase(repository)
    }
}