package com.example.resume_arthur.model

import com.example.resume_arthur.R

class DataSource {

    fun loadSkills(): List<Skills> {
        return listOf(
                Skills("Kotlin" , R.drawable.kotlin) ,
                Skills("Android" , R.drawable.android) ,
                Skills("Git" , R.drawable.git) ,
                Skills("Java" , R.drawable.java)
        )
    }
}