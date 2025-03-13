package com.sozge.raniai.pages

import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Icon
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.sozge.raniai.R
import com.sozge.raniai.components.CustomDropdownMenu
import com.sozge.raniai.components.CustomTextInput
import com.sozge.raniai.components.ExpandedButton
import com.sozge.raniai.components.TopBar

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ProfilePage(navController: NavController) {
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("") }


    var showIconSelector by remember { mutableStateOf(false) }
    val bottomSheetState = rememberModalBottomSheetState()


    var selectedIcon by remember { mutableStateOf<Painter?>(null) }


    val iconList = listOf(
        painterResource(id = R.drawable.profilefairy),
        painterResource(id = R.drawable.profileghost),
        painterResource(id = R.drawable.profilewitch),
        painterResource(id = R.drawable.profilepirate),
        painterResource(id = R.drawable.profilefrog),
        painterResource(id = R.drawable.profileprincess),
        painterResource(id = R.drawable.profiletooth),
        painterResource(id = R.drawable.profilegnome),
        painterResource(id = R.drawable.profilemermaid),
        painterResource(id = R.drawable.profiledemon),
        painterResource(id = R.drawable.profileunicorn),
        painterResource(id = R.drawable.profiledracula)
    )
    val optionsGender = listOf("Hiçbiri", "Erkek", "Kadın")
    val scrollState = rememberScrollState()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        topBar = {
            TopBar(
                title = "Profil",
                navController = navController
            )
        },
        floatingActionButton = {
            ExpandedButton(text = "Kaydet") {
                println(name + "\n" + age + "\n" + gender + "\n" + selectedIcon)
            }
        },
        floatingActionButtonPosition = FabPosition.Center
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .imePadding()
                .verticalScroll(scrollState)
                .padding(innerPadding)
                .padding(16.dp)
                .background(MaterialTheme.colorScheme.background),
            verticalArrangement = Arrangement.spacedBy(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(vertical = 16.dp),
                contentAlignment = Alignment.Center
            ) {
                Box(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.background)
                        .border(2.dp, MaterialTheme.colorScheme.primary, CircleShape)
                        .clickable { showIconSelector = true },
                    contentAlignment = Alignment.Center
                ) {
                    if (selectedIcon != null) {
                        Image(
                            painter = selectedIcon!!,
                            contentDescription = "Seçilen Profil İkonu",
                            modifier = Modifier.size(130.dp),
                        )
                    } else {
                        Icon(
                            imageVector = Icons.Default.AccountCircle,
                            contentDescription = "Profil İkonu",
                            modifier = Modifier.size(130.dp),
                            tint = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                Box(
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                        .padding(8.dp)
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.primary)
                        .clickable { showIconSelector = true },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Edit,
                        contentDescription = "Düzenle",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                }
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .background(MaterialTheme.colorScheme.background),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Text(
                    text = "Kişisel Bilgiler",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.primary
                )

                Divider(thickness = 1.dp, color = MaterialTheme.colorScheme.background)

                CustomTextInput(
                    label = "Ad Soyad",
                    text = name,
                    onValueChange = { name = it },
                    isSingleLine = true,
                    isVisual = true,
                    keyboardType = KeyboardType.Text,
                )

                CustomTextInput(
                    label = "Yaş",
                    text = age,
                    onValueChange = { age = it },
                    isSingleLine = true,
                    isVisual = true,
                    keyboardType = KeyboardType.Number,
                )

                CustomDropdownMenu(
                    label = "Cinsiyet",
                    options = optionsGender,
                    selectedOption = gender,
                    onOptionSelected = { gender = it },
                )
            }

            Box(modifier = Modifier.height(60.dp))
        }
    }

    if (showIconSelector) {
        ModalBottomSheet(
            onDismissRequest = { showIconSelector = false },
            sheetState = bottomSheetState,
            dragHandle = { BottomSheetDefaults.DragHandle() }
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {
                Text(
                    text = "Profil İkonu Seçin",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    maxItemsInEachRow = 5
                ) {
                    iconList.forEach { icon ->
                        Box(
                            modifier = Modifier
                                .padding(8.dp)
                                .size(90.dp)
                                .clip(CircleShape)
                                .background(
                                    if (selectedIcon == icon)
                                        MaterialTheme.colorScheme.primary
                                    else
                                        Color.Transparent
                                )
                                .border(
                                    width = if (selectedIcon == icon) 1.dp else 0.dp,
                                    color = MaterialTheme.colorScheme.primary,
                                    shape = CircleShape
                                )
                                .clickable {
                                    selectedIcon = icon
                                    showIconSelector = false
                                },
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                painter = icon,
                                contentDescription = "icon",
                                modifier = Modifier.size(60.dp)
                            )
                        }
                    }
                }

                Box(modifier = Modifier.height(50.dp))
            }
        }
    }
}
