package com.example.bostatask.api

import com.example.bostatask.api.model.album.AlbumApiResponse
import com.example.bostatask.api.model.photos.PhotosApiResponse
import com.example.bostatask.api.model.user.UsersApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AppApi {
  @GET("users")
  suspend fun getUsersByID(
    @Query("id") id: Int,
  ): Response<UsersApiResponse?>

  @GET("users")
  suspend fun getUsers(): Response<UsersApiResponse?>

  @GET("albums")
  suspend fun getAlbums(): Response<AlbumApiResponse?>

  @GET("albums")
  suspend fun getAlbums(@Query("userId") userId: Int): Response<AlbumApiResponse?>

  @GET("photos")
  suspend fun getPhotos(): Response<PhotosApiResponse?>


  @GET("photos")
  suspend fun getPhotoByID(
    @Query("albumId") albumId: Int,
  ): Response<PhotosApiResponse?>
}
