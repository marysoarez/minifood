package com.marysoarez.minifood.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument

import com.marysoarez.minifood.domain.repository.FakeProductRepository
import com.marysoarez.minifood.domain.repository.FakeRestaurantRepository

import com.marysoarez.minifood.domain.usecases.GetProductsByRestaurant
import com.marysoarez.minifood.domain.usecases.GetRestaurantsUseCase
import com.marysoarez.minifood.presentation.screen.home.HomeScreen
import com.marysoarez.minifood.presentation.screen.home.HomeViewModel
import com.marysoarez.minifood.presentation.screen.product.ProductListScreen
import com.marysoarez.minifood.presentation.screen.product.ProductListViewModel
import com.marysoarez.minifood.presentation.viewmodel.CartViewModel


object Routes {
    const val HOME = "home"
    const val PRODUCTS = "products/{restaurantId}"
}

@Composable
fun NavGraph(cartViewModel: CartViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.HOME) {

        composable(Routes.HOME) {
            val viewModel = HomeViewModel(GetRestaurantsUseCase(FakeRestaurantRepository()))
            HomeScreen(viewModel) { restaurantId ->
                navController.navigate("products/$restaurantId")
            }
        }

        composable(
            route = Routes.PRODUCTS,
            arguments = listOf(navArgument("restaurantId") { type = NavType.StringType })
        ) { backStackEntry ->
            val restaurantId = backStackEntry.arguments?.getString("restaurantId") ?: ""
            val viewModel = ProductListViewModel(
                GetProductsByRestaurant(FakeProductRepository()),
                restaurantId
            )
            ProductListScreen(viewModel, cartViewModel)
        }
    }
}
