package com.example.bostatask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import com.example.bostatask.ui.theme.BostaTaskTheme
<<<<<<< HEAD
import com.example.bostatask.ui.theme.screens.AlbumDetailScreen
=======
>>>>>>> main
import com.example.bostatask.ui.theme.screens.ProfileScreen

class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      BostaTaskTheme {
        // A surface container using the 'background' color from the theme
        Box(
          modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),

          ) {
          Image(
            painter = painterResource(id = R.drawable.topography),
            contentDescription = "Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
              .matchParentSize()
              .background(colorResource(id = R.color.background))
          )
          ProfileScreen()
        }
      }
    }
  }
}


