package com.luckyfrog.ecommerceapp.domain.entity

data class ProductEntity (
    val id: Long,
    val title: String,
    val description: String,
    val category: String,
    val price: Double,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Long,
    val tags: List<String>,
    val sku: String,
    val weight: Long,
    val dimensions: DimensionsEntity,
    val warrantyInformation: String,
    val shippingInformation: String,
    val availabilityStatus: String,
    val reviews: List<ReviewEntity>,
    val returnPolicy: String,
    val minimumOrderQuantity: Long,
    val meta: MetaEntity,
    val images: List<String>,
    val thumbnail: String,
    val brand: String? = null
)

data class DimensionsEntity (
    val width: Double,
    val height: Double,
    val depth: Double
)

data class MetaEntity (
    val createdAt: String,
    val updatedAt: String,
    val barcode: String,
    val qrCode: String
)

data class ReviewEntity (
    val rating: Long,
    val comment: String,
    val date: String,
    val reviewerName: String,
    val reviewerEmail: String
)