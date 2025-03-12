package com.sozge.raniai.pages.authpages

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.sozge.raniai.R
import com.sozge.raniai.components.CustomText
import com.sozge.raniai.components.CustomTextInput
import com.sozge.raniai.components.ExpandedButton
import com.sozge.raniai.components.TopBar
import com.sozge.raniai.viewmodels.AuthViewModel
import com.sozge.raniai.viewmodels.AuthViewModelFactory
import kotlinx.coroutines.delay

@Composable
fun SignInPage(
    navController: NavController,
    authViewModel: AuthViewModel = viewModel(factory = AuthViewModelFactory()),
) {
    val email = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }
    
    // Animation states
    var logoVisible by remember { mutableStateOf(false) }
    var formVisible by remember { mutableStateOf(false) }
    var buttonVisible by remember { mutableStateOf(false) }
    
    // Start animations sequentially
    LaunchedEffect(key1 = true) {
        logoVisible = true
        delay(300)
        formVisible = true
        delay(300)
        buttonVisible = true
    }

    val gradientBackground = Brush.verticalGradient(
        colors = listOf(
            MaterialTheme.colorScheme.background,
            MaterialTheme.colorScheme.background.copy(alpha = 0.8f),
            MaterialTheme.colorScheme.primary.copy(alpha = 0.2f)
        )
    )

    Scaffold(
        modifier = Modifier
            .fillMaxSize(),
        topBar = {
            TopBar(
                title = "Hoş Geldin!",
                isEnableBackButton = true,
                navController = navController
            )
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .background(brush = gradientBackground)
                .padding(16.dp),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                Spacer(modifier = Modifier.height(16.dp))
                
                // Logo with animation
                AnimatedVisibility(
                    visible = logoVisible,
                    enter = fadeIn() + slideInVertically { it / 2 }
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        Image(
                            painter = painterResource(id = R.drawable.colorblack),
                            contentDescription = "Rani Logo",
                            modifier = Modifier
                                .size(120.dp)
                                .padding(4.dp),
                            contentScale = ContentScale.Fit
                        )
                        
                        Text(
                            text = "Tekrar Hoş Geldiniz",
                            style = TextStyle(
                                fontSize = 24.sp,
                                fontWeight = FontWeight.Bold,
                                color = MaterialTheme.colorScheme.primary
                            ),
                            textAlign = TextAlign.Center
                        )
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Text(
                            text = "Hesabınıza giriş yaparak devam edin",
                            style = TextStyle(
                                fontSize = 14.sp,
                                color = MaterialTheme.colorScheme.onSurfaceVariant
                            ),
                            textAlign = TextAlign.Center
                        )
                    }
                }
                
                // Form with animation
                AnimatedVisibility(
                    visible = formVisible,
                    enter = fadeIn() + slideInVertically { it / 2 }
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                            .shadow(
                                elevation = 9.dp,
                                shape = RoundedCornerShape(16.dp),
                                spotColor = MaterialTheme.colorScheme.primary
                            ),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.background
                        ),
                        shape = RoundedCornerShape(16.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(24.dp),
                            verticalArrangement = Arrangement.spacedBy(16.dp)
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
                            
                            Row(
                                horizontalArrangement = Arrangement.End,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                TextButton(onClick = { }) {
                                    Text(
                                        text = "Şifreni mi Unuttun?",
                                        color = MaterialTheme.colorScheme.primary,
                                        style = TextStyle(fontWeight = FontWeight.Medium)
                                    )
                                }
                            }
                        }
                    }
                }
                
                // Buttons with animation
                AnimatedVisibility(
                    visible = buttonVisible,
                    enter = fadeIn() + slideInVertically { it / 2 }
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 16.dp)
                    ) {
                        ExpandedButton(
                            text = "Giriş Yap"
                        ) {
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
                        
                        Spacer(modifier = Modifier.height(8.dp))
                        
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = "Hala aramıza katılmadın mı?",
                                style = TextStyle(
                                    color = MaterialTheme.colorScheme.onSurfaceVariant,
                                    fontSize = 14.sp
                                )
                            )
                            
                            TextButton(onClick = { navController.navigate("SignUpPage") }) {
                                Text(
                                    text = "Kayıt Ol",
                                    style = TextStyle(
                                        fontWeight = FontWeight.Bold,
                                        color = MaterialTheme.colorScheme.primary,
                                        fontSize = 14.sp
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}