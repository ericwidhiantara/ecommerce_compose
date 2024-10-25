package com.luckyfrog.ecommerceapp.data.repository.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.esotericsoftware.kryo.util.Util.log
import com.luckyfrog.ecommerceapp.core.app.Constants
import com.luckyfrog.ecommerceapp.data.datasource.remote.ProductRemoteDataSource
import com.luckyfrog.ecommerceapp.data.model.remote.mapper.mapFromListModel
import com.luckyfrog.ecommerceapp.domain.entity.ProductEntity
import retrofit2.HttpException
import java.io.IOException

class ProductPagingSource(
    private val remoteDataSource: ProductRemoteDataSource,
) : PagingSource<Int, ProductEntity>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ProductEntity> {
        return try {
            val currentPage = params.key ?: 1
            val result = remoteDataSource.getProducts(
                limit = Constants.MAX_PAGE_SIZE,
                skip = (currentPage - 1) * Constants.MAX_PAGE_SIZE
            )
            log("result: $result","ProductPagingSource")
            LoadResult.Page(
                data = if (result.products != null) result.products.mapFromListModel() else emptyList(),
                prevKey = if (currentPage == 1) null else -1,
                nextKey = if (result.products!!.size < Constants.MAX_PAGE_SIZE) null else currentPage + 1
            )
        } catch (exception: IOException) {
            return LoadResult.Error(exception)
        } catch (exception: HttpException) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, ProductEntity>): Int? {
        return state.anchorPosition
    }

}