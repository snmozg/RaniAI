package com.sozge.raniai.pages.authpages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.sozge.raniai.R
import com.sozge.raniai.components.CustomTextInput
import com.sozge.raniai.components.ExpandedButton
import com.sozge.raniai.components.TopBar
import com.sozge.raniai.viewmodels.AuthViewModel
import com.sozge.raniai.viewmodels.AuthViewModelFactory

@Composable
fun SignUpPage(
    navController: NavController,
    authViewModel: AuthViewModel = viewModel(factory = AuthViewModelFactory())
) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    val confirmPassword = remember { mutableStateOf("") }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        topBar = {
            TopBar(
                title = "Hoş Geldin!",
                isEnableBackButton = true,
                navController = navController
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Center,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 5.dp, end = 5.dp),
                verticalArrangement = Arrangement.SpaceEvenly,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.colorblack),
                    contentDescription = "Rani Logo",
                    modifier = Modifier
                        .size(120.dp)
                        .padding()
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    CustomTextInput(
                        label = "Email",
                        text = email.value,
                        onValueChange = { email.value = it },
                        isSingleLine = true,
                        isVisual = true,
                        keyboardType = KeyboardType.Email,
                    )
                    CustomTextInput(
                        label = "Şifre",
                        text = password.value,
                        onValueChange = { password.value = it },
                        isSingleLine = true,
                        isVisual = false,
                        keyboardType = KeyboardType.Password,
                    )
                    CustomTextInput(
                        label = "Şifreyi Onayla",
                        text = confirmPassword.value,
                        onValueChange = { confirmPassword.value = it },
                        isSingleLine = true,
                        isVisual = true,
                        keyboardType = KeyboardType.Password,
                    )
                    Row(
                        horizontalArrangement = Arrangement.End,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        TextButton(onClick = { }) {
                            Text(
                                text = "Şifreni mi Unuttun?",
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    ExpandedButton(text = "Kayıt ol") {
                        authViewModel.signIn(
                            email.value,
                            password.value,
                            onSuccess = {
                                navController.navigate("HomePage")
                            },
                            onError = { message ->
                                println(message)
                            }
                        )
                    }
                    TextButton(
                        onClick = { navController.navigate("SignInPage") },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 40.dp)
                    ) {
                        Text(
                            text = "Zaten Hesabın Var mı? Giriş Yap",
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                }
            }
        }
    }
}


