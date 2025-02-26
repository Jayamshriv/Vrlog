package com.example.vrlog.presentation.components

import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavController
import com.example.vrlog.presentation.navgraph.Routes

@Composable
fun BlogPostDetailScreen(
    navController: NavController,
    link: String?
) {
    var isLoading by remember { mutableStateOf(true) }

    if (link    !=null){
            WebViewComponent(
                url = link,
                onPageFinished = { isLoading = false }
            )


            if (isLoading) {
                CenteredCircularProgress()
            }

    } else {

        Toast.makeText(LocalContext.current, "$link link failure", Toast.LENGTH_SHORT).show()
        navController.navigate( Routes.BlogsListScreen.routes )
    }
}

@Composable
fun WebViewComponent(url: String, onPageFinished: () -> Unit) {
    AndroidView(factory = { context ->
        WebView(context).apply {
            settings.javaScriptEnabled = true
            webViewClient = object : WebViewClient() {
                override fun onPageFinished(view: WebView?, url: String?) {
                    super.onPageFinished(view, url)
                    onPageFinished()
                }
            }
            loadUrl(url)
        }
    })
}
