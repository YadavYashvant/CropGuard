package com.example.compose_tflite.presentation.screens

import androidx.camera.view.CameraController
import androidx.camera.view.LifecycleCameraController
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.content.ContextCompat
import com.example.compose_tflite.data.TfLiteDiseaseClassifier
import com.example.compose_tflite.domain.Classification
import com.example.compose_tflite.nothingfontfamily
import com.example.compose_tflite.presentation.BottomNavigation
import com.example.compose_tflite.presentation.CameraPreview
import com.example.compose_tflite.presentation.DiseaseImageAnalyzer
import com.example.compose_tflite.spacefamily

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat
import com.example.compose_tflite.ui.theme.ComposetfliteTheme

import android.Manifest
import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.compose_tflite.presentation.BottomNavigation
import com.example.compose_tflite.presentation.CameraPreview

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScannerScreen(
    applicationContext: Context
) {
    var classifications by remember {
        mutableStateOf(emptyList<Classification>())
    }
    val analyzer = remember {
        DiseaseImageAnalyzer(
            classifier = TfLiteDiseaseClassifier(
                context = applicationContext
            ),
            onResults = {
                classifications = it
            }
        )
    }
    val controller = remember {
        LifecycleCameraController(applicationContext).apply {
            setEnabledUseCases(CameraController.IMAGE_ANALYSIS)
            setImageAnalysisAnalyzer(
                ContextCompat.getMainExecutor(applicationContext),
                analyzer
            )
        }
    }

    /*val navController = rememberNavController()*/


        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 32.dp),
        ) {

            Text(text = "Plant Disease Detector",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .wrapContentSize(Alignment.Center),
                fontFamily = spacefamily,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                fontSize = 34.sp,
            )

            Card(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 32.dp),
            ) {
                CameraPreview(controller, modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                )
            }

            Card(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 20.dp)
                    .wrapContentHeight(align = Alignment.CenterVertically)
                ,

                ) {
                classifications.forEach {
                    Text(
                        text = it.name,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                        ,
                        fontFamily = nothingfontfamily,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.Center,
                        fontSize = 30.sp,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
    }
}