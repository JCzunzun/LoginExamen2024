package edu.iesam.loginexam1eval.domain

interface UserRepository {
    suspend fun createUser(user: User)
    suspend fun getUsers():List<User>
}