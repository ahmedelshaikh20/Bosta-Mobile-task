package com.example.bostatask.api

import com.example.bostatask.model.user.UsersResponseItem

class AppRepository(private val api: AppApi) {
  suspend fun getAllUsers():List<UsersResponseItem>? {
    return api.getUsers()
  }

  suspend fun getUserById(id : Int): UsersResponseItem? {
    return api.getUsersByID(Int).body()
  }
}
