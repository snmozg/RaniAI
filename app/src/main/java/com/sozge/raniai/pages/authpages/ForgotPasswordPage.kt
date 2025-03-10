package com.sozge.raniai.pages.authpages

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.sozge.raniai.components.CustomTextInput
import com.sozge.raniai.components.ExpandedButton
import com.sozge.raniai.viewmodels.AuthViewModel
import com.sozge.raniai.viewmodels.AuthViewModelFactory

@Composable
fun ForgotPasswordPage(
    navController: NavController,
    authViewModel: AuthViewModel = viewModel(factory = AuthViewModelFactory())
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val email = remember { mutableStateOf("") }

        CustomTextInput(
            label = "Email",
            text = email.value,
            onValueChange = { email.value = it },
            isSingleLine = true,
            isVisual = true,
            keyboardType = KeyboardType.Email,
        )

        ExpandedButton(text = "Forgot Password") {
            // forgot password logic
        }
    }
}