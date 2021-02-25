package com.example.mvvmbasic.data.api

import com.example.mvvmbasic.data.models.SearchResponse
import com.example.mvvmbasic.data.models.Users
import com.google.gson.JsonObject
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubService {
        @GET("users")
        suspend fun getUsers(): Response<List<Users>>
        @GET("search/users")
        suspend fun searchUser(@Query("q") name : String) : Response<SearchResponse>
}
