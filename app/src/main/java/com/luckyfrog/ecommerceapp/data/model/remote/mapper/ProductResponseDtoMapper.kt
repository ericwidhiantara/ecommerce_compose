package com.luckyfrog.ecommerceapp.data.model.remote.mapper

import com.luckyfrog.ecommerceapp.data.model.remote.dto.response.DimensionsResponseDto
import com.luckyfrog.ecommerceapp.data.model.remote.dto.response.MetaResponseDto
import com.luckyfrog.ecommerceapp.data.model.remote.dto.response.ProductResponseDto
import com.luckyfrog.ecommerceapp.data.model.remote.dto.response.ReviewResponseDto
import com.luckyfrog.ecommerceapp.domain.entity.DimensionsEntity
import com.luckyfrog.ecommerceapp.domain.entity.MetaEntity
import com.luckyfrog.ecommerceapp.domain.entity.ProductEntity
import com.luckyfrog.ecommerceapp.domain.entity.ReviewEntity

// Mapping from DTO to Entity
fun ProductResponseDto.mapFromEntity() = ProductEntity(
    id = this.id,
    title = this.title,
    price = this.price,
    description = this.description,
    category = this.category,
    thumbnail = this.thumbnail, // Assuming thumbnail is used as the image
    rating = this.rating,
    discountPercentage = this.discountPercentage,
    stock = this.stock,
    tags = this.tags,
    sku = this.sku,
    weight = this.weight,
    dimensions = this.dimensions.mapFromDto(),
    warrantyInformation = this.warrantyInformation,
    shippingInformation = this.shippingInformation,
    availabilityStatus = this.availabilityStatus,
    reviews = this.reviews.mapFromDto(),
    returnPolicy = this.returnPolicy,
    minimumOrderQuantity = this.minimumOrderQuantity,
    meta = this.meta.mapFromDto(),
    images = this.images,
    brand = this.brand
)

// Mapping from Entity to DTO
fun ProductEntity.mapFromDomain() = ProductResponseDto(
    id = this.id,
    title = this.title,
    price = this.price,
    description = this.description,
    category = this.category,
    thumbnail = this.thumbnail, // Assuming image is stored as thumbnail
    rating = this.rating,
    discountPercentage = this.discountPercentage,
    stock = this.stock,
    tags = this.tags,
    sku = this.sku,
    weight = this.weight,
    dimensions = this.dimensions.mapFromDomain(),
    warrantyInformation = this.warrantyInformation,
    shippingInformation = this.shippingInformation,
    availabilityStatus = this.availabilityStatus,
    reviews = this.reviews.mapFromDomain(),
    returnPolicy = this.returnPolicy,
    minimumOrderQuantity = this.minimumOrderQuantity,
    meta = this.meta.mapFromDomain(),
    images = this.images,
    brand = this.brand
)

fun DimensionsResponseDto.mapFromDto() = DimensionsEntity(width, height, depth)
fun DimensionsEntity.mapFromDomain() = DimensionsResponseDto(width, height, depth)

fun MetaResponseDto.mapFromDto() = MetaEntity(createdAt, updatedAt, barcode, qrCode)
fun MetaEntity.mapFromDomain() = MetaResponseDto(createdAt, updatedAt, barcode, qrCode)

fun List<ReviewResponseDto>.mapFromDto() = this.map { ReviewEntity(it.rating, it.comment, it.date, it.reviewerName, it.reviewerEmail) }
fun List<ReviewEntity>.mapFromDomain() = this.map { ReviewResponseDto(it.rating, it.comment, it.date, it.reviewerName, it.reviewerEmail) }


fun List<ProductResponseDto>.mapFromListModel(): List<ProductEntity> {
    return this.map {
        it.mapFromEntity()
    }
}

fun List<ProductEntity>.mapFromListDomain(): List<ProductResponseDto> {
    return this.map {
        it.mapFromDomain()
    }
}