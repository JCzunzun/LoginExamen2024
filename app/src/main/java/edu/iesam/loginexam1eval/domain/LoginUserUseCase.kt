package edu.iesam.loginexam1eval.domain

import org.koin.core.annotation.Single

@Single
class LoginUserUseCase(private val userRepository: UserRepository) {
    suspend fun invoke(username: String, password: String, rememberMe: Boolean): Boolean {
        val user = userRepository.getUser(username)
        return user != null && user.password == password
    }
}