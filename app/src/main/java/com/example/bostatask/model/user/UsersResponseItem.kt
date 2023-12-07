package com.example.bostatask.model.user

import com.example.bostatask.model.user.Address
import com.example.bostatask.model.user.Company

data class UsersResponseItem(
  val address: Address,
  val company: Company,
  val email: String,
  val id: Int,
  val name: String,
  val phone: String,
  val username: String,
  val website: String
)
