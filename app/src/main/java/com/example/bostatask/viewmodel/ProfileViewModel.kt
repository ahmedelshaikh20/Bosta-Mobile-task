package com.example.bostatask.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.bostatask.api.AppRepository
import kotlinx.coroutines.launch

class ProfileViewModel(appRepository: AppRepository) :  ViewModel(){

  init {
      viewModelScope.launch {
    val a =    appRepository.getAllUsers()
Log.d("Ahmmed" , a.toString())
      }
  }


}
// This allows us to pass tasksRepository to our viewModel
@Suppress("UNCHECKED_CAST")
class ProfileViewModelFactory (
  private val appRepository: AppRepository
) : ViewModelProvider.NewInstanceFactory() {
  override fun <T : ViewModel> create(modelClass: Class<T>) =
    (ProfileViewModel(appRepository) as T)
}
