package com.example.cstichallenge.data.repositories

import com.example.cstichallenge.core.utils.ResourceEvent
import com.example.cstichallenge.data.local.store.AuthPreferences
import com.example.cstichallenge.data.remote.request.AuthRequestDto
import com.example.cstichallenge.data.remote.services.AuthApiService
import com.example.cstichallenge.domain.repositories.AuthRepository
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authApi : AuthApiService,
    private val preferences : AuthPreferences
) : AuthRepository {

    override suspend fun loginCallApi(loginRequest: AuthRequestDto) :ResourceEvent<Unit>{
        return try {
            val response = authApi.loginUser(loginRequest)
            preferences.saveAuthToken(response.token)
            ResourceEvent.Success(Unit)
        }catch (e: IOException){
            ResourceEvent.Error("${e.message}")
        }catch (e: HttpException){
            ResourceEvent.Error("${e.message}")
        }
    }

    override suspend fun registerCallApi(registerRequest: AuthRequestDto): ResourceEvent<Unit> {
        return try {
            val response = authApi.registerUser(registerRequest)
            preferences.saveAuthToken(response.token)
            ResourceEvent.Success(Unit)
        }catch (e: IOException){
            ResourceEvent.Error("${e.message}")
        }catch (e: HttpException){
            ResourceEvent.Error("${e.message}")
        }
    }
}