package com.example.compose_tflite.plantsApi_feature.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.base.R
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.compose_tflite.plantsApi_feature.model.Movie

@Composable
fun MovieItem(movie: Movie) {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(200.dp), shape = RoundedCornerShape(8.dp), /*elevation = 4.dp*/
    ) {
        Surface() {
            Card(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .defaultMinSize(minHeight = 200.dp)
                    .fillMaxSize(),
                shape = RoundedCornerShape(8.dp),
            ) {
                Row(
                    Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                ) {

                    Image(
                        painter = rememberImagePainter(
                            data = movie.imageUrl,

                            builder = {
                                scale(Scale.FILL)
                                placeholder(R.drawable.notification_action_background)
                                transformations(CircleCropTransformation())

                            }
                        ),
                        contentDescription = movie.desc,
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(0.2f)
                    )


                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(4.dp)
                            .fillMaxHeight()
                            .weight(0.8f)
                    ) {
                        Text(
                            text = movie.name,
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            text = movie.category,
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .background(
                                    Color.LightGray,
                                    shape = RoundedCornerShape(5.dp)
                                )
                                .padding(4.dp)
                        )
                        Text(
                            text = movie.desc,
                            style = MaterialTheme.typography.bodySmall,
                            overflow = TextOverflow.Ellipsis
                        )

                    }
                }
            }
        }
    }

}