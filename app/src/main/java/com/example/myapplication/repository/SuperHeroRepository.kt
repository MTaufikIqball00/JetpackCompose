package com.example.myapplication.repository

import com.example.myapplication.data.model.SuperheroResponse
import com.example.myapplication.data.network.ApiService
import javax.inject.Inject

class SuperHeroRepository @Inject constructor(
    private val apiService: ApiService
) {
    suspend fun getSuperheroes(apiKey: String): List<SuperheroResponse> {
        val superheroes = mutableListOf<SuperheroResponse>()
        for (i in 1..10) {
            val randomId = (1..731).random()
            val response = apiService.getSuperhero(apiKey, randomId.toString())
            if (response.isSuccessful) {
                response.body()?.let { superheroes.add(it) }
            }
        }
        return superheroes
    }
}