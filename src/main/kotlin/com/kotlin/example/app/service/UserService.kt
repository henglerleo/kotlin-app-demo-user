package com.kotlin.example.app.service

import com.kotlin.example.app.model.mapper.UserMapper
import com.kotlin.example.app.model.request.UserRequest
import com.kotlin.example.app.model.response.UserResponse
import com.kotlin.example.app.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    val userRepository: UserRepository
) {
    fun saveUser(userRequest: UserRequest) : UserResponse {
        if(userRepository.findByDoc(userRequest.doc) == null) {
            val user = userRepository.save(UserMapper.requestToUser(userRequest))
            return UserMapper.userToResponse(user)
        } else {
            throw Exception("user.already.exists")
        }
    }

    fun updateUser(userRequest: UserRequest) : UserResponse {
        var userFound = userRepository.findByDoc(userRequest.doc)
        if(userFound == null) {
            throw Exception("user.not.found")
        } else {
            userFound.name = userRequest.name
            userFound.age = userRequest.age
            return UserMapper.userToResponse(userRepository.save(userFound))
        }
    }

    fun findUser(doc: Long) : UserResponse {
        val user = userRepository.findByDoc(doc)
        if (user == null) {
            throw Exception("user.not.found")
        } else {
            return UserMapper.userToResponse(user)
        }
    }

    fun deleteUser(doc: Long) : UserResponse {
        val user = userRepository.findByDoc(doc)
        if (user == null) {
            throw Exception("user.not.found")
        } else {
            userRepository.delete(user)
            return UserMapper.userToResponse(user)
        }
    }

    fun findAll() : List<UserResponse>{
        return UserMapper.usersToResponse(userRepository.findAll())
    }
}