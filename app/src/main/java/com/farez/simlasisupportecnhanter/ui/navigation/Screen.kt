package com.farez.simlasisupportecnhanter.ui.navigation

sealed class Screen (val route : String) {
    object Home : Screen("ScreenName.HOME.name")
    object Simulasi : Screen("ScreenName.SIMULASI.name")
    object Keterangan : Screen("ScreenName.KETERANGAN.name")
    object Rule : Screen("ScreenName.RULE.name")
}