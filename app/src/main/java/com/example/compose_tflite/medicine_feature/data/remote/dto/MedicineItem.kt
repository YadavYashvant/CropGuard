package com.example.compose_tflite.medicine_feature.data.remote.dto

data class MedicineItem(
    val active_ingredients: List<ActiveIngredient>,
    val application_number: String,
    val brand_name: String,
    val brand_name_base: String,
    val dosage_form: String,
    val finished: Boolean,
    val generic_name: String,
    val labeler_name: String,
    val listing_expiration_date: String,
    val marketing_category: String,
    val marketing_start_date: String,
    val openfda: Openfda,
    val packaging: List<Packaging>,
    val pharm_class: List<String>,
    val product_id: String,
    val product_ndc: String,
    val product_type: String,
    val route: List<String>,
    val spl_id: String
)