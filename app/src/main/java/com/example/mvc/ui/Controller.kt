package com.example.mvc.ui


import com.example.mvc.database.Database.Database.getCurrentUser

class Controller {
    fun login(userName: String?, password: String?): Int {
        return if (userName == getCurrentUser().userName &&
            password == getCurrentUser().password
        ) 1
        else 0

    }
}