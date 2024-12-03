package edu.iesam.loginexam1eval.data

import edu.iesam.loginexam1eval.data.local.LoginXmlLocalDataSource
import edu.iesam.loginexam1eval.domain.User
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class UserDataRepositoryTest{
    private val localDataSource = mockk<LoginXmlLocalDataSource>()
    private lateinit var repository:UserDataRepository

    @BeforeEach
    fun setUp(){
        repository = UserDataRepository(localDataSource)
    }

    @Test
    fun `test getUser receives a user from local data source`()= runBlocking {
        val user= User("1", "test", "test", false)
        coEvery { localDataSource.findById(user.id) } returns user

        val result = repository.getUser(user.id)

        assertEquals(user, result)
    }
    @Test
    fun `test getUser receives null from local data source`()= runBlocking {
        val userId= "1"
        coEvery { localDataSource.findById(userId) } returns null

        val result = repository.getUser(userId)

        assertNull(result)
    }
    @Test
    fun `test save user in local data source`():Unit= runBlocking {
        val user= User("1", "test", "test", false)
        coEvery { localDataSource.save(user) } returns Unit

        repository.createUser(user)

        coVerify { localDataSource.save(user) }
    }
}