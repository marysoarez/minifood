package com.marysoarez.minifood

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.marysoarez.minifood.domain.repository.FakeRestaurantRepository
import com.marysoarez.minifood.domain.usecases.GetRestaurantsUseCase
import com.marysoarez.minifood.presentation.navigation.NavGraph
import com.marysoarez.minifood.presentation.screen.home.HomeViewModel
import com.marysoarez.minifood.ui.theme.MinifoodTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val repository = FakeRestaurantRepository()
        val getRestaurantsUseCase = GetRestaurantsUseCase(repository)
        val homeViewModel = HomeViewModel(getRestaurantsUseCase)

        setContent {
            MinifoodTheme {
                NavGraph()
            }
        }
    }
}
