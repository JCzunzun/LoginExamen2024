package edu.iesam.loginexam1eval.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import edu.iesam.loginexam1eval.domain.UnsuscribeUserUseCase
import edu.iesam.loginexam1eval.domain.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class UnsuscribeViewModel(private val unsuscribeUserUseCase: UnsuscribeUserUseCase): ViewModel() {
    private val _uiState= MutableLiveData<UiState>()
    val uiState : LiveData<UiState> = _uiState

    fun unsuscribe(user: User) {
        viewModelScope.launch (Dispatchers.IO) {
            val delete = unsuscribeUserUseCase.invoke(user)
            _uiState.postValue(UiState(delete = delete))
        }
    }
    data class UiState (
        val delete: Boolean ?= false
    )
}