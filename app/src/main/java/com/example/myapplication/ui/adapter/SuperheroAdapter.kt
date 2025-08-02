package com.example.myapplication.ui.adapter

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.myapplication.data.model.SuperheroResponse

@Composable
fun SuperheroGrid(
    superheroes: List<SuperheroResponse>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Pahlawan dan Penjahat Terpopuler",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(bottom = 12.dp)
                .align(Alignment.Start)
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(superheroes, key = { it.id ?: "" }) { superhero ->
                SuperheroItem(
                    superhero = superhero
                )
            }
        }
    }
}

@Composable
fun SuperheroItem(
    superhero: SuperheroResponse
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = rememberImagePainter(
                data = superhero.image?.url,
                builder = {
                    crossfade(true)
                }
            ),
            contentDescription = superhero.name,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .aspectRatio(1f)
                .fillMaxWidth()
        )
        Text(
            text = superhero.name ?: "Unknown",
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 8.dp)
        )
    }
}
