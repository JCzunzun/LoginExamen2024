package edu.iesam.loginexam1eval.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.loginexam1eval.domain.CreateUserUseCase
import edu.iesam.loginexam1eval.domain.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class RegisterViewModel(
    private val createUserUseCase: CreateUserUseCase
):ViewModel() {
    private val _uiState= MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState

     fun buildUser(user: User){
        viewModelScope.launch (Dispatchers.IO){
            val createUser=createUserUseCase.invoke(user)
            _uiState.postValue(UiState(create= createUser))
        }
    }
    data class UiState(
        val create:Boolean = false
    )
}