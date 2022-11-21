package com.addam.jetpackcomposetutorial.features.posts

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.addam.jetpackcomposetutorial.models.PostResponse
import com.addam.jetpackcomposetutorial.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * Created by addam on 17/11/2022
 */
@HiltViewModel
class PostsViewModel @Inject constructor(
    private val mainRepository: MainRepository
): ViewModel()  {

    private val _data: MutableList<PostResponse> = mutableStateListOf()
    val data: List<PostResponse> = _data

    fun getEmployees()  = viewModelScope.launch {
        mainRepository.getPosts().let {
            if (it.isSuccessful){
                if(it.body()!!.isNotEmpty()){
                    _data.clear()
                }
                _data.addAll(it.body()!!)
            }
        }
    }
}