package com.example.mvvmjetpackcomposenoteapp.notes

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mvvmjetpackcomposenoteapp.MainActivity
import com.example.mvvmjetpackcomposenoteapp.Screen
import com.example.mvvmjetpackcomposenoteapp.core.utils.TestTags
import com.example.mvvmjetpackcomposenoteapp.di.AppModule
import com.example.mvvmjetpackcomposenoteapp.ui.theme.MVVMJetpackComposeNoteAppTheme
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
@UninstallModules(AppModule::class)
class NotesScreenTest{

    @get:Rule(order = 0)
    val hiltRule = HiltAndroidRule(this)

    @get:Rule(order = 1)
    val composeRule = createAndroidComposeRule<MainActivity>()
    @OptIn(ExperimentalAnimationApi::class)
    @Before
    fun setUp(){
        hiltRule.inject()
        composeRule.setContent { 
            val navController = rememberNavController()
            MVVMJetpackComposeNoteAppTheme {
                NavHost(navController = navController,
                startDestination = Screen.NotesScreen.route){
                    composable(route = Screen.NotesScreen.route){
                        NotesScreen(navController = navController)
                    }
                }
            }
        }
    }

    @Test
    fun clickToggleOrederSection_isVisible(){
        composeRule.onNodeWithTag(TestTags.ORDER_SECTION).assertDoesNotExist()
        composeRule.onNodeWithContentDescription("Sort").performClick()
        composeRule.onNodeWithTag(TestTags.ORDER_SECTION).assertIsDisplayed()
    }
}