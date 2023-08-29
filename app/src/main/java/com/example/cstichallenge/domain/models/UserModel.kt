package com.example.cstichallenge.domain.models

import com.example.cstichallenge.data.models.DataDto
import com.example.cstichallenge.data.models.SupportDto

data class UserModel (
    var data: DataDto,
    var support: SupportDto
)