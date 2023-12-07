package com.example.bostatask.ui.theme.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
<<<<<<< HEAD
=======
import androidx.compose.foundation.lazy.itemsIndexed
>>>>>>> main
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bostatask.R
<<<<<<< HEAD
import com.example.bostatask.api.AppRepository
import com.example.bostatask.api.RetrofitInstance
import com.example.bostatask.viewmodel.ProfileViewModel
=======
>>>>>>> main


val mulish = FontFamily(
  Font(R.font.mulishbold, FontWeight.Bold),
  Font(R.font.mulishlight, FontWeight.Light)
)

@Composable
fun ProfileScreen() {
<<<<<<< HEAD
val ProfileViewModel = ProfileViewModel(appRepository = AppRepository(RetrofitInstance.api))
=======

>>>>>>> main
  Column(modifier = Modifier.fillMaxWidth()) {
    profileSection(
      modifier = Modifier
        .padding(horizontal = 10.dp, vertical = 10.dp)
        .clip(RoundedCornerShape(10.dp))
        .shadow(elevation = 36.dp, spotColor = Color(0x30000000), ambientColor = Color(0x30000000)),
      name = "Ahmed",
      address = "El rehab Cairo Egypt "
    )

    LazyColumn(
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      items(1) {
        AlbumItem(
          modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 10.dp)
            .background(
              colorResource(id = R.color.profilesectionbackground)
            ), albumName = "Ahmed Salah"
        )
      }
    }
  }
}


@Composable
fun profileSection(modifier: Modifier = Modifier, name: String, address: String) {

  Row(
    modifier = modifier
      .fillMaxWidth()
      .background(color = colorResource(id = R.color.black)),
    verticalAlignment = Alignment.CenterVertically,
    horizontalArrangement = Arrangement.SpaceBetween

  ) {
    Image(
      painter = painterResource(id = R.drawable.ic_launcher_foreground),
      contentDescription = "Profile Image",
      modifier = Modifier
        .padding(vertical = 10.dp, horizontal = 10.dp)
        .border(
          width = 1.dp,
          color = Color.Gray,
          shape = CircleShape
        )
        .clip(CircleShape),
      alignment = Alignment.TopStart
    )
    Column(
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      Text(
        text = name,
        modifier = Modifier.padding(end = 10.dp, top = 10.dp, bottom = 10.dp),
        style = TextStyle(
          fontFamily = mulish,
          color = Color.White,
          fontSize = 24.sp,
          fontWeight = FontWeight.Bold
        )
      )
      Text(
        text = address,
        modifier = Modifier.padding(end = 10.dp, top = 10.dp, bottom = 10.dp),
        style = TextStyle(
          color = Color.White,
          fontFamily = mulish,
          fontWeight = FontWeight.Light,
          fontSize = 15.sp
        )
      )
    }
  }

}


@Composable
fun AlbumItem(modifier: Modifier = Modifier, albumName: String) {
  Box(modifier = modifier
    .fillMaxWidth()
    .clip(RoundedCornerShape(10.dp))) {


    Text(
      text = albumName,
      modifier = Modifier.padding(vertical = 10.dp, horizontal = 10.dp),
      style = TextStyle(
        color = Color.White,
        fontFamily = mulish,
        fontWeight = FontWeight.Light,
        fontSize = 20.sp
      )
    )
  }


}



