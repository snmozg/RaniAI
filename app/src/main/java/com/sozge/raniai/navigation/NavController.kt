package com.sozge.raniai.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.sozge.raniai.pages.ProfilePage
import com.sozge.raniai.pages.dreampages.CategoryPage
import com.sozge.raniai.pages.dreampages.ExplainPage
import com.sozge.raniai.pages.mainpages.DreamPage
import com.sozge.raniai.pages.mainpages.HomePage
import com.sozge.raniai.pages.mainpages.RisingPage
import com.sozge.raniai.pages.mainpages.ZodiacPage
import com.sozge.raniai.pages.zodiacpages.ZodiacConstellationsPage
import com.sozge.raniai.pages.zodiacpages.ZodiacDailyCommentPage
import com.sozge.raniai.pages.zodiacpages.ZodiacInfoPage
import com.sozge.raniai.viewmodels.CategoryViewModel

@Composable
fun NavController() {
    val categoryViewModel = CategoryViewModel()
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "HomePage"
    ){
        composable(route = "HomePage") { HomePage(navController) }
        composable(route = "DreamPage") { DreamPage(navController) }
        composable(route = "ZodiacPage") { ZodiacPage(navController) }

        composable(route = "UserInfoPage") { ProfilePage(navController) }

        composable("ZodiacInfoPage/{zodiacName}") { backStackEntry ->
            val zodiacName = backStackEntry.arguments?.getString("zodiacName") ?: "Bilinmiyor"
            ZodiacInfoPage(navController, zodiacName)
        }
        composable("ZodiacConstellationsPage/{zodiacName}") { backStackEntry ->
            val zodiacName = backStackEntry.arguments?.getString("zodiacName") ?: "Bilinmiyor"
            ZodiacConstellationsPage(navController, zodiacName)
        }
        composable(route = "ZodiacDailyCommentPage") { ZodiacDailyCommentPage(navController) }

        composable(route = "ExplainPage") { ExplainPage(navController) }
        composable(route = "RisingPage") { RisingPage(navController) }
        composable(route="CategoryPage") { CategoryPage(navController, categoryViewModel) }

    }
}