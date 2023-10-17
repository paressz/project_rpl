package com.farez.simlasisupportecnhanter.ui.screen.simulasi

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog

@Composable
fun ResultDialog(
    modifier: Modifier = Modifier
) {
    Dialog(onDismissRequest = { /*TODO*/ }) {
        Card(
            modifier = modifier
                .height(375.dp)
        ) {

        }
    }
}