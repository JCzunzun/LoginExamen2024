package edu.iesam.loginexam1eval.domain

import io.mockk.coEvery
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class SaveRememberUserUseCaseTest{
    private val userRepository = mockk<UserRepository>()
    private lateinit var saveRememberUserUseCase: SaveRememberUserUseCase

    @BeforeEach
    fun setUp(){
        saveRememberUserUseCase = SaveRememberUserUseCase(userRepository)
    }
    @Test
    fun `test saveRememberUser receive a true in parameter`()= runBlocking {
        val user= User("Juan","Juan","1234",true)
        coEvery { userRepository.saveRememberUser(user) } returns Unit

        val result = saveRememberUserUseCase.invoke(user)

        assertEquals(Unit, result)
    }
    @Test
    fun `test saveRememberUser receive a false in parameter`(): Unit = runBlocking {
        val user= User("Juan","Juan","1234",false)
        val user2= User("","","",false)
        coEvery { userRepository.saveRememberUser(user2) } just runs

        saveRememberUserUseCase.invoke(user)

        coEvery { userRepository.saveRememberUser(user2) }
    }
}