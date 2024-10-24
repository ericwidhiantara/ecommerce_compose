package com.luckyfrog.ecommerceapp.domain.usecase

import androidx.paging.PagingData
import com.luckyfrog.ecommerceapp.core.generic.usecase.BaseUseCase
import com.luckyfrog.ecommerceapp.domain.model.ecommerce
import com.luckyfrog.ecommerceapp.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetMoviesUseCase @Inject constructor(
    private val repository: MovieRepository
) : BaseUseCase<Unit, Flow<PagingData<Movie>>> {
    override suspend fun execute(input: Unit): Flow<PagingData<Movie>> {
        return repository.getMovies()
    }
}