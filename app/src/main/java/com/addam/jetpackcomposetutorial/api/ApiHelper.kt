package com.addam.jetpackcomposetutorial.api

import com.addam.jetpackcomposetutorial.models.PostResponse
import retrofit2.Response

/**
 * Created by addam on 17/11/2022
 */
interface ApiHelper {
    suspend fun getPosts(): Response<List<PostResponse>>
}