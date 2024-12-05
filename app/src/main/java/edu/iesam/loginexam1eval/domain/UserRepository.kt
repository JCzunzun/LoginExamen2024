package edu.iesam.loginexam1eval.domain

interface UserRepository {
    suspend fun createUser(user: User)
    suspend fun getUsers():List<User>
    suspend fun getUser(username: String): User?
    suspend fun saveRememberUser(user: User)
    suspend fun getRememberUser(): User?
    suspend fun unsuscribeUser(user: User)
}