package com.example.compose_tflite.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.base.R
import coil.compose.rememberImagePainter
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.example.compose_tflite.plantsApi_feature.model.Movie

//"https://www.familyhandyman.com/wp-content/uploads/2020/04/Powdery-Mildew-GettyImages-1090508010.jpg?fit=696%2C696?fit=700,700"


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Surface
import androidx.compose.material3.Text

import androidx.compose.ui.draw.clip

import androidx.compose.ui.unit.dp

import coil.compose.rememberImagePainter

import com.example.compose_tflite.plantsApi_feature.model.expTrefle.Plant
import com.example.compose_tflite.plantsApi_feature.model.expTrefle.PlantData

@OptIn(ExperimentalCoilApi::class)
@Composable
fun DummyItem() {
    Card(
        modifier = Modifier
            .padding(8.dp, 4.dp)
            .fillMaxWidth()
            .height(600.dp), shape = RoundedCornerShape(16.dp), /*elevation = 4.dp*/
    ) {
        Surface {


            Card(
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
                    .defaultMinSize(minHeight = 200.dp)
                    .fillMaxSize()
                    .clickable { },
                shape = RoundedCornerShape(16.dp),
            ) {
                Row(
                    Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                ) {
                    Image(
                        painter = rememberImagePainter(
                            data = "https://www.familyhandyman.com/wp-content/uploads/2020/04/Powdery-Mildew-GettyImages-1090508010.jpg?fit=696%2C696?fit=700,700",

                            builder = {
                                scale(Scale.FILL)
                                placeholder(R.drawable.notification_action_background)
                                transformations(CircleCropTransformation())
                            }
                        ),
                        contentDescription = null,
                        modifier = Modifier
                            .fillMaxHeight()
                            .weight(0.2f)
                            .padding(4.dp)

                    )

                    Column(
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .padding(horizontal = 5.dp, vertical = 4.dp)
                            .fillMaxHeight()
                            .weight(0.8f)
                    ) {
                        Text(
                            text = "Disease",
                            style = MaterialTheme.typography.bodyLarge,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(bottom = 4.dp)
                        )
                        Text(
                            text = "Solution: Rake up and destroy infected leaves to reduce the spread of spores. Also, give plants good drainage and ample air circulation. Avoid overhead watering at night; mid-morning is preferred to allow foliage to dry before evening. Commercial fungicides are available for powdery mildew, or you can spray with a solution of one tsp. baking soda and one quart of water as recommended by George “Doc” and Katy Abraham, authors of The Green Thumb Garden Handbook.\n" +
                                    "\n" +
                                    "Lilac, a highly aromatic plant, is a common victim of powdery mildew.",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier
                                .background(
                                    Color.LightGray,
                                    shape = RoundedCornerShape(16.dp)
                                )
                                .padding(horizontal = 8.dp, vertical = 8.dp)
                        )
                        Text(
                            text = "Problem:  Powdery mildew leaves a telltale white dusty coating on leaves, stems and flowers. Caused by a fungus, it affects a number of plants, including lilacs, apples, grapes, cucumbers, peas, phlox, daisies and roses.",
                            style = MaterialTheme.typography.bodySmall,
                            overflow = TextOverflow.Ellipsis,
                            modifier = Modifier.padding(top = 10.dp)
                        )
                    }
                }
            }
        }
    }
}

/*text = "Solution: Rake up and destroy infected leaves to reduce the spread of spores. Also, give plants good drainage and ample air circulation. Avoid overhead watering at night; mid-morning is preferred to allow foliage to dry before evening. Commercial fungicides are available for powdery mildew, or you can spray with a solution of one tsp. baking soda and one quart of water as recommended by George “Doc” and Katy Abraham, authors of The Green Thumb Garden Handbook.\n" +
                                    "\n" +
                                 "Lilac, a highly aromatic plant, is a common victim of powdery mildew.",*/
/*
text = "Problem:  Powdery mildew leaves a telltale white dusty coating on leaves, stems and flowers. Caused by a fungus, it affects a number of plants, including lilacs, apples, grapes, cucumbers, peas, phlox, daisies and roses.",
 */