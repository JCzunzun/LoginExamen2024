package edu.iesam.loginexam1eval.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.loginexam1eval.domain.GetRememberUserUseCase
import edu.iesam.loginexam1eval.domain.LoginUserUseCase
import edu.iesam.loginexam1eval.domain.SaveRememberUserUseCase
import edu.iesam.loginexam1eval.domain.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class LoginViewModel( private val loginUseCase: LoginUserUseCase,
                      private val saveRememberUserUseCase: SaveRememberUserUseCase,
    private val getRememberUserUseCase: GetRememberUserUseCase
): ViewModel() {
    private val _uiState= MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState

    fun login(username: String, password: String, rememberMe: Boolean) {
        viewModelScope.launch (Dispatchers.IO) {
            val user = loginUseCase.invoke(username, password, rememberMe)
            saveRememberUserUseCase.invoke(User(username,username,password,rememberMe))
            _uiState.postValue(UiState(correct = user))
        }
    }
    fun getRememberUser() {
        viewModelScope.launch (Dispatchers.IO) {
            val user = getRememberUserUseCase.invoke()
            _uiState.postValue(UiState(userReminder = user))
        }
    }
    data class UiState (
        val correct: Boolean ?= false,
        val userReminder: User ?= null
    )
}