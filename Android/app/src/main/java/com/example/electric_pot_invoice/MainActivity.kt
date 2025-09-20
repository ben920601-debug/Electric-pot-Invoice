package com.example.electricpotinvoice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.example.electric_pot_invoice.ui.CarrierScreen
import com.example.electric_pot_invoice.ui.SettingsScreen
import com.example.electric_pot_invoice.ui.RecordScreen
import com.example.electric_pot_invoice.ui.PrizeScreen
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.automirrored.filled.List

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ElectricPotInvoiceApp()
        }
    }
}

@Composable
fun ElectricPotInvoiceApp() {
    var selectedTab by remember { mutableIntStateOf(0) }

    Scaffold(
        bottomBar = {
            NavigationBar {
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Home, contentDescription = "載具") },
                    label = { Text("載具") },
                    selected = selectedTab == 0,
                    onClick = { selectedTab = 0 }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Settings, contentDescription = "設定") },
                    label = { Text("設定") },
                    selected = selectedTab == 1,
                    onClick = { selectedTab = 1 }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.AutoMirrored.Filled.List, contentDescription = "紀錄") },
                    label = { Text("紀錄") },
                    selected = selectedTab == 2,
                    onClick = { selectedTab = 2 }
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Filled.Star, contentDescription = "兌獎") },
                    label = { Text("兌獎") },
                    selected = selectedTab == 3,
                    onClick = { selectedTab = 3 }
                )
            }
        }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding) // ✅ 修正這裡
        ) {
            when (selectedTab) {
                0 -> CarrierScreen()
                1 -> SettingsScreen()
                2 -> RecordScreen()
                3 -> PrizeScreen()
            }
        }
    }
}