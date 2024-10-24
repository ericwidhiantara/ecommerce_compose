package com.luckyfrog.ecommerceapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.luckyfrog.ecommerceapp.core.app.Constants
import com.luckyfrog.ecommerceapp.data.datasource.remote.ecommerceRemoteDataSource
import com.luckyfrog.ecommerceapp.data.repository.paging.ecommercePagingSource
import com.luckyfrog.ecommerceapp.domain.model.Movie
import com.luckyfrog.ecommerceapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val remoteDataSource: MovieRemoteDataSource
) : MovieRepository {

    override suspend fun getMovies(): Flow<PagingData<Movie>> {
        return Pager(
            config = PagingConfig(pageSize = Constants.MAX_PAGE_SIZE, prefetchDistance = 2),
            pagingSourceFactory = {
                MoviePagingSource(remoteDataSource)
            }
        ).flow
    }
}