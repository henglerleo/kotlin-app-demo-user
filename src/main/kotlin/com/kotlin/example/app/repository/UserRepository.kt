package com.kotlin.example.app.repository

import com.kotlin.example.app.model.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByDoc(doc: Long) : User?
}