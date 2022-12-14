package com.example.advantagetrainer

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.CountDownTimer
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
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
    var (couponSelection, onOptionSelected) = rememberSaveable { mutableStateOf(Coupons.FREE_CHIPS)}
    var (couponGameEdge, updateCouponGameEdge ) = rememberSaveable { mutableStateOf("") }
    var (couponFaceValue, updateCouponFaceValue ) = rememberSaveable { mutableStateOf("") }
    var (couponBet, updateCouponBetValue ) = rememberSaveable { mutableStateOf("") }
    var (deck, updateDeck) = remember { mutableStateOf(ArrayList<Card>()) }

    var sharedPref = LocalContext.current.getSharedPreferences(
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
                onNavigateToSettings = {navController.navigate("settings")}
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
    }
}



@Composable
fun CountingDrillScreen(
    onNavigateToHome: () -> Unit,
    sharedPref: SharedPreferences,
    deck: ArrayList<Card>,
    updateDeck: (ArrayList<Card>) -> Unit
){
    var cardVisible = remember { mutableStateOf(false) }
    var index = remember { mutableStateOf(0) }
    var cardFlashSpeed = Settings.cardFlashSpeedMapper[sharedPref.getInt(Settings.CARD_FLASH_SPEED, 2)]!!
    var numCardToFlashSetting = Settings.numCardToFlashMapper[sharedPref.getInt(Settings.NUM_CARDS_TO_FLASH, 0)]!!
    var numCardToFlash = numCardToFlashSetting

    // If the user has setting to flash 1-3 cards set numCardToFlash to a random int between 1-3
    if(numCardToFlashSetting == 3){
        numCardToFlash = (1..3).random()
    }
    var newDeck = ArrayList<Card>()

    if(cardVisible.value) {
        object : CountDownTimer(cardFlashSpeed, cardFlashSpeed) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                if(index.value > deck.size){
                    index.value = 0
                    cardVisible.value = false
                    deck.clear()
                    this.cancel()
                }else{
                    index.value += numCardToFlash
                }
            }
        }.start()

        if(index.value < deck.size) {
            ShowCard(deck, index.value, numCardToFlash)
        }
    }else if(deck.size == 0){
        newDeck = CreateDeck(sharedPref = sharedPref)
        updateDeck(newDeck)
    }


    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = {
            cardVisible.value = true
        },
            Modifier.testTag("StartButton")
        ) {
            Text(text = "Start")
        }
        Button(
            onClick = {
                onNavigateToHome()
                deck.clear()
                      },
            Modifier.testTag("HomeButton")
        ) {
            Text(text = "Home")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CouponCalculatorScreen(
    onNavigateToHome: () -> Unit,
    couponSelection: Coupons,
    onOptionSelected: (Coupons) -> Unit,
    couponGameEdge: String,
    updateCouponGameEdge: (String) -> Unit,
    couponFaceValue: String,
    updateCouponFaceValue: (String) -> Unit,
    couponBet: String,
    updateCouponBetValue: (String) -> Unit
) {
    val (couponExpectedValue, onCouponExpectedValueChange)  = remember { mutableStateOf("0.0") }
    val radioOptions = Coupons.values()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Top,
    ) {
        Column {
            radioOptions.forEach { couponType ->
                Row(
                    Modifier
                        .fillMaxWidth()
                        .selectable(
                            selected = (couponType == couponSelection),
                            onClick = { onOptionSelected(couponType) }
                        )
                ) {
                    RadioButton(
                        selected = (couponType == couponSelection),
                        onClick = {
                            onOptionSelected(couponType)
                        },
                    )
                    Text(
                        text = couponType.coupon,
                        modifier = Modifier.align(Alignment.CenterVertically)
                    )
                }
            }

            Text("Dollar value of your coupon")
            Row( Modifier
                .fillMaxWidth()) {
                TextField(
                    value = couponFaceValue,
                    onValueChange = {
                        updateCouponFaceValue(it)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                )
            }

            Text("Your edge as a percent")
            Row( Modifier
                .fillMaxWidth()) {
                TextField(
                    value = couponGameEdge,
                    onValueChange = {
                        updateCouponGameEdge(it)
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                )
            }

            if(couponSelection == Coupons.MATCH_PLAY){
                Text("Dollar amount of the bet you make with the match play")
                Row( Modifier
                    .fillMaxWidth()) {

                    TextField(
                        value = couponBet,
                        onValueChange = { it ->
                            updateCouponBetValue(it)
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    )
                }
            }

            if(couponExpectedValue.toDouble() != 0.0){
                Text("The value of your coupon is:")
                Text(couponExpectedValue)
            }
            Text(couponExpectedValue)
        }


    }


    Column(
        modifier = Modifier
            .padding(24.dp)
            .fillMaxWidth()
            .fillMaxHeight(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { calculateCoupon(couponSelection, couponFaceValue, couponGameEdge, couponBet, onCouponExpectedValueChange) }) {
            Text(text = "Calculate")
        }
        Button(onClick = onNavigateToHome) {
            Text(text = "Home")
        }
    }
}

fun calculateCoupon(
    couponSelection: Coupons,
    couponFaceValue: String,
    couponGameEdge: String,
    couponBet: String,
    onCouponExpectedValueChange: (String) -> Unit,
) {
    var expectedValue = 0.0

    if(couponSelection == Coupons.MATCH_PLAY){
        expectedValue = couponFaceValue.toDouble() * (1 + couponGameEdge.toDouble())
    }

    onCouponExpectedValueChange(expectedValue.toString())

}

@Composable
fun HomeScreen(
    onNavigateToCouponCalculator: () -> Unit,
    onNavigateToCountingDrill: () -> Unit,
    onNavigateToSettings: () -> Unit
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
    var useSpanishDeck = sharedPref.getBoolean(Settings.USE_SPANISH_DECK, false)
    var numDeckToCountSetting = sharedPref.getInt(Settings.NUM_DECKS_TO_COUNT, 0)
    var numDecksToCount = 1

    // Protect ourself from trying to access the mapper with an index that is out of bounds
    // Default to and create a single deck instead
    if(numDeckToCountSetting <= Settings.numDecksToCountMapper.size - 1){
        numDecksToCount = Settings.numDecksToCountMapper[numDeckToCountSetting]!!
    }

    var deck = ArrayList<Card>()

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
