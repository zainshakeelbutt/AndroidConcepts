package com.o5appstudio.androidconcepts.mvvmpractice.usersapi.model

data class Address(
    val city: String,
    val geo: Geo,
    val street: String,
    val suite: String,
    val zipcode: String
)