package com.farez.simlasisupportecnhanter

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.Wallpapers
import androidx.core.view.WindowCompat
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.farez.simlasisupportecnhanter.data.model.RuleEnitity
import com.farez.simlasisupportecnhanter.ui.navigation.Screen
import com.farez.simlasisupportecnhanter.ui.screen.home.HomeScreen
import com.farez.simlasisupportecnhanter.ui.screen.keterangan.KeteranganScreen
import com.farez.simlasisupportecnhanter.ui.screen.rules.RuleScreen
import com.farez.simlasisupportecnhanter.ui.screen.simulasi.SimulasiScreen
import com.farez.simlasisupportecnhanter.ui.theme.SimlasiSupportEcnhanterTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SimlasiSupportEcnhanterTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                    ) {
                        val navController = rememberNavController()
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
            }
        }
    }
}

@Preview(showSystemUi = true, wallpaper = Wallpapers.GREEN_DOMINATED_EXAMPLE, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun appPreview() {
    SimlasiSupportEcnhanterTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colorScheme.background
        ) {
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
                }        }
    }
}

