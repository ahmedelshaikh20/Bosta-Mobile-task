package com.example.bostatask.repositry

import com.example.bostatask.api.AppApi
import com.example.bostatask.api.model.album.AlbumApiResponse
import com.example.bostatask.api.model.photos.PhotosApiResponse
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlbumRepository @Inject constructor(private val api: AppApi) {

  suspend fun getAllAlbums(): AlbumApiResponse? {
    return api.getAlbums().body()
  }

  suspend fun getAllPhotos(): PhotosApiResponse? {
    return api.getPhotos().body()
  }

  suspend fun getPhotoByAlbumId(albumId: Int): PhotosApiResponse? {
    return api.getPhotoByID(albumId).body()
  }
}
