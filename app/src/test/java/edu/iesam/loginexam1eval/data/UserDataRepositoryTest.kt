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
    private lateinit var userRepository: UserDataRepository

    @BeforeEach
    fun setUp() {
        userRepository = UserDataRepository(localDataSource)
    }

    @Test
    fun `test unsuscribe user delete correct user`():Unit = runBlocking {
        val user = User("test", "test", "test", false)
        coEvery { localDataSource.unSuscribe(user) } returns Unit

        userRepository.unsuscribeUser(user)

        coVerify { localDataSource.unSuscribe(user) }
    }
}