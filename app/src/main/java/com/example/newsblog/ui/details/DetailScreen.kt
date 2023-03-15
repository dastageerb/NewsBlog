package com.example.newsblog.ui.details

import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController

@Composable
fun DetailsScreen(navHostController: NavHostController) {
    Box(modifier = Modifier.fillMaxSize()) {

        Text(text = "Helllo worls", modifier = Modifier.align(Alignment.Center))


    }

}


//        AndroidView(factory = {
//            WebView(it).apply {
//                layoutParams = ViewGroup.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.MATCH_PARENT
//                )
//                webViewClient = WebViewClient()
//                //loadUrl(mUrl)
//            }
//        }, update = {
//            it.loadUrl(mUrl)
//        })