package com.sozge.raniai.pages.mainpages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.sozge.raniai.components.CustomText
import com.sozge.raniai.components.DatePicker
import com.sozge.raniai.components.ExpandedButton
import com.sozge.raniai.components.FloatingBottomNavBar
import com.sozge.raniai.components.TimePicker
import com.sozge.raniai.components.TopBar

@Composable
fun RisingPage(navController: NavController) {
    var selectedTab by remember { mutableStateOf("Yükselen") }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        topBar = {
            TopBar(
                title = "Yükselen Hesaplama",
                isEnableBackButton = false,
                navController = navController
            )
        },
        bottomBar = {
            FloatingBottomNavBar(
                selectedTab = selectedTab,
                onTabSelected = { selectedTab = it },
                navController
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
        ) {
            CustomText(text = "Yükselen Hesaplama")
            DatePicker()
            TimePicker()
            ExpandedButton(text = "Yükselen Hesapla!") {
            }
        }
    }
}