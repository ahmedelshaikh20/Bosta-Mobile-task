package com.example.bostatask.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.bostatask.ui.screens.AlbumScreen
import com.example.bostatask.ui.screens.ImagePreview
import com.example.bostatask.ui.screens.ProfileScreen

@Composable
fun Navigation() {
  val navController = rememberNavController()
  NavHost(navController = navController, startDestination = Screen.ProfileScreen.route) {
    composable(Screen.ProfileScreen.route) {
      ProfileScreen(navController)
    }
    composable(Screen.AlbumScreen.route+"/{albumId}" ,arguments =(listOf(navArgument("albumId"){
      type = NavType.IntType
      defaultValue = 0
      nullable = false
    })) ) {entry->
      AlbumScreen(albumsId = entry.arguments?.getInt("albumId"),navController)
    }
    composable(Screen.ImagePreviewScreen.route + "/{link}", arguments = listOf(navArgument("link") {
      type = NavType.StringType
      defaultValue = ""
      nullable = true
    })) { entry ->
      ImagePreview(link = entry.arguments?.getString("link") )
    }
  }


}
