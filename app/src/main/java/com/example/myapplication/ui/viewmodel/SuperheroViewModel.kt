package com.example.myapplication.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.model.SuperheroResponse
import com.example.myapplication.repository.SuperHeroRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SuperheroViewModel @Inject constructor(
    val repository: SuperHeroRepository
): ViewModel() {
    private val _superheroes = MutableLiveData<List<SuperheroResponse>>()
    val superheroes: LiveData<List<SuperheroResponse>> get() = _superheroes

    private val apiKey = "d2d733ae959b6ae017a75570f637e593"

    fun fetchSuperheroes() {
        viewModelScope.launch {
            val data = repository.getSuperheroes(apiKey)
            _superheroes.value = data
        }
    }
}