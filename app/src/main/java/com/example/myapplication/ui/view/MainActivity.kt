package com.example.myapplication.ui.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.myapplication.ui.adapter.SuperheroGrid
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.ui.viewmodel.SuperheroViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                val viewModel: SuperheroViewModel = hiltViewModel()

                val superheroes = viewModel.superheroes.observeAsState(initial = emptyList())

                LaunchedEffect(Unit) {
                    viewModel.fetchSuperheroes()
                }

                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SuperheroGrid(
                        superheroes = superheroes.value,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
