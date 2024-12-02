package edu.iesam.loginexam1eval.domain

class LoginUserUseCase(private val userRepository: UserRepository) {
    suspend fun invoke(username: String, password: String): Boolean {
        val user = userRepository.getUser(username)
        return user != null && user.password == password
    }
}