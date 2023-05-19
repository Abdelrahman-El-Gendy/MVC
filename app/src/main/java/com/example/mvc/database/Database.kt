package com.example.mvc.database

import com.example.mvc.data.User

class Database {
    companion object Database {
        fun getCurrentUser(): User {
            return User("Abdelrahman", "12345")
        }
    }

}