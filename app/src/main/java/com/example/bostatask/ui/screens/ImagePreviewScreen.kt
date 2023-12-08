package com.example.bostatask.ui.screens

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat.startActivity
import coil.compose.AsyncImage
import com.example.bostatask.R
import net.engawapg.lib.zoomable.rememberZoomState
import net.engawapg.lib.zoomable.zoomable


@Composable
fun ImagePreview(link: String?) {
  Column(
    modifier = Modifier
      .fillMaxSize()
      .padding(vertical = 10.dp, horizontal = 10.dp),
    verticalArrangement = Arrangement.SpaceAround,
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    AsyncImage(
      model = link, contentDescription = "Zoomable Image", modifier = Modifier
        .size(200.dp)
        .zoomable(
          rememberZoomState()
        )
    )

    Share(text = link.toString(), context = LocalContext.current)

  }
}

@Composable
fun Share(modifier: Modifier = Modifier, text: String, context: Context) {
  val sendIntent = Intent(Intent.ACTION_SEND).apply {
    putExtra(Intent.EXTRA_TEXT, text)
    type = "text/plain"
  }
  val shareIntent = Intent.createChooser(sendIntent, null)


  Button(modifier = modifier.background(colorResource(id = R.color.background)),
    colors = ButtonDefaults.buttonColors
      (containerColor = Color.Black),
    onClick = {
      startActivity(context, shareIntent, null)
    }) {
    Icon(imageVector = Icons.Default.Share, contentDescription = null)
    Text("Share", modifier = Modifier.padding(start = 8.dp))
  }
}

