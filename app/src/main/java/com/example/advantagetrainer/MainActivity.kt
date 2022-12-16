package com.example.advantagetrainer

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.advantagetrainer.ui.theme.AdvantageTrainerTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdvantageTrainerTheme {
                GenerateAppView()
            }
        }
    }
}

enum class Coupons (val coupon: String) {
    FREE_CHIPS ("Free Chips"),
    MATCH_PLAY ("Match Play")
}

@Preview
@Composable
fun GenerateAppView(){
    Surface(color = Color.White, modifier = Modifier.fillMaxSize()) {
        MyAppNavHost()
    }
}

@Composable
fun MyAppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "home"
) {
    val (couponSelection, onOptionSelected) = rememberSaveable { mutableStateOf(Coupons.FREE_CHIPS)}
    val (couponGameEdge, updateCouponGameEdge ) = rememberSaveable { mutableStateOf("") }
    val (couponFaceValue, updateCouponFaceValue ) = rememberSaveable { mutableStateOf("") }
    val (couponBet, updateCouponBetValue ) = rememberSaveable { mutableStateOf("") }
    val (deck, updateDeck) = remember { mutableStateOf(ArrayList<Card>()) }

    val sharedPref = LocalContext.current.getSharedPreferences(
        Settings.SETTINGS_FILE_LOCATION, Context.MODE_PRIVATE)

    with (sharedPref.edit()) {
        putInt(Settings.CARD_FLASH_SPEED, sharedPref.getInt(Settings.CARD_FLASH_SPEED, 0))
        putBoolean(Settings.USE_SPANISH_DECK, sharedPref.getBoolean(Settings.USE_SPANISH_DECK, false))
        putInt(Settings.NUM_CARDS_TO_FLASH, sharedPref.getInt(Settings.NUM_CARDS_TO_FLASH, 1))
        apply()
    }


    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {
        composable("home") {
            HomeScreen(
                onNavigateToCouponCalculator = { navController.navigate("couponcalculator") },
                onNavigateToCountingDrill = {navController.navigate("countingdrill")},
                onNavigateToSettings = {navController.navigate("settings")},
                onNavigateToStrategyDrill = {navController.navigate("strategydrill")}
            )

        }
        composable("countingdrill") {
            CountingDrillScreen(
                onNavigateToHome = { navController.navigate("home") },
                sharedPref,
                deck,
                updateDeck
            )
        }
        composable("couponcalculator") {
            CouponCalculatorScreen(
                onNavigateToHome = { navController.navigate("home") },
                couponSelection,
                onOptionSelected,
                couponGameEdge,
                updateCouponGameEdge,
                couponFaceValue,
                updateCouponFaceValue,
                couponBet,
                updateCouponBetValue,
            )
        }
        composable("settings") {
            SettingsScreen(
                sharedPref
            )
        }
        composable("strategydrill") {
            StrategyDrillScreen(
                sharedPref
            )
        }
    }
}

@Composable
fun HomeScreen(
    onNavigateToCouponCalculator: () -> Unit,
    onNavigateToCountingDrill: () -> Unit,
    onNavigateToSettings: () -> Unit,
    onNavigateToStrategyDrill: () -> Unit
) {
    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onNavigateToCountingDrill,
            Modifier.testTag("CountingDrillButton")
        ) {
            Text(text = "Counting Drill")
        }
        Button(
            onClick = onNavigateToStrategyDrill,
            Modifier.testTag("StrategyDrillButton")
        ) {
            Text(text = "Strategy Drill")
        }
        Button(
           onClick = onNavigateToCouponCalculator,
           Modifier.testTag("CouponCalculatorButton")
        ) {
            Text(text = "Coupon Calculator")
        }
        Button(
            onClick = onNavigateToSettings,
            Modifier.testTag("SettingsButton")
        ) {
            Text(text = "Settings")
        }

    }
}

@Composable
fun ShowCard(deck: ArrayList<Card>, index: Int, numCardToFlashSetting: Int) {
    var boxOffset = 0.dp
    val singleCardIndex = index
    val doubleCardIndex = index + 1
    val tripleCardIndex = index + 2
    val numCardToFlash = numCardToFlashSetting


    // Update the box offset to account for the additional cards
    if(numCardToFlash == 2 && index < deck.size - 1){
        boxOffset = 24.dp
    }else if (numCardToFlash == 3 && index < deck.size - 2){
        boxOffset = 48.dp
    }

    // TODO Use offset instead of padding to display the cards. Also change the zindex so the card layout is proper
    // To prevent against an IndexOutOfBoundsException if we accidently call this function with a large index
    if(index < deck.size){
        Surface(
            color = Color.Transparent,
            modifier = Modifier.fillMaxHeight().fillMaxWidth()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Box(
                    Modifier.offset(x = boxOffset, y = boxOffset)
                ) {
                    // Show a single card. If there is only 1 card left in the deck to show, show one card regardless of the setting
                    if (numCardToFlash == 1 || index == deck.size - 1) {
                        Image(
                            painter = painterResource(deck[singleCardIndex].cardImageId),
                            contentDescription = "Card",
                        )
                        // Show 2 cards
                    } else if (numCardToFlash == 2 || (numCardToFlash == 3 && index == deck.size - 2)) {
                        Image(
                            painter = painterResource(deck[singleCardIndex].cardImageId),
                            contentDescription = "Card",
                        )
                        Image(
                            painter = painterResource(deck[doubleCardIndex].cardImageId),
                            contentDescription = "Card",
                            modifier = Modifier.padding(36.dp),
                        )
                        // Show 3 cards
                    } else if (numCardToFlash == 3) {
                        Image(
                            painter = painterResource(deck[singleCardIndex].cardImageId),
                            contentDescription = "Card",
                        )
                        Image(
                            painter = painterResource(deck[doubleCardIndex].cardImageId),
                            contentDescription = "Card",
                            modifier = Modifier.padding(36.dp),
                        )
                        Image(
                            painter = painterResource(deck[tripleCardIndex].cardImageId),
                            contentDescription = "Card",
                            modifier = Modifier.padding(72.dp),
                        )
                    }

                }

            }
        }
    }
}

@Composable
fun CreateDeck(sharedPref: SharedPreferences): ArrayList<Card>{
    val useSpanishDeck = sharedPref.getBoolean(Settings.USE_SPANISH_DECK, false)
    val numDeckToCountSetting = sharedPref.getInt(Settings.NUM_DECKS_TO_COUNT, 0)
    var numDecksToCount = 1

    // Protect ourself from trying to access the mapper with an index that is out of bounds
    // Default to and create a single deck instead
    if(numDeckToCountSetting <= Settings.numDecksToCountMapper.size - 1){
        numDecksToCount = Settings.numDecksToCountMapper[numDeckToCountSetting]!!
    }

    val deck = ArrayList<Card>()

    for (i in 0 until numDecksToCount){
        for (suit in Suits.values()) {
            CardValueMapper.cardValueMapper.forEach { (key, value) ->
                if(key == CardNames.TEN && useSpanishDeck){
                    return@forEach // Continue
                }
                val id = LocalContext.current.resources.getIdentifier("com.example.advantagetrainer:drawable/$suit$key", null, null)
                deck.add(Card(suit, key, value, id))
            }
        }
    }

    deck.shuffle()

    return deck
}


