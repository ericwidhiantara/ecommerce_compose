package com.luckyfrog.ecommerceapp.presentation.details

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.luckyfrog.ecommerceapp.presentation.main.MainViewModel

@Composable
fun DetailsScreen(
    mainViewModel: MainViewModel,
    viewModel: DetailsViewModel = hiltViewModel()
) {

    Text(text = "DetailsScreen", color = MaterialTheme.colorScheme.onBackground)
}