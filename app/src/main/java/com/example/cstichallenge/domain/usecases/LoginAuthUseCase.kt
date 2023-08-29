package com.example.cstichallenge.domain.usecases

import com.example.cstichallenge.data.remote.request.AuthRequestDto
import com.example.cstichallenge.domain.models.AuthResultModel
import com.example.cstichallenge.domain.repositories.AuthRepository
import javax.inject.Inject

class LoginAuthUseCase @Inject constructor(
    private val repository: AuthRepository
) {

    suspend operator fun invoke(email:String, password:String) : AuthResultModel {

        val emailError = if (email.isBlank()) "Username cannot be blank" else null
        val passwordError = if (password.isBlank()) "Password cannot be blank" else null

        if (emailError != null){
            return AuthResultModel(
                emailError = emailError
            )
        }

        if (passwordError!=null){
            return AuthResultModel(
                passwordError = passwordError
            )
        }

        val loginRequest = AuthRequestDto(
            email = email.trim(),
            password = password.trim()
        )

        return AuthResultModel(
            result = repository.loginCallApi(loginRequest)
        )
    }
}