package com.example.compose_tflite.medicine_feature.data.remote.dto

data class Packaging(
    val description: String,
    val marketing_start_date: String,
    val package_ndc: String,
    val sample: Boolean
)