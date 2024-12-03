package edu.iesam.loginexam1eval.domain

import org.koin.core.annotation.Single

@Single
class GetRememberUserUseCase (private val userRepository: UserRepository) {

    suspend fun invoke(): User? {
        return userRepository.getRememberUser()
    }
}