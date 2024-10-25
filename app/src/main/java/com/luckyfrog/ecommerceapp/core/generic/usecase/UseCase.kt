package com.luckyfrog.ecommerceapp.core.generic.usecase

interface UseCase<In, Out>{
    suspend fun execute(input: In): Out
}