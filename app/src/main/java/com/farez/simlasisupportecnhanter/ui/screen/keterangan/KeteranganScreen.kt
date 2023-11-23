package com.farez.simlasisupportecnhanter.ui.screen.keterangan

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.farez.simlasisupportecnhanter.R

@Composable
fun KeteranganScreen() {
    var isExpanded by remember {
        mutableStateOf(false)
    }
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .navigationBarsPadding()
            .statusBarsPadding(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            KeteranganItem(
                title = "HP Kawan",
                desc = "Nilai HP Kawan yang akan disimulasikan",
                drawableId = R.drawable.hp_ally
            )
        }
        item {
            KeteranganItem(
                title = "HP Diri",
                desc = "Nilai HP Diri yang akan disimulasikan",
                drawableId = R.drawable.hp_self,
            )
        }
        item {
            KeteranganItem(
                title = "HP Lawan",
                desc = "Nilai HP Lawan yang akan disimulasikan",
                drawableId = R.drawable.hp_enemy
            )
        }
    }
}



@Preview
@Composable
private fun screenPrev() {
    KeteranganScreen()
}