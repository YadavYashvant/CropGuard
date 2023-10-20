package com.example.compose_tflite.medicine_feature.data.remote.dto

data class Openfda(
    val is_original_packager: List<Boolean>,
    val manufacturer_name: List<String>,
    val nui: List<String>,
    val pharm_class_cs: List<String>,
    val pharm_class_epc: List<String>,
    val pharm_class_moa: List<String>,
    val rxcui: List<String>,
    val spl_set_id: List<String>,
    val unii: List<String>
)