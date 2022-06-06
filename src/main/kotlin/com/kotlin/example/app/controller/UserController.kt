package com.kotlin.example.app.controller

import com.kotlin.example.app.model.request.UserRequest
import com.kotlin.example.app.model.response.UserResponse
import com.kotlin.example.app.service.UserService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("user")
class UserController (
    private val userService: UserService
) {
    @PostMapping
    fun create(@RequestBody userRequest: UserRequest) : UserResponse {
        return userService.saveUser(userRequest)
    }

    @GetMapping
    fun findAll() : List<UserResponse> {
        return userService.findAll()
    }

    @GetMapping("/{doc}")
    fun findUser(@PathVariable doc: Long) : UserResponse {
        return userService.findUser(doc)
    }

    @PutMapping("/{doc}")
    fun updateUser(@PathVariable doc: Long, @RequestBody userRequest: UserRequest) : UserResponse {
        return userService.updateUser(userRequest)
    }

    @DeleteMapping("/{doc}")
    fun deleteUser(@PathVariable doc: Long) : UserResponse {
        return userService.deleteUser(doc)
    }
}