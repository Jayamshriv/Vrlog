package com.example.vrlog.presentation.navgraph

sealed class Routes(
    val routes: String
) {
    data object BlogsListScreen : Routes("BlogsListScreen")
    data object PostDetailScreen : Routes("PostDetailScreen")
}