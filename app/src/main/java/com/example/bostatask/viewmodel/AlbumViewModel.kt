package com.example.bostatask.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bostatask.api.model.photos.PhotosApiResponseItem
import com.example.bostatask.repositry.AlbumRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(private val albumRepository: AlbumRepository) :
  ViewModel() {


  private var _photos = MutableStateFlow(listOf<PhotosApiResponseItem>())
  val photos = _photos.asStateFlow()
  private var _currentAlbumPhotos = listOf<PhotosApiResponseItem>()

  fun updatePhotoBasedOnSearch(query: String) {
    val selectedPhotos = _currentAlbumPhotos.filter { photo ->
      photo.title.contains(query)
    }

    _photos.update {
      selectedPhotos
    }
  }

  fun getPhotosById(albumId: Int?) {
    viewModelScope.launch {
      if (albumId != null) {
        val photoApiResponse = albumRepository.getPhotoByAlbumId(albumId)
        if (photoApiResponse != null) {
          _currentAlbumPhotos = photoApiResponse
          _photos.update {
            _currentAlbumPhotos
          }
        }
      }
    }
  }


}

