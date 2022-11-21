package com.addam.jetpackcomposetutorial.api

import com.addam.jetpackcomposetutorial.models.PostResponse
import retrofit2.Response
import retrofit2.http.GET

/**
 * Created by addam on 17/11/2022
 */
interface ApiServices {
//    @GET("employees")
//    suspend fun getEmployees(): Response<EmployeeResponse>

    @GET("posts")
    suspend fun getPosts(): Response<List<PostResponse>>
}