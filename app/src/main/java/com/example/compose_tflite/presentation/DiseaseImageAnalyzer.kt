package com.example.compose_tflite.presentation

import com.example.compose_tflite.domain.DiseaseClassifier

import androidx.camera.core.ImageAnalysis
import androidx.camera.core.ImageProxy
import com.example.compose_tflite.domain.Classification

class DiseaseImageAnalyzer(
    private val classifier: DiseaseClassifier,
    private val onResults: (List<Classification>) -> Unit
): ImageAnalysis.Analyzer {

    private var frameSkipCounter = 0

    override fun analyze(image: ImageProxy) {
        if(frameSkipCounter % 60 == 0) {
            val rotationDegrees = image.imageInfo.rotationDegrees
            val bitmap = image
                .toBitmap()
                .centerCrop(321, 321)

            val results = classifier.classify(bitmap, rotationDegrees)
            onResults(results)
        }
        frameSkipCounter++

        image.close()
    }
}