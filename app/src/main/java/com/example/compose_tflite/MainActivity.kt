package com.example.compose_tflite

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.core.app.ActivityCompat
import com.example.compose_tflite.ui.theme.ComposetfliteTheme

import android.Manifest
import android.annotation.SuppressLint
import android.content.pm.PackageManager
import androidx.activity.viewModels
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.core.content.ContextCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.compose_tflite.plantsApi_feature.viewModel.MovieViewModel
import com.example.compose_tflite.presentation.BottomNavigation
import com.example.compose_tflite.presentation.screens.HomeScreen
import com.example.compose_tflite.presentation.screens.ImageScreen
import com.example.compose_tflite.presentation.screens.ScannerScreen

val nothingfontfamily = FontFamily(
    Font(R.font.nothingfont, FontWeight.Normal)
)

val spacefamily = FontFamily(
    Font(R.font.spacebold, FontWeight.Bold)
)

class MainActivity : ComponentActivity() {

    /*private val viewModel: CreditCardViewModel by viewModels()*/
    val movieViewModel by viewModels<MovieViewModel>()
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {

        /*window.setFlags(
            android.view.WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            android.view.WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )*/

        super.onCreate(savedInstanceState)

        if(!hasCameraPermission()) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.CAMERA),
                0
            )
        }

        setContent {
            ComposetfliteTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {

                    val navController = rememberNavController()

                    Scaffold(
                        bottomBar = {
                            BottomNavigation(navController = navController)
                        }
                    ) {

                        NavHost(navController = navController, startDestination = "Home") {
                            composable("Home") {
                                HomeScreen(movieViewModel)
                            }
                            composable("Scanner") {
                                ScannerScreen(applicationContext = applicationContext)
                            }
                            composable("Image Scan") {
                                ImageScreen()
                            }
                        }
                    }
                }
            }
        }
    }
    private fun hasCameraPermission(): Boolean {
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.CAMERA
        ) == PackageManager.PERMISSION_GRANTED
    }

    /*@Composable
    fun MovieList(movieList: List<Movie>) {
        LazyColumn{
            itemsIndexed(items = movieList) { index, movie ->
                MovieItem(movie = movie)
            }
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun DefaultPreview() {
        ComposetfliteTheme {
            val movie = Movie(
                "Coco",
                "https://howtodoandroid.com/images/coco.jpg",
                "Coco is a 2017 American 3D computer-animated musical fantasy adventure film produced by Pixar",
                "Latest"
            )

            MovieItem(movie = movie )

        }
    }*/

}
