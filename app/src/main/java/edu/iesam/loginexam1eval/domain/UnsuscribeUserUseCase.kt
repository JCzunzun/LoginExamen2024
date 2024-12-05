package edu.iesam.loginexam1eval.domain

import org.koin.core.annotation.Single

@Single
class UnsuscribeUserUseCase (private val userRepository: UserRepository)  {

    operator suspend fun invoke(user: User) : Boolean {
        val userGet= userRepository.getUser(user.username)
        val rememberUser = userRepository.getRememberUser()

        if (userGet != null) {
            if (userGet.password == user.password) {
                userRepository.unsuscribeUser(user)
                return true
            }
        }
        if (rememberUser != null){
            if (rememberUser.username == user.username){
                userRepository.saveRememberUser(User("", "", "", false))
            }
        }
        return false
    }
}
