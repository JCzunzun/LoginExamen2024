package edu.iesam.loginexam1eval.data

import edu.iesam.loginexam1eval.data.local.LoginXmlLocalDataSource
import edu.iesam.loginexam1eval.domain.User
import edu.iesam.loginexam1eval.domain.UserRepository
import org.koin.core.annotation.Single

@Single
class UserDataRepository(private val localDataSource: LoginXmlLocalDataSource) : UserRepository {
    override suspend fun createUser(user: User) {
        localDataSource.save(user)
    }

    override suspend fun getUsers(): List<User> {
        return localDataSource.findAll()
    }

    override suspend fun getUser(username: String): User? {
        return localDataSource.findById(username)
    }
}