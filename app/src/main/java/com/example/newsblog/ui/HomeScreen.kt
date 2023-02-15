package com.example.newsblog.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.navigation.NavHostController
import com.example.newsblog.data.model.NewsResponse
import com.example.newsblog.util.ApiResponse

@Composable
fun HomeScreen(viewModel: HomeViewModel,navHostController: NavHostController) {

    LaunchedEffect(viewModel.loadApi) {
        viewModel.getHeadlines()
    }

    val viewState by remember(viewModel) { viewModel.newsResponse }.collectAsState(initial = ApiResponse.Loading())

    Box(modifier = Modifier.fillMaxSize()
    ) {

        ProgressBarView(viewState is ApiResponse.Loading,Modifier.align(Alignment.BottomCenter))

        LoadNewsArticles(viewState is ApiResponse.Success,(viewState as ApiResponse.Success).data)



    }
}

@Composable
fun LoadNewsArticles(isSuccess: Boolean, response: NewsResponse) {
    if (isSuccess) {

    }
}

@Composable
fun ProgressBarView(isLoading: Boolean,modifier: Modifier) {
    if (isLoading) {
        CircularProgressIndicator(
            modifier = modifier,
            color = MaterialTheme.colors.secondary)
    }
}
