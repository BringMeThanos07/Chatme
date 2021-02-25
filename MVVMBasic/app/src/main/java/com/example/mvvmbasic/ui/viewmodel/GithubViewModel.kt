package com.example.mvvmbasic.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.mvvmbasic.data.models.Users
import com.example.mvvmbasic.data.repos.GithubRepository
import kotlinx.coroutines.*

class GithubViewModel : ViewModel() {

    val users = MutableLiveData<List<Users>>()

     fun fetchUsers(){
         viewModelScope.launch {
              val response = withContext(Dispatchers.IO){GithubRepository.getUsers()}
             if(response.isSuccessful){
                 response.body()?.let {
                     users.postValue(it)
                 }
             }
         }
        // runIO (Dispatchers.Main) {
        // }
     }

    fun searchUsers(name :String) = liveData(Dispatchers.IO){

            val response = withContext(Dispatchers.IO){GithubRepository.searchUsers(name)}
            if(response.isSuccessful){
                response.body()?.let {
                    emit(it.items)
                }
            }
        }
        // runIO (Dispatchers.Main) {
        // }
    }


fun ViewModel.runIO( dispatcher: CoroutineDispatcher = Dispatchers.IO,
                     function : suspend CoroutineScope.() -> Unit){
    viewModelScope.launch (dispatcher){
        function()
    }
}
