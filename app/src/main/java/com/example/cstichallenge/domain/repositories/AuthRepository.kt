package com.example.cstichallenge.domain.repositories

import com.example.cstichallenge.core.utils.ResourceEvent
import com.example.cstichallenge.data.remote.request.AuthRequestDto

interface AuthRepository {
    suspend fun loginCallApi(loginRequest: AuthRequestDto): ResourceEvent<Unit>
    suspend fun registerCallApi(registerRequest: AuthRequestDto): ResourceEvent<Unit>
}