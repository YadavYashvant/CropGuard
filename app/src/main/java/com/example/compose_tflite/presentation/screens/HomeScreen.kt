package com.example.compose_tflite.presentation.screens

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.compose_tflite.R

@OptIn(ExperimentalCoilApi::class)
@Composable
fun HomeScreen() {

    val imageUri = rememberSaveable { mutableStateOf("") }
    val painter = rememberImagePainter(
        if(imageUri.value.isNotEmpty()) {
            imageUri.value
        }
        else {
            R.drawable.instapfp
        }
    )

    val launcher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent(),
    ) {uri: Uri? ->
        uri?.let {
            imageUri.value = it.toString()
        }
    }

    Column {
        Text(
            text = "Home",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp)
                .padding(top = 40.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.onBackground,
        )

        Card(

            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 32.dp)
                .height(500.dp)
                .clip(MaterialTheme.shapes.large)
            ,

            ) {
            Image(
                painter = painter,
                contentDescription = "Leaves",
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .clickable { launcher.launch("image/*") },
                contentScale = ContentScale.Crop
            )
        }
    }
}