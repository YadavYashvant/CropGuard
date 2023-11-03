package com.example.compose_tflite.presentation.screens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import coil.annotation.ExperimentalCoilApi

/*const val BASE_URL = "https://poetrydb.org/author,title/"*/

import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.compose_tflite.plantsApi_feature.model.Movie
import com.example.compose_tflite.plantsApi_feature.model.expTrefle.Plant
import com.example.compose_tflite.plantsApi_feature.model.expTrefle.PlantData
import com.example.compose_tflite.plantsApi_feature.view.MovieItem
import com.example.compose_tflite.plantsApi_feature.viewModel.MovieViewModel
import com.example.compose_tflite.ui.theme.ComposetfliteTheme

@OptIn(ExperimentalCoilApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(movieViewModel: MovieViewModel) {
    MovieList(movieList = movieViewModel.movieListResponse)
    movieViewModel.getMovieList()
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieList(movieList: List<Movie>) {
    LazyColumn{
        item {
            /*Text(text = "Welcome to CropGuard",
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 8.dp, start =32.dp)
                ,
                color = Color.Black,
                textAlign = TextAlign.Center
            )*/
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                var value by remember { mutableStateOf("") }
                val onValueChange: (String) -> Unit = { newValue ->
                    value = newValue
                }
                TextField(
                    value = value,
                    onValueChange = onValueChange,
                    shape = MaterialTheme.shapes.extraLarge,
                    placeholder = {
                        Text(
                            text = "Search Here",
                            /*Modifier.align(Alignment.CenterVertically),
                            fontFamily = com.example.codev.spacefamily,*/
                            textAlign = TextAlign.Center,
                        )
                    },
                    modifier = Modifier
                        /*.align(Alignment.CenterVertically)*/
                        .fillMaxWidth()
                        .padding(16.dp)
                    ,
                    colors = TextFieldDefaults.textFieldColors(
                        unfocusedIndicatorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent
                    ),
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Search, contentDescription = null,
                            Modifier
                                .scale(1.3F)
                                .padding(10.dp)
                        )
                    },
                )

                val chipList = listOf("Latest", "Popular", "Top Rated", "Upcoming", "Now Playing", "Trending")
                val scrollstate = rememberScrollState()
                Row(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .paddingFromBaseline(bottom = 16.dp)
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .horizontalScroll(scrollstate)
                ) {
                    for (i in 0..5) {
                        FilterChipHome(chipList[i])
                    }
                }
            }
        }
        itemsIndexed(items = movieList) { index, movie ->
            /*MovieItem(movie = movie)*/
            DummyItem()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterChipHome(
    filterText: String
) {
    var selected by remember { mutableStateOf(false) }

    FilterChip(
        onClick = { selected = !selected },
        label = {
            Text(filterText)
        },
        selected = selected,
        leadingIcon = if (selected) {
            {
                Icon(
                    imageVector = Icons.Filled.Done,
                    contentDescription = "Done icon",
                    modifier = Modifier.size(FilterChipDefaults.IconSize)
                )
            }
        } else {
            null
        },
        modifier = Modifier.padding(horizontal = 4.dp)
    )
}