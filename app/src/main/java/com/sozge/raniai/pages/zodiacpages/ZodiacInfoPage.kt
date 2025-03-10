package com.sozge.raniai.pages.zodiacpages

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.sozge.raniai.R
import com.sozge.raniai.components.TopBar
import com.sozge.raniai.components.ZodiacBottomSheetContent
import com.sozge.raniai.datas.repos.ZodiacRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ZodiacInfoPage(
    navController: NavController,
    horoscopeName: String,
) {
    val horoscope = ZodiacRepository.getZodiac(horoscopeName)

    if (horoscope == null) {
        Text(text = "Burç bilgisi bulunamadı", color = Color.Red, fontSize = 20.sp)
        return
    }
    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = false)
    var showSheet by remember { mutableStateOf(true) }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        topBar = {
            TopBar(title = "${horoscope.name} Burcu", navController = navController)
        },
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (showSheet) {
                ModalBottomSheet(
                    onDismissRequest = { showSheet = false },
                    sheetState = sheetState,
                    containerColor = MaterialTheme.colorScheme.tertiary
                ) {
                    ZodiacBottomSheetContent(
                        title = horoscope.name,
                        dateRange = horoscope.dateRange,
                        description = horoscope.description,
                        firstButtonText = "Genel",
                        firstButtonContent = horoscope.general,
                        secondButtonText = "Erkek",
                        secondButtonContent = horoscope.male,
                        thirdButtonText = "Kadın",
                        thirdButtonContent = horoscope.female,
                    )
                }
            }
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.colorblack),
                    contentDescription = ""
                )
            }
        }
    }
}