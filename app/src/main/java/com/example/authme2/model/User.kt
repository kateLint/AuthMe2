package com.example.authme2.model

data class User(
    val name: String,
    val age: Int,
    val email: String,
    var pictureName: Int? = null
)