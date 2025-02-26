package com.example.vrlog

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.vrlog.presentation.navgraph.NavGraph
import com.example.vrlog.presentation.ui.theme.VrlogTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private lateinit var navController : NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            VrlogTheme {
                Box(modifier = Modifier
                    .fillMaxSize()
                ) {
                    NavGraph()
                }
            }
        }
    }
}
