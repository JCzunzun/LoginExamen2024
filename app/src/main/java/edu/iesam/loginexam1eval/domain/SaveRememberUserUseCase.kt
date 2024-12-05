package edu.iesam.loginexam1eval.domain

import org.koin.core.annotation.Single

@Single
class SaveRememberUserUseCase (private val userRepository: UserRepository)  {

    operator suspend fun invoke(user: User){
        if (user.rememberMe){
            userRepository.saveRememberUser(user)
        }
        else{
            userRepository.saveRememberUser(User("", "", "", false))
        }
    }
}