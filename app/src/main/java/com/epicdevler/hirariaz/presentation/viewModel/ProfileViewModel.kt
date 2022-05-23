package com.epicdevler.hirariaz.presentation.viewModel

import androidx.lifecycle.ViewModel
import com.epicdevler.hirariaz.utils.ResponseMsg
import kotlinx.coroutines.flow.MutableStateFlow

class ProfileViewModel : ViewModel() {
    private val _userState: MutableStateFlow<UiState> = MutableStateFlow(UiState())
    val userState get() = _userState

    fun login(email: String, password: String) {
        _userState.value = UiState(isLoading = true)
        if (email.isEmpty() || password.isEmpty()) _userState.value =
            UiState(isError = true, errorMsg = ResponseMsg.LOGIN_DETAILS_EMPTY)
        _userState.value = UiState(isSuccess = true)
    }
}

data class UiState(
    val isError: Boolean = false,
    val errorMsg: String? = null,
    val isSuccess: Boolean = false,
    val isLoading: Boolean = false,
)