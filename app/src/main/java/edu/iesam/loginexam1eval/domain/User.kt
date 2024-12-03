package edu.iesam.loginexam1eval.domain

data class User(
    val id: String,
    val username:String,
    val password: String,
    val rememberMe: Boolean
)