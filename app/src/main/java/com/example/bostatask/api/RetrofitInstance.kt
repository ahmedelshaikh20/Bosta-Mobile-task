package com.example.bostatask.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


// We add Http Logging to Log the requests
val logging = HttpLoggingInterceptor().apply {
  this.level = HttpLoggingInterceptor.Level.BODY
};
var client = OkHttpClient.Builder()
  .addInterceptor(logging)
  .build()

object RetrofitInstance {
  val api: AppApi by lazy {
    Retrofit.Builder()
      .baseUrl(Constants.base_url)
      .addConverterFactory(GsonConverterFactory.create())
      .client(client)
      .build()
      .create(AppApi::class.java)
  }
}



