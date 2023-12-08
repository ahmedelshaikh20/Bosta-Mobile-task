package com.example.bostatask.ui.screens
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.bostatask.R
import com.example.bostatask.navigation.Screen
import com.example.bostatask.viewmodel.ProfileViewModel


val mulish = FontFamily(
  Font(R.font.mulishbold, FontWeight.Bold),
  Font(R.font.mulishlight, FontWeight.Light)
)

@Composable
fun ProfileScreen(navController: NavController ,profileViewModel: ProfileViewModel= hiltViewModel()) {
  val user by profileViewModel.user.collectAsState()
  val albums by profileViewModel.albums.collectAsState()

  Column(modifier = Modifier.fillMaxWidth()) {
    profileSection(
      modifier = Modifier
        .padding(horizontal = 10.dp, vertical = 10.dp)
        .clip(RoundedCornerShape(10.dp))
        .shadow(elevation = 36.dp, spotColor = Color(0x30000000), ambientColor = Color(0x30000000)),
      name = user?.name,
      address = user?.address?.city + user?.address?.street
    )

    LazyColumn(
      verticalArrangement = Arrangement.Center,
      horizontalAlignment = Alignment.CenterHorizontally
    ) {
      items(albums) { album ->
        AlbumItem(
          modifier = Modifier
            .padding(vertical = 10.dp, horizontal = 10.dp)
            .background(
              colorResource(id = R.color.profilesectionbackground)
            ), albumName = album.title.toString() , onClick = {
              navController.navigate(Screen.AlbumScreen.withArgs("${album.id}"))
          }
        )
      }
    }
  }
}


@Composable
fun profileSection(modifier: Modifier = Modifier, name: String?, address: String?) {

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
        text = name ?: "",
        modifier = Modifier.padding(end = 10.dp, top = 10.dp, bottom = 10.dp),
        style = TextStyle(
          fontFamily = mulish,
          color = Color.White,
          fontSize = 24.sp,
          fontWeight = FontWeight.Bold
        )
      )
      Text(
        text = address ?: "",
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
fun AlbumItem(modifier: Modifier = Modifier, albumName: String , onClick : ()-> Unit) {
  Box(
    modifier = modifier
      .fillMaxWidth()
      .clip(RoundedCornerShape(10.dp))
      .clickable {
        onClick()
      }
  ) {
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



