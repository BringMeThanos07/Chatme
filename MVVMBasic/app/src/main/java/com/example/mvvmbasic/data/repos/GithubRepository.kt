package com.example.mvvmbasic.data.repos

import com.example.mvvmbasic.data.api.client

object GithubRepository {
    suspend fun getUsers() =  client.api.getUsers()


    suspend fun searchUsers(name:String) =  client.api.searchUser(name)
}