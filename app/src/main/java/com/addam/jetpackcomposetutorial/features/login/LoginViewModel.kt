package com.addam.jetpackcomposetutorial.features.login

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine

/**
 * Created by addam on 16/11/2022
 */
class LoginViewModel: ViewModel() {
    val username = MutableStateFlow("")
    val password = MutableStateFlow("")

    val isFormValid = username.combine(password){ input1, input2 ->
        input1.isNotEmpty() && input2.isNotEmpty()
    }
}