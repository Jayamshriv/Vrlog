package com.example.vrlog.presentation.navgraph

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vrlog.presentation.components.BlogsListScreen
import com.example.vrlog.presentation.components.BlogPostDetailScreen

@Composable
fun NavGraph() {

    val navController = rememberNavController()

    NavHost(
        navController = navController, startDestination = Routes.BlogsListScreen.routes){
        composable(route = Routes.PostDetailScreen.routes) {
            val postModel= navController.previousBackStackEntry?.savedStateHandle?.get<String>("link")
            Log.e("roverImage", postModel.toString())
            BlogPostDetailScreen(navController,postModel)
        }

        composable(route = Routes.BlogsListScreen.routes){
            BlogsListScreen(navController = navController)
        }
    }


}