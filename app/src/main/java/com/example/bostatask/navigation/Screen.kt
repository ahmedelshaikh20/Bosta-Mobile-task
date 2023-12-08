package com.example.bostatask.navigation

sealed class Screen (val route: String) {
  object ProfileScreen : Screen("profile_screen")
  object AlbumScreen : Screen("album_screen")

  object ImagePreviewScreen : Screen("image_preview_screen")


  fun withArgs (vararg args: String):String{
    return buildString {
      append(route)
      args.forEach {arg->
        append(("/$arg"))
      }
    }
  }

}
