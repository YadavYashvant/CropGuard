package com.example.compose_tflite.domain

import android.graphics.Bitmap

interface DiseaseClassifier {
    fun classify(bitmap: Bitmap, rotationDegrees: Int): List<Classification>
}