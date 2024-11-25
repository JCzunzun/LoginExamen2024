package edu.iesam.loginexam1eval.domain

import android.util.Log
import org.koin.core.annotation.Single

@Single
class CreateUserUseCase(private val userRepository: UserRepository) {
    suspend fun invoke(user: User):Boolean{
        val users = userRepository.getUsers().contains(user)
        if (!users){
            userRepository.createUser(user)
        }
        return users
    }
}