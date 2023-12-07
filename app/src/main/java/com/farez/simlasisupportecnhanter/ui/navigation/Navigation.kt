package com.farez.simlasisupportecnhanter.ui.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.farez.simlasisupportecnhanter.ui.screen.home.HomeScreen
import com.farez.simlasisupportecnhanter.ui.screen.keterangan.KeteranganScreen
import com.farez.simlasisupportecnhanter.ui.screen.rules.RuleScreen
import com.farez.simlasisupportecnhanter.ui.screen.simulasi.SimulasiScreen

@Composable
fun SetupNavigation() {
    var navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(navController)
        }
        composable(Screen.Simulasi.route) {
            SimulasiScreen()
        }
        composable(Screen.Keterangan.route) {
            KeteranganScreen()
        }
        composable(Screen.Rule.route) {
            RuleScreen()

        }
    }
}