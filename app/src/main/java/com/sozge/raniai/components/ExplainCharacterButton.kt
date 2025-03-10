package com.sozge.raniai.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.sozge.raniai.R

@Composable
fun ExplainCharacterButton(
    text: String = "Agah",
    icon: Painter = painterResource(id = R.drawable.colorblack),
    isSelected: Boolean,
    onClick: () -> Unit = {},
) {
    OutlinedButton(
        onClick = {
            onClick()
        },
        modifier = Modifier
            .height(60.dp)
            .width(125.dp)
            .padding(2.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = if (isSelected) MaterialTheme.colorScheme.primary else Color.Transparent,
            contentColor = Color.White
        ),
        shape = RoundedCornerShape(20.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Image(
                painter = icon,
                contentDescription = null,
                modifier = Modifier
                    .size(32.dp)
                    .padding(end = 4.dp)
            )
            CustomText(
                text = text,
                fontSize = 16.sp,
            )

        }
    }
}