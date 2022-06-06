package com.kotlin.example.app.model.mapper

import com.kotlin.example.app.model.User
import com.kotlin.example.app.model.request.UserRequest
import com.kotlin.example.app.model.response.UserResponse

object UserMapper {
    fun requestToUser(userRequest: UserRequest) : User {
        return User(name = userRequest.name,
        age = userRequest.age,
        doc = userRequest.doc)
    }
    fun userToResponse(user: User) : UserResponse {
        return UserResponse(name = user.name,
        age = user.age,
        doc = user.doc)
    }
    fun usersToResponse(users : List<User?>) : List<UserResponse> {
        var responseList = arrayListOf<UserResponse>()
        if(users.isEmpty())
            return responseList
        users.forEach {
            responseList.add(userToResponse(it!!))
        }
        return responseList
    }
}