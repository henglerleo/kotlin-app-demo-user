package com.kotlin.example.app.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "user", schema = "userSchema")
data class User(
    @Id @GeneratedValue
    val id: Long? = null,
    var name: String,
    var age: Int,
    val doc: Long
)
