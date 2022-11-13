package com.example.jetweatherforecast.screens.settings

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.jetweatherforecast.widgets.WeatherAppBar
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetweatherforecast.model.Unit

@Composable
fun SettingsScreen(navController: NavController,
settingsViewModel: SettingsViewModel= hiltViewModel()){
   var unitToggleState by remember { mutableStateOf(false) }
   val measurementUnits = listOf("Imperial (F)", "Metric (C)")

   val choiceFromDb=settingsViewModel.unitList.collectAsState().value

   val defaultChoice=if(choiceFromDb.isNullOrEmpty()) measurementUnits[0]
   else choiceFromDb[0].unit

   var choiceState by remember {
      mutableStateOf(defaultChoice)
   }

   Scaffold(topBar={
      WeatherAppBar(navController = navController,
      title="Settings",
      icon=Icons.Default.ArrowBack,
      isMainScreen = false){
         navController.popBackStack()
      }
   }) {s->
      Log.d("SS", "SettingsScreen:$s ")
      Surface(modifier= Modifier
         .fillMaxWidth()
         .fillMaxHeight()) {
         Column(verticalArrangement = Arrangement.Center,
         horizontalAlignment = Alignment.CenterHorizontally) {

            Text(text = "Change Units of Measurements",
               modifier = Modifier.padding(bottom=15.dp))
            
            IconToggleButton(checked = !unitToggleState,
               onCheckedChange = {
                  unitToggleState = !it
                  choiceState = if (unitToggleState) {
                     "Imperial (F)"
                  } else {
                     "Metric (C)"
                  }
                  Log.d("TAGCHOICE", "MainContent: $unitToggleState")
               },
            modifier= Modifier
               .fillMaxWidth(0.5f)
               .padding(5.dp)
               .clip(shape = RectangleShape)
               .background(Color.Cyan.copy(alpha = 0.2f))) {

               Text(text =if(unitToggleState) "Farenheit °F" else "Celsius °C" )
            }

            Button(onClick = {
               settingsViewModel.deleteAllUnits()
               settingsViewModel.insertUnit(Unit(unit = choiceState ))

            },
               modifier = Modifier
                  .padding(3.dp)
                  .align(CenterHorizontally),
               shape = RoundedCornerShape(34.dp),
               colors = ButtonDefaults.buttonColors(
                  backgroundColor = Color(0xFFEFBE42)
               )) {
               Text(text = "Save",
                  modifier = Modifier.padding(4.dp),
                  color = Color.White,
                  fontSize = 17.sp)

            }
         }
      }
   }
}
