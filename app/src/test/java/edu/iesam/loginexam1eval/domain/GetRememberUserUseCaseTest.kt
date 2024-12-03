package edu.iesam.loginexam1eval.domain

import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GetRememberUserUseCaseTest{
    private val userRepository = mockk<UserRepository>()
    private lateinit var getRememberUserUseCase: GetRememberUserUseCase

    @BeforeEach
    fun setUp(){
        getRememberUserUseCase = GetRememberUserUseCase(userRepository)
    }

    @Test
    fun `test getRememberUser receive a user from repository`()= runBlocking {
        val user= User("Juan","Juan","1234",false)
        coEvery { userRepository.getRememberUser() } returns user

        val result = getRememberUserUseCase.invoke()

        assertEquals(user, result)

    }
    @Test
    fun `test getRememberUser receive null from repository`()= runBlocking {
        coEvery { userRepository.getRememberUser() } returns null

        val result = getRememberUserUseCase.invoke()

        assertNull(result)
    }
}