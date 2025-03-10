package com.sozge.raniai.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Schedule
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sozge.raniai.R

@Composable
fun ZodiacBottomSheetContent(
    isClickablePage: Boolean = true,
    colorfulPageText: String = "Burç yorumlarını görmek için lütfen bekleyiniz..",
    title: String,
    dateRange: String,
    description: String,
    firstButtonText: String = "",
    firstButtonContent: String = "",
    secondButtonText: String = "",
    secondButtonContent: String = "",
    thirdButtonText: String = "",
    thirdButtonContent: String = "",
) {
    var selectedTab by remember { mutableStateOf("First") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CustomText(text = title, fontSize = 24.sp)

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(4.dp)
            ) {
                Icon(
                    imageVector = Icons.Outlined.Schedule,
                    contentDescription = "Date range",
                    modifier = Modifier.size(16.dp)
                )
                CustomText(text = dateRange, fontSize = 14.sp)
            }

            CustomText(
                text = description,
                fontSize = 16.sp
            )
        }
        if (isClickablePage) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                ZodiacBottomSheetTextButton(
                    text = firstButtonText,
                    isSelected = selectedTab == "First",
                    onClick = { selectedTab = "First" }
                )
                ZodiacBottomSheetTextButton(
                    text = secondButtonText,
                    isSelected = selectedTab == "Second",
                    onClick = { selectedTab = "Second" }
                )
                ZodiacBottomSheetTextButton(
                    text = thirdButtonText,
                    isSelected = selectedTab == "Third",
                    onClick = { selectedTab = "Third" }
                )
            }

            when (selectedTab) {
                "First" -> {
                    CustomText(
                        text = firstButtonContent,
                        fontSize = 16.sp
                    )
                }

                "Second" -> {
                    CustomText(
                        text = secondButtonContent,
                        fontSize = 16.sp
                    )
                }

                "Third" -> {
                    CustomText(
                        text = thirdButtonContent,
                        fontSize = 16.sp
                    )
                }
            }
        } else {
            LazyRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
            ) {
                items(1) {
                    ZodiacBottomSheetColorfulCard(
                        text = "sağlık",
                        icon = painterResource(id = R.drawable.dailyhealth),
                        colorValue = 1
                    )
                    ZodiacBottomSheetColorfulCard(
                        text = "Aşk",
                        icon = painterResource(id = R.drawable.dailylove),
                        colorValue = 2
                    )
                    ZodiacBottomSheetColorfulCard(
                        text = "Para",
                        icon = painterResource(id = R.drawable.dailymoney),
                        colorValue = 5
                    )
                    ZodiacBottomSheetColorfulCard(
                        text = "Kariyer",
                        icon = painterResource(id = R.drawable.dailycareer),
                        colorValue = 2
                    )
                }
            }
            CustomText(
                text = colorfulPageText,
                fontSize = 16.sp
            )
        }
    }
}