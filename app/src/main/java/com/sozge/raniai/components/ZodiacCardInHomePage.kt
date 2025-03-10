package com.sozge.raniai.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sozge.raniai.R

@Composable
fun ZodiacCardInHomePage(
    text: String,
    icon: Int = R.drawable.colorblack
) {
    Card(
        onClick = {},
        modifier = Modifier
            .background(MaterialTheme.colorScheme.background)
            .height(150.dp)
            .width(120.dp)
            .padding(end = 5.dp),
        border = BorderStroke(2.dp, MaterialTheme.colorScheme.tertiary),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    modifier = Modifier.padding(15.dp),
                    painter = painterResource(id = icon),
                    contentDescription = text
                )
                CustomText(
                    text = text,
                    fontSize = 20.sp,
                )
            }
        }
    }
}