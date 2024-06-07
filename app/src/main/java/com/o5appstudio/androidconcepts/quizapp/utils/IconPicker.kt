package com.o5appstudio.androidconcepts.quizapp.utils

import com.o5appstudio.androidconcepts.R

object IconPicker {

    val icons = arrayOf(
        R.drawable.quiz_ic1,
        R.drawable.quiz_ic2,
        R.drawable.quiz_ic3,
        R.drawable.quiz_ic4,
        R.drawable.quiz_ic5,
    )
    var currentIconIndex = 0

    fun getIcons(): Int {
        currentIconIndex = (currentIconIndex + 1) % icons.size
        return icons[currentIconIndex]
    }

}