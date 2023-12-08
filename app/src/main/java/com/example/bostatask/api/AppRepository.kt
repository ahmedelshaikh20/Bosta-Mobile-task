package com.example.bostatask.api

import com.example.bostatask.model.album.AlbumApiResponse
import com.example.bostatask.model.photos.PhotosApiResponse
import com.example.bostatask.model.user.UsersApiResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AppRepository @Inject constructor(private val api: AppApi) {
  suspend fun getAllUsers():UsersApiResponse? {
    return api.getUsers().body()
  }

  suspend fun getAllAlbums(): AlbumApiResponse? {
    return api.getAlbums().body()
  }
  suspend fun getAlbumsByUserId(userId : Int): AlbumApiResponse? {
    return api.getAlbums(userId).body()
  }
  suspend fun getUserById(id : Int): UsersApiResponse? {
    return api.getUsersByID(id).body()
  }

  suspend fun getAllPhotos(): PhotosApiResponse? {
    return api.getPhotos().body()
  }
  suspend fun getPhotoByAlbumId(albumId : Int): PhotosApiResponse? {
    return api.getPhotoByID(albumId).body()
  }
}
