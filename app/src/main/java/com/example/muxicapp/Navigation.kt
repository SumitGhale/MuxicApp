package com.example.muxicapp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Navigation(navController: NavHostController) {
    val context = LocalContext.current
    val viewModel = remember {
        SongLIstViewModel(context)
    }
    NavHost(navController, startDestination = Screen.ArtistScreen.route) {
        composable(Screen.ArtistScreen.route) {
            ArtistScreen(){artistName->
                navController.currentBackStackEntry?.savedStateHandle?.set("artistName", artistName)
                navController.navigate(Screen.SongListScreen.route)
            }
        }
        composable(Screen.SongListScreen.route) {
            val artistName = navController.previousBackStackEntry?.savedStateHandle?.get<String>("artistName") ?: "eminem"
            SongLists(artistName, viewModel = viewModel)
        }
    }
}