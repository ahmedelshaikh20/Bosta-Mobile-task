package com.example.bostatask.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bostatask.api.model.album.AlbumApiResponseItem
import com.example.bostatask.api.model.user.UsersResponseItem
import com.example.bostatask.repositry.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(private val userRepository: UserRepository) :
  ViewModel() {

  private var _user = MutableStateFlow<UsersResponseItem?>(null)
  val user = _user.asStateFlow()


  private var _albums = MutableStateFlow(listOf<AlbumApiResponseItem>())
  val albums = _albums.asStateFlow()

  private val userId = (1..10).random()

  init {
    getRandomUser(userId)
  }


  fun getRandomUser(userId: Int) {
    viewModelScope.launch {
      val userApiResponse = userRepository.getUserById(userId)
      if (userApiResponse != null) {
        _user.value = userApiResponse.get(0)
        getAllAlbums(userId)
      }
    }
  }


  private fun getAllAlbums(userId: Int) {
    viewModelScope.launch {
      val allAlbums = userRepository.getAlbumsByUserId(userId)
      if (allAlbums != null)
        _albums.update {
          allAlbums
        }
    }
  }


}

