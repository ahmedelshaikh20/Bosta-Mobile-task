package com.example.bostatask.di

import com.example.bostatask.api.AppApi
import com.example.bostatask.api.RetrofitInstance
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class AppRepoModule() {

  @Provides
  fun provideApi() : AppApi{
    return RetrofitInstance.api
  }

}
