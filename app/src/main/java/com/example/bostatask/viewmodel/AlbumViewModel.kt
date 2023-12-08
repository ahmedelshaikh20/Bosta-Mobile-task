package com.example.bostatask.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.bostatask.api.AppRepository
import com.example.bostatask.model.photos.PhotosApiResponseItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AlbumViewModel @Inject constructor(private val appRepository: AppRepository) : ViewModel() {


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
        val photoApiResponse = appRepository.getPhotoByAlbumId(albumId)
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

// This allows us to pass appRepo to our viewModel
@Suppress("UNCHECKED_CAST")
class TasksViewModelFactory(
  private val appRepository: AppRepository
) : ViewModelProvider.NewInstanceFactory() {
  override fun <T : ViewModel> create(modelClass: Class<T>) =
    (AlbumViewModel(appRepository) as T)
}
