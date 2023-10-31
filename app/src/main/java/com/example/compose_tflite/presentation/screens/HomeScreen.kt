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
import androidx.compose.ui.tooling.preview.Preview
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

@Preview
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
