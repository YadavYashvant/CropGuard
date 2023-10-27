package com.example.compose_tflite.presentation.screens

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import coil.annotation.ExperimentalCoilApi

/*const val BASE_URL = "https://poetrydb.org/author,title/"*/

import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.compose_tflite.plantsApi_feature.model.Movie
import com.example.compose_tflite.plantsApi_feature.view.MovieItem
import com.example.compose_tflite.plantsApi_feature.viewModel.MovieViewModel
import com.example.compose_tflite.ui.theme.ComposetfliteTheme

@OptIn(ExperimentalCoilApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(movieViewModel: MovieViewModel) {

    MovieList(movieList = movieViewModel.movieListResponse)
    movieViewModel.getMovieList()



    /*Column (
        modifier = Modifier
            .padding(horizontal = 16.dp)
    ) {
        *//*Text(text = "LeafGuard",
            fontSize = 48.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(16.dp)
        )*//*

        var value by remember { mutableStateOf("") }
        val onValueChange: (String) -> Unit = {value = it}

        TextField(
            value = value,
            onValueChange = onValueChange,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),

            shape = MaterialTheme.shapes.extraLarge,
            colors = TextFieldDefaults.textFieldColors(
                unfocusedIndicatorColor = Color.Transparent,
                focusedIndicatorColor = Color.Transparent
            ),
            placeholder = {
                Text(text = "Search for a product",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal,
                    modifier = Modifier
                        .align(Alignment.CenterHorizontally)
                )
            }
        )
        Spacer(modifier = Modifier.height(16.dp))

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
        ) {
            items(
                count = 5,

                itemContent = { index ->

                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp)
                        .clip(MaterialTheme.shapes.medium)
                        .clickable { },
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        *//*Text(
                            text = "LeafGuard",
                            fontSize = 24.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(16.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))*//*
                        Image(
                            painter = rememberImagePainter(
                                data = R.drawable.leaves,
                                builder = {
                                    crossfade(true)
                                }
                            ),
                            contentDescription = "LeafGuard",
                            contentScale = ContentScale.Crop,
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(200.dp)
                        )
                        Spacer(modifier = Modifier.height(16.dp))
                        Text(
                            text = "CropGuard is an Android app that uses advanced AI to identify crop diseases from photos. It provides instant recommendations for disease management, optimizing yield and promoting sustainable farming. With a user-friendly interface and real-time updates, CropGuard equips farmers with knowledge and fosters a community of shared insights. Boost your crop's health, productivity, and sustainability with CropGuard.",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Normal,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(16.dp)
                        )
                    }
                }})
        }
    }*/
}

@Composable
fun MovieList(movieList: List<Movie>) {
    LazyColumn{
        item {
            Text(text = "Welcome to CropGuard",
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 8.dp, start =32.dp)
                ,
                color = Color.Black,
                textAlign = TextAlign.Center
            )
        }
        itemsIndexed(items = movieList) { index, movie ->
            MovieItem(movie = movie)
        }
    }
}

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
}
