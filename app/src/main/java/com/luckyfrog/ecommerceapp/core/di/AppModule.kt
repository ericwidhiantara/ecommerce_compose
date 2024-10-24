package com.luckyfrog.ecommerceapp.core.di

import com.luckyfrog.ecommerceapp.core.network.ecommerceApi
import com.luckyfrog.ecommerceapp.data.datasource.remote.ecommerceRemoteDataSource
import com.luckyfrog.ecommerceapp.data.datasource.remote.ecommerceRemoteDataSourceImpl
import com.luckyfrog.ecommerceapp.data.repository.EcommerceRepositoryImpl
import com.luckyfrog.ecommerceapp.domain.repository.ecommerceRepository
import com.luckyfrog.ecommerceapp.domain.usecase.GetMoviesUseCase
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
    fun providesMovieRemoteDataSource(
        api: MovieApi
    ): MovieRemoteDataSource {
        return MovieRemoteDataSourceImpl(api)
    }

    @Singleton
    @Provides
    fun providesMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource
    ): MovieRepository {
        return MovieRepositoryImpl(movieRemoteDataSource)
    }

    @Singleton
    @Provides
    fun providesGetMoviesUseCase(
        movieRepository: MovieRepository
    ): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }
}