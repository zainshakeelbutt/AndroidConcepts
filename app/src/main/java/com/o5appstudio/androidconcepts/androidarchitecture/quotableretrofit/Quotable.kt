package com.o5appstudio.androidconcepts.androidarchitecture.quotableretrofit

data class Quotable(
    val count: Int,
    val lastItemIndex: Int,
    val page: Int,
    val results: List<Result>,
    val totalCount: Int,
    val totalPages: Int
)