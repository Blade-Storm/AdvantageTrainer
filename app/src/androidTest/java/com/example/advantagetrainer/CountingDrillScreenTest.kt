package com.example.advantagetrainer

import android.content.Context
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.advantagetrainer.ui.theme.AdvantageTrainerTheme
import com.example.advantagetrainer.views.CountingDrillScreen
import org.junit.Rule
import org.junit.Test


class CountingDrillScreenTest {
    var testUtils = TestUtils()

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun countingDrillScreen_ShouldStartDrill() {
        val startButton = "StartButton"

        // Start the app
        composeTestRule.setContent {
            val sharedPref = LocalContext.current.getSharedPreferences(
                testUtils.TEST_SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE
            )

            with(sharedPref.edit()) {
                clear()
                putInt(Settings.NUM_CARDS_TO_FLASH, 0)
                apply()
            }

            val navController = rememberNavController()

            NavHost(
                modifier = Modifier,
                navController = navController,
                startDestination = "countingDrillScreen"
            ) {
                composable("countingDrillScreen") {
                    CountingDrillScreen(
                        sharedPref,
                    )
                }
            }

            AdvantageTrainerTheme {
                CountingDrillScreen(
                    sharedPref,
                )
            }
        }

        // Click the start button
        val startDrillButton =
            composeTestRule.onAllNodes(hasClickAction()).filter(hasTestTag(startButton))
        startDrillButton[0].performClick()

        // Assert that cards are being displayed
        composeTestRule.onAllNodes(hasContentDescription("Card")).assertCountEquals(1)
    }
}