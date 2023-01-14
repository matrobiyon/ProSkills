package com.ru.studentsroom.room

import android.app.Application

class StudentApplication : Application() {
    val database : StudentDatabase by lazy {
        StudentDatabase.getData(this)
    }
}