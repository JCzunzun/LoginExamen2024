package edu.iesam.loginexam1eval.domain

import edu.iesam.loginexam1eval.data.UserDataRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class UnsuscribeUserUseCaseTest {
    private val userRepository = mockk<UserDataRepository>()
    private lateinit var unsuscribeUserUseCase: UnsuscribeUserUseCase

    @BeforeEach
    fun setUp() {
        unsuscribeUserUseCase = UnsuscribeUserUseCase(userRepository)
    }

    @Test
    fun `test unsuscribe user return true`() = runBlocking {
        val user = User("test", "test", "test", false)
        coEvery { userRepository.getUser(user.username) } returns user
        coEvery { userRepository.unsuscribeUser(user) } returns Unit
        coEvery { userRepository.getRememberUser() } returns user
        val result = unsuscribeUserUseCase.invoke(user)
        assertTrue(result)

    }

    @Test
    fun `test user not found return false`() = runBlocking {
        val user = User("test", "test", "test", false)
        coEvery { userRepository.getUser(user.username) } returns null
        coEvery { userRepository.getRememberUser() } returns null

        val result = unsuscribeUserUseCase.invoke(user)

        assertFalse(result)
    }
}