package com.example.electricpotinvoice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.CreditCard
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Settings

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InvoiceApp()
        }
    }
}

@Composable
fun InvoiceApp() {
    val navController = rememberNavController()
    val tabs = listOf("carrier", "reward", "records", "settings")

    Scaffold(
        bottomBar = {
            NavigationBar {
                tabs.forEach { screen ->
                    NavigationBarItem(
                        icon = {
                            when (screen) {
                                "carrier" -> Icon(Icons.Outlined.CreditCard, contentDescription = "發票載具")
                                "reward" -> Icon(Icons.Outlined.Star, contentDescription = "兌獎專區")
                                "records" -> Icon(Icons.Outlined.List, contentDescription = "發票紀錄")
                                "settings" -> Icon(Icons.Outlined.Settings, contentDescription = "設定專區")
                            }
                        },
                        label = {
                            Text(
                                when (screen) {
                                    "carrier" -> "發票載具"
                                    "reward" -> "兌獎專區"
                                    "records" -> "發票紀錄"
                                    else -> "設定專區"
                                }
                            )
                        },
                        selected = false,
                        onClick = { /* TODO 之後再加導航 */ }
                    )
                }
            }
        }
    ) { padding ->
        Box(Modifier.padding(padding)) {
            Text("主畫面內容", modifier = Modifier.padding(16.dp))
        }
    }
}