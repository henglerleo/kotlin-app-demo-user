package com.kotlin.example.app.model.response

data class UserResponse(
    val name: String,
    val age: Int,
    val doc: Long,
    val field: String = "Default"
)
