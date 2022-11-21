package com.addam.jetpackcomposetutorial.repository

import com.addam.jetpackcomposetutorial.api.ApiHelper
import javax.inject.Inject

/**
 * Created by addam on 17/11/2022
 */
class MainRepository @Inject constructor(
    private val apiHelper: ApiHelper
){
    suspend fun getPosts() = apiHelper.getPosts()
}