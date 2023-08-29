package com.example.cstichallenge.data.remote.response

import com.google.gson.annotations.SerializedName

data class AuthResponseDto(
    @SerializedName("token")
    val token : String
)