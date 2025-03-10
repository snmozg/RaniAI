package com.sozge.raniai.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme.colorScheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sozge.raniai.datas.CategoryCard
import com.sozge.raniai.utils.myFont

@Composable
fun CategoryCardItem(
    index: Int,
    item: CategoryCard,
    isSelected: Boolean,
    cardWidth: Dp,
    cardHeight: Dp,
    onClick: () -> Unit
) {
    val myButtonColor = colorScheme.primary
    val lightBlack = colorScheme.tertiary
    val newWhite = colorScheme.onBackground
    val buttonColor by remember { mutableStateOf(lightBlack) }

    val myTextColor = colorScheme.primary
    val textColor by remember { mutableStateOf(newWhite) }

    Column(
        modifier = Modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
        ) {
            Column(
                modifier = Modifier
                    .clip(RoundedCornerShape(20.dp))
                    .width(cardWidth)
                    .height(cardHeight)
                    .background(if (isSelected) myButtonColor else buttonColor),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painterResource(item.image),
                    contentDescription = item.text,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .clickable(
                            enabled = true,
                            onClickLabel = "Clickable Image",
                            onClick = onClick
                        )
                        .padding(10.dp)
                )
            }
        }
        Text(
            modifier = Modifier.padding(start = 10.dp),
            text = item.text,
            color = if (isSelected) myTextColor else textColor,
            fontSize = 16.sp,
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Normal,
            fontFamily = myFont
        )
    }
}