package com.example.compose_tflite.plantsApi_feature.model

data class DefaultImage(
    val license: Int,
    val license_name: String,
    val license_url: String,
    val medium_url: String,
    val original_url: String,
    val regular_url: String,
    val small_url: String,
    val thumbnail: String
)