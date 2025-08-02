package com.example.myapplication.data.network

import com.example.myapplication.data.model.SuperheroResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("api/{api-key}/{id}")
    suspend fun getSuperhero(
        @Path("api-key") apiKey: String,
        @Path("id") id: String
    ): Response<SuperheroResponse>
}