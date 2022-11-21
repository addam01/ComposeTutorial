package com.addam.jetpackcomposetutorial.api

import com.addam.jetpackcomposetutorial.models.PostResponse
import retrofit2.Response
import javax.inject.Inject

/**
 * Created by addam on 17/11/2022
 */
class ApiHelperImpl @Inject constructor(private val apiServices: ApiServices):ApiHelper {
    override suspend fun getPosts(): Response<List<PostResponse>>
    = apiServices.getPosts()

}