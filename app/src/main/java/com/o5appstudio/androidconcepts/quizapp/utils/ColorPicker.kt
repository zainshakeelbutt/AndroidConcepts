package com.o5appstudio.androidconcepts.quizapp.utils

object ColorPicker {

    val colors = arrayOf(
        "#B1ACFF",
        "#ACE9FF",
        "#ACFFD7",
        "#F3ACFF",
        "#FFACEF",
        "#F188A2",
        "#88F1DF",
        "#187B6B",
        "#27084A",
        "#490596"
    )
    var currentColorIndex = 0

    fun getColor(): String {
        currentColorIndex = (currentColorIndex + 1) % colors.size
        return colors[currentColorIndex]
    }

}