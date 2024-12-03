package edu.iesam.loginexam1eval.domain

import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CreateUserUseCaseTest{
    private val userRepository = mockk<UserRepository>()
    private lateinit var createUserUseCase: CreateUserUseCase

    @BeforeEach
    fun setUp(){
        createUserUseCase = CreateUserUseCase(userRepository)
    }

    @Test
    fun `test invoke creates a user and returns true`():Unit= runBlocking{
        val user= User("1", "test", "test", false)
        coEvery { userRepository.createUser(user) } returns Unit
        coEvery { userRepository.getUser(user.username) } returns null

        val result = createUserUseCase.invoke(user)

        assertTrue(result)
        coVerify { userRepository.createUser(user) }
    }

    @Test
    fun `test invoke returns false`()= runBlocking {
        val user= User("1", "test", "test", false)
        coEvery { userRepository.getUser(user.username) } returns user
        coEvery { userRepository.createUser(user) } returns Unit

        val result = createUserUseCase.invoke(user)

        assertFalse(result)
    }
}