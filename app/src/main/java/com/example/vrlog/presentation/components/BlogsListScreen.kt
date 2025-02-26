package com.example.vrlog.presentation.components

import android.util.Log
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.vrlog.presentation.navgraph.Routes
import com.example.vrlog.presentation.viewmodel.BlogsPostViewModel

@Composable
fun BlogsListScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
) {
    val viewModel : BlogsPostViewModel = hiltViewModel()
    LaunchedEffect(Unit) {
        viewModel.getBlogsPost(20, 1)
    }
    val blogsDataState = viewModel.blogPosts.value

    if (blogsDataState.isLoading or blogsDataState.error.isNotEmpty()) {
        CenteredCircularProgress()
        Log.e("MAIN Activity", blogsDataState.toString())
    } else {

        LazyColumn {
            items(
                blogsDataState.post
            ) { data ->
                BlogsPostCard(
                    post = data
                ) { link ->
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        "link",
                        link
                    )
                    navController.navigate(Routes.PostDetailScreen.routes)
                }
            }
        }

    }
}
