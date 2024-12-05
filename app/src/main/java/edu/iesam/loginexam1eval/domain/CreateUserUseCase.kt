package edu.iesam.loginexam1eval.domain

import android.util.Log
import org.koin.core.annotation.Single

@Single
class CreateUserUseCase(private val userRepository: UserRepository) {
    operator suspend fun invoke(user: User):Boolean{
        val userVerified = userRepository.getUser(user.username)
        if (userVerified == null){
            userRepository.createUser(user)
            return true
        }
        return false
    }
}