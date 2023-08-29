package com.example.cstichallenge.data.remote.services

import com.example.cstichallenge.data.remote.request.AuthRequestDto
import com.example.cstichallenge.data.remote.response.AuthResponseDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthApiService {

    @POST("api/login")
    suspend fun loginUser(@Body loginRequest: AuthRequestDto) : AuthResponseDto


    @POST("api/register")
    suspend fun registerUser(@Body registerRequest: AuthRequestDto) : AuthResponseDto

    @GET("api/user/{id}")
    suspend fun getUserDetails()
}