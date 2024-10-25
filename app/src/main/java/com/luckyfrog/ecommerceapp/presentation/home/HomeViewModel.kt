package com.luckyfrog.ecommerceapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.luckyfrog.ecommerceapp.domain.entity.ProductEntity
import com.luckyfrog.ecommerceapp.domain.usecase.GetProductsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProductsUseCase: GetProductsUseCase
) : ViewModel() {

    private val _productsState: MutableStateFlow<PagingData<ProductEntity>> = MutableStateFlow(value = PagingData.empty())
    val productsState: MutableStateFlow<PagingData<ProductEntity>> get() = _productsState

    init {
        onEvent(HomeEvent.GetHome)
    }

    fun onEvent(event: HomeEvent) {
        viewModelScope.launch {
            when (event) {
                is HomeEvent.GetHome -> {
                    getProducts()
                }
            }
        }
    }

    private suspend fun getProducts() {
        getProductsUseCase.execute(Unit)
            .distinctUntilChanged()
            .cachedIn(viewModelScope)
            .collect {
                _productsState.value = it
            }
    }
}

sealed class HomeEvent {
    object GetHome : HomeEvent()
}

data class HomeState(
    val products: List<ProductEntity> = listOf()
)