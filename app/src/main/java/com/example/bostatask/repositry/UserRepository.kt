package com.example.bostatask.repositry

import com.example.bostatask.api.AppApi
import com.example.bostatask.api.model.album.AlbumApiResponse
import com.example.bostatask.api.model.user.UsersApiResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository @Inject constructor(private val api: AppApi) {
  suspend fun getAllUsers(): UsersApiResponse? {
    return api.getUsers().body()
  }

  suspend fun getAlbumsByUserId(userId : Int): AlbumApiResponse? {
    return api.getAlbums(userId).body()
  }
  suspend fun getUserById(id : Int): UsersApiResponse? {
    return api.getUsersByID(id).body()
  }

}
