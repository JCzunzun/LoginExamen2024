package edu.iesam.loginexam1eval.data

import edu.iesam.loginexam1eval.data.local.LoginXmlLocalDataSource
import edu.iesam.loginexam1eval.domain.User
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class UserDataRepositoryTest{
    private val localDataSource = mockk<LoginXmlLocalDataSource>()
    private lateinit var userRepository: UserDataRepository

    @BeforeEach
    fun setUp(){
        userRepository = UserDataRepository(localDataSource)
    }
    @Test
    fun `test getUser receive a user from local data source`()= runBlocking {
        val user= User("Juan","Juan","1234",false)
        coEvery { localDataSource.findById(user.username) } returns user

        val result = userRepository.getUser(user.username)

        assertEquals(user, result)
    }
    @Test
    fun `test getUser receive null from local data source`()= runBlocking {
        val user= User("Juan","Juan","1234",false)
        coEvery { localDataSource.findById(user.username) } returns null

        val result = userRepository.getUser(user.username)

        assertNull(result)
    }
}