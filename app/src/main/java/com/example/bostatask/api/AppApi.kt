package com.example.bostatask.api

import com.example.bostatask.model.user.UsersApiResponse
import com.example.bostatask.model.user.UsersResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface AppApi {
  @GET("users")
  suspend fun getUsersByID(
    @Query("id") id: Int.Companion,
  ): Response<UsersResponseItem>
  @GET("users")
  suspend fun getUsers(): List<UsersResponseItem>


}
