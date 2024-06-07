package com.o5appstudio.androidconcepts.mvvmpractice.usersapi.model

data class UsersItem(
    val address: Address,
    val company: Company,
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val username: String,
    val website: String
)