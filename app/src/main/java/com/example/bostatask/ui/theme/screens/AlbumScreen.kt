package com.example.bostatask.ui.theme.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.bostatask.R
import com.example.bostatask.model.photos.PhotosApiResponseItem
import com.example.bostatask.navigation.Screen
import com.example.bostatask.viewmodel.AlbumViewModel
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun AlbumScreen(albumsId: Int?, navController: NavController, albumViewModel: AlbumViewModel) {
  val photos by albumViewModel.photos.collectAsState()
  LaunchedEffect(key1 =albumsId  ){
    albumViewModel.getPhotosById(albumsId)
  }

  Column {

    searchBar(onQueryChange = {
      albumViewModel.updatePhotoBasedOnSearch(it)
    })
// Then We do the grid here
    LazyVerticalGrid(
      columns = GridCells.Adaptive(minSize = 128.dp)
    ) {
      items(photos) { photo ->
        PhotoItem(modifier = Modifier.clickable {
          val encodedUrl = URLEncoder.encode(photo.url, StandardCharsets.UTF_8.toString())
          navController.navigate(Screen.ImagePreviewScreen.withArgs(encodedUrl))
        }, photo)
      }
    }
  }


}

@Composable
fun PhotoItem(modifier: Modifier = Modifier, photo: PhotosApiResponseItem) {
  AsyncImage(
    modifier = modifier,
    model = photo.url,
    contentDescription = "Icon Description",
  )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun searchBar(
  modifier: Modifier = Modifier,
  onQueryChange: (String) -> Unit
) {

  var query by remember {
    mutableStateOf("")
  }
  var isActive by remember {
    mutableStateOf(false)
  }
  SearchBar(
    modifier = modifier
      .fillMaxWidth()
      .padding(vertical = 15.dp, horizontal = 15.dp)
      .clip(RoundedCornerShape(10.dp)),

    query = query,
    onQueryChange = { newQuery ->
      query = newQuery
      onQueryChange(newQuery)
    },
    onSearch = {

    },
    active = false,
    onActiveChange = { activeChange ->
      isActive = activeChange

    },
    shape = RoundedCornerShape(10.dp),
    colors = SearchBarDefaults.colors(containerColor = colorResource(id = R.color.SearchContainerColor)),
    trailingIcon = {
      Icon(
        imageVector = Icons.Default.Search,
        contentDescription = "SearchIcon",
        tint = Color.Gray,
        modifier = Modifier.size(30.dp)
      )
    },
    placeholder = {
      Text(
        text = "Search",
        modifier = Modifier
          .fillMaxWidth()
          .size(30.dp),
        color = colorResource(id = R.color.SearchHintColor)
      )
    },
    tonalElevation = 0.dp


  ) {

  }
}
