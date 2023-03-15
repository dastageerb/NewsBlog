package com.example.newsblog.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.rememberAsyncImagePainter
import com.example.newsblog.data.model.NewsArticle
import com.example.newsblog.data.model.NewsResponse
import com.example.newsblog.ui.Destination
import com.example.newsblog.ui.HomeViewModel
import com.example.newsblog.util.ApiResponse

@Composable
fun HomeScreen(viewModel: HomeViewModel, navHostController: NavHostController) {

    LaunchedEffect(viewModel.loadApi) {
        viewModel.searchHeadlines("tech")
    }

    val viewState by remember(viewModel) { viewModel.newsResponse }.collectAsState()

    Box(modifier = Modifier.fillMaxSize()
    ) {
        when(viewState) {
            is ApiResponse.Loading -> {
                ProgressBarView(Modifier.align(Alignment.BottomCenter))
            }
            is ApiResponse.Success -> {
                LoadNewsArticles((viewState as ApiResponse.Success<NewsResponse>).data, navHostController)
            }
            is ApiResponse.Error -> {

            }
        }
    }
}

@Composable
fun LoadNewsArticles(response: NewsResponse,navHostController: NavHostController) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(), state = rememberLazyListState()
    ) {
        itemsIndexed(response.newsArticles) { index, article ->
            NewsArticleView(article,navHostController)
        }
    }
}

@Composable
fun ProgressBarView(modifier: Modifier) {
        CircularProgressIndicator(
            modifier = modifier,
            color = MaterialTheme.colors.secondary)
}


@Composable
fun NewsArticleView(article: NewsArticle,navHostController: NavHostController) {
    Row (modifier = Modifier.clickable {
            navHostController.navigate(Destination.DetailScreen.route)
    }) {
        Image(
            painter = rememberAsyncImagePainter(article.urlToImage),
            contentDescription = null,
            alignment = Alignment.CenterStart,
            modifier = Modifier
                .width(100.dp)
                .height(100.dp)
        )
        article.title?.let {
            Text(text = it)
        }
    }
}

