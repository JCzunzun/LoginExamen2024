package edu.iesam.loginexam1eval.domain

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LoginUserUseCaseTest{
    private val userRepository = mockk<UserRepository>()
    private lateinit var loginUserUseCase: LoginUserUseCase

    @BeforeEach
    fun setUp(){
        loginUserUseCase = LoginUserUseCase(userRepository)
    }
    @Test
    fun `test login user with correct credentials returns true`()= runBlocking {
        val username = "test"
        val password = "test"
        val user = User(username,username, password, false)
        coEvery { userRepository.getUser(username) } returns user

        val result = loginUserUseCase.invoke(username, password, false)

        assertTrue(result)
    }
    @Test
    fun `test login user with incorrect credentials returns false`()= runBlocking {
        val username = "test"
        val password = "test"
        val user = User(username,username, password, false)
        coEvery { userRepository.getUser(username) } returns user

        val result = loginUserUseCase.invoke(username, "wrong", false)

        assertFalse(result)
    }
}