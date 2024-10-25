package com.luckyfrog.ecommerceapp.presentation.util.resource.route

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.luckyfrog.ecommerceapp.presentation.details.DetailsScreen
import com.luckyfrog.ecommerceapp.presentation.home.HomeScreen
import com.luckyfrog.ecommerceapp.presentation.main.MainViewModel

@Composable
fun NavGraph(mainViewModel: MainViewModel) {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreen.HomeScreen.route,
    ) {

        composable(route = AppScreen.HomeScreen.route) {
            HomeScreen(
                mainViewModel = mainViewModel,
                navController = navController
            )
        }

        composable(route = AppScreen.DetailsScreen.route) {
            DetailsScreen(mainViewModel)
        }
    }
}