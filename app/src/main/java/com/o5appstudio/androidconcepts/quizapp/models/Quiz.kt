package com.o5appstudio.androidconcepts.quizapp.models

data class Quiz(
    var id : String = "",
    var title: String = "",
    var questions: MutableMap<String,Questions> = mutableMapOf()
)