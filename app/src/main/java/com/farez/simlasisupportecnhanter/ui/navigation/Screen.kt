package com.farez.simlasisupportecnhanter.ui.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

sealed class Screen (val route : String) {
    object Home : Screen("ScreenName.HOME.name")
    object Simulasi : Screen("ScreenName.SIMULASI.name")
    object Keterangan : Screen("ScreenName.KETERANGAN.name")
    object Rule : Screen("ScreenName.RULE.name")
}

